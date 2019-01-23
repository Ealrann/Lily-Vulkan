package org.sheepy.vulkan.common.device;

import static org.lwjgl.vulkan.VK10.*;

import java.util.HashMap;
import java.util.Map;

import org.lwjgl.vulkan.VkFormatProperties;
import org.lwjgl.vulkan.VkInstance;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.lwjgl.vulkan.VkPhysicalDeviceMemoryProperties;
import org.sheepy.vulkan.common.device.data.DeviceProperties;

public class PhysicalDevice
{
	public final VkPhysicalDevice vkPhysicalDevice;
	public final VkInstance vkInstance;
	public final DeviceProperties deviceProperties;

	private String name;
	private int driverVersion;
	private VkPhysicalDeviceMemoryProperties memProperties;
	private final Map<Integer, VkFormatProperties> formatProperties = new HashMap<>();

	public PhysicalDevice(VkPhysicalDevice vkPhysicalDevice, VkInstance vkInstance)
	{
		this.vkPhysicalDevice = vkPhysicalDevice;
		this.vkInstance = vkInstance;

		deviceProperties = new DeviceProperties(vkPhysicalDevice);

	}

	public void allocate()
	{

		name = deviceProperties.vkDeviceProperties.deviceNameString();
		driverVersion = deviceProperties.vkDeviceProperties.driverVersion();

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
