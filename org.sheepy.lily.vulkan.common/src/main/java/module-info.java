import org.sheepy.lily.core.api.adapter.annotation.Adapters;
import org.sheepy.lily.vulkan.common.engine.VulkanEngineAdapter;

@Adapters(classifiers = VulkanEngineAdapter.class)

module org.sheepy.lily.vulkan.common
{
	requires transitive org.sheepy.lily.vulkan.api;

	requires org.sheepy.lily.core.impl;

	exports org.sheepy.lily.vulkan.common.allocation;
	exports org.sheepy.lily.vulkan.common.util;

	opens org.sheepy.lily.vulkan.common.engine;
}
