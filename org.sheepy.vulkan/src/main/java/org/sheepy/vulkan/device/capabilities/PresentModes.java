package org.sheepy.vulkan.device.capabilities;

import static org.lwjgl.vulkan.KHRSurface.vkGetPhysicalDeviceSurfacePresentModesKHR;

import org.lwjgl.vulkan.VkPhysicalDevice;
import org.sheepy.vulkan.log.Logger;
import org.sheepy.vulkan.surface.VkSurface;

public class PresentModes
{
	public final int[] presentModes;

	public PresentModes(VkPhysicalDevice device, VkSurface surface)
	{
		final int[] count = new int[1];
		int err = vkGetPhysicalDeviceSurfacePresentModesKHR(device, surface.ptr, count, null);
		Logger.check(err, "Failed to get count of physical device surface presentation modes");

		presentModes = new int[count[0]];
		err = vkGetPhysicalDeviceSurfacePresentModesKHR(device, surface.ptr, count, presentModes);
		Logger.check(err, "Failed to get physical device surface presentation modes");
	}
}
