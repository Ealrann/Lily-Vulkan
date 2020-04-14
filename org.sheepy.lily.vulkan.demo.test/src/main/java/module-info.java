import org.sheepy.lily.core.api.adapter.IAdapterProvider;
import org.sheepy.lily.vulkan.demo.test.composite.Adapters;

module org.sheepy.lily.vulkan.demo.test
{
	requires org.sheepy.lily.vulkan.api;

	requires org.joml;

	exports org.sheepy.lily.vulkan.demo.test.composite.grow;
	exports org.sheepy.lily.vulkan.demo.test.composite.grow.model;
	exports org.sheepy.lily.vulkan.demo.test.composite.instance;
	exports org.sheepy.lily.vulkan.demo.test.composite.instance.model;

	opens org.sheepy.lily.vulkan.demo.test.composite.grow;
	opens org.sheepy.lily.vulkan.demo.test.composite.grow.adapter;
	opens org.sheepy.lily.vulkan.demo.test.composite.instance;
	opens org.sheepy.lily.vulkan.demo.test.composite.instance.adapter;

	provides IAdapterProvider with Adapters;
}
