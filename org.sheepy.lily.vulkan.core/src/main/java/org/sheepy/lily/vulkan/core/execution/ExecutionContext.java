package org.sheepy.lily.vulkan.core.execution;

import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.sheepy.lily.game.core.allocation.GameAllocationContext;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.core.device.InternalVulkanContext;
import org.sheepy.lily.vulkan.core.device.LogicalDevice;
import org.sheepy.lily.vulkan.core.device.PhysicalDevice;
import org.sheepy.lily.vulkan.core.device.VulkanContext;
import org.sheepy.lily.vulkan.core.execution.queue.EQueueType;
import org.sheepy.lily.vulkan.core.execution.queue.VulkanQueue;
import org.sheepy.lily.vulkan.core.window.Window;

import java.util.Collection;
import java.util.List;

public class ExecutionContext extends GameAllocationContext implements InternalExecutionContext, InternalVulkanContext
{
	public final EQueueType queueType;
	private final boolean resetAllowed;

	public VulkanQueue queue;
	public CommandPool commandPool;
	private VulkanContext vulkanContext;

	public ExecutionContext(EQueueType queueType, boolean resetAllowed)
	{
		this.queueType = queueType;
		this.resetAllowed = resetAllowed;
	}

	@Override
	public void allocate(VulkanContext vulkanContext)
	{
		this.vulkanContext = vulkanContext;
		final var logicalDevice = vulkanContext.getLogicalDevice();
		switch (queueType)
		{
			case Compute:
				queue = logicalDevice.borrowComputeQueue();
				break;
			case Graphic:
				queue = logicalDevice.borrowGraphicQueue();
				break;
			case Present:
				throw new AssertionError("Present is not a valid ExecutionContext");
			default:
				break;
		}

		commandPool = new CommandPool(queue.familyIndex, resetAllowed);
		commandPool.allocate(vulkanContext);
	}

	@Override
	public void free(VulkanContext vulkanContext)
	{
		getLogicalDevice().returnQueue(queue);
		commandPool.free(vulkanContext);
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
			protected void doExecute(InternalExecutionContext context,
									 ICommandBuffer<?> commandBuffer)
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

	@Override
	public Window getWindow()
	{
		return vulkanContext.getWindow();
	}

	@Override
	public PhysicalDevice getPhysicalDevice()
	{
		return vulkanContext.getPhysicalDevice();
	}

	@Override
	public LogicalDevice getLogicalDevice()
	{
		return vulkanContext.getLogicalDevice();
	}

	@Override
	public VkDevice getVkDevice()
	{
		return vulkanContext.getVkDevice();
	}

	@Override
	public VkPhysicalDevice getVkPhysicalDevice()
	{
		return vulkanContext.getVkPhysicalDevice();
	}
}
