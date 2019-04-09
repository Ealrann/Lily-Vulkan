package org.sheepy.lily.vulkan.extra.graphic.pipeline.terrain;

import static org.lwjgl.vulkan.VK10.*;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.resource.IVertexBufferDescriptor;
import org.sheepy.lily.vulkan.api.resource.IVkDescriptorSet;
import org.sheepy.lily.vulkan.extra.api.terrain.IMeshProviderAdapter;
import org.sheepy.lily.vulkan.extra.graphic.model.TerrainRenderer;
import org.sheepy.lily.vulkan.process.graphic.pipeline.GraphicsPipelineAdapter;
import org.sheepy.lily.vulkan.resource.descriptor.IDescriptorSetAdapter;

@Statefull
@Adapter(scope = TerrainRenderer.class)
public class TerrainRendererAdapter extends GraphicsPipelineAdapter
{
	private IMeshProviderAdapter meshProviderAdapter;
	private List<Integer[]> descriptorIndexes;

	public TerrainRendererAdapter(TerrainRenderer pipeline)
	{
		super(pipeline);

		final var meshProvider = pipeline.getMeshProvider();

		if (meshProvider != null)
		{
			meshProviderAdapter = IMeshProviderAdapter.adapt(meshProvider);
		}
	}

	@Override
	public void record(VkCommandBuffer vkCommandBuffer, int bindPoint, int index)
	{
		vkCmdBindPipeline(vkCommandBuffer, bindPoint, getPipelineId());
		pushConstants(vkCommandBuffer);

		final long[] vertexBuffers = new long[1];
		final long[] offsets = new long[1];

		final var meshes = meshProviderAdapter.getMeshes();
		for (int i = 0; i < meshes.size(); i++)
		{
			final var mesh = meshes.get(i);
			final var indexedBuffer = mesh.getIIndexedBuffer();
			final long indexAddress = indexedBuffer.getIndexBufferAddress();
			final int indexCount = indexedBuffer.getIndicesCount();
			vertexBuffers[0] = indexedBuffer.getVertexBufferAddress();
			offsets[0] = 0;

			bindDescriptor(vkCommandBuffer, bindPoint, descriptorIndexes.get(i));
			vkCmdBindVertexBuffers(vkCommandBuffer, 0, vertexBuffers, offsets);
			vkCmdBindIndexBuffer(vkCommandBuffer, indexAddress, 0, VK_INDEX_TYPE_UINT32);
			vkCmdDrawIndexed(vkCommandBuffer, indexCount, mesh.getInstanceCount(), 0, 0, 0);
		}
	}

	@Override
	public void collectDescriptorSets(List<IVkDescriptorSet> collectIn)
	{
		final List<Integer[]> indexes = new ArrayList<>();

		final var mainDescriptorSet = getDescriptorSetFromModel();
		final var meshes = meshProviderAdapter.getMeshes();
		int index = 0;

		if (mainDescriptorSet != null)
		{
			collectIn.add(mainDescriptorSet);
			index++;
		}

		for (final var mesh : meshes)
		{
			final var meshDescriptorSet = mesh.getDescriptorSet();

			int count = mainDescriptorSet != null ? 1 : 0;
			if (meshDescriptorSet != null) count++;

			final Integer[] indexesArray = new Integer[count];
			int arrayIndex = 0;

			// First is the main descriptor set
			if (mainDescriptorSet != null)
			{
				indexesArray[arrayIndex++] = 0;
			}
			if (meshDescriptorSet != null)
			{
				indexesArray[arrayIndex++] = index;
				index++;
				collectIn.add(meshDescriptorSet);
			}

			indexes.add(indexesArray);
		}

		descriptorIndexes = List.copyOf(indexes);
	}

	@Override
	public void collectResources(List<Object> collectIn)
	{
		super.collectResources(collectIn);

		final var meshes = meshProviderAdapter.getMeshes();
		for (final var mesh : meshes)
		{
			collectIn.add(mesh);
		}
	}

	@Override
	protected IVertexBufferDescriptor<?> getVertexBufferDescriptor()
	{
		return meshProviderAdapter.getVertexBufferDescriptor();
	}

	private IVkDescriptorSet getDescriptorSetFromModel()
	{
		var modelDS = pipeline.getDescriptorSet();
		if (modelDS == null)
		{
			modelDS = pipeline.getDescriptorSetRef();
		}

		IDescriptorSetAdapter mainDescriptorSet = null;
		if (modelDS != null)
		{
			mainDescriptorSet = IDescriptorSetAdapter.adapt(modelDS);
		}

		return mainDescriptorSet;
	}
}
