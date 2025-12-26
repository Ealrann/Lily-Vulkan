package org.sheepy.lily.vulkan.core.device.loader;

import org.lwjgl.vulkan.VkPhysicalDeviceFeatures;
import org.sheepy.lily.vulkan.core.device.PhysicalDevice;
import org.sheepy.lily.vulkan.core.device.capabilities.ColorDomains;
import org.sheepy.lily.vulkan.core.device.capabilities.PresentModes;
import org.sheepy.lily.vulkan.core.window.VkSurface;

import static org.lwjgl.vulkan.VK10.VK_PHYSICAL_DEVICE_TYPE_DISCRETE_GPU;
import static org.lwjgl.vulkan.VK10.vkGetPhysicalDeviceFeatures;

public final class PhysicalDeviceJudge
{
	private final VkSurface surface;

	public PhysicalDeviceJudge(VkSurface surface)
	{
		this.surface = surface;
	}

	public int rateDeviceSuitability(PhysicalDevice.Builder deviceBuilder)
	{
		int score = capabilityScore(deviceBuilder);

		if (surface != null)
		{
			final var colorDomains = new ColorDomains(deviceBuilder.vkPhysicalDevice, surface);
			final var modes = new PresentModes(deviceBuilder.vkPhysicalDevice, surface);
			if (colorDomains.size() == 0 || modes.presentModes.length == 0)
			{
				score = 0;
			}
		}

		return score;
	}

	private static int capabilityScore(PhysicalDevice.Builder deviceBuilder)
	{
		final var deviceProperties = deviceBuilder.deviceProperties.vkDeviceProperties;

		final VkPhysicalDeviceFeatures deviceFeatures = VkPhysicalDeviceFeatures.calloc();
		vkGetPhysicalDeviceFeatures(deviceBuilder.vkPhysicalDevice, deviceFeatures);
		int score = 0;

		// Discrete GPUs have a significant performance advantage
		if (deviceProperties.deviceType() == VK_PHYSICAL_DEVICE_TYPE_DISCRETE_GPU)
		{
			score += 15000;
		}

		// Maximum possible size of textures affects graphics quality
		score += deviceProperties.limits().maxImageDimension2D();

		if (deviceBuilder.deviceExtensions.isLackOfMandatoryExtensions() || deviceFeatures.samplerAnisotropy() == false)
		{
			score = 0;
		}
		else
		{
			score += deviceBuilder.deviceExtensions.retainedExtensionsCount() * 100;
		}

		deviceFeatures.free();

		return score;
	}
}
