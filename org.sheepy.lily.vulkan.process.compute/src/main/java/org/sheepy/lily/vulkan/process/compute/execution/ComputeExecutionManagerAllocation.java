package org.sheepy.lily.vulkan.process.compute.execution;

import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.allocation.annotation.InjectChildren;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionManager;
import org.sheepy.lily.vulkan.model.process.compute.ComputeFactory;
import org.sheepy.lily.vulkan.model.process.compute.ComputePackage;
import org.sheepy.lily.vulkan.process.execution.ExecutionManagerAllocation;
import org.sheepy.lily.vulkan.process.execution.WaitData;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

import java.util.List;
import java.util.stream.Stream;

@ModelExtender(scope = ComputeExecutionManager.class)
@Allocation(context = ProcessContext.class)
@AllocationChild(features = ComputePackage.COMPUTE_EXECUTION_MANAGER__COMMAND_BUFFERS)
@AllocationChild(features = ComputePackage.COMPUTE_EXECUTION_MANAGER__RECORDERS)
public final class ComputeExecutionManagerAllocation extends ExecutionManagerAllocation<ComputeExecutionRecorderAllocation>
{
	private final ComputeExecutionManager executionManager;
	private List<ComputeExecutionRecorderAllocation> recorders;
	private int index = -1;

	private ComputeExecutionManagerAllocation(ComputeExecutionManager executionManager, ProcessContext context)
	{
		super(executionManager, context);

		this.executionManager = executionManager;
		setupRecorders(executionManager);
	}

	@InjectChildren(index = 1, type = ComputeExecutionRecorderAllocation.class)
	private void updateRecorders(List<ComputeExecutionRecorderAllocation> recorders)
	{
		this.recorders = recorders;
	}

	@Override
	protected int acquire()
	{
		return index = (index + 1) % executionManager.getIndexCount();
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

	private static void setupRecorders(ComputeExecutionManager executionManager)
	{
		final var recorders = executionManager.getRecorders();
		if (recorders.size() != executionManager.getIndexCount())
		{
			recorders.clear();
			for (int i = 0; i < executionManager.getIndexCount(); i++)
			{
				final var commandBuffer = ComputeFactory.eINSTANCE.createComputeCommandBuffer();
				commandBuffer.setIndex(i);
				executionManager.getCommandBuffers().add(commandBuffer);

				final var computeExecutionRecorder = ComputeFactory.eINSTANCE.createComputeExecutionRecorder();
				computeExecutionRecorder.setIndex(i);
				computeExecutionRecorder.setCommandBuffer(commandBuffer);

				recorders.add(computeExecutionRecorder);
			}
		}
	}
}
