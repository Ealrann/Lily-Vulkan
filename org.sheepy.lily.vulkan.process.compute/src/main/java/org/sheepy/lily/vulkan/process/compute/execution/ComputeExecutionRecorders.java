package org.sheepy.lily.vulkan.process.compute.execution;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.execution.IExecutionRecorder;
import org.sheepy.lily.vulkan.process.compute.process.ComputeContext;
import org.sheepy.lily.vulkan.process.execution.ExecutionRecorders;
import org.sheepy.lily.vulkan.process.execution.SubmissionsBuilder;

public class ComputeExecutionRecorders extends ExecutionRecorders
{
	@Override
	public List<IExecutionRecorder> createRecorders(MemoryStack stack, IAllocationContext context)
	{
		final var computeContext = (ComputeContext) context;
		final var process = computeContext.process;

		final var waitForEmitters = gatherWaitDatas(process);
		final var signals = gatherSinalSemaphores(process);
		final var submissionBuilder = new SubmissionsBuilder(waitForEmitters, signals, true);

		final var commandBuffer = new ComputeCommandBuffer();
		final var submission = submissionBuilder.buildSubmission(commandBuffer, 0);

		final var res = new ComputeExecutionRecorder(commandBuffer, submission, 0);

		return List.of(res);
	}
}
