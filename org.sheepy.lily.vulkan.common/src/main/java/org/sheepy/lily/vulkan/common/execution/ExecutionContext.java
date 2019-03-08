package org.sheepy.lily.vulkan.common.execution;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.api.queue.EQueueType;
import org.sheepy.lily.vulkan.api.queue.VulkanQueue;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocable;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;
import org.sheepy.lily.vulkan.common.engine.IVulkanContext;
import org.sheepy.lily.vulkan.common.engine.VulkanContext;

public class ExecutionContext extends VulkanContext implements IAllocationContext, IAllocable
{
	public final EQueueType queueType;
	private final boolean resetAllowed;

	public VulkanQueue queue;
	public CommandPool commandPool;

	public ExecutionContext(EQueueType queueType, boolean resetAllowed)
	{
		this.queueType = queueType;
		this.resetAllowed = resetAllowed;
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		setLogicalDevice(((IVulkanContext) context).getLogicalDevice());
		setWindow(((IVulkanContext) context).getWindow());

		switch (queueType)
		{
		case Compute:
			queue = getLogicalDevice().createComputeQueue();
			break;
		case Graphic:
			queue = getLogicalDevice().createGraphicQueue();
			break;
		case Present:
			throw new AssertionError("Present is not a valid ExecutionContext");
		default:
			break;
		}

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
