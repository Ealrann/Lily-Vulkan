package org.sheepy.vulkan.device.data;

import static org.lwjgl.vulkan.KHRSurface.vkGetPhysicalDeviceSurfacePresentModesKHR;

import org.lwjgl.vulkan.VkPhysicalDevice;
import org.sheepy.vulkan.util.Logger;
import org.sheepy.vulkan.window.Surface;

public class PresentModes
{
	public final int[] presentModes;

	public PresentModes(VkPhysicalDevice device, Surface surface)
	{
		final int[] count = new int[1];
		int err = vkGetPhysicalDeviceSurfacePresentModesKHR(device, surface.id, count, null);
		Logger.check(err, "Failed to get count of physical device surface presentation modes");

		presentModes = new int[count[0]];
		err = vkGetPhysicalDeviceSurfacePresentModesKHR(device, surface.id, count, presentModes);
		Logger.check(err, "Failed to get physical device surface presentation modes");
	}
}