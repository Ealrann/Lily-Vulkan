import org.sheepy.lily.core.api.adapter.annotation.Adapters;
import org.sheepy.lily.vulkan.demo.test.adapter.TestDataProviderAdapter;

@Adapters(classifiers = {
		TestDataProviderAdapter.class
})

module org.sheepy.lily.vulkan.demo.test
{
	requires org.sheepy.lily.vulkan.base;

	requires org.joml;
	
	opens org.sheepy.lily.vulkan.demo.test.adapter;
}
