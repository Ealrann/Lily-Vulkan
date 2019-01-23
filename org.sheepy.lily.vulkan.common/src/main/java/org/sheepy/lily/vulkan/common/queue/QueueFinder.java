package org.sheepy.lily.vulkan.common.queue;

import static org.lwjgl.vulkan.KHRSurface.vkGetPhysicalDeviceSurfaceSupportKHR;
import static org.lwjgl.vulkan.VK10.*;

import java.nio.IntBuffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.lwjgl.vulkan.VkQueueFamilyProperties;
import org.sheepy.lily.vulkan.api.window.Surface;

public class QueueFinder
{
	private final MemoryStack stack;
	private final VkQueueFamilyProperties.Buffer queueProps;

	public QueueFinder(MemoryStack stack, VkQueueFamilyProperties.Buffer queueProps)
	{
		this.stack = stack;
		this.queueProps = queueProps;
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

	public Integer findPresentQueueIndex(VkPhysicalDevice physicalDevice, Surface surface)
	{
		Integer res = null;

		for (int index = 0; index < queueProps.capacity(); index++)
		{
			final IntBuffer supportsPresent = stack.callocInt(1);
			vkGetPhysicalDeviceSurfaceSupportKHR(physicalDevice, index, surface.id,
					supportsPresent);

			if (supportsPresent.get(0) == VK_TRUE)
			{
				res = index;
				break;
			}
		}

		return res;
	}
}
