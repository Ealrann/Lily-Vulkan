package org.sheepy.lily.vulkan.common.execution;

import java.util.Collection;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.vulkan.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.execution.IExecutionContext;
import org.sheepy.lily.vulkan.api.execution.ISingleTimeCommand;
import org.sheepy.lily.vulkan.api.nativehelper.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.api.process.IVulkanContext;
import org.sheepy.lily.vulkan.api.queue.EQueueType;
import org.sheepy.lily.vulkan.api.queue.VulkanQueue;
import org.sheepy.lily.vulkan.common.device.LogicalDevice;
import org.sheepy.lily.vulkan.common.device.VulkanContext;
import org.sheepy.lily.vulkan.common.execution.internal.SingleTimeCommand;

public class ExecutionContext extends VulkanContext
		implements IAllocationContext, IAllocable, IExecutionContext
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
		setLogicalDevice((LogicalDevice) ((VulkanContext) context).getLogicalDevice());
		setWindow(((IVulkanContext) context).getWindow());

		switch (queueType)
		{
		case Compute:
			queue = logicalDevice.createComputeQueue();
			break;
		case Graphic:
			queue = logicalDevice.createGraphicQueue();
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

	@Override
	public VulkanQueue getQueue()
	{
		return queue;
	}

	@Override
	public void execute(ISingleTimeCommand command)
	{
		try (MemoryStack stack = MemoryStack.stackPush())
		{
			execute(stack, command);
		}
	}

	@Override
	public void execute(MemoryStack stack, ISingleTimeCommand command)
	{
		execute(stack, null, command);
	}

	@Override
	public void execute(MemoryStack stack,
						Collection<VkSemaphore> semaphoreToSignal,
						ISingleTimeCommand command)
	{
		final SingleTimeCommand stc = new SingleTimeCommand(this, stack, semaphoreToSignal)
		{
			@Override
			protected void doExecute(MemoryStack stack, VkCommandBuffer commandBuffer)
			{
				command.execute(stack, commandBuffer);
			}

			@Override
			protected void postExecute()
			{
				command.postExecute();
			}
		};
		stc.execute();
	}
}
