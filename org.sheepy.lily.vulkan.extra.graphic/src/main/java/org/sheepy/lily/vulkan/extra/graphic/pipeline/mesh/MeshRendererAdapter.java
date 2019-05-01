package org.sheepy.lily.vulkan.extra.graphic.pipeline.mesh;

import static org.lwjgl.vulkan.VK10.*;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.extra.api.terrain.IMeshProviderAdapter;
import org.sheepy.lily.vulkan.extra.graphic.model.MeshRenderer;
import org.sheepy.lily.vulkan.process.graphic.pipeline.GraphicsPipelineAdapter;
import org.sheepy.lily.vulkan.resource.descriptor.IDescriptorSetAdapter;
import org.sheepy.vulkan.descriptor.IVkDescriptorSet;
import org.sheepy.vulkan.resource.indexed.IVertexBufferDescriptor;

@Statefull
@Adapter(scope = MeshRenderer.class)
public class MeshRendererAdapter extends GraphicsPipelineAdapter
{
	private final IMeshProviderAdapter meshProviderAdapter;

	private List<Integer[]> descriptorIndexes;

	public MeshRendererAdapter(MeshRenderer pipeline)
	{
		super(pipeline);

		final var meshProvider = pipeline.getMeshProvider();

		if (meshProvider != null)
		{
			meshProviderAdapter = IMeshProviderAdapter.adapt(meshProvider);
		}
		else
		{
			meshProviderAdapter = null;
		}
	}

	@Override
	public void update()
	{
		final var stagingBuffer = pushBufferAdapter.getStagingBuffer();
		final var meshes = meshProviderAdapter.getMeshes();
		for (int i = 0; i < meshes.size(); i++)
		{
			final var mesh = meshes.get(i);
			mesh.update(stagingBuffer);
			recordNeeded |= mesh.hasChanged();
		}
	}

	@Override
	protected void record(VkCommandBuffer vkCommandBuffer, int bindPoint, int index)
	{
		vkCmdBindPipeline(vkCommandBuffer, bindPoint, getPipelineId());
		pushConstants(vkCommandBuffer);

		final long[] vertexBuffers = new long[1];
		final long[] offsets = new long[1];

		final var meshes = meshProviderAdapter.getMeshes();
		for (int i = 0; i < meshes.size(); i++)
		{
			final var mesh = meshes.get(i);
			final long indexAddress = mesh.getIndexBufferAddress();
			final int indexCount = mesh.getIndicesCount();
			final long indexOffset = mesh.getIndexBufferOffset();
			vertexBuffers[0] = mesh.getVertexBufferAddress();
			offsets[0] = mesh.getVertexBufferOffset();

			bindDescriptor(vkCommandBuffer, bindPoint, descriptorIndexes.get(i));

			vkCmdBindVertexBuffers(vkCommandBuffer, 0, vertexBuffers, offsets);
			vkCmdBindIndexBuffer(vkCommandBuffer, indexAddress, indexOffset, VK_INDEX_TYPE_UINT32);
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
