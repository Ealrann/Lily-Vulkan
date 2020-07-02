package org.sheepy.lily.vulkan.process.execution;

import org.sheepy.lily.vulkan.api.execution.IExecutionPlayer;
import org.sheepy.lily.vulkan.core.execution.IExecutionRecorders;

import java.util.List;

public abstract class ExecutionManagerAllocation implements IExecutionRecorders
{
	@Override
	public void checkFence()
	{
		final var recorders = getRecorders();
		for (int i = 0; i < recorders.size(); i++)
		{
			final var recorder = recorders.get(i);
			recorder.checkFence();
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

	protected abstract List<? extends IExecutionPlayer> getRecorders();
}
