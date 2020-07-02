package org.sheepy.lily.vulkan.process.compute.execution;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.allocation.annotation.InjectChildren;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionManager;
import org.sheepy.lily.vulkan.model.process.compute.ComputeFactory;
import org.sheepy.lily.vulkan.model.process.compute.ComputePackage;
import org.sheepy.lily.vulkan.process.execution.ExecutionConcurencyUtil;
import org.sheepy.lily.vulkan.process.execution.ExecutionManagerAllocation;
import org.sheepy.lily.vulkan.process.execution.WaitData;
import org.sheepy.lily.vulkan.process.process.ProcessContext;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ModelExtender(scope = ComputeExecutionManager.class)
@Allocation(context = ProcessContext.class)
@AllocationChild(features = ComputePackage.COMPUTE_EXECUTION_MANAGER__RECORDERS)
public final class ComputeExecutionManagerAllocation extends ExecutionManagerAllocation implements IExtender
{
	private final ComputeExecutionManager executionManager;
	private final List<VkSemaphore> executionSemaphores;
	private final List<WaitData> waitForEmitters;
	private final List<VkSemaphore> signals;

	private List<ComputeExecutionRecorderAllocation> recorders;
	private int index = -1;

	private ComputeExecutionManagerAllocation(ComputeExecutionManager executionManager, ProcessContext context)
	{
		this.executionManager = executionManager;
		setupRecorders(executionManager);

		final int indexCount = executionManager.getIndexCount();
		executionSemaphores = Stream.generate(() -> new VkSemaphore(context.getVkDevice()))
									.limit(indexCount)
									.collect(Collectors.toUnmodifiableList());
		executionSemaphores.get(0).signalSemaphore(context);

		final var process = context.getProcess();
		waitForEmitters = ExecutionConcurencyUtil.gatherWaitDatas(process);
		signals = ExecutionConcurencyUtil.gatherSinalSemaphores(process);
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
	public ComputeExecutionRecorderAllocation acquire()
	{
		index = (index + 1) % executionManager.getIndexCount();
		final var recorder = recorders.get(index);
		recorder.prepare();
		return recorder;
	}

	@Override
	protected List<ComputeExecutionRecorderAllocation> getRecorders()
	{
		return recorders;
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

	public List<WaitData> getWaitForEmitters(int index)
	{
		final var semaphoreToWait = executionSemaphores.get(index);
		final var waitData = new WaitData(semaphoreToWait, EPipelineStage.TRANSFER_BIT);
		return Stream.concat(waitForEmitters.stream(), Stream.of(waitData)).collect(Collectors.toUnmodifiableList());
	}

	public List<VkSemaphore> getSignals(int index)
	{
		final var indexToSignal = (index + 1) % executionManager.getIndexCount();
		final var semaphoreToWait = executionSemaphores.get(indexToSignal);
		return Stream.concat(signals.stream(), Stream.of(semaphoreToWait)).collect(Collectors.toUnmodifiableList());
	}
}
