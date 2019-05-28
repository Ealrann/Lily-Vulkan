package org.sheepy.lily.vulkan.process.graphic.pipeline.task;

import static org.lwjgl.vulkan.VK10.vkCmdDraw;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.vulkan.api.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.model.process.graphic.Draw;

@Adapter(scope = Draw.class)
public class DrawAdapter implements IPipelineTaskAdapter<Draw>
{
	@Override
	public void record(Draw task, RecordContext context)
	{
		final int vertexCount = task.getVertexCount();
		final int instanceCount = task.getInstanceCount();
		final int firstVertex = task.getFirstVertex();
		final int firstInstance = task.getFirstInstance();

		vkCmdDraw(context.commandBuffer, vertexCount, instanceCount, firstVertex, firstInstance);
	}
}
