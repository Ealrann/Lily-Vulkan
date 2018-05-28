package org.sheepy.lily.game.vulkan.device;

import static org.lwjgl.system.MemoryUtil.memAllocInt;
import static org.lwjgl.system.MemoryUtil.memFree;
import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import org.lwjgl.vulkan.VkExtensionProperties;
import org.lwjgl.vulkan.VkInstance;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.lwjgl.vulkan.VkPhysicalDeviceFeatures;
import org.lwjgl.vulkan.VkPhysicalDeviceMemoryProperties;
import org.lwjgl.vulkan.VkPhysicalDeviceProperties;

public class PhysicalDeviceWrapper
{
	private VkPhysicalDevice physicalDevice;
	private VkInstance vkInstance;
	private int rate;
	private String name;
	private PhysicalDeviceSupportDetails details;

	private String[] requiredExtensions;

	PhysicalDeviceWrapper(VkPhysicalDevice physicalDevice, VkInstance vkInstance, long surface,
			String[] requiredExtensions)
	{
		this.physicalDevice = physicalDevice;
		this.vkInstance = vkInstance;
		this.requiredExtensions = requiredExtensions;

		details = new PhysicalDeviceSupportDetails(this, surface);

		rateDeviceSuitability();
	}

	private void rateDeviceSuitability()
	{
		VkPhysicalDeviceProperties deviceProperties = VkPhysicalDeviceProperties.calloc();
		VkPhysicalDeviceFeatures deviceFeatures = VkPhysicalDeviceFeatures.calloc();
		vkGetPhysicalDeviceProperties(physicalDevice, deviceProperties);
		vkGetPhysicalDeviceFeatures(physicalDevice, deviceFeatures);
		name = deviceProperties.deviceNameString();
		int score = 0;

		// Discrete GPUs have a significant performance advantage
		if (deviceProperties.deviceType() == VK_PHYSICAL_DEVICE_TYPE_DISCRETE_GPU)
		{
			score += 1000;
		}

		// Maximum possible size of textures affects graphics quality
		score += deviceProperties.limits().maxImageDimension2D();

		// Application can't work without geometry shaders
		if (!deviceFeatures.geometryShader())
		{
			score = 0;
		}

		// Application can't work without required extensions
		if (checkDeviceExtensionSupport() == false)
		{
			score = 0;
		}
		// Application can't work without swap chain
		else
		{
			if (details.isAdequate() == false)
			{
				score = 0;
			}
		}

		rate = score;
		deviceProperties.free();
		deviceFeatures.free();

	}

	private boolean checkDeviceExtensionSupport()
	{
		boolean res = true;
		IntBuffer extensionCount = memAllocInt(1);

		vkEnumerateDeviceExtensionProperties(physicalDevice, (ByteBuffer) null, extensionCount,
				(VkExtensionProperties.Buffer) null);
		VkExtensionProperties.Buffer availableExtensions = VkExtensionProperties
				.calloc(extensionCount.get(0));

		vkEnumerateDeviceExtensionProperties(physicalDevice, (ByteBuffer) null, extensionCount,
				availableExtensions);

		for (String requiredExtension : requiredExtensions)
		{
			boolean found = false;
			for (VkExtensionProperties extension : availableExtensions)
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

	public int findMemoryType(int typeFilter, int properties)
	{
		int res = -1;

		VkPhysicalDeviceMemoryProperties memProperties = VkPhysicalDeviceMemoryProperties.calloc();
		vkGetPhysicalDeviceMemoryProperties(physicalDevice, memProperties);

		for (int i = 0; i < memProperties.memoryTypeCount(); i++)
		{
			if (((typeFilter & (1 << i)) != 0)
					&& (memProperties.memoryTypes(i).propertyFlags() & properties) == properties)
			{
				res = i;
				break;
			}
		}

		memProperties.free();
		
		if(res == -1)
		{
			System.err.println("Memory type not found");
		}

		return res;
	}

	public VkPhysicalDevice getVkPhysicalDevice()
	{
		return physicalDevice;
	}

	public int getRate()
	{
		return rate;
	}

	public String getName()
	{
		return name;
	}
	
	public VkInstance getVkInstance()
	{
		return vkInstance;
	}
}