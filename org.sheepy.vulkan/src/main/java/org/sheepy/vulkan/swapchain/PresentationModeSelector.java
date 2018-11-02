package org.sheepy.vulkan.swapchain;

import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.vulkan.KHRSurface.*;

import java.nio.IntBuffer;

import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.model.enumeration.EPresentMode;
import org.sheepy.vulkan.util.Logger;
import org.sheepy.vulkan.window.Surface;

public class PresentationModeSelector
{
	private final LogicalDevice logicalDevice;
	private final Surface surface;

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
		Logger.check(err, "Failed to get count of physical device surface presentation modes");

		IntBuffer pPresentModes = memAllocInt(presentModeCount);
		err = vkGetPhysicalDeviceSurfacePresentModesKHR(logicalDevice.getVkPhysicalDevice(),
				surface.id, pPresentModeCount, pPresentModes);
		Logger.check(err, "Failed to get physical device surface presentation modes");

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
