package org.sheepy.lily.game.vulkan;

import static org.lwjgl.system.MemoryStack.stackPush;
import static org.lwjgl.system.MemoryUtil.memAllocPointer;
import static org.lwjgl.system.MemoryUtil.memFree;
import static org.lwjgl.vulkan.KHRSurface.vkGetPhysicalDeviceSurfaceSupportKHR;
import static org.lwjgl.vulkan.VK10.*;

import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.lwjgl.vulkan.VkQueue;
import org.lwjgl.vulkan.VkQueueFamilyProperties;

public class QueueManager implements Iterable<Integer>
{
	private VkPhysicalDevice physicalDevice;

	private Integer graphicQueueIndex = null;
	private Integer presentQueueIndex = null;

	private List<Integer> queueIndexes;

	private boolean exclusive = false;

	public QueueManager(VkPhysicalDevice physicalDevice)
	{
		this.physicalDevice = physicalDevice;
	}

	public void load(Long surface)
	{
		try (MemoryStack stack = stackPush())
		{
			IntBuffer pQueueFamilyPropertyCount = stack.ints(1);
			vkGetPhysicalDeviceQueueFamilyProperties(physicalDevice, pQueueFamilyPropertyCount,
					null);
			int queueCount = pQueueFamilyPropertyCount.get(0);
			VkQueueFamilyProperties.Buffer queueProps = VkQueueFamilyProperties
					.callocStack(queueCount, stack);
			vkGetPhysicalDeviceQueueFamilyProperties(physicalDevice, pQueueFamilyPropertyCount,
					queueProps);

			graphicQueueIndex = findGraphicQueueIndex(stack, queueProps);
			presentQueueIndex = findPresentQueueIndex(stack, queueProps, surface);

			queueIndexes = new ArrayList<>();

			queueIndexes.add(graphicQueueIndex);
			queueIndexes.add(presentQueueIndex);

			queueIndexes = Collections.unmodifiableList(queueIndexes);

			Set<Integer> uniqueIndexes = new HashSet<>(queueIndexes);
			exclusive = uniqueIndexes.size() == 1;
		}
	}

	public boolean isExclusive()
	{
		return exclusive;
	}

	private Integer findGraphicQueueIndex(MemoryStack stack,
			VkQueueFamilyProperties.Buffer queueProps)
	{
		Integer res = null;

		for (int index = 0; index < queueProps.capacity(); index++)
		{
			if ((queueProps.get(index).queueFlags() & VK_QUEUE_GRAPHICS_BIT) != 0)
			{
				res = index;
				break;
			}
		}

		return res;
	}

	private Integer findPresentQueueIndex(MemoryStack stack,
			VkQueueFamilyProperties.Buffer queueProps,
			long surface)
	{
		Integer res = null;

		for (int index = 0; index < queueProps.capacity(); index++)
		{
			IntBuffer supportsPresent = stack.callocInt(1); // memAllocInt(queueCount);
			vkGetPhysicalDeviceSurfaceSupportKHR(physicalDevice, index, surface, supportsPresent);

			if (supportsPresent.get(0) == VK_TRUE)
			{
				res = index;
				break;
			}
		}

		return res;
	}

	public Integer getGraphicQueueIndex()
	{
		return graphicQueueIndex;
	}

	public Integer getPresentQueueIndex()
	{
		return presentQueueIndex;
	}

	public List<Integer> getQueueIndexes()
	{
		return queueIndexes;
	}

	public VkQueue getGraphicQueue(VkDevice logicalDevice)
	{
		return retrieveDeviceQueue(logicalDevice, graphicQueueIndex);
	}

	public VkQueue getPresentQueue(VkDevice logicalDevice)
	{
		return retrieveDeviceQueue(logicalDevice, presentQueueIndex);
	}

	private static VkQueue retrieveDeviceQueue(VkDevice device, int queueFamilyIndex)
	{
		PointerBuffer pQueue = memAllocPointer(1);
		vkGetDeviceQueue(device, queueFamilyIndex, 0, pQueue);
		long queue = pQueue.get(0);
		memFree(pQueue);
		return new VkQueue(queue, device);
	}

	public int size()
	{
		return queueIndexes.size();
	}

	@Override
	public Iterator<Integer> iterator()
	{
		return queueIndexes.iterator();
	}
}
