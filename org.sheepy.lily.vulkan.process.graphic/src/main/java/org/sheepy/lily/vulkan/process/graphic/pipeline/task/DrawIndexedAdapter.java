package org.sheepy.lily.vulkan.process.graphic.pipeline.task;

import static org.lwjgl.vulkan.VK10.vkCmdDrawIndexed;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.core.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed;

@Adapter(scope = DrawIndexed.class)
public class DrawIndexedAdapter implements IPipelineTaskAdapter<DrawIndexed>
{
	@Override
	public void record(DrawIndexed task, IRecordContext context)
	{
		final int indexCount = task.getIndexCount();
		final int instanceCount = task.getInstanceCount();
		final int firstIndex = task.getFirstIndex();
		final int vertexOffset = task.getVertexOffset();
		final int firstInstance = task.getFirstInstance();
		final var commandBuffer = ((RecordContext) context).commandBuffer;

		vkCmdDrawIndexed(	commandBuffer,
							indexCount,
							instanceCount,
							firstIndex,
							vertexOffset,
							firstInstance);
	}
}
