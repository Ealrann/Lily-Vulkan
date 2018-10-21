/**
 * 
 */
/**
 * @author ealrann
 *
 */
module org.sheepy.vulkan.demo {

	exports org.sheepy.vulkan.demo.mesh;

	exports org.sheepy.vulkan.demo.model;
	exports org.sheepy.vulkan.demo.model.impl;

	requires transitive org.sheepy.vulkan;
	
	requires org.joml;
	
	// Make resources (shaders) public
	opens org.sheepy.vulkan.demo.triangle;
	opens org.sheepy.vulkan.demo.rotatingtriangle;
	opens org.sheepy.vulkan.demo.texture;
}
