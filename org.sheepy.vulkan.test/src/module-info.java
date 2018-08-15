/**
 * 
 */
/**
 * @author ealrann
 *
 */
module org.sheepy.vulkan.test {
	
	exports test.vulkan.mesh;

	requires transitive org.sheepy.vulkan;
	
	// Make resources (shaders) public
	opens test.vulkan.triangle;
	opens test.vulkan.rotatingtriangle;
	opens test.vulkan.texture;
	opens test.vulkan.gameoflife;
}