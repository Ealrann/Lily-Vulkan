package org.sheepy.lily.vulkan.extra.graphic.pipeline.mesh;
//
//import java.util.List;
//
//import org.lwjgl.vulkan.VkCommandBuffer;
//import org.sheepy.lily.core.api.adapter.annotation.Adapter;
//import org.sheepy.lily.core.api.adapter.annotation.Statefull;
//import org.sheepy.lily.vulkan.api.resource.mesh.IMeshProviderAdapter;
//import org.sheepy.lily.vulkan.extra.graphic.model.MeshRenderer;
//import org.sheepy.lily.vulkan.process.graphic.pipeline.GraphicsPipelineAdapter;
//import org.sheepy.lily.vulkan.resource.descriptor.IDescriptorSetAdapter;
//import org.sheepy.vulkan.descriptor.IVkDescriptorSet;
//import org.sheepy.vulkan.pipeline.VkPipelineLayout;
//import org.sheepy.vulkan.resource.indexed.IVertexDescriptor;
//
//@Statefull
//@Adapter(scope = MeshRenderer.class)
//public class MeshRendererAdapter extends GraphicsPipelineAdapter
//{
//
//	private List<Integer[]> descriptorIndexes;
//
//	public MeshRendererAdapter(MeshRenderer pipeline)
//	{
//		super(pipeline);
//
//		final var meshProvider = pipeline.getMeshProvider();
//
//		if (meshProvider != null)
//		{
//			meshProviderAdapter = IMeshProviderAdapter.adapt(meshProvider);
//		}
//		else
//		{
//			meshProviderAdapter = null;
//		}
//	}
//
//
//	@Override
//	protected void record(VkCommandBuffer vkCommandBuffer, int bindPoint)
//	{
//		final VkPipelineLayout vkPipeline = getVkPipelineLayout();
//		vkPipeline.bindDescriptors(vkCommandBuffer, bindPoint);
//
//		pushConstants(vkCommandBuffer);
//
//		final long[] vertexBuffers = new long[1];
//		final long[] offsets = new long[1];
//
//		final var meshes = meshProviderAdapter.getMeshes();
//		for (int i = 0; i < meshes.size(); i++)
//		{
//			
//		}
//	}
//
//	@Override
//	public void collectDescriptorSets(List<IVkDescriptorSet> collectIn)
//	{
//		throw new RuntimeException("Need reimplement");
////		final List<Integer[]> indexes = new ArrayList<>();
////		final List<IVkDescriptor> descriptors = new ArrayList<>();
////
////		final var mainDescriptorSet = getDescriptorSetFromModel();
////		final var meshes = meshProviderAdapter.getMeshes();
////		int index = 0;
////
////		if (mainDescriptorSet != null)
////		{
////			collectIn.add(mainDescriptorSet);
////			index++;
////		}
////
////		for (final var mesh : meshes)
////		{
////			final var meshDescriptors = mesh.getDescriptors();
////
////			int count = mainDescriptorSet != null ? 1 : 0;
////			if (meshDescriptors != null) count++;
////
////			final Integer[] indexesArray = new Integer[count];
////			int arrayIndex = 0;
////
////			// First is the main descriptor set
////			if (mainDescriptorSet != null)
////			{
////				indexesArray[arrayIndex++] = 0;
////			}
////			if (meshDescriptorSet != null)
////			{
////				indexesArray[arrayIndex++] = index;
////				index++;
////				descriptors.add(meshDescriptorSet);
////			}
////
////			indexes.add(indexesArray);
////		}
////		descriptorIndexes = List.copyOf(indexes);
////
////		final IVkDescriptorSet res = new VkDescriptorSet();
////
////		collectIn.add(res);
//
//	}
//
//	@Override
//	public void collectResources(List<Object> collectIn)
//	{
//		super.collectResources(collectIn);
//
//		final var meshes = meshProviderAdapter.getMeshes();
//		for (final var mesh : meshes)
//		{
//			collectIn.add(mesh);
//		}
//	}
//
//	@Override
//	protected IVertexDescriptor<?> getVertexBufferDescriptor()
//	{
//		return meshProviderAdapter.getVertexBufferDescriptor();
//	}
//
//	private IVkDescriptorSet getDescriptorSetFromModel()
//	{
//		var modelDS = pipeline.getDescriptorSet();
//		if (modelDS == null)
//		{
//			modelDS = pipeline.getDescriptorSetRef();
//		}
//
//		IDescriptorSetAdapter mainDescriptorSet = null;
//		if (modelDS != null)
//		{
//			mainDescriptorSet = IDescriptorSetAdapter.adapt(modelDS);
//		}
//
//		return mainDescriptorSet;
//	}
//}
