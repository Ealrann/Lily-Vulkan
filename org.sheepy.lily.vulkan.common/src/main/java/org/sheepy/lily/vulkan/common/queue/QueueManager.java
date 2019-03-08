package org.sheepy.lily.vulkan.common.queue;

import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.vulkan.VK10.vkGetDeviceQueue;

import java.nio.IntBuffer;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.lwjgl.vulkan.VkQueue;
import org.sheepy.lily.vulkan.api.nativehelper.surface.VkSurface;
import org.sheepy.lily.vulkan.api.queue.EQueueType;
import org.sheepy.lily.vulkan.api.queue.VulkanQueue;

public class QueueManager
{
	private final boolean loadComputeQueue;
	private final QueueFinder queueFinder;
	private final Map<EQueueType, Integer> indexMap = new HashMap<>(3);

	private boolean exclusive = false;

	public QueueManager(VkPhysicalDevice physicalDevice, boolean loadComputeQueue)
	{
		this.loadComputeQueue = loadComputeQueue;
		queueFinder = new QueueFinder(physicalDevice);
	}

	public void load(VkSurface surface)
	{
		loadGraphicFamilly();

		if (loadComputeQueue)
		{
			loadComputeFamilly();
		}

		loadPresentFamilly(surface);

		determineExclusitvity();
	}

	private void determineExclusitvity()
	{
		final Set<Integer> uniqueIndexes = new HashSet<>(indexMap.values());
		exclusive = uniqueIndexes.size() == 1;
	}

	private void loadGraphicFamilly()
	{
		var graphicQueueIndex = queueFinder.findGraphicQueueIndex();
		indexMap.put(EQueueType.Graphic, graphicQueueIndex);
	}

	private void loadComputeFamilly()
	{
		var computeQueueIndex = queueFinder.findComputeQueueIndex();
		indexMap.put(EQueueType.Compute, computeQueueIndex);
	}

	private void loadPresentFamilly(VkSurface surface)
	{
		var presentQueueIndex = queueFinder.findPresentQueueIndex(surface);
		indexMap.put(EQueueType.Present, presentQueueIndex);
	}

	public boolean isExclusive()
	{
		return exclusive;
	}

	public Collection<Integer> getQueueIndexes()
	{
		return indexMap.values();
	}

	public IntBuffer allocIndices()
	{
		final IntBuffer res = MemoryUtil.memAllocInt(indexMap.size());
		for (final int index : getQueueIndexes())
		{
			res.put(index);
		}
		res.flip();

		return res;
	}

	private VulkanQueue createQueue(VkDevice device, EQueueType type)
	{
		var queueFamilyIndex = indexMap.get(type);
		final var vkQueue = retrieveDeviceQueue(device, queueFamilyIndex);
		final var graphicQueue = new VulkanQueue(type, queueFamilyIndex, vkQueue);

		return graphicQueue;
	}

	private static VkQueue retrieveDeviceQueue(VkDevice device, int queueFamilyIndex)
	{
		final PointerBuffer pQueue = memAllocPointer(1);
		vkGetDeviceQueue(device, queueFamilyIndex, 0, pQueue);
		final long queue = pQueue.get(0);
		memFree(pQueue);
		return new VkQueue(queue, device);
	}

	public VulkanQueue createGraphicQueue(VkDevice device)
	{
		return createQueue(device, EQueueType.Graphic);
	}

	public VulkanQueue createComputeQueue(VkDevice device)
	{
		if (loadComputeQueue == false)
		{
			throw new AssertionError("Compute support was not turned on.");
		}
		return createQueue(device, EQueueType.Compute);
	}

	public VulkanQueue createPresentQueue(VkDevice device, VkSurface surface)
	{
		loadPresentFamilly(surface);
		return createQueue(device, EQueueType.Present);
	}
}
