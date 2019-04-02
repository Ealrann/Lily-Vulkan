package org.sheepy.lily.vulkan.demo.mesh;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.process.graphic.api.IGraphicContext;
import org.sheepy.lily.vulkan.process.graphic.pipeline.GraphicsPipelineAdapter;
import org.sheepy.lily.vulkan.resource.indexed.IVertexBufferDescriptor;
import org.sheepy.lily.vulkan.resource.indexed.IndexedBuffer;

@Statefull
@Adapter(scope = GraphicsPipeline.class, name = MeshModelFactory.MESH_PIPELINE_NAME)
public class MeshPipelineAdapter extends GraphicsPipelineAdapter
{
	public static IIndexedBufferBuilder<?> meshBuilder = null;

	private IndexedBuffer<?> indexBuffer;

	public MeshPipelineAdapter(GraphicsPipeline pipeline)
	{
		super(pipeline);
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		final var graphicContext = (IGraphicContext) context;
		indexBuffer = meshBuilder.build(graphicContext);

		super.allocate(stack, context);
	}

	@Override
	public void free(IAllocationContext context)
	{
		super.free(context);

		indexBuffer.free(context);
		indexBuffer = null;
	}

	@Override
	public void record(VkCommandBuffer vkCommandBuffer, int bindPoint, int index)
	{
		super.record(vkCommandBuffer, bindPoint, index);

		final var indexBufferId = indexBuffer.getIndexBufferAddress();

		final long[] vertexBuffers = new long[] {
				indexBuffer.getVertexBufferAddress()
		};
		final long[] offsets = {
				0
		};

		vkCmdBindVertexBuffers(vkCommandBuffer, 0, vertexBuffers, offsets);
		vkCmdBindIndexBuffer(vkCommandBuffer, indexBufferId, 0, VK_INDEX_TYPE_UINT32);
		vkCmdDrawIndexed(vkCommandBuffer, indexBuffer.getIndicesCount(), 1, 0, 0, 0);
	}

	@Override
	protected IVertexBufferDescriptor<?> getVertexBufferDescriptor()
	{
		return indexBuffer.getIndexBufferDescriptor();
	}
}
