package org.sheepy.vulkan.device.capabilities;

import static org.lwjgl.vulkan.KHRSurface.vkGetPhysicalDeviceSurfaceCapabilitiesKHR;

import org.lwjgl.vulkan.VkPhysicalDevice;
import org.lwjgl.vulkan.VkSurfaceCapabilitiesKHR;
import org.sheepy.vulkan.log.Logger;
import org.sheepy.vulkan.surface.VkSurface;

public class Capabilities
{
	private static final String FAILED_TO_GET_SURFACE_CAPABILITIES = "Failed to get physical device surface capabilities";

	public VkSurfaceCapabilitiesKHR vkCapabilities;

	public Capabilities(VkPhysicalDevice device, VkSurface surface)
	{
		vkCapabilities = VkSurfaceCapabilitiesKHR.calloc();

		if (surface.isDeprecated() == false && surface.ptr > 0)
		{
			final var err = vkGetPhysicalDeviceSurfaceCapabilitiesKHR(	device,
																		surface.ptr,
																		vkCapabilities);
			Logger.check(err, FAILED_TO_GET_SURFACE_CAPABILITIES);
		}
	}

	public void free()
	{
		vkCapabilities.free();
		vkCapabilities = null;
	}
}
