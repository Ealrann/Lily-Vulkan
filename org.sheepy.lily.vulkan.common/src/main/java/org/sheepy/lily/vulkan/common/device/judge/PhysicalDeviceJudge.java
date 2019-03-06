package org.sheepy.lily.vulkan.common.device.judge;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkPhysicalDeviceFeatures;
import org.sheepy.lily.vulkan.api.nativehelper.device.capabilities.ColorDomains;
import org.sheepy.lily.vulkan.api.nativehelper.device.capabilities.PresentModes;
import org.sheepy.lily.vulkan.api.nativehelper.surface.VkSurface;
import org.sheepy.lily.vulkan.common.device.PhysicalDevice;

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
		var deviceProperties = physicalDevice.deviceProperties.vkDeviceProperties;

		VkPhysicalDeviceFeatures deviceFeatures = VkPhysicalDeviceFeatures.calloc();
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
