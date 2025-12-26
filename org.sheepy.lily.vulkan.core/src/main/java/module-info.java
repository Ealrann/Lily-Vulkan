module org.sheepy.lily.vulkan.core
{
	requires transitive org.sheepy.lily.vulkan.api;
	requires transitive org.sheepy.lily.game.core;
	requires transitive org.lwjgl.glfw;
	requires transitive org.lwjgl.vulkan;

	opens org.sheepy.lily.vulkan.core.cadence to logoce.lmf.core.api;
	opens org.sheepy.lily.vulkan.core.descriptor to logoce.lmf.core.api;
	opens org.sheepy.lily.vulkan.core.engine to logoce.lmf.core.api;
	opens org.sheepy.lily.vulkan.core.input to logoce.lmf.core.api;
	opens org.sheepy.lily.vulkan.core.variable to logoce.lmf.core.api;

	requires org.lwjgl.natives;
	requires org.lwjgl.glfw.natives;

	exports org.sheepy.lily.vulkan.core.barrier;
	exports org.sheepy.lily.vulkan.core.cadence;
	exports org.sheepy.lily.vulkan.core.concurrent;
	exports org.sheepy.lily.vulkan.core.debug;
	exports org.sheepy.lily.vulkan.core.descriptor;
	exports org.sheepy.lily.vulkan.core.device;
	exports org.sheepy.lily.vulkan.core.device.capabilities;
	exports org.sheepy.lily.vulkan.core.device.data;
	exports org.sheepy.lily.vulkan.core.device.loader;
	exports org.sheepy.lily.vulkan.core.engine;
	exports org.sheepy.lily.vulkan.core.engine.extension;
	exports org.sheepy.lily.vulkan.core.engine.utils;
	exports org.sheepy.lily.vulkan.core.execution;
	exports org.sheepy.lily.vulkan.core.execution.loader;
	exports org.sheepy.lily.vulkan.core.execution.queue;
	exports org.sheepy.lily.vulkan.core.graphic;
	exports org.sheepy.lily.vulkan.core.instance;
	exports org.sheepy.lily.vulkan.core.instance.loader;
	exports org.sheepy.lily.vulkan.core.input;
	exports org.sheepy.lily.vulkan.core.pipeline;
	exports org.sheepy.lily.vulkan.core.process;
	exports org.sheepy.lily.vulkan.core.resource;
	exports org.sheepy.lily.vulkan.core.resource.attachment;
	exports org.sheepy.lily.vulkan.core.resource.buffer;
	exports org.sheepy.lily.vulkan.core.resource.image;
	exports org.sheepy.lily.vulkan.core.resource.memory;
	exports org.sheepy.lily.vulkan.core.resource.memory.builder;
	exports org.sheepy.lily.vulkan.core.resource.util;
	exports org.sheepy.lily.vulkan.core.util;
	exports org.sheepy.lily.vulkan.core.variable;
	exports org.sheepy.lily.vulkan.core.window;

	provides org.logoce.lmf.core.api.extender.IAdapterProvider
			with org.sheepy.lily.vulkan.core.Extenders;

	provides org.sheepy.lily.vulkan.api.debug.IVulkanDebugService
			with org.sheepy.lily.vulkan.core.debug.VulkanDebugService;
}
