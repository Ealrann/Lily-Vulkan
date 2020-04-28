package org.sheepy.lily.vulkan.process.graphic.pipeline.task;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.core.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.model.process.graphic.Draw;

import static org.lwjgl.vulkan.VK10.vkCmdDraw;

@ModelExtender(scope = Draw.class)
@Adapter(singleton = true)
public class DrawAdapter implements IPipelineTaskAdapter<Draw>
{
	@Override
	public void record(Draw task, IRecordContext context)
	{
		final int vertexCount = task.getVertexCount();
		final int instanceCount = task.getInstanceCount();
		final int firstVertex = task.getFirstVertex();
		final int firstInstance = task.getFirstInstance();
		final var commandBuffer = ((RecordContext) context).commandBuffer;

		vkCmdDraw(commandBuffer, vertexCount, instanceCount, firstVertex, firstInstance);
	}
}
