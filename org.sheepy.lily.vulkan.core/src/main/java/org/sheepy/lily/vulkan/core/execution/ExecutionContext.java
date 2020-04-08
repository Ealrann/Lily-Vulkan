package org.sheepy.lily.vulkan.core.execution;

import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkInstance;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.game.core.allocation.GameAllocationContext;
import org.sheepy.lily.vulkan.api.execution.IExecutionContext;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.core.device.LogicalDevice;
import org.sheepy.lily.vulkan.core.device.PhysicalDevice;
import org.sheepy.lily.vulkan.core.execution.queue.EQueueType;
import org.sheepy.lily.vulkan.core.execution.queue.VulkanQueue;
import org.sheepy.lily.vulkan.core.window.Window;

import java.util.Collection;
import java.util.List;

public class ExecutionContext extends GameAllocationContext implements IVulkanContext,
																	   IExecutionContext,
																	   IAllocable<IVulkanContext>
{
	public final EQueueType queueType;
	private final boolean resetAllowed;

	public VulkanQueue queue;
	public CommandPool commandPool;
	private IVulkanContext vulkanContext;

	public ExecutionContext(EQueueType queueType, boolean resetAllowed)
	{
		this.queueType = queueType;
		this.resetAllowed = resetAllowed;
	}

	@Override
	public void allocate(IVulkanContext vulkanContext)
	{
		this.vulkanContext = vulkanContext;
		final var logicalDevice = vulkanContext.getLogicalDevice();
		switch (queueType)
		{
			case Compute -> queue = logicalDevice.borrowComputeQueue();
			case Graphic -> queue = logicalDevice.borrowGraphicQueue();
			case Present -> throw new AssertionError("Present is not a valid ExecutionContext");
		}

		commandPool = new CommandPool.Builder(queue.familyIndex, resetAllowed).build(vulkanContext);
	}

	@Override
	public void free(IVulkanContext vulkanContext)
	{
		getLogicalDevice().returnQueue(queue);
		commandPool.free(vulkanContext);
	}

	public VulkanQueue getQueue()
	{
		return queue;
	}

	public CommandPool getCommandPool()
	{
		return commandPool;
	}

	public void execute(ISingleTimeCommand command)
	{
		execute(List.of(), command);
	}

	public void execute(Collection<VkSemaphore> semaphoreToSignal, ISingleTimeCommand command)
	{
		final var stc = new SingleTimeCommandImpl(this, semaphoreToSignal, command);
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
	public VkInstance getVkInstance()
	{
		return vulkanContext.getVkInstance();
	}

	@Override
	public VkPhysicalDevice getVkPhysicalDevice()
	{
		return vulkanContext.getVkPhysicalDevice();
	}

	private static final class SingleTimeCommandImpl extends SingleTimeCommand
	{
		private final ISingleTimeCommand command;

		public SingleTimeCommandImpl(final ExecutionContext executionContext,
									 final Collection<VkSemaphore> semaphoreToSignal,
									 final ISingleTimeCommand command)
		{
			super(executionContext, semaphoreToSignal);
			this.command = command;
		}

		@Override
		protected void doExecute(ExecutionContext context, ICommandBuffer<?> commandBuffer)
		{
			command.execute(context, commandBuffer);
		}

		@Override
		protected void postExecute()
		{
			command.postExecute();
		}
	}
}
