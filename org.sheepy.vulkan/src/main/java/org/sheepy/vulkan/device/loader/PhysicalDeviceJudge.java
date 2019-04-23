package org.sheepy.vulkan.device.loader;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkPhysicalDeviceFeatures;
import org.sheepy.vulkan.device.PhysicalDevice;
import org.sheepy.vulkan.device.capabilities.ColorDomains;
import org.sheepy.vulkan.device.capabilities.PresentModes;
import org.sheepy.vulkan.surface.VkSurface;

public class PhysicalDeviceJudge
{
	private ColorDomains colorDomains;
	private PresentModes modes;

	public PhysicalDeviceJudge()
	{}

	public int rateDeviceSuitability(PhysicalDevice physicalDevice, VkSurface surface)
	{
		colorDomains = new ColorDomains(physicalDevice.vkPhysicalDevice, surface);
		modes = new PresentModes(physicalDevice.vkPhysicalDevice, surface);
		final var deviceProperties = physicalDevice.deviceProperties.vkDeviceProperties;

		final VkPhysicalDeviceFeatures deviceFeatures = VkPhysicalDeviceFeatures.calloc();
		vkGetPhysicalDeviceFeatures(physicalDevice.vkPhysicalDevice, deviceFeatures);
		int score = 0;

		// Discrete GPUs have a significant performance advantage
		if (deviceProperties.deviceType() == VK_PHYSICAL_DEVICE_TYPE_DISCRETE_GPU)
		{
			score += 1000;
		}

		// Maximum possible size of textures affects graphics quality
		score += deviceProperties.limits().maxImageDimension2D();

		if (physicalDevice.getRetainedExtensions() == null
				|| isAdequate() == false
				|| deviceFeatures.samplerAnisotropy() == false)
		{
			score = 0;
		}
		else
		{
			score += physicalDevice.getRetainedExtensions().size() * 100;
		}

		deviceFeatures.free();

		return score;
	}

	public boolean isAdequate()
	{
		return colorDomains.size() != 0 && modes.presentModes.length > 0;
	}
}
