package org.sheepy.lily.vulkan.process.compute.process;

import org.logoce.adapter.api.Adapter;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.vulkan.core.execution.queue.EQueueType;
import org.sheepy.lily.vulkan.core.process.InternalProcessAdapter;
import org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionManager;
import org.sheepy.lily.vulkan.model.process.compute.ComputeProcess;

@ModelExtender(scope = ComputeProcess.class)
@Adapter
public final class ComputeProcessAdapter implements InternalProcessAdapter
{
	private final int executionCount;

	private ComputeProcessAdapter(ComputeProcess process)
	{
		executionCount = ((ComputeExecutionManager) process.getExecutionManager()).getIndexCount();
	}

	@Override
	public EQueueType getExecutionQueueType()
	{
		return EQueueType.Compute;
	}

	@Override
	public boolean needPresentQueue()
	{
		return false;
	}

	@Override
	public int getExecutionCount()
	{
		return executionCount;
	}
}
