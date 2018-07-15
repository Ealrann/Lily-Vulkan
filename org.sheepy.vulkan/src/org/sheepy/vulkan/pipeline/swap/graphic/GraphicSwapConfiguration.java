package org.sheepy.vulkan.pipeline.swap.graphic;

import static org.lwjgl.vulkan.VK10.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.lwjgl.vulkan.VkDevice;
import org.sheepy.vulkan.command.CommandPool;
import org.sheepy.vulkan.descriptor.DescriptorPool;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.pipeline.swap.IGraphicsPipeline;
import org.sheepy.vulkan.pipeline.swap.SwapConfiguration;
import org.sheepy.vulkan.pipeline.swap.graphic.impl.BasicColorBlendState;
import org.sheepy.vulkan.pipeline.swap.graphic.impl.BasicDepthStencilState;
import org.sheepy.vulkan.pipeline.swap.graphic.impl.BasicInputAssembly;
import org.sheepy.vulkan.pipeline.swap.graphic.impl.BasicMultisampleState;
import org.sheepy.vulkan.pipeline.swap.graphic.impl.BasicRasterizer;
import org.sheepy.vulkan.pipeline.swap.graphic.impl.BasicShaderStage;
import org.sheepy.vulkan.pipeline.swap.graphic.impl.BasicViewportState;
import org.sheepy.vulkan.pipeline.swap.graphic.impl.IndexBufferDescriptor;
import org.sheepy.vulkan.shader.Shader;

public class GraphicSwapConfiguration extends SwapConfiguration
{
	public IGraphicsPipeline graphicsPipeline;
	
	public final DescriptorPool descriptorPool;
	public final List<Shader> shaders;

	public GraphicSwapConfiguration(LogicalDevice logicalDevice, CommandPool commandPool,
			DescriptorPool descriptorPool, List<Shader> shaders)
	{
		super(logicalDevice, commandPool);
		this.descriptorPool = descriptorPool;
		this.shaders = Collections.unmodifiableList(new ArrayList<>(shaders));
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
