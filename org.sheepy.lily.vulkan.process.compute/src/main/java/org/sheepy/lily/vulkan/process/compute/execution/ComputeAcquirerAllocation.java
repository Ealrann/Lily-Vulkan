package org.sheepy.lily.vulkan.process.compute.execution;

import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.vulkan.model.process.compute.ComputeAcquirer;
import org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionManager;
import org.sheepy.lily.vulkan.process.execution.IExecutionAcquirerAdapter;
import org.sheepy.lily.vulkan.process.execution.WaitData;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

import java.util.stream.Stream;

@ModelExtender(scope = ComputeAcquirer.class)
@Allocation(context = ProcessContext.class)
public final class ComputeAcquirerAllocation implements IExecutionAcquirerAdapter
{
	private final int recordCount;
	private final int executionCount;

	private int recordIndex = -1;
	private int executionIndex = -1;

	private ComputeAcquirerAllocation(ComputeAcquirer acquirer)
	{
		final var executionManager = (ComputeExecutionManager) acquirer.eContainer();
		recordCount = executionManager.getIndexCount();
		executionCount = Math.max(2, recordCount);
	}

	@Override
	public AcquisitionInfo acquire()
	{
		recordIndex = (recordIndex + 1) % recordCount;
		executionIndex = (executionIndex + 1) % executionCount;
		return new AcquisitionInfo(executionIndex, recordIndex);
	}

	@Override
	public Stream<WaitData> streamAcquireSemaphores()
	{
		return Stream.empty();
	}
}
