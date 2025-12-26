module org.sheepy.lily.vulkan.api
{
	requires transitive org.sheepy.lily.game.api;
	requires transitive org.sheepy.vulkan;

	exports org.sheepy.lily.vulkan.api.concurrent;
	exports org.sheepy.lily.vulkan.api.debug;
	exports org.sheepy.lily.vulkan.api.device;
	exports org.sheepy.lily.vulkan.api.engine;
	exports org.sheepy.lily.vulkan.api.execution;
	exports org.sheepy.lily.vulkan.api.graphic;
	exports org.sheepy.lily.vulkan.api.input;
	exports org.sheepy.lily.vulkan.api.process;
	exports org.sheepy.lily.vulkan.api.resource.buffer;
	exports org.sheepy.lily.vulkan.api.util;
	exports org.sheepy.lily.vulkan.api.view;

	exports org.sheepy.lily.vulkan.model.process;
	exports org.sheepy.lily.vulkan.model.process.compute;
	exports org.sheepy.lily.vulkan.model.process.graphic;
	exports org.sheepy.lily.vulkan.model.vulkan;
	exports org.sheepy.lily.vulkan.model.vulkanresource;

	uses org.sheepy.lily.vulkan.api.debug.IVulkanDebugService;

	provides org.sheepy.lily.core.api.resource.IModelExtension
			with org.sheepy.lily.vulkan.api.model.LilyVulkanModelExtension;
}
