import org.sheepy.common.api.adapter.IAdapter;
import org.sheepy.vulkan.common.application.LogicalDeviceAdapter;
import org.sheepy.vulkan.common.engine.ExecutionManagerAdapter;
import org.sheepy.vulkan.common.engine.SharedResourcesAdapter;
import org.sheepy.vulkan.common.engine.VulkanEngineAdapter;

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
	exports org.sheepy.vulkan.common.engine;
	exports org.sheepy.vulkan.common.input;
	exports org.sheepy.vulkan.common.nativehelper;
	exports org.sheepy.vulkan.common.resource.image;
	exports org.sheepy.vulkan.common.queue;
	exports org.sheepy.vulkan.common.util;
	exports org.sheepy.vulkan.common.ui;
	exports org.sheepy.vulkan.common.window;

	opens org.sheepy.vulkan.common.application;

	provides IAdapter with LogicalDeviceAdapter, VulkanEngineAdapter, ExecutionManagerAdapter,
			SharedResourcesAdapter;
}
