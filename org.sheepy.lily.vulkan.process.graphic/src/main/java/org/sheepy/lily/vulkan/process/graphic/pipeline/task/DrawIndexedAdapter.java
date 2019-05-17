package org.sheepy.lily.vulkan.process.graphic.pipeline.task;

import static org.lwjgl.vulkan.VK10.vkCmdDrawIndexed;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.vulkan.api.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed;

@Adapter(scope = DrawIndexed.class)
public class DrawIndexedAdapter implements IPipelineTaskAdapter<DrawIndexed>
{
	@Override
	public void record(DrawIndexed task, RecordContext context)
	{
		final int indexCount = task.getIndexCount();
		final int instanceCount = task.getInstanceCount();
		final int firstIndex = task.getFirstIndex();
		final int vertexOffset = task.getVertexOffset();
		final int firstInstance = task.getFirstInstance();

		vkCmdDrawIndexed(context.commandBuffer, indexCount, instanceCount, firstIndex, vertexOffset,
				firstInstance);
	}
}
