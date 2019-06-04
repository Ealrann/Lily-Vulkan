package org.sheepy.lily.vulkan.process.graphic.pipeline.task;

import static org.lwjgl.vulkan.VK10.vkCmdBindIndexBuffer;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.api.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.api.resource.IBufferReferenceAdapter;
import org.sheepy.lily.vulkan.model.process.graphic.BindIndexBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.process.graphic.IndexedVertexDescriptor;

@Adapter(scope = BindIndexBuffer.class)
public final class BindIndexBufferAdapter implements IPipelineTaskAdapter<BindIndexBuffer>
{
	@Override
	public void record(BindIndexBuffer task, RecordContext context)
	{
		final var pipeline = ModelUtil.findParent(task, GraphicsPipeline.class);
		final var bufferRef = task.getBufferRef();
		final var adapter = IBufferReferenceAdapter.adapt(bufferRef);
		final var indexPtr = adapter.getBufferPtr(bufferRef);
		final var indexOffset = adapter.getOffset(bufferRef);
		final var vertexDescriptor = (IndexedVertexDescriptor) pipeline.getVertexDescriptor();
		final var indexType = vertexDescriptor.getIndexType().getValue();

		vkCmdBindIndexBuffer(context.commandBuffer, indexPtr, indexOffset, indexType);
	}
}
