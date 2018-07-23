package org.sheepy.vulkan.pipeline.graphic;

import static org.lwjgl.vulkan.KHRSurface.VK_COLOR_SPACE_SRGB_NONLINEAR_KHR;
import static org.lwjgl.vulkan.KHRSurface.VK_PRESENT_MODE_MAILBOX_KHR;
import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.command.CommandPool;
import org.sheepy.vulkan.common.IAllocable;
import org.sheepy.vulkan.concurrent.VkSemaphore;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.swapchain.ColorDomain;

public class GraphicConfiguration implements IAllocable
{
	public final ColorDomain targetColorDomain;
	public final LogicalDevice logicalDevice;
	public final CommandPool commandPool;
	
	public IRenderPass renderPass;

	public final VkSemaphore imageAvailableSemaphore;

	public int presentationMode = VK_PRESENT_MODE_MAILBOX_KHR;
	public int swapImageUsages = VK_IMAGE_USAGE_COLOR_ATTACHMENT_BIT;

	public int frameWaitStage = VK_PIPELINE_STAGE_COLOR_ATTACHMENT_OUTPUT_BIT;

	public boolean depthBuffer = false;

	public GraphicConfiguration(LogicalDevice logicalDevice, CommandPool commandPool)
	{
		this(logicalDevice, commandPool, VK_FORMAT_B8G8R8A8_UNORM,
				VK_COLOR_SPACE_SRGB_NONLINEAR_KHR);
	}

	public GraphicConfiguration(LogicalDevice logicalDevice, CommandPool commandPool,
			int imageFormat, int colorSpace)
	{
		this.targetColorDomain = new ColorDomain(imageFormat, colorSpace);
		this.logicalDevice = logicalDevice;
		this.commandPool = commandPool;

		imageAvailableSemaphore = new VkSemaphore(logicalDevice);
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		imageAvailableSemaphore.allocate(stack);
	}

	@Override
	public void free()
	{
		imageAvailableSemaphore.free();
	}
}
