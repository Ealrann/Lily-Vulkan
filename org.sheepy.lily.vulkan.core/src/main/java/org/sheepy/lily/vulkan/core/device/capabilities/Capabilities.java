package org.sheepy.lily.vulkan.core.device.capabilities;

import static org.lwjgl.vulkan.KHRSurface.vkGetPhysicalDeviceSurfaceCapabilitiesKHR;

import org.lwjgl.vulkan.VkPhysicalDevice;
import org.lwjgl.vulkan.VkSurfaceCapabilitiesKHR;
import org.sheepy.lily.vulkan.core.util.Logger;
import org.sheepy.lily.vulkan.core.window.VkSurface;

public final class Capabilities
{
	private static final String FAILED_TO_GET_SURFACE_CAPABILITIES = "Failed to get physical device surface capabilities";

	public VkSurfaceCapabilitiesKHR vkCapabilities;

	public Capabilities(VkPhysicalDevice device, VkSurface surface)
	{
		vkCapabilities = VkSurfaceCapabilitiesKHR.calloc();

		if (surface.isDeprecated() == false)
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
