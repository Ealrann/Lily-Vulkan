package org.sheepy.vulkan.execution.loader;

import static org.lwjgl.vulkan.KHRSurface.vkGetPhysicalDeviceSurfaceSupportKHR;
import static org.lwjgl.vulkan.VK10.*;

import java.nio.IntBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.lwjgl.vulkan.VkQueueFamilyProperties;
import org.lwjgl.vulkan.VkQueueFamilyProperties.Buffer;
import org.sheepy.vulkan.surface.VkSurface;

public final class QueueFinder
{
	private final VkQueueFamilyProperties.Buffer queueProps;
	private final VkPhysicalDevice physicalDevice;

	public QueueFinder(VkPhysicalDevice physicalDevice)
	{
		this.physicalDevice = physicalDevice;
		this.queueProps = getQueueProperties();
	}

	private Buffer getQueueProperties()
	{
		final IntBuffer pQueueCount = BufferUtils.createIntBuffer(1);
		vkGetPhysicalDeviceQueueFamilyProperties(physicalDevice, pQueueCount, null);
		final int queueCount = pQueueCount.get(0);
		final var queueProps = VkQueueFamilyProperties.create(queueCount);
		vkGetPhysicalDeviceQueueFamilyProperties(physicalDevice, pQueueCount, queueProps);
		return queueProps;
	}

	public Integer findGraphicQueueIndex()
	{
		return findQueueIndex(VK_QUEUE_GRAPHICS_BIT);
	}

	public Integer findComputeQueueIndex()
	{
		return findQueueIndex(VK_QUEUE_COMPUTE_BIT);
	}

	private Integer findQueueIndex(int type)
	{
		Integer res = null;

		for (int index = 0; index < queueProps.capacity(); index++)
		{
			if ((queueProps.get(index).queueFlags() & type) != 0)
			{
				res = index;
				break;
			}
		}

		return res;
	}

	public Integer findPresentQueueIndex(VkSurface surface)
	{
		Integer res = null;

		for (int index = 0; index < queueProps.capacity(); index++)
		{
			final int[] supportsPresent = new int[1];
			vkGetPhysicalDeviceSurfaceSupportKHR(physicalDevice, index, surface.ptr,
					supportsPresent);

			if (supportsPresent[0] == VK_TRUE)
			{
				res = index;
				break;
			}
		}

		return res;
	}
}
