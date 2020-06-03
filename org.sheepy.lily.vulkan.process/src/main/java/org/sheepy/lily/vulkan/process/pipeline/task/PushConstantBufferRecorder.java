package org.sheepy.lily.vulkan.process.pipeline.task;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.api.resource.buffer.IConstantBufferUpdater;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineTaskRecorder;
import org.sheepy.lily.vulkan.core.pipeline.IVkPipelineRecordable;
import org.sheepy.lily.vulkan.model.process.AbstractPipeline;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.PushConstantBuffer;
import org.sheepy.lily.vulkan.model.resource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;

import static org.lwjgl.vulkan.VK10.vkCmdPushConstants;

@ModelExtender(scope = PushConstantBuffer.class)
@Adapter
public final class PushConstantBufferRecorder implements IPipelineTaskRecorder
{
	private final PushConstantBuffer task;
	private final ConstantBuffer buffer;
	private final IConstantBufferUpdater updater;

	private boolean dirty = true;

	public PushConstantBufferRecorder(PushConstantBuffer task, IObservatoryBuilder observatory)
	{
		this.task = task;
		buffer = task.getBuffer();
		updater = buffer.adapt(IConstantBufferUpdater.class);

		observatory.explore(ProcessPackage.PUSH_CONSTANT_BUFFER__BUFFER)
				   .listenNoParam(() -> dirty = true, VulkanResourcePackage.CONSTANT_BUFFER__DATA);
	}

	@Override
	public void record(RecordContext context)
	{
		final var pipeline = ModelUtil.findParent(task, AbstractPipeline.class);
		final var vkPipelineAdapter = pipeline.adapt(IVkPipelineRecordable.class);

		if (updater != null)
		{
			updater.beforePush(buffer);
		}

		final var data = buffer.getData();
		if (data != null)
		{
			final var commandBuffer = context.commandBuffer;
			final long layoutId = vkPipelineAdapter.getVkPipelineLayout().getId();
			final int stageFlags = VulkanModelUtil.getEnumeratedFlag(task.getStages());

			vkCmdPushConstants(commandBuffer, layoutId, stageFlags, 0, data);
		}

		dirty = false;
	}

	@Override
	public boolean isRecordDirty(final int index)
	{
		return dirty;
	}
}
