package org.sheepy.lily.vulkan.process.compute.process;

import org.sheepy.lily.vulkan.core.descriptor.DescriptorPool;
import org.sheepy.lily.vulkan.core.execution.IExecutionRecorder;
import org.sheepy.lily.vulkan.core.execution.queue.EQueueType;
import org.sheepy.lily.vulkan.core.process.IComputeContext;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.process.compute.execution.ComputeExecutionRecorders;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

import java.util.List;

public final class ComputeContext extends ProcessContext<ComputeContext> implements IComputeContext
{
	public final AbstractProcess Process;
	public final ComputeExecutionRecorders executionRecorders = new ComputeExecutionRecorders();

	public ComputeContext(EQueueType queueType,
						  boolean resetAllowed,
						  DescriptorPool descriptorPool,
						  AbstractProcess Process)
	{
		super(queueType, resetAllowed, descriptorPool, Process);
		this.Process = Process;

		allocationList.add(executionRecorders);
	}

	@Override
	public List<IExecutionRecorder<? super ComputeContext>> getRecorders()
	{
		return executionRecorders.getRecorders();
	}

	@Override
	public ComputeExecutionRecorders getExecutionRecorders()
	{
		return executionRecorders;
	}

	@Override
	public int getSwapCount()
	{
		return 1;
	}
}
