import org.logoce.extender.api.IAdapterProvider;
import org.sheepy.lily.vulkan.demo.Extenders;

module org.sheepy.lily.vulkan.demo.texture {
	requires org.sheepy.lily.vulkan.api;

	exports org.sheepy.lily.vulkan.demo.mesh;
	exports org.sheepy.lily.vulkan.demo.texture;
	exports org.sheepy.lily.vulkan.demo.rotating;
	exports org.sheepy.lily.vulkan.demo.triangle;
	exports org.sheepy.lily.vulkan.demo;

	opens org.sheepy.lily.vulkan.demo.adapter;
	opens org.sheepy.lily.vulkan.demo.texture;
	opens org.sheepy.lily.vulkan.demo.rotating;
	opens org.sheepy.lily.vulkan.demo.triangle;

	provides IAdapterProvider with Extenders;
}
