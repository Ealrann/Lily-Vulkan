package test.vulkan.common;

import org.sheepy.vulkan.adapter.VulkanAdapterRegistry;
import org.sheepy.vulkan.model.VulkanPackage;
import org.sheepy.vulkan.resource.indexed.IIndexedBufferBuilder;

import test.vulkan.mesh.MeshAdapterWrapper;
import test.vulkan.mesh.MeshPipelineAdapter;
import test.vulkan.mesh.UniformBufferAdapter;

public class VulkanDemoWrapperUtil
{
	public static void registerWrappers(IIndexedBufferBuilder<?> meshBuilder)
	{
		final var registry = VulkanAdapterRegistry.INSTANCE;
		final var pipelineClass = MeshPipelineAdapter.class;
		final var pipelineEClass = VulkanPackage.Literals.MESH_PIPELINE;
		final var uniformClass = UniformBufferAdapter.class;
		final var uniformEClass = VulkanPackage.Literals.UNIFORM_BUFFER;
		
		registry.addWrapper(new MeshAdapterWrapper(meshBuilder));
		registry.addWrapper(new VulkanDemoAdapterWrapper(pipelineClass, pipelineEClass));
		registry.addWrapper(new VulkanDemoAdapterWrapper(uniformClass, uniformEClass));
	}
}
