package org.sheepy.lily.vulkan.process.compute.execution;

import org.sheepy.lily.vulkan.process.compute.process.ComputeContext;
import org.sheepy.lily.vulkan.process.execution.ExecutionRecorders;
import org.sheepy.lily.vulkan.process.execution.Submission;

import java.util.List;

public class ComputeExecutionRecorders extends ExecutionRecorders<ComputeContext>
{
	@Override
	public List<ComputeExecutionRecorder> createRecorders(ComputeContext context)
	{
		final var computeContext = context;
		final var process = computeContext.getProcess();

		final var waitForEmitters = gatherWaitDatas(process);
		final var signals = gatherSinalSemaphores(process);

		final var commandBuffer = new ComputeCommandBuffer();
		final var submission = new Submission<>(commandBuffer, waitForEmitters, signals, true);

		final var res = new ComputeExecutionRecorder(commandBuffer, submission, 0);

		return List.of(res);
	}
}
