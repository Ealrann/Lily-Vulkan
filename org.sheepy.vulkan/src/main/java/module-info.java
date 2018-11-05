import org.sheepy.common.api.adapter.IServiceAdapter;
import org.sheepy.vulkan.application.LogicalDeviceAdapter;
import org.sheepy.vulkan.application.VulkanApplicationAdapter;
import org.sheepy.vulkan.pipeline.compute.ComputePipelineAdapter;
import org.sheepy.vulkan.pipeline.compute.ComputerAdapter;
import org.sheepy.vulkan.pipeline.graphic.image.ImagePipelineAdapter;
import org.sheepy.vulkan.process.compute.ComputeProcessAdapter;
import org.sheepy.vulkan.process.graphic.GraphicProcessAdapter;
import org.sheepy.vulkan.processpool.ExecutionManagerAdapter;
import org.sheepy.vulkan.processpool.ResourceManagerAdapter;
import org.sheepy.vulkan.processpool.compute.ComputeContextAdapter;
import org.sheepy.vulkan.processpool.compute.ComputeProcessPoolAdapter;
import org.sheepy.vulkan.processpool.graphic.GraphicContextAdapter;
import org.sheepy.vulkan.processpool.graphic.GraphicProcessPoolAdapter;
import org.sheepy.vulkan.resource.buffer.PushConstantAdapter;
import org.sheepy.vulkan.resource.descriptor.DescriptorSetAdapter;
import org.sheepy.vulkan.resource.file.FileResourceAdapter;
import org.sheepy.vulkan.resource.file.ModuleResourceAdapter;
import org.sheepy.vulkan.resource.image.DepthImageAdapter;
import org.sheepy.vulkan.resource.shader.ShaderAdapter;
import org.sheepy.vulkan.resource.texture.TextureAdapter;

/**
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

	requires transitive org.sheepy.common;

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
	exports org.sheepy.vulkan.model.process;
	exports org.sheepy.vulkan.model.process.impl;
	exports org.sheepy.vulkan.model.resource;
	exports org.sheepy.vulkan.model.resource.impl;

	provides IServiceAdapter
			with LogicalDeviceAdapter, VulkanApplicationAdapter, GraphicProcessPoolAdapter,
			ComputeProcessPoolAdapter, GraphicProcessAdapter, ComputeProcessAdapter,
			ComputePipelineAdapter, ComputerAdapter, ImagePipelineAdapter, ShaderAdapter,
			TextureAdapter, DepthImageAdapter, FileResourceAdapter, ModuleResourceAdapter,
			PushConstantAdapter, DescriptorSetAdapter, ResourceManagerAdapter,
			ExecutionManagerAdapter, GraphicContextAdapter, ComputeContextAdapter;
	
	requires org.junit.jupiter.api;
}