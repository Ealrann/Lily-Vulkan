import org.sheepy.lily.core.api.adapter.annotation.Adapters;
import org.sheepy.lily.vulkan.common.engine.VulkanEngineAdapter;

@Adapters(classifiers = VulkanEngineAdapter.class)

module org.sheepy.lily.vulkan.common
{
	requires transitive org.sheepy.lily.vulkan.api;

	requires org.sheepy.lily.core.impl;

	exports org.sheepy.lily.vulkan.common.allocation.adapter;
	exports org.sheepy.lily.vulkan.common.allocation.allocator;
	exports org.sheepy.lily.vulkan.common.allocation.common;
	exports org.sheepy.lily.vulkan.common.concurrent;
	exports org.sheepy.lily.vulkan.common.device;
	exports org.sheepy.lily.vulkan.common.device.data;
	exports org.sheepy.lily.vulkan.common.device.display;
	exports org.sheepy.lily.vulkan.common.execution;
	exports org.sheepy.lily.vulkan.common.engine;
	exports org.sheepy.lily.vulkan.common.input;
	exports org.sheepy.lily.vulkan.common.nativehelper;
	exports org.sheepy.lily.vulkan.common.resource;
	exports org.sheepy.lily.vulkan.common.resource.image;
	exports org.sheepy.lily.vulkan.common.queue;
	exports org.sheepy.lily.vulkan.common.util;
	exports org.sheepy.lily.vulkan.common.ui;
}
