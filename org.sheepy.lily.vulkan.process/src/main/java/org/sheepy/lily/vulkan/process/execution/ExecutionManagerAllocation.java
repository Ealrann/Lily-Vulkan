package org.sheepy.lily.vulkan.process.execution;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VK10;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.core.execution.IExecutionManagerAdapter;
import org.sheepy.lily.vulkan.model.process.ProcessExecutionManager;
import org.sheepy.lily.vulkan.process.execution.util.Submission;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public abstract class ExecutionManagerAllocation<T extends IExecutionRecorderAllocation> implements
																						 IExecutionManagerAdapter
{
	private final ProcessExecutionManager executionManager;
	private final ProcessContext context;

	private T lastExecutedRecorder = null;

	protected ExecutionManagerAllocation(final ProcessExecutionManager executionManager, final ProcessContext context)
	{
		this.executionManager = executionManager;
		this.context = context;
	}

	protected final T acquire(int index)
	{
		if (index == -1)
		{
			dummySubmission();
			return null;
		}
		else
		{
			final int semaphoreCount = executionManager.getWaitedBy().size();
			final var waitSemaphores = streamWaitData(true).toList();
			final var recorder = getRecorders().get(index);
			recorder.prepare(waitSemaphores, signalSemaphores(), semaphoreCount);
			lastExecutedRecorder = recorder;
			return recorder;
		}
	}

	private void dummySubmission()
	{
		try (final var stack = MemoryStack.stackPush())
		{
			final var waitSemaphores = streamWaitData(false).toList();
			final var dummySubmission = new Submission(stack, List.of(), waitSemaphores, List.of());
			dummySubmission.submit(context.getQueue().vkQueue, VK10.VK_NULL_HANDLE);
			lastExecutedRecorder = null;
		}
	}

	@Override
	public void waitIdle()
	{
		for (final var recorder : getRecorders())
		{
			recorder.waitIdle();
		}
	}

	public final VkSemaphore borrowSemaphore()
	{
		return lastExecutedRecorder != null ? lastExecutedRecorder.borrowSemaphore() : null;
	}

	private Stream<WaitData> streamWaitData(boolean withAcquireSemaphores)
	{
		final var res = executionManager.getWaitForExecution()
										.stream()
										.map(e -> e.adapt(ExecutionManagerAllocation.class))
										.map(ExecutionManagerAllocation::borrowSemaphore)
										.filter(Objects::nonNull)
										.map(s -> new WaitData(s, executionManager.getWaitStage()));

		if (withAcquireSemaphores)
		{
			return Stream.concat(res, streamAcquireSemaphores());
		}
		else
		{
			return res;
		}
	}

	protected abstract List<T> getRecorders();

	protected abstract List<VkSemaphore> signalSemaphores();

	protected abstract Stream<WaitData> streamAcquireSemaphores();
}
