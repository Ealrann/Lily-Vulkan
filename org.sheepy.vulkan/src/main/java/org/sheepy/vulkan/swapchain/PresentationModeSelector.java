package org.sheepy.vulkan.swapchain;

import static org.lwjgl.system.MemoryUtil.memAllocInt;
import static org.lwjgl.system.MemoryUtil.memFree;
import static org.lwjgl.vulkan.KHRSurface.VK_PRESENT_MODE_FIFO_KHR;
import static org.lwjgl.vulkan.KHRSurface.VK_PRESENT_MODE_MAILBOX_KHR;
import static org.lwjgl.vulkan.KHRSurface.vkGetPhysicalDeviceSurfacePresentModesKHR;
import static org.lwjgl.vulkan.VK10.VK_SUCCESS;

import java.nio.IntBuffer;

import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.model.enumeration.EPresentMode;
import org.sheepy.vulkan.util.VulkanUtils;
import org.sheepy.vulkan.window.Surface;

public class PresentationModeSelector
{
	private LogicalDevice logicalDevice;
	private Surface surface;

	public PresentationModeSelector(LogicalDevice logicalDevice, Surface surface)
	{
		this.logicalDevice = logicalDevice;
		this.surface = surface;
	}

	public int findBestMode(EPresentMode desiredMode)
	{
		IntBuffer pPresentModeCount = memAllocInt(1);
		int err = vkGetPhysicalDeviceSurfacePresentModesKHR(logicalDevice.getVkPhysicalDevice(),
				surface.id, pPresentModeCount, null);
		int presentModeCount = pPresentModeCount.get(0);
		if (err != VK_SUCCESS)
		{
			throw new AssertionError(
					"Failed to get number of physical device surface presentation modes: "
							+ VulkanUtils.translateVulkanResult(err));
		}

		IntBuffer pPresentModes = memAllocInt(presentModeCount);
		err = vkGetPhysicalDeviceSurfacePresentModesKHR(logicalDevice.getVkPhysicalDevice(),
				surface.id, pPresentModeCount, pPresentModes);
		if (err != VK_SUCCESS)
		{
			throw new AssertionError("Failed to get physical device surface presentation modes: "
					+ VulkanUtils.translateVulkanResult(err));
		}

		// Try to use mailbox mode. Low latency and non-tearing
		int swapchainPresentMode = VK_PRESENT_MODE_FIFO_KHR;
		for (int i = 0; i < presentModeCount; i++)
		{
			if (pPresentModes.get(i) == desiredMode.getValue())
			{
				swapchainPresentMode = pPresentModes.get(i);
				break;
			}
			if (pPresentModes.get(i) == VK_PRESENT_MODE_MAILBOX_KHR)
			{
				swapchainPresentMode = pPresentModes.get(i);
			}
		}
		memFree(pPresentModeCount);
		memFree(pPresentModes);

		return swapchainPresentMode;
	}
}
