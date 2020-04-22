import org.sheepy.lily.core.api.extender.IExtenderProvider;
import org.sheepy.lily.vulkan.core.Extenders;

module org.sheepy.lily.vulkan.core {
	requires transitive org.sheepy.lily.vulkan.api;
	requires transitive org.sheepy.lily.game.core;
	requires transitive org.lwjgl.vulkan;
	requires transitive org.lwjgl.glfw;

	requires org.lwjgl.natives;
	requires org.lwjgl.glfw.natives;

	exports org.sheepy.lily.vulkan.core.barrier;
	exports org.sheepy.lily.vulkan.core.concurrent;
	exports org.sheepy.lily.vulkan.core.descriptor;
	exports org.sheepy.lily.vulkan.core.device;
	exports org.sheepy.lily.vulkan.core.device.capabilities;
	exports org.sheepy.lily.vulkan.core.device.data;
	exports org.sheepy.lily.vulkan.core.execution;
	exports org.sheepy.lily.vulkan.core.engine.extension;
	exports org.sheepy.lily.vulkan.core.execution.queue;
	exports org.sheepy.lily.vulkan.core.graphic;
	exports org.sheepy.lily.vulkan.core.pipeline;
	exports org.sheepy.lily.vulkan.core.process;
	exports org.sheepy.lily.vulkan.core.resource;
	exports org.sheepy.lily.vulkan.core.resource.attachment;
	exports org.sheepy.lily.vulkan.core.resource.buffer;
	exports org.sheepy.lily.vulkan.core.resource.font;
	exports org.sheepy.lily.vulkan.core.resource.image;
	exports org.sheepy.lily.vulkan.core.resource.memory;
	exports org.sheepy.lily.vulkan.core.util;
	exports org.sheepy.lily.vulkan.core.window;

	opens org.sheepy.lily.vulkan.core.cadence;
	opens org.sheepy.lily.vulkan.core.descriptor;
	opens org.sheepy.lily.vulkan.core.engine;
	opens org.sheepy.lily.vulkan.core.input;
	opens org.sheepy.lily.vulkan.core.variable;

	provides IExtenderProvider with Extenders;
}
