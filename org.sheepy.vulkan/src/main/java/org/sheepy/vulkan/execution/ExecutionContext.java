package org.sheepy.vulkan.execution;

import java.util.Collection;
import java.util.List;

import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.vulkan.concurrent.VkSemaphore;
import org.sheepy.vulkan.device.DelegatedVulkanContext;
import org.sheepy.vulkan.device.IVulkanContext;
import org.sheepy.vulkan.queue.EQueueType;
import org.sheepy.vulkan.queue.VulkanQueue;

public class ExecutionContext extends DelegatedVulkanContext
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
	public void allocate(IVulkanContext context)
	{
		super.allocate(context);

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
		commandPool.allocate(this);
	}

	@Override
	public void free(IVulkanContext context)
	{
		commandPool.free(this);
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
		execute(List.of(), command);
	}

	@Override
	public void execute(Collection<VkSemaphore> semaphoreToSignal, ISingleTimeCommand command)
	{
		final SingleTimeCommand stc = new SingleTimeCommand(this, semaphoreToSignal)
		{
			@Override
			protected void doExecute(IExecutionContext context, VkCommandBuffer commandBuffer)
			{
				command.execute(context, commandBuffer);
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
