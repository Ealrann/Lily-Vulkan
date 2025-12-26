package org.sheepy.lily.vulkan.process.compute.execution;

import org.logoce.lmf.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.allocation.annotation.InjectChildren;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.model.process.ProcessModelDefinition;
import org.sheepy.lily.vulkan.model.process.Submission;
import org.sheepy.lily.vulkan.model.process.compute.ComputeAcquirer;
import org.sheepy.lily.vulkan.model.process.compute.ComputeCommandBuffer;
import org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionManager;
import org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionRecorder;
import org.sheepy.lily.vulkan.process.execution.ExecutionManagerAllocation;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

import java.util.List;
import java.util.stream.IntStream;

@ModelExtender(scope = ComputeExecutionManager.class)
@Allocation(context = ProcessContext.class)
@AllocationChild(features = ComputeExecutionManager.FeatureIDs.COMMAND_BUFFERS)
@AllocationChild(features = ComputeExecutionManager.FeatureIDs.ACQUIRER)
@AllocationChild(features = ComputeExecutionManager.FeatureIDs.RECORDERS)
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
	protected List<VkSemaphore> signalSemaphores(final int executionID, final int recordIndex)
	{
		return List.of();
	}

	private static void setupRecorders(ComputeExecutionManager executionManager)
	{

		final var recordCount = executionManager.indexCount();
		final var executionCount = Math.max(2, recordCount);

		final var recorderList = executionManager.recorders();

		if (recorderList.size() != executionCount)
		{
			executionManager.acquirer(ComputeAcquirer.builder().build());

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
		final var commandBuffer = ComputeCommandBuffer.builder().index(index).build();
		executionManager.CommandBuffers().add(commandBuffer);
		return commandBuffer;
	}

	private static ComputeExecutionRecorder createRecorder(ComputeCommandBuffer commandBuffer)
	{
		final var submission = createSubmission();
		return ComputeExecutionRecorder.builder()
									   .commandBuffer(() -> commandBuffer)
									   .submission(() -> submission)
									   .build();
	}

	private static Submission createSubmission()
	{
		return ProcessModelDefinition.Groups.SUBMISSION.lmBuilder().newBuilder().build();
	}
}
