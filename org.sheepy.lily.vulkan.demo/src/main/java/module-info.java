import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.cadence.IMainLoop;
import org.sheepy.lily.vulkan.demo.mesh.MeshAdapter;
import org.sheepy.lily.vulkan.demo.mesh.MeshMainLoop;
import org.sheepy.lily.vulkan.demo.mesh.MeshPipelineAdapter;

/**
 *
 */
module org.sheepy.lily.vulkan.demo {

	requires transitive org.sheepy.lily.vulkan.api;
	requires transitive org.sheepy.lily.vulkan.resource;
	requires transitive org.sheepy.lily.vulkan.process.graphic;

	requires org.joml;

	exports org.sheepy.lily.vulkan.demo.mesh;

	exports org.sheepy.lily.vulkan.demo.model;
	exports org.sheepy.lily.vulkan.demo.model.impl;
	
	provides IMainLoop with MeshMainLoop;
	provides IAdapter with MeshAdapter, MeshPipelineAdapter;
}

