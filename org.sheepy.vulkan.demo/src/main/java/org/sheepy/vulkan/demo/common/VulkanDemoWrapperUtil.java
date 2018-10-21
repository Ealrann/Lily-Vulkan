package org.sheepy.vulkan.demo.common;

import org.sheepy.vulkan.adapter.VulkanAdapterRegistry;
import org.sheepy.vulkan.demo.mesh.MeshAdapterWrapper;
import org.sheepy.vulkan.demo.mesh.MeshPipelineAdapter;
import org.sheepy.vulkan.demo.mesh.UniformBufferAdapter;
import org.sheepy.vulkan.demo.model.VulkanDemoPackage;
import org.sheepy.vulkan.resource.indexed.IIndexedBufferBuilder;

public class VulkanDemoWrapperUtil
{
	public static void registerWrappers(IIndexedBufferBuilder<?> meshBuilder)
	{
		final var registry = VulkanAdapterRegistry.INSTANCE;
		final var pipelineClass = MeshPipelineAdapter.class;
		final var pipelineEClass = VulkanDemoPackage.Literals.MESH_PIPELINE;
		final var uniformClass = UniformBufferAdapter.class;
		final var uniformEClass = VulkanDemoPackage.Literals.UNIFORM_BUFFER;
		
		registry.addWrapper(new MeshAdapterWrapper(meshBuilder));
		registry.addWrapper(new VulkanDemoAdapterWrapper(pipelineClass, pipelineEClass));
		registry.addWrapper(new VulkanDemoAdapterWrapper(uniformClass, uniformEClass));
	}
}
