package org.sheepy.lily.vulkan.process.compute.execution;

import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.allocation.annotation.InjectChildren;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.compute.*;
import org.sheepy.lily.vulkan.process.execution.ExecutionManagerAllocation;
import org.sheepy.lily.vulkan.process.execution.WaitData;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@ModelExtender(scope = ComputeExecutionManager.class)
@Allocation(context = ProcessContext.class)
@AllocationChild(features = ComputePackage.COMPUTE_EXECUTION_MANAGER__COMMAND_BUFFERS)
@AllocationChild(features = ComputePackage.COMPUTE_EXECUTION_MANAGER__RECORDERS)
public final class ComputeExecutionManagerAllocation extends ExecutionManagerAllocation<ComputeExecutionRecorderAllocation>
{
	private final int recordCount;
	private final int executionCount;
	private List<ComputeExecutionRecorderAllocation> recorders;
	private int recordIndex = -1;
	private int executionIndex = -1;

	private ComputeExecutionManagerAllocation(ComputeExecutionManager executionManager, ProcessContext context)
	{
		super(executionManager, context);

		recordCount = executionManager.getIndexCount();
		executionCount = Math.max(2, recordCount);
		setupRecorders(executionManager, recordCount, executionCount);
	}

	@InjectChildren(index = 1, type = ComputeExecutionRecorderAllocation.class)
	private void updateRecorders(List<ComputeExecutionRecorderAllocation> recorders)
	{
		this.recorders = recorders;
	}

	@Override
	protected AcquisitionInfo acquire()
	{
		recordIndex = (recordIndex + 1) % recordCount;
		executionIndex = (executionIndex + 1) % executionCount;
		return new AcquisitionInfo(executionIndex, recordIndex);
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

	@Override
	protected Stream<WaitData> streamAcquireSemaphores()
	{
		return Stream.empty();
	}

	private static void setupRecorders(ComputeExecutionManager executionManager,
									   final int indexCount,
									   final int executionCount)
	{
		final var recorderList = executionManager.getRecorders();

		if (recorderList.size() != executionCount)
		{
			recorderList.clear();
			final var commandBuffers = IntStream.range(0, indexCount)
												.mapToObj(i -> createCommandBuffer(i, executionManager))
												.toList();
			final var recorders = IntStream.range(0, executionCount)
										   .mapToObj(i -> createRecorder(commandBuffers.get(i % indexCount)))
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
