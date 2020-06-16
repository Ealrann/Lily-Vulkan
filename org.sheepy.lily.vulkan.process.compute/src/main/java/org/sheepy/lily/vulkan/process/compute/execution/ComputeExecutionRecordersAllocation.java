package org.sheepy.lily.vulkan.process.compute.execution;

import org.sheepy.lily.core.api.allocation.annotation.*;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableExtender;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionRecorder;
import org.sheepy.lily.vulkan.model.process.compute.ComputePackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputeProcess;
import org.sheepy.lily.vulkan.process.execution.ExecutionRecordersAllocation;
import org.sheepy.lily.vulkan.process.execution.Submission;
import org.sheepy.lily.vulkan.process.process.ProcessContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.List;

@ModelExtender(scope = ComputeExecutionRecorder.class)
@Allocation(context = ProcessContext.class)
@AllocationDependency(parent = ComputeProcess.class, features = {ComputePackage.COMPUTE_PROCESS__PIPELINE_PKG, ProcessPackage.PIPELINE_PKG__PIPELINES}, type = IRecordableExtender.class)
public final class ComputeExecutionRecordersAllocation extends ExecutionRecordersAllocation implements IExtender
{
	private static final List<ECommandStage> stages = List.of(ECommandStage.TRANSFER, ECommandStage.COMPUTE);

	private final ComputeExecutionRecorderAllocation executionRecorder;

	private ComputeExecutionRecordersAllocation(ProcessContext context,
												@InjectDependency(index = 0) List<IRecordableExtender> pipelines)
	{
		super(pipelines, stages);

		final var computeContext = context;
		final var process = computeContext.getProcess();
		final var waitForEmitters = gatherWaitDatas(process);
		final var signals = gatherSinalSemaphores(process);
		final var commandBuffer = new ComputeCommandBuffer(context);
		final var submission = new Submission(commandBuffer.getVkCommandBuffer(),
											  context,
											  waitForEmitters,
											  signals,
											  true);

		executionRecorder = new ComputeExecutionRecorderAllocation(commandBuffer, submission, 0);
	}

	@Free
	private void free(ProcessContext context)
	{
		executionRecorder.free(context);
	}

	@UpdateDependency(index = 0)
	private void updatePipelines(List<IRecordableExtender> pipelines)
	{
		super.updateRecordables(pipelines);
	}

	@Override
	public Integer acquire()
	{
		return 0;
	}

	@Override
	public List<ComputeExecutionRecorderAllocation> getRecorders()
	{
		return List.of(executionRecorder);
	}
}
