package org.sheepy.lily.vulkan.extra.graphic.rendering.data;

import org.sheepy.lily.vulkan.core.resource.buffer.IBufferViewerAdapter;
import org.sheepy.lily.vulkan.extra.api.mesh.data.IIndexSupplier;
import org.sheepy.lily.vulkan.extra.api.mesh.data.IVertexSupplier;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public record RenderPipelineSetup(GraphicsPipeline pipeline, List<BufferViewer> buffers, Structure structure)
{

	public Stream<IVertexSupplier> streamVertexSuppliers()
	{
		return buffers.stream()
					  .filter(RenderPipelineSetup::isVertexBuffer)
					  .map(RenderPipelineSetup::adaptVertexSupplier);
	}

	public Optional<IIndexSupplier> indexSuppliers()
	{
		return buffers.stream()
					  .filter(RenderPipelineSetup::isIndexBuffer)
					  .map(RenderPipelineSetup::adaptIndexSupplier)
					  .findAny();
	}

	private static IVertexSupplier adaptVertexSupplier(final BufferViewer b)
	{
		return b.adapt(IBufferViewerAdapter.class).adaptDataSource(IVertexSupplier.class);
	}

	private static IIndexSupplier adaptIndexSupplier(final BufferViewer b)
	{
		return b.adapt(IIndexSupplier.class);
	}

	private static boolean isVertexBuffer(final BufferViewer b)
	{
		return b.getUsages().contains(EBufferUsage.VERTEX_BUFFER_BIT);
	}

	private static boolean isIndexBuffer(final BufferViewer b)
	{
		return b.getUsages().contains(EBufferUsage.INDEX_BUFFER_BIT);
	}
}
