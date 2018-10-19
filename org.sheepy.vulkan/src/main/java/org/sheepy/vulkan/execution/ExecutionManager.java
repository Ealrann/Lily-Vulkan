package org.sheepy.vulkan.execution;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.allocation.IBasicAllocable;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.device.LogicalDeviceContext;
import org.sheepy.vulkan.execution.queue.EQueueType;
import org.sheepy.vulkan.execution.queue.IQueueManagerListener;
import org.sheepy.vulkan.execution.queue.VulkanQueue;

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
	public boolean isDirty()
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
