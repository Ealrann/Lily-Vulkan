package org.sheepy.lily.vulkan.process.compute.execution;

import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.*;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.api.concurrent.IFenceView;
import org.sheepy.lily.vulkan.api.execution.IExecutionPlayer;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableExtender;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionManager;
import org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionRecorder;
import org.sheepy.lily.vulkan.model.process.compute.ComputePackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputeProcess;
import org.sheepy.lily.vulkan.process.execution.GenericExecutionRecorder;
import org.sheepy.lily.vulkan.process.execution.Submission;
import org.sheepy.lily.vulkan.process.process.ProcessContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.List;

@ModelExtender(scope = ComputeExecutionRecorder.class)
@Allocation(context = ProcessContext.class, reuseDirtyAllocations = true)
@AllocationDependency(parent = ComputeProcess.class, features = {ComputePackage.COMPUTE_PROCESS__PIPELINE_PKG, ProcessPackage.PIPELINE_PKG__PIPELINES}, type = IRecordableExtender.class)
public final class ComputeExecutionRecorderAllocation implements IExecutionPlayer, IExtender
{
	private static final List<ECommandStage> stages = List.of(ECommandStage.MAIN);

	private final ComputeCommandBuffer commandBuffer;
	private final Submission submission;
	private final GenericExecutionRecorder executionRecorder;
	private final IAllocationState config;

	private List<IRecordableExtender> recordables;
	private boolean needRecord = true;

	private ComputeExecutionRecorderAllocation(ComputeExecutionRecorder recorder,
											   ProcessContext context,
											   IAllocationState config,
											   @InjectDependency(index = 0) List<IRecordableExtender> recordables)
	{
		commandBuffer = new ComputeCommandBuffer(context);
		this.config = config;
		this.recordables = recordables;

		final var manager = (ComputeExecutionManager) recorder.eContainer();
		final var managerAllocation = manager.adapt(ComputeExecutionManagerAllocation.class);
		final int index = recorder.getIndex();
		final var waitForEmitters = managerAllocation.getWaitForEmitters(index);
		final var signals = managerAllocation.getSignals(index);
		final int queuedExecutionCount = manager.getIndexCount() > 1 ? 2 : 1;

		this.submission = new Submission(commandBuffer.getVkCommandBuffer(),
										 context,
										 waitForEmitters,
										 signals,
										 queuedExecutionCount);

		executionRecorder = new GenericExecutionRecorder(commandBuffer,
														 submission,
														 index,
														 manager.getIndexCount(),
														 this::recordCommand);
	}

	@UpdateDependency(index = 0)
	private void updateRecorders(List<IRecordableExtender> recordables)
	{
		this.recordables = recordables;
		needRecord = true;
	}

	public void prepare()
	{
		if (needRecord)
		{
			executionRecorder.record(stages);
			needRecord = false;
		}
	}

	@Free
	public void free(ExecutionContext context)
	{
		commandBuffer.free(context);
		submission.free();
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
		final boolean fenceIsUnlocked = submission.checkFence();
		if (fenceIsUnlocked && config.isLocked())
		{
			config.unlockAllocation();
		}
		assert !config.isLocked() == fenceIsUnlocked;
		return fenceIsUnlocked;
	}

	@Override
	public void waitIdle()
	{
		submission.waitIdle();
		checkFence();
	}

	@Override
	public IFenceView play()
	{
		config.lockAllocation();
		return submission.submit();
	}
}
