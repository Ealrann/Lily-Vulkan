package org.sheepy.lily.vulkan.demo.mesh;

import static org.lwjgl.vulkan.VK10.*;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.demo.model.MeshPipeline;
import org.sheepy.lily.vulkan.process.graphic.execution.GraphicCommandBuffer;
import org.sheepy.lily.vulkan.process.graphic.pipeline.GraphicsPipelineAdapter;
import org.sheepy.lily.vulkan.resource.indexed.IVertexBufferDescriptor;

@Statefull
@Adapter(scope = MeshPipeline.class)
public class MeshPipelineAdapter extends GraphicsPipelineAdapter
{
	public MeshPipelineAdapter(MeshPipeline pipeline)
	{
		super(pipeline);
	}

	@Override
	public void record(GraphicCommandBuffer commandBuffer, int bindPoint)
	{
		final var vkCommandBuffer = commandBuffer.getVkCommandBuffer();
		final var meshPipeline = (MeshPipeline) pipeline;
		final var mesh = meshPipeline.getMesh();
		final var meshAdapter = MeshAdapter.adapt(mesh);

		final var indexBuffer = meshAdapter.getIndexBuffer();
		final var indexBufferId = indexBuffer.getIndexBufferAddress();

		final long[] vertexBuffers = new long[] {
				indexBuffer.getVertexBufferAddress()
		};
		final long[] offsets = {
				0
		};

		vkCmdBindPipeline(vkCommandBuffer, bindPoint, pipelineId);

		if (meshPipeline.getDescriptorSet() != null)
		{
			bindDescriptor(commandBuffer, bindPoint, 0);
		}

		vkCmdBindVertexBuffers(vkCommandBuffer, 0, vertexBuffers, offsets);
		vkCmdBindIndexBuffer(vkCommandBuffer, indexBufferId, 0, VK_INDEX_TYPE_UINT32);
		vkCmdDrawIndexed(vkCommandBuffer, indexBuffer.getIndicesCount(), 1, 0, 0, 0);
	}

	@Override
	protected IVertexBufferDescriptor<?> getVertexBufferDescriptor()
	{
		final var meshPipeline = (MeshPipeline) pipeline;
		final var mesh = meshPipeline.getMesh();
		final var meshAdapter = MeshAdapter.adapt(mesh);

		return meshAdapter.getIndexBuffer().getIndexBufferDescriptor();
	}
}
