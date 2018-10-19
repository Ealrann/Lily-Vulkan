/**
 * 
 */
/**
 * @author ealrann
 *
 */
module org.sheepy.vulkan.demo {
	
	exports test.vulkan.mesh;

	requires transitive org.sheepy.vulkan;
	
	requires org.joml;
	
	// Make resources (shaders) public
	opens test.vulkan.triangle;
	opens test.vulkan.rotatingtriangle;
	opens test.vulkan.texture;
	opens test.vulkan.gameoflife;
}