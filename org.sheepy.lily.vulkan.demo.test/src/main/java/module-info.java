import org.sheepy.lily.core.api.adapter.IAdapterProvider;
import org.sheepy.lily.vulkan.demo.test.composite.Adapters;

module org.sheepy.lily.vulkan.demo.test
{
	requires org.sheepy.lily.vulkan.api;

	requires org.joml;

	opens org.sheepy.lily.vulkan.demo.test.composite.grow;
	opens org.sheepy.lily.vulkan.demo.test.composite.grow.adapter;
	opens org.sheepy.lily.vulkan.demo.test.composite.instance;
	opens org.sheepy.lily.vulkan.demo.test.composite.instance.adapter;

	provides IAdapterProvider with Adapters;
}
