package org.sheepy.lily.vulkan.process.execution;

import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.vulkan.VK10.*;

import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.Collection;
import java.util.List;

import org.lwjgl.PointerBuffer;
import org.lwjgl.vulkan.VkQueue;
import org.lwjgl.vulkan.VkSubmitInfo;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.common.execution.ISubmission;
import org.sheepy.lily.vulkan.common.process.IProcessContext.IRecorderContext;
import org.sheepy.vulkan.concurrent.IFenceView;
import org.sheepy.vulkan.concurrent.VkFence;
import org.sheepy.vulkan.concurrent.VkSemaphore;
import org.sheepy.vulkan.execution.ICommandBuffer;
import org.sheepy.vulkan.execution.IRecordable.RecordContext.IExecutionIdleListener;
import org.sheepy.vulkan.log.EVulkanErrorStatus;
import org.sheepy.vulkan.log.Logger;

public class Submission<T extends IRecorderContext<T>> implements ISubmission<T>
{
	private static final String FENCE_TIMEOUT = "Fence timeout";
	private static final int TIMEOUT = (int) 60e9;
	private static final String FAILED_SUBMIT = "Failed to submit command buffer";

	public final VkFence fence;

	private final Collection<WaitData> waitSemaphores;
	private final ICommandBuffer<? super T> commandBuffer;
	private final List<VkSemaphore> signalSemaphores;

	private VkSubmitInfo submitInfo;
	private LongBuffer bWaitSemaphores;
	private IntBuffer waitStages;
	private PointerBuffer pCommandBuffers;
	private LongBuffer bSignalSemaphores;
	private List<IExecutionIdleListener> listeners;
	private VkQueue queue;

	public Submission(	ICommandBuffer<? super T> commandBuffer,
						Collection<WaitData> waitSemaphores,
						Collection<VkSemaphore> signalSemaphores,
						boolean useFence)
	{
		this.commandBuffer = commandBuffer;
		this.waitSemaphores = List.copyOf(waitSemaphores);
		this.signalSemaphores = List.copyOf(signalSemaphores);

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
	public void configureAllocation(IAllocationConfigurator config, T context)
	{
		config.addDependencies(List.of(commandBuffer));
	}

	@Override
	public void allocate(T context)
	{
		queue = context.getQueue().vkQueue;
		if (fence != null) fence.allocate(context);

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

		allocSignalSemaphoreBuffer();

		submitInfo = VkSubmitInfo.calloc();
		submitInfo.sType(VK_STRUCTURE_TYPE_SUBMIT_INFO);
		submitInfo.waitSemaphoreCount(waitSemaphores.size());
		submitInfo.pWaitSemaphores(bWaitSemaphores);
		submitInfo.pWaitDstStageMask(waitStages);
		submitInfo.pCommandBuffers(pCommandBuffers);
		submitInfo.pSignalSemaphores(bSignalSemaphores);
	}

	private void allocSignalSemaphoreBuffer()
	{
		bSignalSemaphores = memAllocLong(signalSemaphores.size());
		for (int i = 0; i < signalSemaphores.size(); i++)
		{
			final var signalSemaphore = signalSemaphores.get(i).getPtr();
			bSignalSemaphores.put(signalSemaphore);
		}
		bSignalSemaphores.flip();
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
	public IFenceView submit()
	{
		final long fenceId = fence != null ? fence.getId() : 0;

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
