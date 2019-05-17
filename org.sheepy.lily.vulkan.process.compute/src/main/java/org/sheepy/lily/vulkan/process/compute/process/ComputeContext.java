package org.sheepy.lily.vulkan.process.compute.process;

import java.util.List;

import org.sheepy.lily.vulkan.api.execution.IExecutionRecorder;
import org.sheepy.lily.vulkan.api.process.IComputeContext;
import org.sheepy.lily.vulkan.model.process.compute.ComputeProcess;
import org.sheepy.lily.vulkan.process.compute.execution.ComputeExecutionRecorders;
import org.sheepy.lily.vulkan.process.process.ProcessContext;
import org.sheepy.vulkan.descriptor.DescriptorPool;
import org.sheepy.vulkan.queue.EQueueType;

public final class ComputeContext extends ProcessContext<IComputeContext> implements IComputeContext
{
	public final ComputeProcess computeProcess;
	public final ComputeExecutionRecorders executionRecorders = new ComputeExecutionRecorders();

	public ComputeContext(	EQueueType queueType,
							boolean resetAllowed,
							DescriptorPool descriptorPool,
							ComputeProcess computeProcess)
	{
		super(queueType, resetAllowed, descriptorPool, computeProcess);
		this.computeProcess = computeProcess;

		allocationList.add(executionRecorders);
	}

	@Override
	public List<IExecutionRecorder<? super IComputeContext>> getRecorders()
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
