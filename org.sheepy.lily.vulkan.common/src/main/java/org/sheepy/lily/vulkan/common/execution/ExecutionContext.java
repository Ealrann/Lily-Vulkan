package org.sheepy.lily.vulkan.common.execution;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.api.queue.EQueueType;
import org.sheepy.lily.vulkan.api.queue.VulkanQueue;
import org.sheepy.lily.vulkan.common.allocation.IAllocable;
import org.sheepy.lily.vulkan.common.device.LogicalDevice;
import org.sheepy.lily.vulkan.common.device.LogicalDeviceContext;

public class ExecutionContext extends LogicalDeviceContext implements IAllocable
{
	public final CommandPool commandPool;
	public final EQueueType queueType;

	private VulkanQueue queue;

	public ExecutionContext(LogicalDevice logicalDevice, EQueueType queueType, boolean resetAllowed)
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
	}

	public VulkanQueue getQueue()
	{
		return queue;
	}
}
