import org.logoce.extender.api.IAdapterProvider;
import org.sheepy.lily.vulkan.demo.test.composite.Extenders;

module org.sheepy.lily.vulkan.demo.test {
	requires org.sheepy.lily.vulkan.api;

	requires org.joml;

	exports org.sheepy.lily.vulkan.demo.test.composite.grow;
	exports org.sheepy.lily.vulkan.demo.test.composite.grow.model;

	opens org.sheepy.lily.vulkan.demo.test.composite.grow;
	opens org.sheepy.lily.vulkan.demo.test.composite.grow.adapter;

	provides IAdapterProvider with Extenders;
}
