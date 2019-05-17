package org.sheepy.vulkan.execution;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkCommandBufferBeginInfo;
import org.lwjgl.vulkan.VkSubmitInfo;
import org.sheepy.vulkan.concurrent.VkSemaphore;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

public abstract class SingleTimeCommand extends AbstractCommandBuffer<IExecutionContext>
{
	protected final IExecutionContext executionContext;
	private List<VkSemaphore> semaphoreToSignal = null;
	private final MemoryStack stack;

	public SingleTimeCommand(IExecutionContext executionManager, MemoryStack stack)
	{
		this(executionManager, stack, null);
	}

	public SingleTimeCommand(	IExecutionContext executionContext,
								MemoryStack stack,
								Collection<VkSemaphore> semaphoreToSignal)
	{
		this.executionContext = executionContext;
		this.stack = stack;
		if (semaphoreToSignal != null && semaphoreToSignal.isEmpty() == false)
		{
			this.semaphoreToSignal = new ArrayList<>(semaphoreToSignal);
		}
		else
		{
			this.semaphoreToSignal = null;
		}

		allocate(stack, executionContext);
	}

	public void execute()
	{
		start(null);

		doExecute(stack, vkCommandBuffer);

		end(null);

		postExecute();

		free(executionContext);
	}

	@Override
	public void start(ECommandStage stage)
	{
		final VkCommandBufferBeginInfo beginInfo = VkCommandBufferBeginInfo.callocStack(stack);
		beginInfo.sType(VK_STRUCTURE_TYPE_COMMAND_BUFFER_BEGIN_INFO);
		beginInfo.flags(VK_COMMAND_BUFFER_USAGE_ONE_TIME_SUBMIT_BIT);

		vkBeginCommandBuffer(vkCommandBuffer, beginInfo);
	}

	@Override
	public void end(ECommandStage stage)
	{
		vkEndCommandBuffer(vkCommandBuffer);

		final PointerBuffer pCommandBuffer = stack.mallocPointer(1);
		pCommandBuffer.put(vkCommandBuffer.address());
		pCommandBuffer.flip();

		LongBuffer lBuffer = null;
		if (semaphoreToSignal != null)
		{
			lBuffer = MemoryUtil.memAllocLong(semaphoreToSignal.size());
			for (final VkSemaphore vkSemaphore : semaphoreToSignal)
			{
				lBuffer.put(vkSemaphore.getId());
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

	protected abstract void doExecute(MemoryStack stack, VkCommandBuffer commandBuffer);

	protected void postExecute()
	{}

}
