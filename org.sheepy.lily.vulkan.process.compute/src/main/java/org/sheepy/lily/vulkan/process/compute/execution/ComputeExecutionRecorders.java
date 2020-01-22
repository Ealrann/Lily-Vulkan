package org.sheepy.lily.vulkan.process.compute.execution;

import java.util.List;

import org.sheepy.lily.vulkan.common.process.IComputeContext;
import org.sheepy.lily.vulkan.process.execution.ExecutionRecorders;
import org.sheepy.lily.vulkan.process.execution.Submission;

public class ComputeExecutionRecorders extends ExecutionRecorders<IComputeContext>
{
	@Override
	public List<ComputeExecutionRecorder> createRecorders(IComputeContext context)
	{
		final var computeContext = context;
		final var process = computeContext.getProcess();

		final var waitForEmitters = gatherWaitDatas(process);
		final var signals = gatherSinalSemaphores(process);

		final var commandBuffer = new ComputeCommandBuffer();
		final var submission = new Submission<IComputeContext>(	commandBuffer,
																waitForEmitters,
																signals,
																true);

		final var res = new ComputeExecutionRecorder(commandBuffer, submission, 0);

		return List.of(res);
	}
}
