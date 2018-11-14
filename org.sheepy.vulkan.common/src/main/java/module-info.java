import org.sheepy.common.api.adapter.ISingletonAdapter;
import org.sheepy.vulkan.common.application.LogicalDeviceAdapter;
import org.sheepy.vulkan.common.application.VulkanApplicationAdapter;

/**
 * 
 */
module org.sheepy.vulkan.common
{
	requires transitive org.sheepy.vulkan.api;
	
	exports org.sheepy.vulkan.common.allocation;
	exports org.sheepy.vulkan.common.allocation.adapter;
	exports org.sheepy.vulkan.common.allocation.adapter.impl;
	exports org.sheepy.vulkan.common.allocation.allocator;
	exports org.sheepy.vulkan.common.allocation.allocator.wrapper;
	exports org.sheepy.vulkan.common.concurrent;
	exports org.sheepy.vulkan.common.device;
	exports org.sheepy.vulkan.common.device.data;
	exports org.sheepy.vulkan.common.execution;
	exports org.sheepy.vulkan.common.queue;
	exports org.sheepy.vulkan.common.window;
	exports org.sheepy.vulkan.common.util;

	provides ISingletonAdapter
			with LogicalDeviceAdapter, VulkanApplicationAdapter;
}
