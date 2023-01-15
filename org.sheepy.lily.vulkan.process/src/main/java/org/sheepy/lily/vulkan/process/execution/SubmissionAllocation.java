package org.sheepy.lily.vulkan.process.execution;

import org.logoce.extender.api.IAdapter;
import org.logoce.extender.api.ModelExtender;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.game.api.execution.EExecutionStatus;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.core.util.EVulkanErrorStatus;
import org.sheepy.lily.vulkan.core.util.Logger;
import org.sheepy.lily.vulkan.model.process.Submission;
import org.sheepy.lily.vulkan.process.execution.util.CountLocker;
import org.sheepy.lily.vulkan.process.execution.util.FenceManager;
import org.sheepy.lily.vulkan.process.execution.util.SemaphoreManager;
import org.sheepy.lily.vulkan.process.execution.util.VkSubmission;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.vulkan.VK10.VK_SUCCESS;

@ModelExtender(scope = Submission.class)
@Allocation(context = ProcessContext.class)
public final class SubmissionAllocation implements IAdapter
{
	private static final String FAILED_SUBMIT = "Failed to submit command buffer";

	private final ProcessContext context;
	private final SemaphoreManager semaphoreManager;
	private final CountLocker locker;

	private List<WaitData> waitSemaphores;
	private List<VkSemaphore> signalSemaphores;

	private SubmissionAllocation(final ProcessContext context, final IAllocationState allocationState)
	{
		this.context = context;
		this.semaphoreManager = new SemaphoreManager();
		this.locker = new CountLocker(allocationState::lockAllocation, allocationState::unlockAllocation);
	}

	private void updateLock(EExecutionStatus e)
	{
		switch (e)
		{
			case Started -> locker.increase();
			case Done, Canceled -> locker.decrease();
		}
	}

	public void prepare(final List<WaitData> waitSemaphores,
						final List<VkSemaphore> signalSemaphores,
						final int semaphoreCount,
						final FenceManager fenceManager)
	{
		this.waitSemaphores = waitSemaphores;

		semaphoreManager.next();
		semaphoreManager.prepareSemaphores(context.getVkDevice(), semaphoreCount);
		fenceManager.addListener(this::updateLock);
		final var executionSemaphores = semaphoreManager.getSemaphores();
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

	public boolean play(final VkCommandBuffer vkCommandBuffer, final FenceManager fenceManager)
	{
		try (final var stack = MemoryStack.stackPush())
		{
			final var submission = new VkSubmission(stack, List.of(vkCommandBuffer), waitSemaphores, signalSemaphores);
			final var queue = context.getQueue().vkQueue;
			final var res = submission.submit(queue, fenceManager.getFence().getPtr());

			Logger.check(res, FAILED_SUBMIT, true);

			if (res != VK_SUCCESS)
			{
				if (DebugUtil.DEBUG_ENABLED)
				{
					final var status = EVulkanErrorStatus.resolveFromCode(res);
					final String message = status != null ? status.message : "Unknown Error";
					System.err.println("[Submit] " + message);
				}
			}
			return res == VK_SUCCESS;
		}
	}

	@Free
	private void free(ProcessContext context)
	{
		semaphoreManager.free(context.getVkDevice());
	}

	public VkSemaphore borrowSemaphore()
	{
		return semaphoreManager.borrowSemaphore();
	}
}
