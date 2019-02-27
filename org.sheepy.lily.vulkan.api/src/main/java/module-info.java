module org.sheepy.lily.vulkan.api
{
	requires transitive org.sheepy.lily.core.api;

	requires transitive org.lwjgl;
	requires transitive org.lwjgl.vulkan;
	requires transitive org.lwjgl.glfw;
	requires transitive org.lwjgl.stb;

	requires transitive org.joml;

	requires org.lwjgl.natives;
	requires org.lwjgl.glfw.natives;
	requires org.lwjgl.stb.natives;

	exports org.sheepy.lily.vulkan.api.adapter;
	exports org.sheepy.lily.vulkan.api.concurrent;
	exports org.sheepy.lily.vulkan.api.nativehelper;
	exports org.sheepy.lily.vulkan.api.nativehelper.device.capabilities;
	exports org.sheepy.lily.vulkan.api.nativehelper.surface;
	exports org.sheepy.lily.vulkan.api.nativehelper.window;
	exports org.sheepy.lily.vulkan.api.queue;
	exports org.sheepy.lily.vulkan.api.util;

	exports org.sheepy.lily.vulkan.model;
	exports org.sheepy.lily.vulkan.model.impl;
	exports org.sheepy.lily.vulkan.model.util;
	exports org.sheepy.lily.vulkan.model.enumeration;
	exports org.sheepy.lily.vulkan.model.enumeration.impl;
	exports org.sheepy.lily.vulkan.model.process;
	exports org.sheepy.lily.vulkan.model.process.impl;
	exports org.sheepy.lily.vulkan.model.process.util;
	exports org.sheepy.lily.vulkan.model.process.compute;
	exports org.sheepy.lily.vulkan.model.process.compute.impl;
	exports org.sheepy.lily.vulkan.model.process.compute.util;
	exports org.sheepy.lily.vulkan.model.process.graphic;
	exports org.sheepy.lily.vulkan.model.process.graphic.impl;
	exports org.sheepy.lily.vulkan.model.process.graphic.util;
	exports org.sheepy.lily.vulkan.model.resource;
	exports org.sheepy.lily.vulkan.model.resource.impl;
	exports org.sheepy.lily.vulkan.model.resource.util;
}
