import org.sheepy.common.api.adapter.IServiceAdapter;
import org.sheepy.vulkan.demo.mesh.MeshAdapter;
import org.sheepy.vulkan.demo.mesh.MeshPipelineAdapter;
import org.sheepy.vulkan.demo.mesh.UniformBufferAdapter;

/**
 *
 */
module org.sheepy.vulkan.demo {

	requires transitive org.sheepy.vulkan.process.graphic;

	requires org.joml;

	exports org.sheepy.vulkan.demo.mesh;

	exports org.sheepy.vulkan.demo.model;
	exports org.sheepy.vulkan.demo.model.impl;
	
	provides IServiceAdapter with MeshAdapter, MeshPipelineAdapter, UniformBufferAdapter;
}
