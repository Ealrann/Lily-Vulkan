package org.sheepy.lily.vulkan.process.execution;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.game.api.execution.EExecutionStatus;
import org.sheepy.lily.vulkan.api.concurrent.IFenceView;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.core.execution.AbstractCommandBuffer;
import org.sheepy.lily.vulkan.core.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.core.util.EVulkanErrorStatus;
import org.sheepy.lily.vulkan.core.util.Logger;
import org.sheepy.lily.vulkan.process.execution.util.FenceManager;
import org.sheepy.lily.vulkan.process.execution.util.Submission;
import org.sheepy.lily.vulkan.process.process.ProcessContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static org.lwjgl.vulkan.VK10.VK_SUCCESS;

public final class GenericExecutionRecorder
{
	private static final String FAILED_SUBMIT = "Failed to submit command buffer";

	private final AbstractCommandBuffer commandBuffer;
	private final ProcessContext context;
	private final IAllocationState allocationState;
	private final int index;
	private final int indexCount;
	private final FenceManager fences;
	private final Consumer<RecordContext> doRecord;
	private final VkSemaphore executionSemaphore;

	private List<WaitData> waitSemaphores;
	private List<VkSemaphore> signalSemaphores;

	public GenericExecutionRecorder(AbstractCommandBuffer commandBuffer,
									ProcessContext context,
									IAllocationState allocationState,
									int index,
									int indexCount,
									int fenceCount,
									Consumer<RecordContext> doRecord)
	{
		this.commandBuffer = commandBuffer;
		this.context = context;
		this.allocationState = allocationState;
		this.index = index;
		this.indexCount = indexCount;
		this.doRecord = doRecord;
		this.fences = new FenceManager(fenceCount, context.getVkDevice());
		executionSemaphore = new VkSemaphore(context.getVkDevice());
	}

	public void prepare(final List<WaitData> waitSemaphores,
						List<VkSemaphore> signalSemaphores,
						boolean signalExecutionSemaphore)
	{
		this.waitSemaphores = waitSemaphores;

		if (signalExecutionSemaphore)
		{
			this.signalSemaphores = new ArrayList<>(signalSemaphores.size() + 1);
			this.signalSemaphores.addAll(signalSemaphores);
			this.signalSemaphores.add(executionSemaphore);
		}
		else
		{
			this.signalSemaphores = signalSemaphores;
		}
	}

	public void record(List<ECommandStage> stages)
	{
		final List<Consumer<EExecutionStatus>> listeners = new ArrayList<>();
		final var vkCommandBuffer = commandBuffer.getVkCommandBuffer();

		try (final var stack = MemoryStack.stackPush())
		{
			for (int i = 0; i < stages.size(); i++)
			{
				final var stage = stages.get(i);
				final var context = new RecordContext(vkCommandBuffer, stage, index, indexCount, stack);

				commandBuffer.start(stage);
				doRecord.accept(context);
				commandBuffer.end(stage);
				listeners.addAll(context.getExecutionListeners());
			}
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}

		if (listeners.isEmpty() == false) fences.setNextExecutionListeners(listeners);
	}

	public SubmitResult play()
	{
		try (final var stack = MemoryStack.stackPush())
		{
			final var submission = new Submission(stack,
												  commandBuffer.getVkCommandBuffer(),
												  waitSemaphores,
												  signalSemaphores);

			allocationState.lockAllocation();

			final var queue = context.getQueue().vkQueue;
			final var fence = fences.next();
			fence.notify(EExecutionStatus.Started, false);
			final var res = submission.submit(queue, fence.fence.getPtr());

			Logger.check(res, FAILED_SUBMIT, true);

			if (res != VK_SUCCESS)
			{
				fence.notify(EExecutionStatus.Canceled, true);

				if (DebugUtil.DEBUG_ENABLED)
				{
					final var status = EVulkanErrorStatus.resolveFromCode(res);
					final String message = status != null ? status.message : "Unknown Error";
					System.err.println("[Submit] " + message);
				}
			}
			return new SubmitResult(fence.fence, res);
		}
	}

	public boolean checkFence()
	{
		final boolean fenceIsUnlocked = fences.check();
		if (fenceIsUnlocked && allocationState.isLocked())
		{
			allocationState.unlockAllocation();
		}
		assert !allocationState.isLocked() == fenceIsUnlocked;
		return fenceIsUnlocked;
	}

	public void free(VkDevice vkDevice)
	{
		fences.free();
		executionSemaphore.free(vkDevice);
	}

	public void waitIdle()
	{
		fences.waitIdle();
		checkFence();
	}

	public VkSemaphore getSemaphore()
	{
		return executionSemaphore;
	}

	public static record SubmitResult(IFenceView fence, int result)
	{
	}
}
