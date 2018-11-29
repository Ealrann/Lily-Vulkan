import org.sheepy.common.api.adapter.ISingletonAdapter;
import org.sheepy.vulkan.demo.mesh.MeshAdapter;
import org.sheepy.vulkan.demo.mesh.MeshPipelineAdapter;

/**
 *
 */
module org.sheepy.vulkan.demo {

	requires transitive org.sheepy.vulkan.api;
	requires transitive org.sheepy.vulkan.process.graphic;
	requires transitive org.sheepy.vulkan.resource;

	requires org.joml;

	exports org.sheepy.vulkan.demo.mesh;

	exports org.sheepy.vulkan.demo.model;
	exports org.sheepy.vulkan.demo.model.impl;
	
	provides ISingletonAdapter with MeshAdapter, MeshPipelineAdapter;
}

