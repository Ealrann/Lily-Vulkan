package org.sheepy.lily.vulkan.core.execution;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkInstance;
import org.lwjgl.vulkan.VkPhysicalDevice;
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

public class ExecutionContext extends GameAllocationContext implements IVulkanContext, IExecutionContext
{
	private final IVulkanContext vulkanContext;
	public final EQueueType queueType;

	public VulkanQueue queue;
	public CommandPool commandPool;

	public ExecutionContext(IVulkanContext vulkanContext, EQueueType queueType, boolean resetAllowed)
	{
		this.vulkanContext = vulkanContext;
		this.queueType = queueType;

		final var logicalDevice = vulkanContext.getLogicalDevice();
		final var vkDevice = vulkanContext.getVkDevice();
		switch (queueType)
		{
			case Compute -> queue = logicalDevice.borrowComputeQueue();
			case Graphic -> queue = logicalDevice.borrowGraphicQueue();
			case Present -> throw new AssertionError("Present is not a valid ExecutionContext");
		}

		try (final var stack = MemoryStack.stackPush())
		{
			commandPool = new CommandPool.Builder(queue.familyIndex, resetAllowed).build(vkDevice, stack);
		}
	}

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

	public void executeCommand(ISingleTimeCommand command)
	{
		executeCommand(List.of(), command);
	}

	public <Result> Result executeFunction(ISingleTimeFunction<Result> function)
	{
		final var stc = new SingleTimeFunctionImpl<>(this, function);
		stc.execute();

		return stc.result;
	}

	public void executeCommand(Collection<VkSemaphore> semaphoreToSignal, ISingleTimeCommand command)
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
		protected void doExecute(IRecordContext context)
		{
			command.execute(context);
		}
	}

	private static final class SingleTimeFunctionImpl<Result> extends SingleTimeCommand
	{
		private final ISingleTimeFunction<Result> function;

		private Result result;

		public SingleTimeFunctionImpl(final ExecutionContext executionContext,
									  final ISingleTimeFunction<Result> function)
		{
			super(executionContext);
			this.function = function;
		}

		@Override
		protected void doExecute(IRecordContext context)
		{
			result = function.execute(context);
		}
	}
}
