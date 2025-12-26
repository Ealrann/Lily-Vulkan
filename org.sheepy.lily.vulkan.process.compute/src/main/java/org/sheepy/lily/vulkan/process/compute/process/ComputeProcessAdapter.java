package org.sheepy.lily.vulkan.process.compute.process;

import org.logoce.lmf.core.api.adapter.Adapter;
import org.logoce.lmf.core.api.extender.ModelExtender;
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
		executionCount = ((ComputeExecutionManager) process.executionManager()).indexCount();
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
