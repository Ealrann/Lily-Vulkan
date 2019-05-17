package org.sheepy.lily.vulkan.process.pipeline.task;

import static org.lwjgl.vulkan.VK10.vkCmdPushConstants;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.api.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineAdapter;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.model.process.IPipeline;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.PushConstant;
import org.sheepy.vulkan.util.VkModelUtil;

@Statefull
@Adapter(scope = PushConstant.class)
public class PushConstantAdapter implements IPipelineTaskAdapter<PushConstant>
{
	private boolean dirty = true;

	@NotifyChanged
	public void notifyChanged(Notification notification)
	{
		if (notification.getFeature() == ProcessPackage.Literals.PUSH_CONSTANT__DATA)
		{
			dirty = true;
		}
	}

	@Override
	public void record(PushConstant pushConstant, RecordContext context)
	{
		final var pipeline = ModelUtil.findParent(pushConstant, IPipeline.class);
		final var pipelineAdapter = IPipelineAdapter.adapt(pipeline);
		final var data = pushConstant.getData();
		if (data != null)
		{
			final long layoutId = pipelineAdapter.getVkPipelineLayout().getId();
			final int stageFlags = VkModelUtil.getEnumeratedFlag(pushConstant.getStages());

			vkCmdPushConstants(context.commandBuffer, layoutId, stageFlags, 0, data);
		}

		dirty = false;
	}

	@Override
	public boolean needRecord(PushConstant task, int index)
	{
		return dirty;
	}
}
