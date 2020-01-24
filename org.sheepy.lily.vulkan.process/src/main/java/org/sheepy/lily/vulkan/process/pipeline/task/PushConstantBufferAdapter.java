package org.sheepy.lily.vulkan.process.pipeline.task;

import static org.lwjgl.vulkan.VK10.vkCmdPushConstants;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.notification.INotificationListener;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.api.resource.buffer.IConstantBufferUpdater;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.common.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.common.pipeline.IPipelineAdapter;
import org.sheepy.lily.vulkan.common.pipeline.IVkPipelineAdapter;
import org.sheepy.lily.vulkan.model.process.IPipeline;
import org.sheepy.lily.vulkan.model.process.PushConstantBuffer;
import org.sheepy.lily.vulkan.model.resource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;

@Statefull
@Adapter(scope = PushConstantBuffer.class)
public class PushConstantBufferAdapter implements IPipelineTaskAdapter<PushConstantBuffer>
{
	private final INotificationListener bufferListener = n -> dirty = true;
	private final ConstantBuffer buffer;
	private final IConstantBufferUpdater updater;

	private boolean dirty = true;

	public PushConstantBufferAdapter(PushConstantBuffer task)
	{
		buffer = task.getBuffer();
		updater = buffer.adapt(IConstantBufferUpdater.class);
		buffer.addListener(bufferListener, ResourcePackage.CONSTANT_BUFFER__DATA);
	}

	@Dispose
	public void dispose()
	{
		buffer.removeListener(bufferListener, ResourcePackage.CONSTANT_BUFFER__DATA);
	}

	@Override
	public void record(PushConstantBuffer pushConstant, IRecordContext context)
	{
		final var pipeline = ModelUtil.findParent(pushConstant, IPipeline.class);
		final var pipelineAdapter = pipeline.<IVkPipelineAdapter<?>> adaptNotNullGeneric(IPipelineAdapter.class);

		if (updater != null)
		{
			updater.beforePush(buffer);
		}

		final var data = buffer.getData();
		if (data != null)
		{
			final var commandBuffer = ((RecordContext) context).commandBuffer;
			final long layoutId = pipelineAdapter.getVkPipelineLayout().getId();
			final int stageFlags = VulkanModelUtil.getEnumeratedFlag(pushConstant.getStages());

			vkCmdPushConstants(commandBuffer, layoutId, stageFlags, 0, data);
		}

		dirty = false;
	}

	@Override
	public boolean needRecord(PushConstantBuffer task, int index)
	{
		return dirty;
	}
}
