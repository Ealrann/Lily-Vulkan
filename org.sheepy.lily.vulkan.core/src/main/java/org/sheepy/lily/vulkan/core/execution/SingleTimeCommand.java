package org.sheepy.lily.vulkan.core.execution;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkCommandBufferBeginInfo;
import org.lwjgl.vulkan.VkSubmitInfo;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.nio.LongBuffer;
import java.util.Collection;
import java.util.List;

import static org.lwjgl.vulkan.VK10.*;

public abstract class SingleTimeCommand extends AbstractCommandBuffer
{
	protected final ExecutionContext executionContext;
	private final MemoryStack stack;
	private final List<VkSemaphore> semaphoreToSignal;

	public SingleTimeCommand(ExecutionContext executionContext)
	{
		this(executionContext, null);
	}

	public SingleTimeCommand(ExecutionContext executionContext, Collection<VkSemaphore> semaphoreToSignal)
	{
		super(executionContext);

		this.executionContext = executionContext;
		this.stack = executionContext.stack();
		if (semaphoreToSignal != null && semaphoreToSignal.isEmpty() == false)
		{
			this.semaphoreToSignal = List.copyOf(semaphoreToSignal);
		}
		else
		{
			this.semaphoreToSignal = List.of();
		}
	}

	public void execute()
	{
		start(null);

		doExecute(executionContext, this);

		end(null);

		postExecute();

		free(executionContext);
	}

	@Override
	public void start(ECommandStage stage)
	{
		final var beginInfo = VkCommandBufferBeginInfo.callocStack(stack);
		beginInfo.sType(VK_STRUCTURE_TYPE_COMMAND_BUFFER_BEGIN_INFO);
		beginInfo.flags(VK_COMMAND_BUFFER_USAGE_ONE_TIME_SUBMIT_BIT);

		vkBeginCommandBuffer(vkCommandBuffer, beginInfo);
	}

	@Override
	public void end(ECommandStage stage)
	{
		vkEndCommandBuffer(vkCommandBuffer);

		final var pCommandBuffer = stack.mallocPointer(1);
		pCommandBuffer.put(vkCommandBuffer.address());
		pCommandBuffer.flip();

		LongBuffer lBuffer = null;
		if (semaphoreToSignal.isEmpty() == false)
		{
			lBuffer = MemoryUtil.memAllocLong(semaphoreToSignal.size());
			for (final VkSemaphore vkSemaphore : semaphoreToSignal)
			{
				lBuffer.put(vkSemaphore.getPtr());
			}
			lBuffer.flip();
		}

		final VkSubmitInfo submitInfo = VkSubmitInfo.callocStack(stack);
		submitInfo.sType(VK_STRUCTURE_TYPE_SUBMIT_INFO);
		submitInfo.pCommandBuffers(pCommandBuffer);
		submitInfo.pSignalSemaphores(lBuffer);

		vkQueueSubmit(executionContext.getQueue().vkQueue, submitInfo, VK_NULL_HANDLE);
		vkQueueWaitIdle(executionContext.getQueue().vkQueue);

		if (lBuffer != null) MemoryUtil.memFree(lBuffer);
	}

	protected abstract void doExecute(ExecutionContext context, ICommandBuffer commandBuffer);

	protected void postExecute()
	{
	}
}
