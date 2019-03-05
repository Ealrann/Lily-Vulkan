package org.sheepy.lily.vulkan.api.nativehelper.device.capabilities;

import static org.lwjgl.vulkan.KHRSurface.vkGetPhysicalDeviceSurfaceCapabilitiesKHR;

import org.lwjgl.vulkan.VkPhysicalDevice;
import org.lwjgl.vulkan.VkSurfaceCapabilitiesKHR;
import org.sheepy.lily.vulkan.api.nativehelper.surface.VkSurface;
import org.sheepy.lily.vulkan.api.util.Logger;

public class Capabilities
{
	private static final String FAILED_TO_GET_SURFACE_CAPABILITIES = "Failed to get physical device surface capabilities";
	public VkSurfaceCapabilitiesKHR vkCapabilities;

	public Capabilities(VkPhysicalDevice device, VkSurface surface)
	{
		vkCapabilities = VkSurfaceCapabilitiesKHR.calloc();
		final var err = vkGetPhysicalDeviceSurfaceCapabilitiesKHR(device, surface.ptr,
				vkCapabilities);
		Logger.check(err, FAILED_TO_GET_SURFACE_CAPABILITIES);
	}

	public void free()
	{
		vkCapabilities.free();
		vkCapabilities = null;
	}
}
