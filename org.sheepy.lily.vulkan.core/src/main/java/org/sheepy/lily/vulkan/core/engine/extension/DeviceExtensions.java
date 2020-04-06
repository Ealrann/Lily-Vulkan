package org.sheepy.lily.vulkan.core.engine.extension;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkExtensionProperties;
import org.lwjgl.vulkan.VkPhysicalDevice;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import static org.lwjgl.vulkan.VK10.vkEnumerateDeviceExtensionProperties;

public final class DeviceExtensions
{
	public final Set<EDeviceExtension> extensions;

	public DeviceExtensions(Set<EDeviceExtension> extensions)
	{
		this.extensions = Set.copyOf(extensions);
	}

	public PointerBuffer allocBuffer(MemoryStack stack)
	{
		final int extensionCount = extensions.size();
		final var extensionsBuffer = stack.mallocPointer(extensionCount);
		for (var deviceExtension : extensions)
		{
			extensionsBuffer.put(stack.UTF8(deviceExtension.name));
		}
		extensionsBuffer.flip();
		return extensionsBuffer;
	}

	public static final class Builder
	{
		private final List<EDeviceExtension> retainedExtensions = new ArrayList<>();
		private final List<String> availableExtensions;
		private boolean lackOfMandatoryExtensions;

		public Builder(VkPhysicalDevice vkPhysicalDevice, MemoryStack stack)
		{
			availableExtensions = gatherAvailableExtensions(vkPhysicalDevice, stack);
		}

		public Builder requires(EDeviceExtension extension)
		{
			if (availableExtensions.contains(extension.name))
			{
				retainedExtensions.add(extension);
			}
			else
			{
				if (extension.mandatory)
				{
					lackOfMandatoryExtensions = true;
				}
			}
			return this;
		}

		public int retainedExtensionsCount()
		{
			return retainedExtensions.size();
		}

		public boolean isLackOfMandatoryExtensions()
		{
			return lackOfMandatoryExtensions;
		}

		public void log(final boolean verbose)
		{
			System.out.println("\nRetained Device Extensions:");
			for (final EDeviceExtension deviceExtension : retainedExtensions)
			{
				System.out.println("\t- " + deviceExtension.name);
			}
			if (verbose)
			{
				System.out.println("Available Device Extensions:");
				for (final String extension : availableExtensions)
				{
					System.out.println("\t- " + extension);
				}
			}
		}

		public DeviceExtensions build()
		{
			return new DeviceExtensions(EnumSet.copyOf(retainedExtensions));
		}

		private static List<String> gatherAvailableExtensions(VkPhysicalDevice vkPhysicalDevice,
															  final MemoryStack stack)
		{
			final List<String> extensions = new ArrayList<>();
			final int[] extensionCount = new int[1];

			vkEnumerateDeviceExtensionProperties(vkPhysicalDevice, (ByteBuffer) null, extensionCount, null);
			final var availableExtensions = VkExtensionProperties.callocStack(extensionCount[0], stack);

			vkEnumerateDeviceExtensionProperties(vkPhysicalDevice,
												 (ByteBuffer) null,
												 extensionCount,
												 availableExtensions);

			for (final VkExtensionProperties extension : availableExtensions)
			{
				extensions.add(extension.extensionNameString());
			}

			return extensions;
		}
	}
}