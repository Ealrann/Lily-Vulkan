package org.sheepy.lily.vulkan.process.execution;

import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.vulkan.VK10.*;

import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.Collection;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkQueue;
import org.lwjgl.vulkan.VkSubmitInfo;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.api.execution.ISubmission;
import org.sheepy.lily.vulkan.api.process.IProcessContext.IRecorderContext;
import org.sheepy.vulkan.concurrent.VkFence;
import org.sheepy.vulkan.execution.ICommandBuffer;
import org.sheepy.vulkan.log.EVulkanErrorStatus;
import org.sheepy.vulkan.log.Logger;

public class Submission<T extends IRecorderContext<T>> implements ISubmission<T>
{
	private static final String FENCE_TIMEOUT = "Fence timeout";
	private static final int TIMEOUT = (int) 1e8;
	private static final String FAILED_SUBMIT = "Failed to submit command buffer";

	protected final ICommandBuffer<? super T> commandBuffer;
	protected final Collection<WaitData> waitSemaphores;
	protected final Collection<Long> signalSemaphores;

	protected VkSubmitInfo submitInfo;
	protected LongBuffer bWaitSemaphores;
	protected IntBuffer waitStages;
	protected PointerBuffer pCommandBuffers;
	protected LongBuffer bSignalSemaphores;

	public final VkFence fence;
	private VkQueue queue;

	public Submission(	ICommandBuffer<? super T> commandBuffer,
						Collection<WaitData> waitSemaphores,
						Collection<Long> signalSemaphores,
						boolean useFence)
	{
		this.commandBuffer = commandBuffer;
		this.waitSemaphores = waitSemaphores;
		this.signalSemaphores = new ArrayList<>(signalSemaphores);

		if (useFence)
		{
			fence = new VkFence(true);
		}
		else
		{
			fence = null;
		}
	}

	@Override
	public void allocate(MemoryStack stack, T context)
	{
		queue = context.getQueue().vkQueue;
		if (fence != null) fence.allocate(stack, context);

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

		pCommandBuffers = memAllocPointer(1);
		pCommandBuffers.put(commandBuffer.getVkCommandBuffer());
		pCommandBuffers.flip();

		bSignalSemaphores = memAllocLong(signalSemaphores.size());
		for (final Long signalSemaphore : signalSemaphores)
		{
			bSignalSemaphores.put(signalSemaphore);
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

	@Override
	public void free(T context)
	{
		if (fence != null) fence.free(context);

		memFree(pCommandBuffers);
		pCommandBuffers = null;

		if (waitStages != null) memFree(waitStages);

		memFree(bSignalSemaphores);
		bSignalSemaphores = null;

		if (bWaitSemaphores != null) memFree(bWaitSemaphores);

		submitInfo.free();
		submitInfo = null;
	}

	@Override
	public void submit()
	{
		final long fenceId = fence != null ? fence.getId() : 0;

		waitIdle();

		final var res = vkQueueSubmit(queue, submitInfo, fenceId);
		if (fence != null) fence.setUsed(true);

		Logger.check(res, FAILED_SUBMIT, true);

		if (res != VK_SUCCESS && DebugUtil.DEBUG_ENABLED)
		{
			final var status = EVulkanErrorStatus.resolveFromCode(res);
			System.err.println("[Submit] " + status.message);
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
			fence.reset();
		}
	}

	@Override
	public VkSubmitInfo getSubmitInfo()
	{
		return submitInfo;
	}

	@Override
	public boolean isAllocationDirty(T context)
	{
		return context.getExecutionRecorders().isAllocationDirty(context);
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
