package org.sheepy.lily.vulkan.process.execution;

import org.sheepy.lily.vulkan.api.execution.IExecutionPlayer;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.core.execution.IExecutionRecorders;
import org.sheepy.lily.vulkan.model.process.ProcessExecutionManager;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class ExecutionManagerAllocation implements IExecutionRecorders
{
	private final ProcessExecutionManager executionManager;

	private VkSemaphore lastExecutionSemaphore;

	protected ExecutionManagerAllocation(ProcessExecutionManager executionManager)
	{
		this.executionManager = executionManager;
	}

	protected final IExecutionPlayer acquire(int index)
	{
		final var recorder = getRecorders().get(index);
		final boolean waited = executionManager.getWaitedBy().isEmpty() == false;

		final var waitSemaphores = streamWaitData().collect(Collectors.toUnmodifiableList());
		lastExecutionSemaphore = waited ? recorder.getSemaphore() : null;

		recorder.prepare(waitSemaphores, waited);
		return recorder;
	}

	@Override
	public void waitIdle()
	{
		for (final var recorder : getRecorders())
		{
			recorder.waitIdle();
		}
	}

	public final VkSemaphore getSemaphore()
	{
		return lastExecutionSemaphore;
	}

	protected abstract List<? extends IExecutionRecorderAllocation> getRecorders();

	protected Stream<WaitData> streamWaitData()
	{
		return executionManager.getWaitForExecution()
							   .stream()
							   .map(e -> e.adapt(ExecutionManagerAllocation.class))
							   .map(ExecutionManagerAllocation::getSemaphore)
							   .filter(Objects::nonNull)
							   .map(s -> new WaitData(s, executionManager.getWaitStage()));
	}
}
