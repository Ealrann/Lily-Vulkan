package org.sheepy.lily.vulkan.process.graphic.frame;

import static org.lwjgl.system.MemoryUtil.memAllocInt;
import static org.lwjgl.system.MemoryUtil.memFree;
import static org.lwjgl.vulkan.KHRSurface.VK_PRESENT_MODE_FIFO_KHR;
import static org.lwjgl.vulkan.KHRSurface.vkGetPhysicalDeviceSurfacePresentModesKHR;

import java.nio.IntBuffer;

import org.sheepy.lily.vulkan.api.nativehelper.surface.VkSurface;
import org.sheepy.lily.vulkan.api.util.Logger;
import org.sheepy.lily.vulkan.common.device.LogicalDevice;
import org.sheepy.lily.vulkan.model.enumeration.EPresentMode;

public class PresentationModeSelector
{
	private final LogicalDevice logicalDevice;
	private final VkSurface surface;

	public PresentationModeSelector(LogicalDevice logicalDevice, VkSurface surface)
	{
		this.logicalDevice = logicalDevice;
		this.surface = surface;
	}

	public int findBestMode(EPresentMode desiredMode)
	{
		IntBuffer pPresentModeCount = memAllocInt(1);
		int err = vkGetPhysicalDeviceSurfacePresentModesKHR(logicalDevice.getVkPhysicalDevice(),
				surface.ptr, pPresentModeCount, null);
		int presentModeCount = pPresentModeCount.get(0);
		Logger.check(err, "Failed to get count of physical device surface presentation modes");

		IntBuffer pPresentModes = memAllocInt(presentModeCount);
		err = vkGetPhysicalDeviceSurfacePresentModesKHR(logicalDevice.getVkPhysicalDevice(),
				surface.ptr, pPresentModeCount, pPresentModes);
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
		}
		memFree(pPresentModeCount);
		memFree(pPresentModes);

		return swapchainPresentMode;
	}
}
