import org.sheepy.lily.core.api.adapter.annotation.Adapters;
import org.sheepy.lily.vulkan.demo.test.composite.grow.MainCompositeBufferTest;
import org.sheepy.lily.vulkan.demo.test.composite.grow.adapter.TestDataProviderAdapter;
import org.sheepy.lily.vulkan.demo.test.composite.instance.MainCompositeInstanceTest;
import org.sheepy.lily.vulkan.demo.test.composite.instance.adapter.InstanceDataProviderAdapter;

@Adapters(classifiers = {
		TestDataProviderAdapter.class,
		InstanceDataProviderAdapter.class,
		MainCompositeBufferTest.CadenceAdapter.class,
		MainCompositeInstanceTest.CadenceAdapter.class
})

module org.sheepy.lily.vulkan.demo.test
{
	requires org.sheepy.lily.vulkan.base;

	requires org.joml;

	opens org.sheepy.lily.vulkan.demo.test.composite.grow;
	opens org.sheepy.lily.vulkan.demo.test.composite.grow.adapter;
	opens org.sheepy.lily.vulkan.demo.test.composite.instance;
	opens org.sheepy.lily.vulkan.demo.test.composite.instance.adapter;
}
