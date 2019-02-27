package org.sheepy.lily.vulkan.common.device.judge;

import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import org.lwjgl.vulkan.VkExtensionProperties;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.lwjgl.vulkan.VkPhysicalDeviceFeatures;
import org.sheepy.lily.vulkan.api.nativehelper.device.capabilities.ColorDomains;
import org.sheepy.lily.vulkan.api.nativehelper.device.capabilities.PresentModes;
import org.sheepy.lily.vulkan.api.nativehelper.surface.VkSurface;
import org.sheepy.lily.vulkan.common.device.PhysicalDevice;

public class PhysicalDeviceJudge
{
	private final String[] requiredExtensions;

	private ColorDomains colorDomains;
	private PresentModes modes;

	public PhysicalDeviceJudge(String[] requiredExtensions)
	{
		this.requiredExtensions = requiredExtensions;
	}

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

		// Application can't work without required extensions
		// Application can't work without swap chain
		if (checkDeviceExtensionSupport(physicalDevice.vkPhysicalDevice) == false
				|| isAdequate() == false
				|| deviceFeatures.samplerAnisotropy() == false)
		{
			score = 0;
		}

		deviceFeatures.free();

		return score;
	}

	public boolean isAdequate()
	{
		return colorDomains.size() != 0 && modes.presentModes.length > 0;
	}

	private boolean checkDeviceExtensionSupport(VkPhysicalDevice physicalDevice)
	{
		boolean res = true;
		final IntBuffer extensionCount = memAllocInt(1);

		vkEnumerateDeviceExtensionProperties(physicalDevice, (ByteBuffer) null, extensionCount,
				(VkExtensionProperties.Buffer) null);
		final VkExtensionProperties.Buffer availableExtensions = VkExtensionProperties
				.calloc(extensionCount.get(0));

		vkEnumerateDeviceExtensionProperties(physicalDevice, (ByteBuffer) null, extensionCount,
				availableExtensions);

		for (final String requiredExtension : requiredExtensions)
		{
			boolean found = false;
			for (final VkExtensionProperties extension : availableExtensions)
			{
				if (requiredExtension.equals(extension.extensionNameString()))
				{
					found = true;
					break;
				}
			}

			if (found == false)
			{
				res = false;
				break;
			}
		}

		availableExtensions.free();
		memFree(extensionCount);

		return res;
	}
}
