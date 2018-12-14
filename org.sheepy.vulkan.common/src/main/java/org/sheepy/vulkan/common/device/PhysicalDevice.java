package org.sheepy.vulkan.common.device;

import static org.lwjgl.vulkan.VK10.*;

import java.util.HashMap;
import java.util.Map;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkFormatProperties;
import org.lwjgl.vulkan.VkInstance;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.lwjgl.vulkan.VkPhysicalDeviceLimits;
import org.lwjgl.vulkan.VkPhysicalDeviceMemoryProperties;
import org.lwjgl.vulkan.VkPhysicalDeviceProperties;

public class PhysicalDevice
{
	public final VkPhysicalDevice vkPhysicalDevice;
	public final VkInstance vkInstance;

	private String name;
	private int driverVersion;
	private VkPhysicalDeviceMemoryProperties memProperties;
	private final Map<Integer, VkFormatProperties> formatProperties = new HashMap<>();

	public PhysicalDevice(VkPhysicalDevice vkPhysicalDevice, VkInstance vkInstance)
	{
		this.vkPhysicalDevice = vkPhysicalDevice;
		this.vkInstance = vkInstance;
	}

	public void allocate(MemoryStack stack)
	{
		final var deviceProperties = VkPhysicalDeviceProperties.callocStack(stack);
		vkGetPhysicalDeviceProperties(vkPhysicalDevice, deviceProperties);

		name = deviceProperties.deviceNameString();
		driverVersion = deviceProperties.driverVersion();

		memProperties = VkPhysicalDeviceMemoryProperties.calloc();
		vkGetPhysicalDeviceMemoryProperties(vkPhysicalDevice, memProperties);
	}

	public void free()
	{
		memProperties.free();
		memProperties = null;

		for (final VkFormatProperties value : formatProperties.values())
		{
			value.free();
		}

		formatProperties.clear();
	}

	public void printDeviceProperties()
	{
		final VkPhysicalDeviceProperties deviceProperties = VkPhysicalDeviceProperties.calloc();
		vkGetPhysicalDeviceProperties(vkPhysicalDevice, deviceProperties);

		final VkPhysicalDeviceLimits limits = deviceProperties.limits();
		System.out.println("\tmaxImageDimension2D:\t" + limits.maxImageDimension2D());
		System.out.println("\tmaxUniformBufferRange:\t" + limits.maxUniformBufferRange());
		System.out.println("\tmaxStorageBufferRange:\t" + limits.maxStorageBufferRange());
		System.out.println("\tmaxPushConstantsSize:\t" + limits.maxPushConstantsSize());

		deviceProperties.free();
	}

	public int findMemoryType(int typeFilter, int properties)
	{
		int res = -1;

		for (int i = 0; i < memProperties.memoryTypeCount(); i++)
		{
			final var typeTag = 1 << i;
			final var matchType = (typeFilter & typeTag) != 0;

			final var propertyFlags = memProperties.memoryTypes(i).propertyFlags();
			final int matchingProperties = propertyFlags & properties;
			final var matchProperties = matchingProperties == properties;

			if (matchType && matchProperties)
			{
				res = i;
				break;
			}
		}

		if (res == -1)
		{
			System.err.println("Memory type not found");
		}

		return res;
	}

	public int findSupportedFormat(int[] candidates, int tiling, int features)
	{
		for (final int format : candidates)
		{
			final var formatProperty = getFormatProperty(format);

			if (tiling == VK_IMAGE_TILING_LINEAR
					&& (formatProperty.linearTilingFeatures() & features) == features)
			{
				return format;
			}
			else if (tiling == VK_IMAGE_TILING_OPTIMAL
					&& (formatProperty.optimalTilingFeatures() & features) == features)
			{
				return format;
			}
		}

		throw new AssertionError("failed to find supported format!");
	}

	private VkFormatProperties getFormatProperty(int format)
	{
		var formatProperty = formatProperties.get(format);
		if (formatProperty == null)
		{
			formatProperty = VkFormatProperties.calloc();
			vkGetPhysicalDeviceFormatProperties(vkPhysicalDevice, format, formatProperty);
			formatProperties.put(format, formatProperty);
		}
		return formatProperty;
	}

	public String getName()
	{
		return name;
	}

	public int getDriverVersion()
	{
		return driverVersion;
	}
}
