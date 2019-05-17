package org.sheepy.lily.vulkan.process.graphic.pipeline.task;

import static org.lwjgl.vulkan.VK10.vkCmdSetViewport;

import org.lwjgl.vulkan.VkViewport;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.vulkan.api.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.model.process.graphic.SetViewport;

@Adapter(scope = SetViewport.class)
public class SetViewportAdapter implements IPipelineTaskAdapter<SetViewport>
{
	private final VkViewport.Buffer scissorRect = VkViewport.create(1);

	@Override
	public void record(SetViewport task, RecordContext context)
	{
		final float x = task.getX();
		final float y = task.getY();
		final float w = task.getWidth();
		final float h = task.getHeight();
		final float minDepth = task.getMinDepth();
		final float maxDepth = task.getMaxDepth();

		scissorRect.get(0).set(x, y, w, h, minDepth, maxDepth);

		vkCmdSetViewport(context.commandBuffer, 0, scissorRect);
	}
}
