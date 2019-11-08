package org.sheepy.lily.vulkan.process.graphic.pipeline.task;

import static org.lwjgl.vulkan.VK10.vkCmdSetScissor;

import org.lwjgl.vulkan.VkRect2D;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.model.process.graphic.SetScissor;
import org.sheepy.vulkan.execution.IRecordable.RecordContext;

@Adapter(scope = SetScissor.class)
public class SetScissorAdapter implements IPipelineTaskAdapter<SetScissor>
{
	private final VkRect2D.Buffer scissorRect = VkRect2D.create(1);

	@Override
	public void record(SetScissor task, RecordContext context)
	{
		scissorRect.offset().x(task.getOffsetX());
		scissorRect.offset().y(task.getOffsetY());
		scissorRect.extent().width(task.getWidth());
		scissorRect.extent().height(task.getHeight());

		vkCmdSetScissor(context.commandBuffer, 0, scissorRect);
	}
}
