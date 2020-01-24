package org.sheepy.lily.vulkan.common.device;

import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkExtensionProperties;
import org.lwjgl.vulkan.VkFormatProperties;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.lwjgl.vulkan.VkPhysicalDeviceMemoryProperties;
import org.lwjgl.vulkan.VkPhysicalDeviceProperties;
import org.sheepy.lily.vulkan.api.device.IPhysicalDevice;
import org.sheepy.lily.vulkan.common.device.data.DeviceProperties;
import org.sheepy.lily.vulkan.common.device.data.DisplayInfo;
import org.sheepy.lily.vulkan.common.device.loader.DisplayInformationLoader;
import org.sheepy.lily.vulkan.common.engine.extension.EDeviceExtension;
import org.sheepy.lily.vulkan.common.engine.extension.EInstanceExtension;
import org.sheepy.lily.vulkan.common.engine.extension.EngineExtensionRequirement;
import org.sheepy.lily.vulkan.common.instance.VulkanInstance;

public class PhysicalDevice implements IPhysicalDevice
{
	private static final String FAILED_TO_FIND_SUPPORTED_FORMAT = "Failed to find supported format";
	private static final String USING_GRAPHIC_DEVICE = "\nUsing Graphic Device: %s (%s)";

	public final VkPhysicalDevice vkPhysicalDevice;
	public final VulkanInstance vkInstance;
	public final DeviceProperties deviceProperties;
	public final String name;
	public final int driverVersion;

	private final Map<Integer, VkFormatProperties> formatProperties = new HashMap<>();
	private final List<EDeviceExtension> retainedExtensions;
	private final List<String> availableExtensions;
	private final EngineExtensionRequirement extensionRequirement;

	private VkPhysicalDeviceMemoryProperties memProperties;
	private List<DisplayInfo> displaysInfomations = null;

	public PhysicalDevice(	VkPhysicalDevice vkPhysicalDevice,
							VulkanInstance vkInstance,
							EngineExtensionRequirement extensionRequirement)
	{
		this.vkPhysicalDevice = vkPhysicalDevice;
		this.vkInstance = vkInstance;
		this.extensionRequirement = extensionRequirement;

		deviceProperties = new DeviceProperties(vkPhysicalDevice);
		name = deviceProperties.vkDeviceProperties.deviceNameString();
		driverVersion = deviceProperties.vkDeviceProperties.driverVersion();

		availableExtensions = List.copyOf(gatherAvailableExtensions());
		retainedExtensions = List.copyOf(gatherSupportedExtensions(extensionRequirement));
	}

	public void allocate(MemoryStack stack)
	{
		memProperties = VkPhysicalDeviceMemoryProperties.calloc();
		vkGetPhysicalDeviceMemoryProperties(vkPhysicalDevice, memProperties);

		if (extensionRequirement.getRequiredInstanceExtensions()
								.contains(EInstanceExtension.VK_KHR_display))
		{
			displaysInfomations = DisplayInformationLoader.getDisplayInfos(stack, vkPhysicalDevice);
		}
	}

	public void free()
	{
		memProperties.free();
		memProperties = null;

		for (final var formatProperty : formatProperties.values())
		{
			formatProperty.free();
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

		throw new AssertionError(FAILED_TO_FIND_SUPPORTED_FORMAT);
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
		final List<String> extensions = new ArrayList<>();
		final IntBuffer extensionCount = memAllocInt(1);

		vkEnumerateDeviceExtensionProperties(	vkPhysicalDevice,
												(ByteBuffer) null,
												extensionCount,
												(VkExtensionProperties.Buffer) null);
		final var availableExtensions = VkExtensionProperties.calloc(extensionCount.get(0));

		vkEnumerateDeviceExtensionProperties(	vkPhysicalDevice,
												(ByteBuffer) null,
												extensionCount,
												availableExtensions);

		for (final VkExtensionProperties extension : availableExtensions)
		{
			extensions.add(extension.extensionNameString());
		}

		availableExtensions.free();
		memFree(extensionCount);

		return extensions;
	}

	private List<EDeviceExtension> gatherSupportedExtensions(EngineExtensionRequirement extensionRequirement)
	{
		List<EDeviceExtension> compatibleExtensions = new ArrayList<>();
		for (final EDeviceExtension requiredExtension : extensionRequirement.getRequiredDeviceExtensions())
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

	public List<EDeviceExtension> getRetainedExtensions()
	{
		return retainedExtensions;
	}

	public PointerBuffer allocRetainedExtensions(MemoryStack stack)
	{
		final int extensionCount = retainedExtensions.size();
		final var extensionsBuffer = stack.mallocPointer(extensionCount);
		for (int i = 0; i < extensionCount; i++)
		{
			final var requiredExtension = retainedExtensions.get(i);
			extensionsBuffer.put(stack.UTF8(requiredExtension.name));
		}
		extensionsBuffer.flip();
		return extensionsBuffer;
	}

	public long getBufferAlignement(int usage)
	{
		final var limits = getDeviceProperties().limits();
		long alignment = 0;

		if ((usage & VK_BUFFER_USAGE_UNIFORM_BUFFER_BIT) != 0)
		{
			alignment = limits.minUniformBufferOffsetAlignment();
		}
		else if ((usage & VK_BUFFER_USAGE_STORAGE_BUFFER_BIT) != 0)
		{
			alignment = limits.minStorageBufferOffsetAlignment();
		}
		else
		{
			alignment = 1;
		}

		return alignment;
	}

	public void printRetainedExtensions()
	{
		System.out.println("\nUsing Device Extensions:");
		for (final EDeviceExtension deviceExtension : retainedExtensions)
		{
			System.out.println("\t- " + deviceExtension.name);
		}
	}

	public void printAvailableExtensions()
	{
		System.out.println("\nAvailable Device Extensions:");
		for (final String extension : availableExtensions)
		{
			System.out.println("\t- " + extension);
		}
	}

	public void printPhysicalProperties()
	{
		System.out.println("\nPhysical Properties:");
		deviceProperties.print();

		System.out.println("\nPhysical Memory Properties:");
		final int count = memProperties.memoryHeapCount();
		for (int i = 0; i < count; i++)
		{
			final var heap = memProperties.memoryHeaps(i);
			final var flag = heap.flags();
			final var size = heap.size();
			System.out.println(String.format("\tHeap %d: flags: %d - size: %d", i, flag, size));
		}
	}

	public List<DisplayInfo> getDisplaysInfomations()
	{
		return displaysInfomations;
	}

	public VkPhysicalDeviceProperties getDeviceProperties()
	{
		return deviceProperties.vkDeviceProperties;
	}

	public void printInfo()
	{
		final var deviceInfo = String.format(USING_GRAPHIC_DEVICE, name, driverVersion);
		System.out.println(deviceInfo);
	}
}
