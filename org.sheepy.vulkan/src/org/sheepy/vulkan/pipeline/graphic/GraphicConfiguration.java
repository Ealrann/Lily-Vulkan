package org.sheepy.vulkan.pipeline.graphic;

import static org.lwjgl.vulkan.KHRSurface.VK_COLOR_SPACE_SRGB_NONLINEAR_KHR;
import static org.lwjgl.vulkan.KHRSurface.VK_PRESENT_MODE_MAILBOX_KHR;
import static org.lwjgl.vulkan.VK10.*;

import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.pipeline.Configuration;
import org.sheepy.vulkan.swapchain.ColorDomain;

public class GraphicConfiguration extends Configuration
{
	public final ColorDomain targetColorDomain;

	public IRenderPass renderPass;
	
	public boolean clearBeforeRender = true;

	public int presentationMode = VK_PRESENT_MODE_MAILBOX_KHR;
	public int swapImageUsages = VK_IMAGE_USAGE_COLOR_ATTACHMENT_BIT;

	public int frameWaitStage = VK_PIPELINE_STAGE_COLOR_ATTACHMENT_OUTPUT_BIT;

	public boolean depthBuffer = false;

	public GraphicConfiguration(LogicalDevice logicalDevice)
	{
		this(logicalDevice, VK_FORMAT_B8G8R8A8_UNORM, VK_COLOR_SPACE_SRGB_NONLINEAR_KHR);
	}

	public GraphicConfiguration(LogicalDevice logicalDevice, int imageFormat, int colorSpace)
	{
		super(logicalDevice);
		this.targetColorDomain = new ColorDomain(imageFormat, colorSpace);
	}
}
