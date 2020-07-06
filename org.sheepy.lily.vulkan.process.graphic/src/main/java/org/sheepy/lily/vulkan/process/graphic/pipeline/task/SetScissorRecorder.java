package org.sheepy.lily.vulkan.process.graphic.pipeline.task;

import org.lwjgl.vulkan.VkRect2D;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableExtender;
import org.sheepy.lily.vulkan.model.process.graphic.SetScissor;

import static org.lwjgl.vulkan.VK10.vkCmdSetScissor;

@ModelExtender(scope = SetScissor.class)
@Adapter
public final class SetScissorRecorder implements IRecordableExtender
{
	private final VkRect2D.Buffer scissorRect = VkRect2D.create(1);
	private final SetScissor task;

	private SetScissorRecorder(SetScissor task)
	{
		this.task = task;
	}

	@Override
	public void record(RecordContext context)
	{
		scissorRect.offset().x(task.getOffsetX());
		scissorRect.offset().y(task.getOffsetY());
		scissorRect.extent().width(task.getWidth());
		scissorRect.extent().height(task.getHeight());
		final var commandBuffer = ((RecordContext) context).commandBuffer;

		vkCmdSetScissor(commandBuffer, 0, scissorRect);
	}
}
