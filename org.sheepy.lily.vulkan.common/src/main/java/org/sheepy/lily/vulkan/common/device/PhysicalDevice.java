package org.sheepy.lily.vulkan.common.device;

import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.lwjgl.vulkan.VkExtensionProperties;
import org.lwjgl.vulkan.VkFormatProperties;
import org.lwjgl.vulkan.VkInstance;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.lwjgl.vulkan.VkPhysicalDeviceMemoryProperties;
import org.sheepy.lily.vulkan.common.device.data.DeviceProperties;

public class PhysicalDevice
{
	public final VkPhysicalDevice vkPhysicalDevice;
	public final VkInstance vkInstance;
	public final DeviceProperties deviceProperties;

	private final String name;
	private final int driverVersion;
	private VkPhysicalDeviceMemoryProperties memProperties;
	private final Map<Integer, VkFormatProperties> formatProperties = new HashMap<>();
	private final List<DeviceExtension> retainedExtensions;
	private final List<String> availableExtensions;

	public PhysicalDevice(	VkPhysicalDevice vkPhysicalDevice,
							VkInstance vkInstance,
							DeviceExtension[] requiredExtensions)
	{
		this.vkPhysicalDevice = vkPhysicalDevice;
		this.vkInstance = vkInstance;

		deviceProperties = new DeviceProperties(vkPhysicalDevice);
		name = deviceProperties.vkDeviceProperties.deviceNameString();
		driverVersion = deviceProperties.vkDeviceProperties.driverVersion();

		availableExtensions = gatherAvailableExtensions();
		retainedExtensions = gatherSupportedExtensions(requiredExtensions);
	}

	public void allocate()
	{
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

	private List<String> gatherAvailableExtensions()
	{
		List<String> extensions = new ArrayList<>();
		final IntBuffer extensionCount = memAllocInt(1);

		vkEnumerateDeviceExtensionProperties(vkPhysicalDevice, (ByteBuffer) null, extensionCount,
				(VkExtensionProperties.Buffer) null);
		final VkExtensionProperties.Buffer availableExtensions = VkExtensionProperties
				.calloc(extensionCount.get(0));

		vkEnumerateDeviceExtensionProperties(vkPhysicalDevice, (ByteBuffer) null, extensionCount,
				availableExtensions);

		for (final VkExtensionProperties extension : availableExtensions)
		{
			extensions.add(extension.extensionNameString());
		}

		availableExtensions.free();
		memFree(extensionCount);

		return extensions;
	}

	private List<DeviceExtension> gatherSupportedExtensions(DeviceExtension[] requiredExtensions)
	{
		List<DeviceExtension> compatibleExtensions = new ArrayList<>();
		for (final DeviceExtension requiredExtension : requiredExtensions)
		{
			boolean found = false;
			for (final String extension : availableExtensions)
			{
				if (requiredExtension.name.equals(extension))
				{
					found = true;
					compatibleExtensions.add(requiredExtension);
					break;
				}
			}

			if (found == false && requiredExtension.mandatory)
			{
				compatibleExtensions = null;
				break;
			}
		}
		return compatibleExtensions;
	}

	public List<DeviceExtension> getRetainedExtensions()
	{
		return retainedExtensions;
	}

	public String getName()
	{
		return name;
	}

	public int getDriverVersion()
	{
		return driverVersion;
	}

	public void printRetainedExtensions()
	{
		System.out.println("\nUsing Device Extensions:");
		for (DeviceExtension deviceExtension : retainedExtensions)
		{
			System.out.println("\t- " + deviceExtension.name);
		}
	}

	public void printAvailableExtensions()
	{
		System.out.println("\nAvailable Device Extensions:");
		for (String extension : availableExtensions)
		{
			System.out.println("\t- " + extension);
		}
	}

	public void printPhysicalProperties()
	{
		System.out.println("\nPhysical Properties:");
		deviceProperties.print();
	}
}
