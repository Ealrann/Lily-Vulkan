package org.sheepy.lily.vulkan.process.compute.execution;

import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.*;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.api.concurrent.IFenceView;
import org.sheepy.lily.vulkan.core.concurrent.VkSemaphore;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableExtender;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionManager;
import org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionRecorder;
import org.sheepy.lily.vulkan.model.process.compute.ComputePackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputeProcess;
import org.sheepy.lily.vulkan.process.execution.GenericExecutionRecorder;
import org.sheepy.lily.vulkan.process.execution.IExecutionRecorderAllocation;
import org.sheepy.lily.vulkan.process.execution.WaitData;
import org.sheepy.lily.vulkan.process.process.ProcessContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.List;

@ModelExtender(scope = ComputeExecutionRecorder.class)
@Allocation(context = ProcessContext.class, reuseDirtyAllocations = true)
@AllocationDependency(parent = ComputeProcess.class, features = {ComputePackage.COMPUTE_PROCESS__PIPELINE_PKG, ProcessPackage.PIPELINE_PKG__PIPELINES}, type = IRecordableExtender.class)
public final class ComputeExecutionRecorderAllocation implements IExecutionRecorderAllocation
{
	private static final List<ECommandStage> stages = List.of(ECommandStage.MAIN);

	private final ComputeCommandBuffer commandBuffer;
	private final GenericExecutionRecorder executionRecorder;

	private List<IRecordableExtender> recordables;
	private boolean needRecord = true;

	private ComputeExecutionRecorderAllocation(ComputeExecutionRecorder recorder,
											   ProcessContext context,
											   IAllocationState config,
											   @InjectDependency(index = 0) List<IRecordableExtender> recordables)
	{
		commandBuffer = new ComputeCommandBuffer(context);
		this.recordables = recordables;

		final var manager = (ComputeExecutionManager) recorder.eContainer();
		final int index = recorder.getIndex();
		final int queuedExecutionCount = manager.getIndexCount() > 1 ? 1 : 2;

		executionRecorder = new GenericExecutionRecorder(commandBuffer,
														 context,
														 config,
														 index,
														 queuedExecutionCount,
														 this::recordCommand);
	}

	@UpdateDependency(index = 0)
	private void updateRecorders(List<IRecordableExtender> recordables)
	{
		this.recordables = recordables;
		needRecord = true;
	}

	@Override
	public void prepare(final List<WaitData> waitSemaphores, int executionSemaphoreCount)
	{
		executionRecorder.prepare(waitSemaphores, List.of(), executionSemaphoreCount);

		if (needRecord)
		{
			executionRecorder.record(stages);
			needRecord = false;
		}
	}

	@Free
	public void free(ExecutionContext context)
	{
		executionRecorder.free(context.getVkDevice());
		commandBuffer.free(context);
	}

	private void recordCommand(final RecordContext recordContext)
	{
		for (final var recordable : recordables)
		{
			recordable.record(recordContext);
		}
	}

	@Override
	public boolean checkFence()
	{
		return executionRecorder.checkFence();
	}

	@Override
	public void waitIdle()
	{
		executionRecorder.waitIdle();
	}

	@Override
	public IFenceView play()
	{
		return executionRecorder.play().fence();
	}

	@Override
	public VkSemaphore borrowSemaphore()
	{
		return executionRecorder.borrowSemaphore();
	}
}
