package org.sheepy.vulkan.demo.mesh;

import static org.lwjgl.vulkan.VK10.*;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.sheepy.vulkan.demo.model.MeshPipeline;
import org.sheepy.vulkan.demo.model.VulkanDemoPackage;
import org.sheepy.vulkan.model.resource.AbstractConstants;
import org.sheepy.vulkan.process.graphic.execution.GraphicCommandBuffer;
import org.sheepy.vulkan.process.graphic.pipeline.AbstractGraphicsPipelineAdapter;
import org.sheepy.vulkan.resource.descriptor.IDescriptorSetAdapter;
import org.sheepy.vulkan.resource.descriptor.IVkDescriptorSet;
import org.sheepy.vulkan.resource.indexed.IVertexBufferDescriptor;

public class MeshPipelineAdapter extends AbstractGraphicsPipelineAdapter
{
	@Override
	public void record(GraphicCommandBuffer commandBuffer, int bindPoint)
	{
		final var vkCommandBuffer = commandBuffer.getVkCommandBuffer();
		final var meshPipeline = (MeshPipeline) pipeline;
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

		vkCmdBindPipeline(vkCommandBuffer, bindPoint, pipelineId);
		
		if (meshPipeline.getDescriptorSet() != null)
		{
			bindDescriptor(commandBuffer, bindPoint, 0);
		}

		vkCmdBindVertexBuffers(vkCommandBuffer, 0, vertexBuffers, offsets);
		vkCmdBindIndexBuffer(vkCommandBuffer, indexBufferId, 0, VK_INDEX_TYPE_UINT32);
		vkCmdDrawIndexed(vkCommandBuffer, indexBuffer.indexCount(), 1, 0, 0, 0);
	}

	@Override
	protected IVertexBufferDescriptor<?> getVertexBufferDescriptor()
	{
		final var meshPipeline = (MeshPipeline) pipeline;
		final var mesh = meshPipeline.getMesh();
		final var meshAdapter = MeshAdapter.adapt(mesh);

		return meshAdapter.getIndexBuffer().getIndexBufferDescriptor();
	}

	@Override
	protected AbstractConstants getConstants()
	{
		return ((MeshPipeline) pipeline).getConstants();
	}

	@Override
	public List<IVkDescriptorSet> getDescriptorSets()
	{
		List<IVkDescriptorSet> res = new ArrayList<>();
		final var meshPipeline = (MeshPipeline) pipeline;
		var ds = meshPipeline.getDescriptorSet();
		if (ds != null)
		{
			var adapter = IDescriptorSetAdapter.adapt(ds);
			res.add(adapter);
		}
		return res;
	}

	@Override
	public boolean isApplicable(EClass eClass)
	{
		return VulkanDemoPackage.Literals.MESH_PIPELINE == eClass;
	}

	@Override
	protected int getSubpass()
	{
		return 0;
	}
}
