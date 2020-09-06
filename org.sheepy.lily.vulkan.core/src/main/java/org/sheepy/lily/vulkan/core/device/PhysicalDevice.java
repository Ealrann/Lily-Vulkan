package org.sheepy.lily.vulkan.core.device;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkFormatProperties;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.lwjgl.vulkan.VkPhysicalDeviceMemoryProperties;
import org.lwjgl.vulkan.VkPhysicalDeviceProperties;
import org.sheepy.lily.vulkan.api.device.IPhysicalDevice;
import org.sheepy.lily.vulkan.core.device.capabilities.Capabilities;
import org.sheepy.lily.vulkan.core.device.data.DeviceProperties;
import org.sheepy.lily.vulkan.core.engine.extension.DeviceExtensions;
import org.sheepy.lily.vulkan.core.engine.extension.EDeviceExtension;
import org.sheepy.lily.vulkan.core.window.VkSurface;
import org.sheepy.vulkan.model.enumeration.EImageUsage;

import java.util.*;

import static org.lwjgl.vulkan.VK10.*;

public class PhysicalDevice implements IPhysicalDevice
{
	private static final String FAILED_TO_FIND_SUPPORTED_FORMAT = "Failed to find supported format";
	private static final String USING_GRAPHIC_DEVICE = "\nUsing Graphic Device: %s (%s)";

	public final VkPhysicalDevice vkPhysicalDevice;
	public final String name;
	public final DeviceProperties deviceProperties;
	public final DeviceExtensions deviceExtensions;
	private final VkPhysicalDeviceMemoryProperties memProperties;
	private final Map<Integer, VkFormatProperties> formatProperties = new HashMap<>();
	public final Set<EImageUsage> supportedSwapUsages;

	public PhysicalDevice(VkPhysicalDevice vkPhysicalDevice,
						  String name,
						  DeviceExtensions deviceExtensions,
						  DeviceProperties deviceProperties,
						  VkPhysicalDeviceMemoryProperties memProperties,
						  Set<EImageUsage> supportedSwapUsages)
	{
		this.vkPhysicalDevice = vkPhysicalDevice;
		this.deviceExtensions = deviceExtensions;
		this.deviceProperties = deviceProperties;
		this.name = name;
		this.memProperties = memProperties;
		this.supportedSwapUsages = supportedSwapUsages;
	}

	@Override
	public Set<EImageUsage> supportedSwapUsages()
	{
		return supportedSwapUsages;
	}

	public void free()
	{
		memProperties.free();

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

			if (tiling == VK_IMAGE_TILING_LINEAR && (formatProperty.linearTilingFeatures() & features) == features)
			{
				return format;
			}
			else if (tiling == VK_IMAGE_TILING_OPTIMAL && (formatProperty.optimalTilingFeatures() & features) == features)
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

	public long getBufferAlignement(int usage, final boolean coherent)
	{
		final var limits = getDeviceProperties().limits();
		long alignment = 1;

		if ((usage & VK_BUFFER_USAGE_UNIFORM_BUFFER_BIT) != 0)
		{
			alignment = Math.max(alignment, limits.minUniformBufferOffsetAlignment());
		}
		if ((usage & VK_BUFFER_USAGE_STORAGE_BUFFER_BIT) != 0)
		{
			alignment = Math.max(alignment, limits.minStorageBufferOffsetAlignment());
		}
		if (coherent == false)
		{
			alignment = Math.max(alignment, limits.nonCoherentAtomSize());
		}

		return alignment;
	}

	public VkPhysicalDeviceProperties getDeviceProperties()
	{
		return deviceProperties.vkDeviceProperties;
	}

	public static final class Builder
	{
		public final VkPhysicalDevice vkPhysicalDevice;
		public final DeviceProperties deviceProperties;
		public final DeviceExtensions.Builder deviceExtensions;
		public final String name;
		public final VkPhysicalDeviceMemoryProperties memProperties;
		public int driverVersion;

		public Builder(VkPhysicalDevice vkPhysicalDevice, Set<EDeviceExtension> extensions, MemoryStack stack)
		{
			this.vkPhysicalDevice = vkPhysicalDevice;
			deviceProperties = new DeviceProperties(vkPhysicalDevice);
			name = deviceProperties.vkDeviceProperties.deviceNameString();
			deviceExtensions = new DeviceExtensions.Builder(vkPhysicalDevice, stack);
			for (var extension : extensions) deviceExtensions.requires(extension);
			memProperties = VkPhysicalDeviceMemoryProperties.calloc();
			vkGetPhysicalDeviceMemoryProperties(vkPhysicalDevice, memProperties);
			driverVersion = deviceProperties.vkDeviceProperties.driverVersion();
		}

		public PhysicalDevice build(VkSurface dummySurface)
		{
			final var usages = swapUsages(dummySurface);
			return new PhysicalDevice(vkPhysicalDevice,
									  name,
									  deviceExtensions.build(),
									  deviceProperties,
									  memProperties,
									  usages);
		}

		private Set<EImageUsage> swapUsages(final VkSurface dummySurface)
		{
			if (dummySurface == null)
			{
				return Set.of();
			}
			else
			{
				final var capabilities = new Capabilities(vkPhysicalDevice, dummySurface);
				final int usageFlag = capabilities.vkCapabilities.supportedUsageFlags();
				capabilities.free();

				final List<EImageUsage> usages = new ArrayList<>();
				for (var usage : EImageUsage.values())
				{
					if ((usage.getValue() & usageFlag) != 0)
					{
						usages.add(usage);
					}
				}
				return EnumSet.copyOf(usages);
			}
		}

		public void printInfo(final boolean verbose)
		{
			final var deviceInfo = String.format(USING_GRAPHIC_DEVICE, name, driverVersion);
			System.out.println(deviceInfo);
			deviceExtensions.log(verbose);
			if (verbose)
			{
				printPhysicalProperties();
			}
		}

		private void printPhysicalProperties()
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
				System.out.printf("\tHeap %d: flags: %d - size: %d%n", i, flag, size);
			}
		}
	}
}
