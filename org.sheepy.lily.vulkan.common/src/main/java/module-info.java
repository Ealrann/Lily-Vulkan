import org.sheepy.lily.core.api.adapter.IAdapterProvider;
import org.sheepy.lily.vulkan.common.Adapters;

module org.sheepy.lily.vulkan.common
{
	requires transitive org.sheepy.lily.vulkan.api;
	requires transitive org.lwjgl.vulkan;
	requires transitive org.lwjgl.glfw;

	requires org.lwjgl.natives;
	requires org.lwjgl.glfw.natives;

	exports org.sheepy.lily.vulkan.common.allocation;
	exports org.sheepy.lily.vulkan.common.barrier;
	exports org.sheepy.lily.vulkan.common.concurrent;
	exports org.sheepy.lily.vulkan.common.descriptor;
	exports org.sheepy.lily.vulkan.common.device;
	exports org.sheepy.lily.vulkan.common.device.capabilities;
	exports org.sheepy.lily.vulkan.common.execution;
	exports org.sheepy.lily.vulkan.common.engine.extension;
	exports org.sheepy.lily.vulkan.common.execution.queue;
	exports org.sheepy.lily.vulkan.common.graphic;
	exports org.sheepy.lily.vulkan.common.instance;
	exports org.sheepy.lily.vulkan.common.pipeline;
	exports org.sheepy.lily.vulkan.common.process;
	exports org.sheepy.lily.vulkan.common.resource;
	exports org.sheepy.lily.vulkan.common.resource.attachment;
	exports org.sheepy.lily.vulkan.common.resource.buffer;
	exports org.sheepy.lily.vulkan.common.resource.font;
	exports org.sheepy.lily.vulkan.common.resource.image;
	exports org.sheepy.lily.vulkan.common.resource.memory;
	exports org.sheepy.lily.vulkan.common.util;
	exports org.sheepy.lily.vulkan.common.window;

	opens org.sheepy.lily.vulkan.common.cadence;
	opens org.sheepy.lily.vulkan.common.engine;

	provides IAdapterProvider with Adapters;
}
