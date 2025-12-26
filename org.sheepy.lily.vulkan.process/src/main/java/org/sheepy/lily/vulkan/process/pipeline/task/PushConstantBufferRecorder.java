package org.sheepy.lily.vulkan.process.pipeline.task;

import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.logoce.lmf.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.api.resource.buffer.IConstantBufferUpdater;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineAllocation;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableAdapter;
import org.sheepy.lily.vulkan.core.util.Logger;
import org.sheepy.lily.vulkan.model.process.AbstractPipeline;
import org.sheepy.lily.vulkan.model.process.PushConstantBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

import static org.lwjgl.vulkan.VK10.vkCmdPushConstants;

@ModelExtender(scope = PushConstantBuffer.class)
@Allocation
public final class PushConstantBufferRecorder implements IRecordableAdapter
{
	private final PushConstantBuffer task;
	private final ConstantBuffer buffer;
	private final IConstantBufferUpdater updater;
	private boolean hadData = true;

	public PushConstantBufferRecorder(PushConstantBuffer task, IAllocationState config, IObservatoryBuilder observatory)
	{
		this.task = task;
		buffer = task.buffer();
		updater = buffer.adapt(IConstantBufferUpdater.class);

		observatory.explore(PushConstantBuffer.FeatureIDs.BUFFER)
				   .listenNoParam(config::setAllocationObsolete, ConstantBuffer.FeatureIDs.DATA);
	}

	@Override
	public void record(RecordContext context)
	{
		final var pipeline = ModelUtil.findParent(task, AbstractPipeline.class);
		final var vkPipelineAdapter = pipeline.adapt(IPipelineAllocation.class);
		final int stageFlags = VulkanModelUtil.getEnumeratedFlag(task.stages(), EShaderStage::value);

		if (updater != null)
		{
			updater.beforePush(buffer);
		}

		final var data = buffer.data();
		if (DebugUtil.DEBUG_VERBOSE_ENABLED)
		{
			final boolean hasData = data != null;
			if (hasData != hadData)
			{
				final var pipelineName = pipeline != null ? pipeline.name() : "<no-pipeline>";
				final var bufferName = buffer.name();
				final var rawTaskName = task.name();
				final var taskName = rawTaskName == null || rawTaskName.isEmpty() ? "<unnamed>" : rawTaskName;
				final var layoutPtr = vkPipelineAdapter != null ? vkPipelineAdapter.getVkPipelineLayout().getPtr() : 0L;
				final var message = hasData
									? String.format("[PushConstant] Restored data. pipeline=%s task=%s buffer=%s layout=0x%x stages=0x%x",
													pipelineName, taskName, bufferName, layoutPtr, stageFlags)
									: String.format("[PushConstant] Missing data. pipeline=%s task=%s buffer=%s layout=0x%x stages=0x%x",
													pipelineName, taskName, bufferName, layoutPtr, stageFlags);
				Logger.log(message, true);
				hadData = hasData;
			}
		}
		if (data != null)
		{
			final var commandBuffer = context.commandBuffer;
			final long layoutId = vkPipelineAdapter.getVkPipelineLayout().getPtr();

			vkCmdPushConstants(commandBuffer, layoutId, stageFlags, 0, data);
		}
	}
}
