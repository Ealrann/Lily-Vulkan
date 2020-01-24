package org.sheepy.lily.vulkan.common.execution;

import java.util.Collection;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.sheepy.lily.vulkan.common.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.common.device.InternalVulkanContext;
import org.sheepy.lily.vulkan.common.device.LogicalDevice;
import org.sheepy.lily.vulkan.common.device.PhysicalDevice;
import org.sheepy.lily.vulkan.common.device.VulkanContext;
import org.sheepy.lily.vulkan.common.execution.queue.EQueueType;
import org.sheepy.lily.vulkan.common.execution.queue.VulkanQueue;
import org.sheepy.lily.vulkan.common.window.Window;

public class ExecutionContext implements InternalExecutionContext, InternalVulkanContext
{
	public final EQueueType queueType;
	private final boolean resetAllowed;

	public VulkanQueue queue;
	public CommandPool commandPool;
	private MemoryStack stack = null;
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
		commandPool.allocate(this);
	}

	@Override
	public void free()
	{
		getLogicalDevice().returnQueue(queue);
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
			protected void doExecute(	InternalExecutionContext context,
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
	public MemoryStack stackPush()
	{
		if (stack != null)
		{
			stack.pop();
		}

		stack = MemoryStack.stackPush();

		return stack;
	}

	@Override
	public void stackPop()
	{
		if (stack != null)
		{
			stack.pop();
			stack = null;
		}
	}

	@Override
	public MemoryStack stack()
	{
		if (stack == null)
		{
			stackPush();
		}
		return stack;
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
