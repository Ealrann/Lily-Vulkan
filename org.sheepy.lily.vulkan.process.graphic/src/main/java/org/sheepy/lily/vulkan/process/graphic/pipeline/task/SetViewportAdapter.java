package org.sheepy.lily.vulkan.process.graphic.pipeline.task;

import org.lwjgl.vulkan.VkViewport;
import org.logoce.lmf.core.api.adapter.Adapter;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableAdapter;
import org.sheepy.lily.vulkan.model.process.graphic.SetViewport;

import static org.lwjgl.vulkan.VK10.vkCmdSetViewport;

@ModelExtender(scope = SetViewport.class)
@Adapter
public final class SetViewportAdapter implements IRecordableAdapter
{
	private final VkViewport.Buffer viewportRect = VkViewport.create(1);
	private final SetViewport task;

	private SetViewportAdapter(SetViewport task)
	{
		this.task = task;
	}

	@Override
	public void record(RecordContext context)
	{
		final float x = task.x();
		final float y = task.y();
		final float w = task.width();
		final float h = task.height();
		final float minDepth = task.minDepth();
		final float maxDepth = task.maxDepth();
		final var commandBuffer = context.commandBuffer;

		viewportRect.get(0).set(x, y, w, h, minDepth, maxDepth);

		vkCmdSetViewport(commandBuffer, 0, viewportRect);
	}
}
