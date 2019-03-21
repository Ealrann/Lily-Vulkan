import org.sheepy.lily.core.api.adapter.annotation.Adapters;
import org.sheepy.lily.core.api.resource.IModelExtension;
import org.sheepy.lily.vulkan.demo.adapter.UniformBufferAdapter;
import org.sheepy.lily.vulkan.demo.mesh.MeshAdapter;
import org.sheepy.lily.vulkan.demo.mesh.MeshPipelineAdapter;
import org.sheepy.lily.vulkan.demo.model.VulkanDemoModelExtension;

@Adapters(classifiers = {
		MeshAdapter.class, MeshPipelineAdapter.class, UniformBufferAdapter.class
})

module org.sheepy.lily.vulkan.demo
{

	requires transitive org.sheepy.lily.vulkan.process.graphic;

	requires org.joml;

	exports org.sheepy.lily.vulkan.demo.mesh;

	exports org.sheepy.lily.vulkan.demo.model;
	exports org.sheepy.lily.vulkan.demo.model.impl;

	provides IModelExtension with VulkanDemoModelExtension;

	opens org.sheepy.lily.vulkan.demo.adapter;
}
