package org.sheepy.vulkan.demo.mesh;

import static org.lwjgl.vulkan.VK10.*;

import org.eclipse.emf.ecore.EClass;
import org.sheepy.vulkan.demo.model.MeshPipeline;
import org.sheepy.vulkan.demo.model.VulkanDemoPackage;
import org.sheepy.vulkan.model.resource.DescriptorSet;
import org.sheepy.vulkan.model.resource.PushConstant;
import org.sheepy.vulkan.process.graphic.execution.GraphicCommandBuffer;
import org.sheepy.vulkan.process.graphic.pipeline.AbstractGraphicsPipelineAdapter;
import org.sheepy.vulkan.resource.indexed.IVertexBufferDescriptor;

public class MeshPipelineAdapter extends AbstractGraphicsPipelineAdapter
{
	@Override
	public void record(GraphicCommandBuffer commandBuffer, int bindPoint)
	{
		super.record(commandBuffer, bindPoint);

		final var vkCommandBuffer = commandBuffer.getVkCommandBuffer();
		final var meshPipeline = (MeshPipeline) target;
		final var mesh = meshPipeline.getMesh();
		final var meshAdapter = MeshAdapter.adapt(mesh);

		final var indexBuffer = meshAdapter.getIndexBuffer();
		final var indexBufferId = indexBuffer.getIndexBufferId();

		final long[] vertexBuffers = new long[] {
				indexBuffer.getVertexBufferId()
		};
		final long[] offsets = {
				0
		};

		vkCmdBindPipeline(vkCommandBuffer, VK_PIPELINE_BIND_POINT_GRAPHICS, id);
		vkCmdBindVertexBuffers(vkCommandBuffer, 0, vertexBuffers, offsets);
		vkCmdBindIndexBuffer(vkCommandBuffer, indexBufferId, 0, VK_INDEX_TYPE_UINT32);
		vkCmdDrawIndexed(vkCommandBuffer, indexBuffer.indexCount(), 1, 0, 0, 0);
	}

	@Override
	protected IVertexBufferDescriptor<?> getVertexBufferDescriptor()
	{
		final var meshPipeline = (MeshPipeline) target;
		final var mesh = meshPipeline.getMesh();
		final var meshAdapter = MeshAdapter.adapt(mesh);

		return meshAdapter.getIndexBuffer().getIndexBufferDescriptor();
	}

	@Override
	protected PushConstant getPushConstant()
	{
		return ((MeshPipeline) target).getPushConstant();
	}

	@Override
	protected DescriptorSet getDescriptorSet()
	{
		return ((MeshPipeline) target).getDescriptorSet();
	}

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return VulkanDemoPackage.Literals.MESH_PIPELINE == eClass;
	}
}
