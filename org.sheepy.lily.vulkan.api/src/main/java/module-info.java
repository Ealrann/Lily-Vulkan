module org.sheepy.vulkan.api
{
	requires transitive org.sheepy.common.api;
	requires org.sheepy.common.impl;

	requires transitive org.lwjgl;
	requires transitive org.lwjgl.vulkan;
	requires transitive org.lwjgl.glfw;
	requires transitive org.lwjgl.stb;

	requires transitive org.joml;

	requires org.lwjgl.natives;
	requires org.lwjgl.glfw.natives;
	requires org.lwjgl.stb.natives;

	exports org.sheepy.vulkan.api.adapter;
	exports org.sheepy.vulkan.api.concurrent;
	exports org.sheepy.vulkan.api.queue;
	exports org.sheepy.vulkan.api.window;

	exports org.sheepy.vulkan.model;
	exports org.sheepy.vulkan.model.impl;
	exports org.sheepy.vulkan.model.util;
	exports org.sheepy.vulkan.model.enumeration;
	exports org.sheepy.vulkan.model.enumeration.impl;
	exports org.sheepy.vulkan.model.process;
	exports org.sheepy.vulkan.model.process.impl;
	exports org.sheepy.vulkan.model.process.util;
	exports org.sheepy.vulkan.model.process.compute;
	exports org.sheepy.vulkan.model.process.compute.impl;
	exports org.sheepy.vulkan.model.process.compute.util;
	exports org.sheepy.vulkan.model.process.graphic;
	exports org.sheepy.vulkan.model.process.graphic.impl;
	exports org.sheepy.vulkan.model.process.graphic.util;
	exports org.sheepy.vulkan.model.resource;
	exports org.sheepy.vulkan.model.resource.impl;
	exports org.sheepy.vulkan.model.resource.util;
}
