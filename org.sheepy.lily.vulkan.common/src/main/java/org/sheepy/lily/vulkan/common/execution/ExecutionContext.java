package org.sheepy.lily.vulkan.common.execution;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.api.queue.EQueueType;
import org.sheepy.lily.vulkan.api.queue.VulkanQueue;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocable;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;
import org.sheepy.lily.vulkan.common.device.ILogicalDeviceContext;
import org.sheepy.lily.vulkan.common.device.LogicalDeviceContext;

public class ExecutionContext extends LogicalDeviceContext implements IAllocationContext, IAllocable
{
	public final EQueueType queueType;
	private final boolean resetAllowed;

	public CommandPool commandPool;
	private VulkanQueue queue;

	public ExecutionContext(EQueueType queueType, boolean resetAllowed)
	{
		this.queueType = queueType;
		this.resetAllowed = resetAllowed;
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		setLogicalDevice(((ILogicalDeviceContext) context).getLogicalDevice());
		queue = getLogicalDevice().queueManager.getQueue(queueType);
		commandPool = new CommandPool(queue.index, resetAllowed);
		commandPool.allocate(stack, this);
	}

	@Override
	public void free(IAllocationContext context)
	{
		commandPool.free(this);
	}

	@Override
	public boolean isAllocationDirty(IAllocationContext context)
	{
		return false;
	}

	public VulkanQueue getQueue()
	{
		return queue;
	}
}
