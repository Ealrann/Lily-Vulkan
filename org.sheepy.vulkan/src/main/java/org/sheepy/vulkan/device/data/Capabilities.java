package org.sheepy.vulkan.device.data;

import static org.lwjgl.vulkan.KHRSurface.vkGetPhysicalDeviceSurfaceCapabilitiesKHR;

import org.lwjgl.vulkan.VkPhysicalDevice;
import org.lwjgl.vulkan.VkSurfaceCapabilitiesKHR;
import org.sheepy.vulkan.util.Logger;
import org.sheepy.vulkan.util.VulkanUtils;
import org.sheepy.vulkan.window.Surface;

public class Capabilities
{
	public final VkSurfaceCapabilitiesKHR vkCapabilities;

	public Capabilities(VkPhysicalDevice device, Surface surface)
	{
		vkCapabilities = VkSurfaceCapabilitiesKHR.calloc();
		final var id = surface.id;
		final var err = vkGetPhysicalDeviceSurfaceCapabilitiesKHR(device, id, vkCapabilities);
		final String errorMessage = "Failed to get physical device surface capabilities: "
				+ VulkanUtils.translateVulkanResult(err);
		Logger.check(err, errorMessage);
	}

	public void free()
	{
		vkCapabilities.free();
	}
}
