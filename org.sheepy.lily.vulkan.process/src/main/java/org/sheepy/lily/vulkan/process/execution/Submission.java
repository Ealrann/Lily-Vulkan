package org.sheepy.lily.vulkan.process.execution;

import org.lwjgl.PointerBuffer;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkQueue;
import org.lwjgl.vulkan.VkSubmitInfo;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.api.concurrent.IFenceView;
import org.sheepy.lily.vulkan.core.concurrent.VkFence;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.execution.ISubmission;
import org.sheepy.lily.vulkan.core.util.EVulkanErrorStatus;
import org.sheepy.lily.vulkan.core.util.Logger;

import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.Collection;
import java.util.List;

import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.vulkan.VK10.*;

public final class Submission implements ISubmission
{
	private static final String FAILED_SUBMIT = "Failed to submit command buffer";

	private final FenceManager fences;
	private final VkQueue queue;
	private final VkSubmitInfo submitInfo;
	private final PointerBuffer pCommandBuffers;

	private final LongBuffer bWaitSemaphores;
	private final IntBuffer waitStages;
	private final LongBuffer bSignalSemaphores;

	public Submission(VkCommandBuffer commandBuffer,
					  ExecutionContext context,
					  Collection<WaitData> waitSemaphores,
					  Collection<VkSemaphore> signalSemaphores,
					  int queuedExecutionCount)
	{
		fences = new FenceManager(queuedExecutionCount, context.getVkDevice());
		queue = context.getQueue().vkQueue;

		if (waitSemaphores.isEmpty() == false)
		{
			bWaitSemaphores = memAllocLong(waitSemaphores.size());
			waitStages = memAllocInt(waitSemaphores.size());
			for (final WaitData waitData : waitSemaphores)
			{
				bWaitSemaphores.put(waitData.semaphore().getPtr());
				waitStages.put(waitData.waitStage().getValue());
			}
			bWaitSemaphores.flip();
			waitStages.flip();
		}
		else
		{
			bWaitSemaphores = null;
			waitStages = null;
		}

		pCommandBuffers = memAllocPointer(1);
		pCommandBuffers.put(commandBuffer);
		pCommandBuffers.flip();

		bSignalSemaphores = memAllocLong(signalSemaphores.size());
		for (var signalSemaphore : signalSemaphores)
		{
			bSignalSemaphores.put(signalSemaphore.getPtr());
		}
		bSignalSemaphores.flip();

		submitInfo = VkSubmitInfo.calloc();
		submitInfo.sType(VK_STRUCTURE_TYPE_SUBMIT_INFO);
		submitInfo.waitSemaphoreCount(waitSemaphores.size());
		submitInfo.pWaitSemaphores(bWaitSemaphores);
		submitInfo.pWaitDstStageMask(waitStages);
		submitInfo.pCommandBuffers(pCommandBuffers);
		submitInfo.pSignalSemaphores(bSignalSemaphores);
	}

	public void free()
	{
		fences.free();
		memFree(pCommandBuffers);

		if (waitStages != null) memFree(waitStages);

		memFree(bSignalSemaphores);
		if (bWaitSemaphores != null) memFree(bWaitSemaphores);

		submitInfo.free();
	}

	@Override
	public IFenceView submit()
	{
		final var fence = fences.next();
		final long fencePtr = fence.getPtr();
		final var res = vkQueueSubmit(queue, submitInfo, fencePtr);

		Logger.check(res, FAILED_SUBMIT, true);

		if (res != VK_SUCCESS && DebugUtil.DEBUG_ENABLED)
		{
			final var status = EVulkanErrorStatus.resolveFromCode(res);
			final String message = status != null ? status.message : "Unknown Error";
			System.err.println("[Submit] " + message);
		}

		return fence;
	}

	@Override
	public void checkFence()
	{
		fences.check();
	}

	@Override
	public void waitIdle()
	{
		fences.waitIdle();
	}

	public void setNextExecutionListeners(List<VkFence.IFenceListener> listeners)
	{
		fences.setNextExecutionListeners(listeners);
	}

	@Override
	public VkSubmitInfo getSubmitInfo()
	{
		return submitInfo;
	}

	@Override
	public boolean isRunning()
	{
		return fences.isRunning();
	}

}
