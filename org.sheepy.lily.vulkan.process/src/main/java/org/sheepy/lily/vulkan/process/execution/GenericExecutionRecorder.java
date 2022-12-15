package org.sheepy.lily.vulkan.process.execution;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.game.api.execution.EExecutionStatus;
import org.sheepy.lily.vulkan.api.concurrent.IFenceView;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.core.execution.AbstractCommandBuffer;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.util.EVulkanErrorStatus;
import org.sheepy.lily.vulkan.core.util.Logger;
import org.sheepy.lily.vulkan.process.execution.util.Submission;
import org.sheepy.lily.vulkan.process.execution.util.SynchronizationManager;
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
	private final SynchronizationManager synchronizationManager;
	private final Consumer<RecordContext> doRecord;

	private List<WaitData> waitSemaphores;
	private List<VkSemaphore> signalSemaphores;
	private SynchronizationManager.SyncUnit currentSyncUnit = null;

	public GenericExecutionRecorder(AbstractCommandBuffer commandBuffer,
									ProcessContext context,
									IAllocationState allocationState,
									int index,
									int fenceCount,
									Consumer<RecordContext> doRecord)
	{
		this.commandBuffer = commandBuffer;
		this.context = context;
		this.allocationState = allocationState;
		this.index = index;
		this.doRecord = doRecord;
		this.synchronizationManager = new SynchronizationManager(fenceCount, context.getVkDevice());
	}

	public void prepare(final List<WaitData> waitSemaphores,
						final List<VkSemaphore> signalSemaphores,
						final int semaphoreCount)
	{
		this.waitSemaphores = waitSemaphores;

		currentSyncUnit = synchronizationManager.next();
		currentSyncUnit.prepareSemaphores(context.getVkDevice(), semaphoreCount);
		final var executionSemaphores = currentSyncUnit.getSemaphores();
		if (signalSemaphores.isEmpty() == false)
		{
			this.signalSemaphores = new ArrayList<>(signalSemaphores.size() + semaphoreCount);
			this.signalSemaphores.addAll(signalSemaphores);
			this.signalSemaphores.addAll(executionSemaphores);
		}
		else
		{
			this.signalSemaphores = executionSemaphores;
		}
	}

	public void record(List<ECommandStage> stages)
	{
		final List<Consumer<EExecutionStatus>> listeners = new ArrayList<>();
		final var vkCommandBuffer = commandBuffer.getVkCommandBuffer();

		try
		{
			for (int i = 0; i < stages.size(); i++)
			{
				final var stage = stages.get(i);
				final var recordContext = new RecordContext(context, vkCommandBuffer, stage, index);

				recordContext.stackPush();
				commandBuffer.start(stage);
				doRecord.accept(recordContext);
				commandBuffer.end(stage);
				recordContext.stackPop();
				listeners.addAll(recordContext.getExecutionListeners());
			}
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}

		if (listeners.isEmpty() == false) currentSyncUnit.setListeners(listeners);
	}

	public SubmitResult play()
	{
		try (final var stack = MemoryStack.stackPush())
		{
			final var submission = new Submission(stack,
												  List.of(commandBuffer.getVkCommandBuffer()),
												  waitSemaphores,
												  signalSemaphores);

			allocationState.lockAllocation();

			final var queue = context.getQueue().vkQueue;
			currentSyncUnit.start();
			final var res = submission.submit(queue, currentSyncUnit.fence.getPtr());

			Logger.check(res, FAILED_SUBMIT, true);

			if (res != VK_SUCCESS)
			{
				currentSyncUnit.cancel();

				if (DebugUtil.DEBUG_ENABLED)
				{
					final var status = EVulkanErrorStatus.resolveFromCode(res);
					final String message = status != null ? status.message : "Unknown Error";
					System.err.println("[Submit] " + message);
				}
			}
			return new SubmitResult(currentSyncUnit.fence, res);
		}
	}

	public boolean checkFence()
	{
		final boolean fenceIsUnlocked = synchronizationManager.check();
		if (fenceIsUnlocked && allocationState.isLocked())
		{
			allocationState.unlockAllocation();
		}
		assert !allocationState.isLocked() == fenceIsUnlocked;
		return fenceIsUnlocked;
	}

	public void free(VkDevice vkDevice)
	{
		synchronizationManager.free(vkDevice);
	}

	public void waitIdle()
	{
		synchronizationManager.waitIdle();
		checkFence();
	}

	public VkSemaphore borrowSemaphore()
	{
		return currentSyncUnit.borrowSemaphore();
	}

	public record SubmitResult(IFenceView fence, int result)
	{
	}
}
