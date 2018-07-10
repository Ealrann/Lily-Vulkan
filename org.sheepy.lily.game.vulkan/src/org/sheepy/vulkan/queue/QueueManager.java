package org.sheepy.vulkan.queue;

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
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.lwjgl.vulkan.VkQueue;
import org.lwjgl.vulkan.VkQueueFamilyProperties;

public class QueueManager implements Iterable<Integer>
{
	private Integer graphicQueueIndex = null;
	private Integer computeQueueIndex = null;
	private Integer presentQueueIndex = null;

	private VkQueue graphicQueue = null;
	private VkQueue computeQueue = null;
	private VkQueue presentQueue = null;

	private List<Integer> queueIndexes;

	private boolean exclusive = false;

	public QueueManager()
	{}

	public void load(VkPhysicalDevice physicalDevice, Long surface, boolean loadComputeQueue)
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

			graphicQueueIndex = findQueueIndex(stack, queueProps, VK_QUEUE_GRAPHICS_BIT);
			if (loadComputeQueue)
				computeQueueIndex = findQueueIndex(stack, queueProps, VK_QUEUE_COMPUTE_BIT);
			presentQueueIndex = findPresentQueueIndex(stack, physicalDevice, queueProps, surface);

			queueIndexes = new ArrayList<>();

			queueIndexes.add(graphicQueueIndex);
			if (loadComputeQueue) queueIndexes.add(computeQueueIndex);
			queueIndexes.add(presentQueueIndex);

			queueIndexes = Collections.unmodifiableList(queueIndexes);

			Set<Integer> uniqueIndexes = new HashSet<>(queueIndexes);
			exclusive = uniqueIndexes.size() == 1;
		}
	}

	public void loadVkQueues(VkDevice logicalDevice)
	{
		graphicQueue = retrieveDeviceQueue(logicalDevice, graphicQueueIndex);
		if (computeQueueIndex != null)
			computeQueue = retrieveDeviceQueue(logicalDevice, computeQueueIndex);
		presentQueue = retrieveDeviceQueue(logicalDevice, presentQueueIndex);
	}

	public boolean isExclusive()
	{
		return exclusive;
	}

	private Integer findQueueIndex(MemoryStack stack,
			VkQueueFamilyProperties.Buffer queueProps,
			int flags)
	{
		Integer res = null;

		for (int index = 0; index < queueProps.capacity(); index++)
		{
			if ((queueProps.get(index).queueFlags() & flags) != 0)
			{
				res = index;
				break;
			}
		}

		return res;
	}

	private Integer findPresentQueueIndex(MemoryStack stack,
			VkPhysicalDevice physicalDevice,
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

	public Integer getComputeQueueIndex()
	{
		return computeQueueIndex;
	}

	public Integer getPresentQueueIndex()
	{
		return presentQueueIndex;
	}

	public List<Integer> getQueueIndexes()
	{
		return queueIndexes;
	}

	public VkQueue getGraphicQueue()
	{
		return graphicQueue;
	}

	public VkQueue getComputeQueue()
	{
		return computeQueue;
	}

	public VkQueue getPresentQueue()
	{
		return presentQueue;
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

	public IntBuffer allocIndices()
	{
		IntBuffer res = MemoryUtil.memAllocInt(size());
		for (int index : queueIndexes)
		{
			res.put(index);
		}
		res.flip();

		return res;
	}
}
