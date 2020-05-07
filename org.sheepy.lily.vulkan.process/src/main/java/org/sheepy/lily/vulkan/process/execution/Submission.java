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
import org.sheepy.lily.vulkan.core.execution.IRecordable.RecordContext.IExecutionIdleListener;
import org.sheepy.lily.vulkan.core.execution.ISubmission;
import org.sheepy.lily.vulkan.core.util.EVulkanErrorStatus;
import org.sheepy.lily.vulkan.core.util.Logger;

import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.vulkan.VK10.*;

public class Submission implements ISubmission
{
	private static final String FENCE_TIMEOUT = "Fence timeout";
	private static final long TIMEOUT = TimeUnit.SECONDS.toNanos(60);
	private static final String FAILED_SUBMIT = "Failed to submit command buffer";

	public final VkFence fence;

	private final VkQueue queue;
	private final VkSubmitInfo submitInfo;
	private final PointerBuffer pCommandBuffers;

	private final LongBuffer bWaitSemaphores;
	private final IntBuffer waitStages;
	private final LongBuffer bSignalSemaphores;

	private List<IExecutionIdleListener> listeners;

	public Submission(VkCommandBuffer commandBuffer,
					  ExecutionContext context,
					  Collection<WaitData> waitSemaphores,
					  Collection<VkSemaphore> signalSemaphores,
					  boolean useFence)
	{
		if (useFence)
		{
			fence = new VkFence(context.getVkDevice(), true);
		}
		else
		{
			fence = null;
		}

		queue = context.getQueue().vkQueue;

		if (waitSemaphores.isEmpty() == false)
		{
			bWaitSemaphores = memAllocLong(waitSemaphores.size());
			waitStages = memAllocInt(waitSemaphores.size());
			for (final WaitData waitData : waitSemaphores)
			{
				bWaitSemaphores.put(waitData.semaphore.getPtr());
				waitStages.put(waitData.waitStage.getValue());
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
		if (fence != null) fence.free();

		memFree(pCommandBuffers);

		if (waitStages != null) memFree(waitStages);

		memFree(bSignalSemaphores);
		if (bWaitSemaphores != null) memFree(bWaitSemaphores);

		submitInfo.free();
	}

	@Override
	public IFenceView submit()
	{
		final long fenceId = fence != null ? fence.getPtr() : 0;

		waitIdle();

		if (fence != null) fence.setUsed(true);
		final var res = vkQueueSubmit(queue, submitInfo, fenceId);

		Logger.check(res, FAILED_SUBMIT, true);

		if (res != VK_SUCCESS && DebugUtil.DEBUG_ENABLED)
		{
			final var status = EVulkanErrorStatus.resolveFromCode(res);
			System.err.println("[Submit] " + status.message);
		}

		return fence;
	}

	@Override
	public void checkFence()
	{
		if (fence.isUsed() && fence.isSignaled())
		{
			resetFence();
		}
	}

	private void resetFence()
	{
		if (fence.isUsed())
		{
			if (listeners != null)
			{
				for (final var listener : listeners)
				{
					listener.onExecutionIdle();
				}
			}
			fence.reset();
		}
	}

	@Override
	public void waitIdle()
	{
		if (fence != null)
		{
			if (fence.isUsed() && fence.isSignaled() == false)
			{
				if (fence.waitForSignal(TIMEOUT) == false)
				{
					Logger.log(FENCE_TIMEOUT, true);
				}
			}
			resetFence();
		}
	}

	@Override
	public void setExecutionIdleListeners(List<IExecutionIdleListener> listeners)
	{
		this.listeners = listeners;
	}

	@Override
	public VkSubmitInfo getSubmitInfo()
	{
		return submitInfo;
	}

	@Override
	public boolean isBusy()
	{
		boolean res = false;

		if (fence != null)
		{
			res = !fence.isSignaled();
		}

		return res;
	}
}
