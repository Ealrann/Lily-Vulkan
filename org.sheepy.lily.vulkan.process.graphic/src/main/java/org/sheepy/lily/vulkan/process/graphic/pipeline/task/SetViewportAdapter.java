package org.sheepy.lily.vulkan.process.graphic.pipeline.task;

import org.lwjgl.vulkan.VkViewport;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableExtender;
import org.sheepy.lily.vulkan.model.process.graphic.SetViewport;

import static org.lwjgl.vulkan.VK10.vkCmdSetViewport;

@ModelExtender(scope = SetViewport.class)
@Adapter
public final class SetViewportAdapter implements IRecordableExtender
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
		final float x = task.getX();
		final float y = task.getY();
		final float w = task.getWidth();
		final float h = task.getHeight();
		final float minDepth = task.getMinDepth();
		final float maxDepth = task.getMaxDepth();
		final var commandBuffer = context.commandBuffer;

		viewportRect.get(0).set(x, y, w, h, minDepth, maxDepth);

		vkCmdSetViewport(commandBuffer, 0, viewportRect);
	}
}
