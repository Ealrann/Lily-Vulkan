package org.sheepy.lily.vulkan.process.compute.execution;

import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.allocation.annotation.InjectChildren;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.api.execution.IExecutionPlayer;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionManager;
import org.sheepy.lily.vulkan.model.process.compute.ComputeFactory;
import org.sheepy.lily.vulkan.model.process.compute.ComputePackage;
import org.sheepy.lily.vulkan.process.execution.ExecutionManagerAllocation;
import org.sheepy.lily.vulkan.process.execution.WaitData;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ModelExtender(scope = ComputeExecutionManager.class)
@Allocation(context = ProcessContext.class)
@AllocationChild(features = ComputePackage.COMPUTE_EXECUTION_MANAGER__RECORDERS)
public final class ComputeExecutionManagerAllocation extends ExecutionManagerAllocation
{
	private final ComputeExecutionManager executionManager;
	private final List<VkSemaphore> executionSemaphores;
	private final VkDevice vkDevice;

	private List<ComputeExecutionRecorderAllocation> recorders;
	private int index = -1;

	private ComputeExecutionManagerAllocation(ComputeExecutionManager executionManager, ProcessContext context)
	{
		super(executionManager, context);

		this.executionManager = executionManager;
		setupRecorders(executionManager);

		vkDevice = context.getVkDevice();
		final int indexCount = executionManager.getIndexCount();
		executionSemaphores = Stream.generate(() -> new VkSemaphore(vkDevice))
									.limit(indexCount)
									.collect(Collectors.toUnmodifiableList());
		executionSemaphores.get(0).signalSemaphore(context);
	}

	@InjectChildren(index = 0, type = ComputeExecutionRecorderAllocation.class)
	private void updateRecorders(List<ComputeExecutionRecorderAllocation> recorders)
	{
		this.recorders = recorders;
	}

	@Override
	public int getExecutionCount()
	{
		return executionManager.getIndexCount();
	}

	@Free
	public void free(ProcessContext context)
	{
		executionSemaphores.forEach(semaphore -> semaphore.free(context.getVkDevice()));
	}

	@Override
	public IExecutionPlayer acquire()
	{
		index = (index + 1) % executionManager.getIndexCount();
		return acquire(index);
	}

	@Override
	protected List<ComputeExecutionRecorderAllocation> getRecorders()
	{
		return recorders;
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
				final var computeExecutionRecorder = ComputeFactory.eINSTANCE.createComputeExecutionRecorder();
				computeExecutionRecorder.setIndex(i);
				recorders.add(computeExecutionRecorder);
			}
		}
	}
}
