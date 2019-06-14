package org.sheepy.lily.vulkan.process.pipeline.task;

import static org.lwjgl.vulkan.VK10.vkCmdPushConstants;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.api.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineAdapter;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.model.process.IPipeline;
import org.sheepy.lily.vulkan.model.process.PushConstantBuffer;
import org.sheepy.lily.vulkan.model.resource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;
import org.sheepy.vulkan.util.VkModelUtil;

@Statefull
@Adapter(scope = PushConstantBuffer.class)
public class PushConstantBufferAdapter implements IPipelineTaskAdapter<PushConstantBuffer>
{
	private final org.eclipse.emf.common.notify.Adapter bufferListener = new AdapterImpl()
	{
		@Override
		public void notifyChanged(Notification notification)
		{
			if (notification.getFeature() == ResourcePackage.Literals.CONSTANT_BUFFER__DATA)
			{
				dirty = true;
			}
		}
	};

	private final ConstantBuffer buffer;

	private boolean dirty = true;

	public PushConstantBufferAdapter(PushConstantBuffer task)
	{
		buffer = task.getBuffer();
		buffer.eAdapters().add(bufferListener);
	}

	@Dispose
	public void dispose()
	{
		buffer.eAdapters().add(bufferListener);
	}

	@Override
	public void record(PushConstantBuffer pushConstant, RecordContext context)
	{
		final var pipeline = ModelUtil.findParent(pushConstant, IPipeline.class);
		final var pipelineAdapter = IPipelineAdapter.adapt(pipeline);

		buffer.setBeingPushed(true);

		final var data = buffer.getData();
		if (data != null)
		{
			final long layoutId = pipelineAdapter.getVkPipelineLayout().getId();
			final int stageFlags = VkModelUtil.getEnumeratedFlag(pushConstant.getStages());

			vkCmdPushConstants(context.commandBuffer, layoutId, stageFlags, 0, data);
		}

		buffer.setBeingPushed(false);

		dirty = false;
	}

	@Override
	public boolean needRecord(PushConstantBuffer task, int index)
	{
		return dirty;
	}
}
