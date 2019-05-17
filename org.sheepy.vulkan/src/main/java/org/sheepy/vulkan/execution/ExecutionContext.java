package org.sheepy.vulkan.execution;

import java.util.Collection;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.concurrent.VkSemaphore;
import org.sheepy.vulkan.device.IVulkanContext;
import org.sheepy.vulkan.device.VulkanContext;
import org.sheepy.vulkan.queue.EQueueType;
import org.sheepy.vulkan.queue.VulkanQueue;

public class ExecutionContext extends VulkanContext
		implements IAllocable<IVulkanContext>, IExecutionContext
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
	public void allocate(MemoryStack stack, IVulkanContext context)
	{
		setLogicalDevice(context.getLogicalDevice());
		setWindow(context.getWindow());

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
	public void free(IVulkanContext context)
	{
		commandPool.free(this);
	}

	@Override
	public boolean isAllocationDirty(IVulkanContext context)
	{
		return false;
	}

	@Override
	public VulkanQueue getQueue()
	{
		return queue;
	}

	@Override
	public CommandPool getCommandPool()
	{
		return commandPool;
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
