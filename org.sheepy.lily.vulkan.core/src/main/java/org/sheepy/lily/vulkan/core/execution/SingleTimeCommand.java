package org.sheepy.lily.vulkan.core.execution;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkCommandBufferBeginInfo;
import org.lwjgl.vulkan.VkSubmitInfo;
import org.sheepy.lily.game.api.execution.EExecutionStatus;
import org.sheepy.lily.vulkan.core.concurrent.VkFence;
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
	private final VkFence fence;

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

		fence = new VkFence(executionContext.getVkDevice(), false);
	}

	public void execute()
	{
		start(ECommandStage.MAIN);

		final var recordContext = new RecordContext(executionContext, vkCommandBuffer, ECommandStage.MAIN, 0);
		recordContext.stackPush();
		doExecute(recordContext);
		recordContext.stackPop();
		end(ECommandStage.MAIN);
		submit(recordContext);
	}

	@Override
	public void start(ECommandStage stage)
	{
		final var beginInfo = VkCommandBufferBeginInfo.calloc(stack);
		beginInfo.sType(VK_STRUCTURE_TYPE_COMMAND_BUFFER_BEGIN_INFO);
		beginInfo.flags(VK_COMMAND_BUFFER_USAGE_ONE_TIME_SUBMIT_BIT);

		vkBeginCommandBuffer(vkCommandBuffer, beginInfo);
//		System.out.println(Long.toHexString(vkCommandBuffer.address()) + " STC Start");
	}

	@Override
	public void end(ECommandStage stage)
	{
		vkEndCommandBuffer(vkCommandBuffer);
	}

	private void submit(final RecordContext recordContext)
	{
		final var pCommandBuffer = MemoryUtil.memAllocPointer(1);
		final long commandBufferPtr = vkCommandBuffer.address();
		pCommandBuffer.put(commandBufferPtr);
		pCommandBuffer.flip();
		final LongBuffer pSemaphores = allocSemaphorePointers();
		final VkSubmitInfo submitInfo = VkSubmitInfo.calloc();
		submitInfo.sType(VK_STRUCTURE_TYPE_SUBMIT_INFO);
		submitInfo.pCommandBuffers(pCommandBuffer);
		submitInfo.pSignalSemaphores(pSemaphores);
		recordContext.getExecutionListeners().forEach(listener -> listener.accept(EExecutionStatus.Started));
		final var res = vkQueueSubmit(executionContext.getQueue().vkQueue, submitInfo, fence.getPtr());
		final EExecutionStatus finalStatus;
		if (res == VK_SUCCESS)
		{
			finalStatus = EExecutionStatus.Done;
			fence.waitForSignal((long) 1e9);
		}
		else
		{
			finalStatus = EExecutionStatus.Canceled;
		}
		assert fence.isSignaled();

		if (pSemaphores != null) MemoryUtil.memFree(pSemaphores);
		fence.free();
		free(executionContext);
		MemoryUtil.memFree(pCommandBuffer);
		submitInfo.free();

//			System.out.println(Long.toHexString(commandBufferPtr) + " STC Free");
		recordContext.getExecutionListeners().forEach(listener -> listener.accept(finalStatus));
	}

	private LongBuffer allocSemaphorePointers()
	{
		final LongBuffer pSemaphores;
		if (semaphoreToSignal.isEmpty() == false)
		{
			pSemaphores = MemoryUtil.memAllocLong(semaphoreToSignal.size());
			for (final VkSemaphore vkSemaphore : semaphoreToSignal)
			{
				pSemaphores.put(vkSemaphore.getPtr());
			}
			pSemaphores.flip();
		}
		else
		{
			pSemaphores = null;
		}
		return pSemaphores;
	}

	protected abstract void doExecute(IRecordContext context);
}
