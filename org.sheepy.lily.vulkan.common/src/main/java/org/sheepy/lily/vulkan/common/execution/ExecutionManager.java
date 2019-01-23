package org.sheepy.vulkan.common.execution;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.api.queue.EQueueType;
import org.sheepy.vulkan.api.queue.VulkanQueue;
import org.sheepy.vulkan.common.allocation.IBasicAllocable;
import org.sheepy.vulkan.common.device.LogicalDevice;
import org.sheepy.vulkan.common.device.LogicalDeviceContext;
import org.sheepy.vulkan.common.queue.IQueueManagerListener;

public class ExecutionManager extends LogicalDeviceContext implements IBasicAllocable
{
	public final CommandPool commandPool;
	public final EQueueType queueType;

	private VulkanQueue queue;

	private final IQueueManagerListener queueListener = new IQueueManagerListener()
	{
		@Override
		public void onQueueManagerReload()
		{
			loadQueue();
		}
	};

	public ExecutionManager(LogicalDevice logicalDevice, EQueueType queueType, boolean resetAllowed)
	{
		super(logicalDevice);
		this.queueType = queueType;

		loadQueue();
		this.commandPool = new CommandPool(logicalDevice.getVkDevice(), queue.index, resetAllowed);
	}

	private void loadQueue()
	{
		queue = logicalDevice.queueManager.getQueue(queueType);
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		logicalDevice.queueManager.addListener(queueListener);
		commandPool.allocate(stack);
	}

	@Override
	public boolean isAllocationDirty()
	{
		return false;
	}

	@Override
	public void free()
	{
		commandPool.free();
		logicalDevice.queueManager.removeListener(queueListener);
	}

	public VulkanQueue getQueue()
	{
		return queue;
	}
}
