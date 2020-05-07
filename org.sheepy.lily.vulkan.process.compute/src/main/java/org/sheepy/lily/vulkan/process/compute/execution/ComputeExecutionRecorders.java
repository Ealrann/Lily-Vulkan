package org.sheepy.lily.vulkan.process.compute.execution;

import org.sheepy.lily.core.api.allocation.IAllocation;
import org.sheepy.lily.core.api.allocation.up.annotation.Allocation;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.model.process.compute.ComputeConfiguration;
import org.sheepy.lily.vulkan.process.execution.ExecutionRecorders;
import org.sheepy.lily.vulkan.process.execution.Submission;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

import java.util.List;

@ModelExtender(scope = ComputeConfiguration.class)
@Allocation(context = ProcessContext.class)
public final class ComputeExecutionRecorders extends ExecutionRecorders implements IAllocation
{
	private final ComputeExecutionRecorder executionRecorder;

	private ComputeExecutionRecorders(ProcessContext context)
	{
		final var computeContext = context;
		final var process = computeContext.getProcess();

		final var waitForEmitters = gatherWaitDatas(process);
		final var signals = gatherSinalSemaphores(process);

		final var commandBuffer = new ComputeCommandBuffer(context);
		final var submission = new Submission(commandBuffer.getVkCommandBuffer(),
											  context,
											  waitForEmitters,
											  signals,
											  true);

		executionRecorder = new ComputeExecutionRecorder(commandBuffer, context, submission, 0);
	}

	@Override
	public Integer prepareNextExecution()
	{
		return 0;
	}

	@Override
	public List<ComputeExecutionRecorder> getRecorders()
	{
		return List.of(executionRecorder);
	}
}
