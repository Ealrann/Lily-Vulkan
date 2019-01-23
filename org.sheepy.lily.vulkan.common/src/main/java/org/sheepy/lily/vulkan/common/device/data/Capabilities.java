package org.sheepy.vulkan.common.device.data;

import static org.lwjgl.vulkan.KHRSurface.vkGetPhysicalDeviceSurfaceCapabilitiesKHR;

import org.lwjgl.vulkan.VkPhysicalDevice;
import org.lwjgl.vulkan.VkSurfaceCapabilitiesKHR;
import org.sheepy.vulkan.api.window.Surface;
import org.sheepy.vulkan.common.util.Logger;

public class Capabilities
{
	private static final String FAILED_TO_GET_SURFACE_CAPABILITIES = "Failed to get physical device surface capabilities";
	public final VkSurfaceCapabilitiesKHR vkCapabilities;

	public Capabilities(VkPhysicalDevice device, Surface surface)
	{
		vkCapabilities = VkSurfaceCapabilitiesKHR.calloc();
		final var id = surface.id;
		final var err = vkGetPhysicalDeviceSurfaceCapabilitiesKHR(device, id, vkCapabilities);
		Logger.check(err, FAILED_TO_GET_SURFACE_CAPABILITIES);
	}

	public void free()
	{
		vkCapabilities.free();
	}
}
