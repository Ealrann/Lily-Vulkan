package org.sheepy.lily.vulkan.process.compute.execution;

import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.allocation.annotation.InjectChildren;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.compute.*;
import org.sheepy.lily.vulkan.process.execution.ExecutionManagerAllocation;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

import java.util.List;
import java.util.stream.IntStream;

@ModelExtender(scope = ComputeExecutionManager.class)
@Allocation(context = ProcessContext.class)
@AllocationChild(features = ComputePackage.COMPUTE_EXECUTION_MANAGER__COMMAND_BUFFERS)
@AllocationChild(features = ComputePackage.COMPUTE_EXECUTION_MANAGER__ACQUIRER)
@AllocationChild(features = ComputePackage.COMPUTE_EXECUTION_MANAGER__RECORDERS)
public final class ComputeExecutionManagerAllocation extends ExecutionManagerAllocation<ComputeExecutionRecorderAllocation>
{
	private List<ComputeExecutionRecorderAllocation> recorders;

	private ComputeExecutionManagerAllocation(ComputeExecutionManager executionManager, ProcessContext context)
	{
		super(executionManager, context);

		setupRecorders(executionManager);
	}

	@InjectChildren(index = 2, type = ComputeExecutionRecorderAllocation.class)
	private void updateRecorders(List<ComputeExecutionRecorderAllocation> recorders)
	{
		this.recorders = recorders;
	}

	@Override
	protected List<ComputeExecutionRecorderAllocation> getRecorders()
	{
		return recorders;
	}

	@Override
	protected List<VkSemaphore> signalSemaphores()
	{
		return List.of();
	}

	private static void setupRecorders(ComputeExecutionManager executionManager)
	{

		final var recordCount = executionManager.getIndexCount();
		final var executionCount = Math.max(2, recordCount);

		final var recorderList = executionManager.getRecorders();

		if (recorderList.size() != executionCount)
		{
			executionManager.setAcquirer(ComputeFactory.eINSTANCE.createComputeAcquirer());

			recorderList.clear();
			final var commandBuffers = IntStream.range(0, recordCount)
												.mapToObj(i -> createCommandBuffer(i, executionManager))
												.toList();
			final var recorders = IntStream.range(0, executionCount)
										   .mapToObj(i -> createRecorder(commandBuffers.get(i % recordCount)))
										   .toList();
			recorderList.addAll(recorders);
		}
	}

	private static ComputeCommandBuffer createCommandBuffer(final int index,
															final ComputeExecutionManager executionManager)
	{
		final var commandBuffer = ComputeFactory.eINSTANCE.createComputeCommandBuffer();
		commandBuffer.setIndex(index);
		executionManager.getCommandBuffers().add(commandBuffer);
		return commandBuffer;
	}

	private static ComputeExecutionRecorder createRecorder(ComputeCommandBuffer commandBuffer)
	{
		final var submission = ProcessFactory.eINSTANCE.createSubmission();
		final var computeExecutionRecorder = ComputeFactory.eINSTANCE.createComputeExecutionRecorder();
		computeExecutionRecorder.setCommandBuffer(commandBuffer);
		computeExecutionRecorder.setSubmission(submission);
		return computeExecutionRecorder;
	}
}
