/**
 * 
 */
/**
 * @author ealrann
 *
 */
module org.sheepy.vulkan
{
	requires transitive org.lwjgl;
	requires transitive org.lwjgl.vulkan;
	requires transitive org.lwjgl.glfw;
	requires transitive org.joml;
	
	requires org.lwjgl.stb;
	
	requires org.lwjgl.natives;
	requires org.lwjgl.glfw.natives;
	requires org.lwjgl.stb.natives;
	
	
	
	exports org.sheepy.vulkan.descriptor;
	exports org.sheepy.vulkan.pipeline;
	exports org.sheepy.vulkan.queue;
	exports org.sheepy.vulkan.view;
	exports org.sheepy.vulkan.buffer;
	exports org.sheepy.vulkan.window;
	exports org.sheepy.vulkan.command;
	exports org.sheepy.vulkan;
	exports org.sheepy.vulkan.pipeline.graphic.render;
	exports org.sheepy.vulkan.swapchain;
	exports org.sheepy.vulkan.command.graphic;
	exports org.sheepy.vulkan.common;
	exports org.sheepy.vulkan.pipeline.graphic;
	exports org.sheepy.vulkan.pipeline.compute;
	exports org.sheepy.vulkan.pipeline.graphic.render.impl;
	exports org.sheepy.vulkan.util;
	exports org.sheepy.vulkan.device;
	exports org.sheepy.vulkan.concurrent;
	exports org.sheepy.vulkan.resource;
	exports org.sheepy.vulkan.command.compute;
	exports org.sheepy.vulkan.texture;

}