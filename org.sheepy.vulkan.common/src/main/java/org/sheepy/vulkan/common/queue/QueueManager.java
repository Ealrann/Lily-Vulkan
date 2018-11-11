package org.sheepy.vulkan.common.queue;

import static org.lwjgl.system.MemoryStack.stackPush;
import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.vulkan.VK10.*;

import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.lwjgl.vulkan.VkQueue;
import org.lwjgl.vulkan.VkQueueFamilyProperties;
import org.lwjgl.vulkan.VkQueueFamilyProperties.Buffer;
import org.sheepy.vulkan.api.queue.EQueueType;
import org.sheepy.vulkan.api.queue.VulkanQueue;
import org.sheepy.vulkan.common.window.Surface;

public class QueueManager implements Iterable<Integer>
{
	private Integer graphicQueueIndex = null;
	private Integer computeQueueIndex = null;
	private Integer presentQueueIndex = null;

	private final Map<EQueueType, VulkanQueue> queueMap = new HashMap<>();
	private List<Integer> queueIndexes;
	private final List<IQueueManagerListener> listeners = new ArrayList<>();

	private boolean exclusive = false;

	public QueueManager()
	{}

	public void load(VkPhysicalDevice physicalDevice, Surface surface, boolean loadComputeQueue)
	{
		try (MemoryStack stack = stackPush())
		{
			final var queueProps = getQueueProperties(physicalDevice, stack);
			findQueueIndexes(physicalDevice, surface, loadComputeQueue, stack, queueProps);
			buildIndexList(loadComputeQueue);
			buildUniqueIndexes();
		}
	}

	private static Buffer getQueueProperties(VkPhysicalDevice physicalDevice, MemoryStack stack)
	{
		final IntBuffer pQueueCount = stack.ints(1);
		vkGetPhysicalDeviceQueueFamilyProperties(physicalDevice, pQueueCount, null);
		final int queueCount = pQueueCount.get(0);
		final var queueProps = VkQueueFamilyProperties.callocStack(queueCount, stack);
		vkGetPhysicalDeviceQueueFamilyProperties(physicalDevice, pQueueCount, queueProps);
		return queueProps;
	}

	private void buildUniqueIndexes()
	{
		final Set<Integer> uniqueIndexes = new HashSet<>(queueIndexes);
		exclusive = uniqueIndexes.size() == 1;
	}

	private void buildIndexList(boolean loadComputeQueue)
	{
		queueIndexes = new ArrayList<>();
		queueIndexes.add(graphicQueueIndex);
		if (loadComputeQueue) queueIndexes.add(computeQueueIndex);
		queueIndexes.add(presentQueueIndex);
		queueIndexes = List.copyOf(queueIndexes);
	}

	private void findQueueIndexes(	VkPhysicalDevice physicalDevice,
									Surface surface,
									boolean loadComputeQueue,
									MemoryStack stack,
									final VkQueueFamilyProperties.Buffer queueProps)
	{
		final var queueFinder = new QueueFinder(stack, queueProps);
		graphicQueueIndex = queueFinder.findGraphicQueueIndex();
		if (loadComputeQueue) computeQueueIndex = queueFinder.findComputeQueueIndex();
		presentQueueIndex = queueFinder.findPresentQueueIndex(physicalDevice, surface);
	}

	public void loadVkQueues(VkDevice device)
	{
		queueMap.clear();
		
		final var vkGraphicQueue = retrieveDeviceQueue(device, graphicQueueIndex);
		final var graphicType = EQueueType.Graphic;
		final var graphicQueue = new VulkanQueue(graphicType, graphicQueueIndex, vkGraphicQueue);
		queueMap.put(graphicType, graphicQueue);

		if (computeQueueIndex != null)
		{
			final var vkComputeQueue = retrieveDeviceQueue(device, computeQueueIndex);
			final var computeType = EQueueType.Compute;
			final var computeQueue = new VulkanQueue(computeType, computeQueueIndex,
					vkComputeQueue);
			queueMap.put(computeType, computeQueue);
		}
		final var vkPresentQueue = retrieveDeviceQueue(device, presentQueueIndex);
		final var presentType = EQueueType.Present;
		final var presentQueue = new VulkanQueue(presentType, presentQueueIndex, vkPresentQueue);
		queueMap.put(presentType, presentQueue);
		
		fireReload();
	}

	public boolean isExclusive()
	{
		return exclusive;
	}

	public List<Integer> getQueueIndexes()
	{
		return queueIndexes;
	}

	public VulkanQueue getGraphicQueue()
	{
		return getQueue(EQueueType.Graphic);
	}

	public VulkanQueue getComputeQueue()
	{
		return getQueue(EQueueType.Compute);
	}

	public VulkanQueue getPresentQueue()
	{
		return getQueue(EQueueType.Present);
	}

	public VulkanQueue getQueue(EQueueType type)
	{
		return queueMap.get(type);
	}

	private static VkQueue retrieveDeviceQueue(VkDevice device, int queueFamilyIndex)
	{
		final PointerBuffer pQueue = memAllocPointer(1);
		vkGetDeviceQueue(device, queueFamilyIndex, 0, pQueue);
		final long queue = pQueue.get(0);
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
		final IntBuffer res = MemoryUtil.memAllocInt(queueIndexes.size());
		for (final int index : queueIndexes)
		{
			res.put(index);
		}
		res.flip();

		return res;
	}
	
	public void addListener(IQueueManagerListener listener)
	{
		listeners.add(listener);
	}
	
	public void removeListener(IQueueManagerListener listener)
	{
		listeners.remove(listener);
	}
	
	private void fireReload()
	{
		for (final IQueueManagerListener listener : listeners)
		{
			listener.onQueueManagerReload();
		}
	}
}
