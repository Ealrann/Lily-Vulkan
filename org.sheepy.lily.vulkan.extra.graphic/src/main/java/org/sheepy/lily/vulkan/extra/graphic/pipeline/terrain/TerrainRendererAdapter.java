package org.sheepy.lily.vulkan.extra.graphic.pipeline.terrain;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.resource.IVertexBufferDescriptor;
import org.sheepy.lily.vulkan.extra.api.terrain.IMesh;
import org.sheepy.lily.vulkan.extra.api.terrain.IMeshProviderAdapter;
import org.sheepy.lily.vulkan.extra.graphic.model.TerrainRenderer;
import org.sheepy.lily.vulkan.process.graphic.pipeline.GraphicsPipelineAdapter;

@Statefull
@Adapter(scope = TerrainRenderer.class)
public class TerrainRendererAdapter extends GraphicsPipelineAdapter
{
	private IMeshProviderAdapter meshProviderAdapter;

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
		super.record(vkCommandBuffer, bindPoint, index);

		final long[] vertexBuffers = new long[1];
		final long[] offsets = new long[1];

		final var meshes = meshProviderAdapter.getMeshes();
		for (int i = 0; i < meshes.size(); i++)
		{
			final IMesh mesh = meshes.get(i);
			final long indexAddress = mesh.getIndexBufferAddress();
			final int indexCount = mesh.getIndicesCount();
			vertexBuffers[0] = mesh.getVertexBufferAddress();
			offsets[0] = 0;

			vkCmdBindVertexBuffers(vkCommandBuffer, 0, vertexBuffers, offsets);
			vkCmdBindIndexBuffer(vkCommandBuffer, indexAddress, 0, VK_INDEX_TYPE_UINT32);
			vkCmdDrawIndexed(vkCommandBuffer, indexCount, 1, 0, 0, 0);
		}
	}

	@Override
	protected IVertexBufferDescriptor<?> getVertexBufferDescriptor()
	{
		return meshProviderAdapter.getVertexBufferDescriptor();
	}
}
