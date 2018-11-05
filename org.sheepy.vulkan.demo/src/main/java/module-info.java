import org.sheepy.common.api.adapter.IServiceAdapter;
import org.sheepy.vulkan.demo.mesh.MeshAdapter;
import org.sheepy.vulkan.demo.mesh.MeshPipelineAdapter;
import org.sheepy.vulkan.demo.mesh.UniformBufferAdapter;

/**
 *
 */
module org.sheepy.vulkan.demo {

	requires transitive org.sheepy.vulkan;

	requires org.joml;

	exports org.sheepy.vulkan.demo.mesh;

	exports org.sheepy.vulkan.demo.model;
	exports org.sheepy.vulkan.demo.model.impl;
	
	// Make resources (shaders) public
//	opens org.sheepy.vulkan.demo.triangle;
//	opens org.sheepy.vulkan.demo.rotatingtriangle;
//	opens org.sheepy.vulkan.demo.texture;
	
	provides IServiceAdapter with MeshAdapter, MeshPipelineAdapter, UniformBufferAdapter;
}
