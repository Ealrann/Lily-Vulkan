import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.vulkan.common.application.LogicalDeviceAdapter;
import org.sheepy.lily.vulkan.common.engine.ExecutionManagerAdapter;
import org.sheepy.lily.vulkan.common.engine.SharedResourcesAdapter;
import org.sheepy.lily.vulkan.common.engine.VulkanEngineAdapter;

module org.sheepy.lily.vulkan.common
{
	requires transitive org.sheepy.lily.vulkan.api;

	exports org.sheepy.lily.vulkan.common.allocation;
	exports org.sheepy.lily.vulkan.common.allocation.adapter;
	exports org.sheepy.lily.vulkan.common.allocation.adapter.impl;
	exports org.sheepy.lily.vulkan.common.allocation.allocator;
	exports org.sheepy.lily.vulkan.common.allocation.allocator.wrapper;
	exports org.sheepy.lily.vulkan.common.concurrent;
	exports org.sheepy.lily.vulkan.common.device;
	exports org.sheepy.lily.vulkan.common.device.data;
	exports org.sheepy.lily.vulkan.common.execution;
	exports org.sheepy.lily.vulkan.common.engine;
	exports org.sheepy.lily.vulkan.common.input;
	exports org.sheepy.lily.vulkan.common.nativehelper;
	exports org.sheepy.lily.vulkan.common.resource.image;
	exports org.sheepy.lily.vulkan.common.queue;
	exports org.sheepy.lily.vulkan.common.util;
	exports org.sheepy.lily.vulkan.common.ui;
	exports org.sheepy.lily.vulkan.common.window;

	opens org.sheepy.lily.vulkan.common.application;

	provides IAdapter with LogicalDeviceAdapter, VulkanEngineAdapter, ExecutionManagerAdapter,
			SharedResourcesAdapter;
}
