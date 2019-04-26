module org.sheepy.vulkan
{
	requires transitive org.eclipse.emf.common;
	requires transitive org.eclipse.emf.ecore;
	requires transitive org.eclipse.emf.ecore.xmi;

	requires transitive org.lwjgl;
	requires transitive org.lwjgl.vulkan;
	requires transitive org.lwjgl.glfw;
	requires transitive org.lwjgl.stb;

	requires transitive org.joml;

	requires org.lwjgl.natives;
	requires org.lwjgl.glfw.natives;
	requires org.lwjgl.stb.natives;

	exports org.sheepy.vulkan.model.enumeration;
	exports org.sheepy.vulkan.model.enumeration.impl;
	exports org.sheepy.vulkan.model.enumeration.util;
	exports org.sheepy.vulkan.model.graphicpipeline;
	exports org.sheepy.vulkan.model.graphicpipeline.impl;
	exports org.sheepy.vulkan.model.graphicpipeline.util;

	exports org.sheepy.vulkan.allocation;
	exports org.sheepy.vulkan.concurrent;
	exports org.sheepy.vulkan.descriptor;
	exports org.sheepy.vulkan.device;
	exports org.sheepy.vulkan.device.data;
	exports org.sheepy.vulkan.device.capabilities;
	exports org.sheepy.vulkan.execution;
	exports org.sheepy.vulkan.extension;
	exports org.sheepy.vulkan.instance;
	exports org.sheepy.vulkan.log;
	exports org.sheepy.vulkan.pipeline;
	exports org.sheepy.vulkan.pipeline.builder;
	exports org.sheepy.vulkan.queue;
	exports org.sheepy.vulkan.resource.buffer;
	exports org.sheepy.vulkan.resource.image;
	exports org.sheepy.vulkan.resource.indexed;
	exports org.sheepy.vulkan.resource.memory;
	exports org.sheepy.vulkan.surface;
	exports org.sheepy.vulkan.util;
	exports org.sheepy.vulkan.window;
}
