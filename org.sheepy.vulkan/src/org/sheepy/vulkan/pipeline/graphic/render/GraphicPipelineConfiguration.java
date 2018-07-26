package org.sheepy.vulkan.pipeline.graphic.render;

import static org.lwjgl.vulkan.VK10.VK_CULL_MODE_BACK_BIT;
import static org.lwjgl.vulkan.VK10.VK_FRONT_FACE_CLOCKWISE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.lwjgl.vulkan.VkDevice;
import org.sheepy.vulkan.command.CommandPool;
import org.sheepy.vulkan.descriptor.IDescriptor;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.pipeline.IPipelineUnit;
import org.sheepy.vulkan.pipeline.graphic.render.impl.BasicColorBlendState;
import org.sheepy.vulkan.pipeline.graphic.render.impl.BasicDepthStencilState;
import org.sheepy.vulkan.pipeline.graphic.render.impl.BasicInputAssembly;
import org.sheepy.vulkan.pipeline.graphic.render.impl.BasicMultisampleState;
import org.sheepy.vulkan.pipeline.graphic.render.impl.BasicRasterizer;
import org.sheepy.vulkan.pipeline.graphic.render.impl.BasicShaderStage;
import org.sheepy.vulkan.pipeline.graphic.render.impl.BasicViewportState;
import org.sheepy.vulkan.pipeline.graphic.render.impl.IndexBufferDescriptor;
import org.sheepy.vulkan.resource.Shader;

public class GraphicPipelineConfiguration implements IPipelineUnit
{
	public final LogicalDevice logicalDevice;
	public final CommandPool commandPool;
	public final List<IDescriptor> descriptors;

	public GraphicsPipeline graphicPipeline;

	public final List<Shader> shaders;

	public GraphicPipelineConfiguration(LogicalDevice logicalDevice, CommandPool commandPool,
			List<Shader> shaders, List<IDescriptor> descriptors)
	{
		this.logicalDevice = logicalDevice;
		this.commandPool = commandPool;
		this.shaders = Collections.unmodifiableList(new ArrayList<>(shaders));
		this.descriptors = Collections.unmodifiableList(new ArrayList<>(descriptors));
	}

	public int rasterizerCullMode = VK_CULL_MODE_BACK_BIT;
	public int rasterizerFrontFace = VK_FRONT_FACE_CLOCKWISE;

	public IShaderStage shaderStage = new BasicShaderStage();
	public IVertexBufferDescriptor<?> vertexInputState = new IndexBufferDescriptor();
	public IInputAssembly inputAssembly = new BasicInputAssembly();
	public IViewportState viewportState = new BasicViewportState();
	public IRasterizer rasterizer = new BasicRasterizer(this);
	public IDepthStencilState depthStencilState = new BasicDepthStencilState();
	public IMultisampleState multisampleState = new BasicMultisampleState();
	public IColorBlendState colorBlendState = new BasicColorBlendState();

	public VkDevice getVkDevice()
	{
		return logicalDevice.getVkDevice();
	}
}
