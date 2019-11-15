package org.sheepy.vulkan.queue;

import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.vulkan.VK10.*;

import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkDeviceQueueCreateInfo;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.lwjgl.vulkan.VkQueue;
import org.lwjgl.vulkan.VkQueueFamilyProperties;
import org.sheepy.vulkan.execution.loader.QueueFinder;
import org.sheepy.vulkan.surface.VkSurface;

public class QueueManager
{
	private final QueueFinder queueFinder;
	private final QueueFamilyHolder[] queueFamilyHolders;
	private final int[] queueFamilyIndices;
	private boolean exclusive = false;

	public QueueManager(VkPhysicalDevice physicalDevice,
						List<EQueueType> requestedQueueTypes,
						VkSurface surface)
	{
		queueFinder = new QueueFinder(physicalDevice);
		queueFamilyIndices = new int[EQueueType.values().length];
		queueFamilyHolders = new QueueFamilyHolder[queueFinder.getFamilyCount()];

		buildQueueHolders(requestedQueueTypes, surface);
		determineExclusitvity();
	}

	private void buildQueueHolders(List<EQueueType> requestedQueueTypes, VkSurface surface)
	{
		final QueueFamilyHolder.Builder[] builders = new QueueFamilyHolder.Builder[queueFinder.getFamilyCount()];
		final var uniqueTypes = EnumSet.copyOf(requestedQueueTypes);
		for (final var type : uniqueTypes)
		{
			int count = 0;
			for (final var request : requestedQueueTypes)
			{
				if (request == type) count++;
			}

			final int familyIndex = findQueueFamilyIndex(type, surface);
			queueFamilyIndices[type.ordinal()] = familyIndex;

			var builder = builders[familyIndex];
			if (builder == null)
			{
				final var properties = queueFinder.getProperties(familyIndex);
				builder = new QueueFamilyHolder.Builder(familyIndex, properties);
				builders[familyIndex] = builder;
			}

			builder.addCount(count);
			builder.addType(type);
		}

		for (final var builder : builders)
		{
			if (builder != null)
			{
				queueFamilyHolders[builder.familyIndex] = builder.build();
			}
		}
	}

	private Integer findQueueFamilyIndex(final EQueueType type, VkSurface surface)
	{
		switch (type)
		{
		case Graphic:
			return queueFinder.findGraphicQueueIndex();
		case Compute:
			return queueFinder.findComputeQueueIndex();
		case Present:
			return queueFinder.findPresentQueueIndex(surface);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void allocate(VkDevice device)
	{
		for (final QueueFamilyHolder queueHolder : queueFamilyHolders)
		{
			queueHolder.createQueues(device);
		}
	}

	public void free()
	{
		for (final QueueFamilyHolder queueHolder : queueFamilyHolders)
		{
			queueHolder.freeQueues();
		}
	}

	private void determineExclusitvity()
	{
		int count = 0;
		for (final QueueFamilyHolder queueFamilyHolder : queueFamilyHolders)
		{
			if (queueFamilyHolder != null)
			{
				count++;
			}
		}
		exclusive = count == 1;
	}

	public boolean isExclusive()
	{
		return exclusive;
	}

	public int getQueueFamilyIndex(EQueueType queueType)
	{
		return queueFamilyIndices[queueType.ordinal()];
	}

	public VulkanQueue borrowComputeQueue()
	{
		return borrowQueue(EQueueType.Compute);
	}

	public VulkanQueue borrowGraphicQueue()
	{
		return borrowQueue(EQueueType.Graphic);
	}

	public VulkanQueue borrowPresentQueue(VkSurface surface)
	{
		queueFinder.findPresentQueueIndex(surface);
		return borrowQueue(EQueueType.Present);
	}

	public void returnQueue(VulkanQueue queue)
	{
		queueFamilyHolders[queue.familyIndex].returnQueue(queue);
	}

	private VulkanQueue borrowQueue(EQueueType type)
	{
		final var queueHolder = queueFamilyHolders[queueFamilyIndices[type.ordinal()]];
		final var res = queueHolder.borrowQueue();
		assert res != null;
		return res;
	}

	public VkDeviceQueueCreateInfo.Buffer allocQueueInfos(MemoryStack stack)
	{
		int familyCount = 0;
		for (int i = 0; i < queueFamilyHolders.length; i++)
		{
			if (queueFamilyHolders[i] != null)
			{
				familyCount++;
			}
		}
		final var queueCreateInfos = VkDeviceQueueCreateInfo.mallocStack(familyCount, stack);

		for (final var familyHolder : queueFamilyHolders)
		{
			if (familyHolder != null)
			{
				final var queuePriorities = familyHolder.allocPriorities(stack);

				final var queueCreateInfo = queueCreateInfos.get();
				queueCreateInfo.set(VK_STRUCTURE_TYPE_DEVICE_QUEUE_CREATE_INFO,
									VK_NULL_HANDLE,
									0,
									familyHolder.familyIndex,
									queuePriorities);
			}
		}
		queueCreateInfos.flip();
		return queueCreateInfos;
	}

	private static final class QueueFamilyHolder
	{
		// private final Set<EQueueType> types;
		private final int familyIndex;
		private final List<VulkanQueue> queues;
		private final List<Boolean> revervations;
		private final int requestedQueueCount;
		private final int effectiveQueueCount;

		public QueueFamilyHolder(	EnumSet<EQueueType> types,
									int familyIndex,
									int requestedQueueCount,
									int effectiveQueueCount)
		{
			// this.types = EnumSet.copyOf(types);
			this.requestedQueueCount = requestedQueueCount;
			this.effectiveQueueCount = effectiveQueueCount;
			this.familyIndex = familyIndex;
			queues = new ArrayList<>(requestedQueueCount);
			revervations = new ArrayList<>(requestedQueueCount);

			for (int i = 0; i < requestedQueueCount; i++)
			{
				revervations.add(false);
			}
		}

		public FloatBuffer allocPriorities(MemoryStack stack)
		{
			final var queuePriorities = stack.mallocFloat(effectiveQueueCount);
			for (int i = 0; i < effectiveQueueCount; i++)
				queuePriorities.put(1f);
			queuePriorities.flip();
			return queuePriorities;
		}

		public void createQueues(VkDevice device)
		{
			assert queues.isEmpty();

			for (int i = 0; i < effectiveQueueCount; i++)
			{
				final var vkQueue = retrieveDeviceQueue(device, familyIndex, i);
				final var queue = new VulkanQueue(familyIndex, vkQueue, false);
				queues.add(queue);
			}

			if (effectiveQueueCount < requestedQueueCount)
			{
				final int lastIndex = queues.size() - 1;
				final var lastQueue = queues.get(lastIndex);
				for (int i = lastIndex; i < requestedQueueCount; i++)
				{
					queues.add(lastQueue.share());
				}
			}
		}

		public void freeQueues()
		{
			queues.clear();
		}

		public VulkanQueue borrowQueue()
		{
			VulkanQueue res = null;
			for (int i = 0; i < revervations.size(); i++)
			{
				if (revervations.get(i) == false)
				{
					res = queues.get(i);
					revervations.set(i, true);
					break;
				}
			}
			return res;
		}

		public void returnQueue(VulkanQueue queue)
		{
			final int index = queues.indexOf(queue);
			revervations.set(index, false);
		}

		private static VkQueue retrieveDeviceQueue(	VkDevice device,
													int queueFamilyIndex,
													int queueIndex)
		{
			final PointerBuffer pQueue = memAllocPointer(1);
			vkGetDeviceQueue(device, queueFamilyIndex, 0, pQueue);
			final long queue = pQueue.get(queueIndex);
			memFree(pQueue);
			return new VkQueue(queue, device);
		}

		private static final class Builder
		{
			private final int familyIndex;
			private int requestedQueueCount = 0;
			private final List<EQueueType> types = new ArrayList<>();
			private final VkQueueFamilyProperties properties;

			public Builder(int familyIndex, VkQueueFamilyProperties properties)
			{
				this.familyIndex = familyIndex;
				this.properties = properties;
			}

			public void addCount(int count)
			{
				this.requestedQueueCount += count;
			}

			public void addType(EQueueType type)
			{
				types.add(type);
			}

			public QueueFamilyHolder build()
			{
				final int effectiveQueueCount = Math.min(	requestedQueueCount,
															properties.queueCount());
				return new QueueFamilyHolder(	EnumSet.copyOf(types),
												familyIndex,
												requestedQueueCount,
												effectiveQueueCount);
			}
		}
	}
}
