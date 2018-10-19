/**
 * 
 */
open module org.sheepy.vulkan
{
	requires transitive org.lwjgl;
	requires transitive org.lwjgl.vulkan;
	requires transitive org.lwjgl.glfw;
	requires transitive org.joml;
	
	requires org.lwjgl.stb;
	
	requires org.lwjgl.natives;
	requires org.lwjgl.glfw.natives;
	requires org.lwjgl.stb.natives;

	requires transitive org.sheepy.common;
	
	requires transitive org.eclipse.emf.common;
	requires transitive org.eclipse.emf.ecore;

	exports org.sheepy.vulkan;
	exports org.sheepy.vulkan.adapter;
	exports org.sheepy.vulkan.allocation;
	exports org.sheepy.vulkan.concurrent;
	exports org.sheepy.vulkan.device;
	exports org.sheepy.vulkan.device.data;
	exports org.sheepy.vulkan.execution;
	exports org.sheepy.vulkan.execution.graphic;
	exports org.sheepy.vulkan.execution.queue;
	exports org.sheepy.vulkan.pipeline.graphic;
	exports org.sheepy.vulkan.pipeline.graphic.render;
	exports org.sheepy.vulkan.processpool;
	exports org.sheepy.vulkan.processpool.graphic;
	exports org.sheepy.vulkan.resource;
	exports org.sheepy.vulkan.resource.buffer;
	exports org.sheepy.vulkan.resource.descriptor;
	exports org.sheepy.vulkan.resource.indexed;
	exports org.sheepy.vulkan.resource.image;
	exports org.sheepy.vulkan.resource.texture;
	exports org.sheepy.vulkan.view;
	exports org.sheepy.vulkan.window;
	exports org.sheepy.vulkan.util;
	
	exports org.sheepy.vulkan.model;
	exports org.sheepy.vulkan.model.impl;

	exports org.sheepy.vulkan.model.enumeration;
	exports org.sheepy.vulkan.model.enumeration.impl;
	
	
	requires org.junit.jupiter.api;
}