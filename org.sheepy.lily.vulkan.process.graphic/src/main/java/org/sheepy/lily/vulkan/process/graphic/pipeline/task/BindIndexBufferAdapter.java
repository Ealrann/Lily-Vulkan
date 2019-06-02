package org.sheepy.lily.vulkan.process.graphic.pipeline.task;

import static org.lwjgl.vulkan.VK10.vkCmdBindIndexBuffer;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.vulkan.api.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.api.resource.IBufferAdapter;
import org.sheepy.lily.vulkan.model.process.graphic.BindIndexBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.process.graphic.IndexedVertexDescriptor;

@Adapter(scope = BindIndexBuffer.class)
public final class BindIndexBufferAdapter implements IPipelineTaskAdapter<BindIndexBuffer>
{
	@Override
	public void record(BindIndexBuffer task, RecordContext context)
	{
		final var pipeline = findPipeline(task);
		final var buffer = task.getBuffer();
		final var bufferAdapter = IBufferAdapter.adapt(buffer);
		final var indexPtr = bufferAdapter.getPtr();
		final var indexOffset = task.getOffset();
		final var vertexDescriptor = (IndexedVertexDescriptor) pipeline.getVertexDescriptor();
		final var indexType = vertexDescriptor.getIndexType().getValue();

		vkCmdBindIndexBuffer(context.commandBuffer, indexPtr, indexOffset, indexType);
	}

	private static GraphicsPipeline findPipeline(EObject eobject)
	{
		while (eobject != null && eobject instanceof GraphicsPipeline == false)
		{
			eobject = eobject.eContainer();
		}

		return (GraphicsPipeline) eobject;
	}
}
