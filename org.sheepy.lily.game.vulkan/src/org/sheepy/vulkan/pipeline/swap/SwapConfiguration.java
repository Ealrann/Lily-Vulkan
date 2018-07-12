package org.sheepy.vulkan.pipeline.swap;

import static org.lwjgl.vulkan.KHRSurface.VK_COLOR_SPACE_SRGB_NONLINEAR_KHR;
import static org.lwjgl.vulkan.KHRSurface.VK_PRESENT_MODE_MAILBOX_KHR;
import static org.lwjgl.vulkan.VK10.*;

import org.sheepy.vulkan.pipeline.swap.graphic.IColorBlendState;
import org.sheepy.vulkan.pipeline.swap.graphic.IDepthStencilState;
import org.sheepy.vulkan.pipeline.swap.graphic.IInputAssembly;
import org.sheepy.vulkan.pipeline.swap.graphic.IMultisampleState;
import org.sheepy.vulkan.pipeline.swap.graphic.IRasterizer;
import org.sheepy.vulkan.pipeline.swap.graphic.IShaderStage;
import org.sheepy.vulkan.pipeline.swap.graphic.IVertexDescriptor;
import org.sheepy.vulkan.pipeline.swap.graphic.IViewportState;
import org.sheepy.vulkan.pipeline.swap.graphic.impl.BasicColorBlendState;
import org.sheepy.vulkan.pipeline.swap.graphic.impl.BasicDepthStencilState;
import org.sheepy.vulkan.pipeline.swap.graphic.impl.BasicInputAssembly;
import org.sheepy.vulkan.pipeline.swap.graphic.impl.BasicMultisampleState;
import org.sheepy.vulkan.pipeline.swap.graphic.impl.BasicRasterizer;
import org.sheepy.vulkan.pipeline.swap.graphic.impl.BasicShaderStage;
import org.sheepy.vulkan.pipeline.swap.graphic.impl.BasicViewportState;
import org.sheepy.vulkan.pipeline.swap.graphic.impl.VertexDescriptor;
import org.sheepy.vulkan.swapchain.ColorDomain;

public class SwapConfiguration
{
	public final ColorDomain colorDomain;

	public SwapConfiguration()
	{
		this(VK_FORMAT_B8G8R8A8_UNORM, VK_COLOR_SPACE_SRGB_NONLINEAR_KHR);
	}

	public SwapConfiguration(int imageFormat, int colorSpace)
	{
		this.colorDomain = new ColorDomain(imageFormat, colorSpace);
	}

	public int presentationMode = VK_PRESENT_MODE_MAILBOX_KHR;

	public int rasterizerCullMode = VK_CULL_MODE_BACK_BIT;
	public int rasterizerFrontFace = VK_FRONT_FACE_CLOCKWISE;

	public int swapImageUsages = VK_IMAGE_USAGE_COLOR_ATTACHMENT_BIT;

	/**
	 * true if the graphic pipeline should activate a render pass during command
	 * recording
	 **/
	public boolean depthBuffer = false;

	public IShaderStage shaderStage = new BasicShaderStage();
	public IVertexDescriptor<?> vertexInputState = new VertexDescriptor();
	public IInputAssembly inputAssembly = new BasicInputAssembly();
	public IViewportState viewportState = new BasicViewportState();
	public IRasterizer rasterizer = new BasicRasterizer(this);
	public IDepthStencilState depthStencilState = new BasicDepthStencilState();
	public IMultisampleState multisampleState = new BasicMultisampleState();
	public IColorBlendState colorBlendState = new BasicColorBlendState();

}
