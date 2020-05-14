package org.sheepy.lily.vulkan.process.compute.execution;

import org.sheepy.lily.core.api.allocation.IAllocation;
import org.sheepy.lily.core.api.allocation.up.annotation.*;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableAllocation;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputeConfiguration;
import org.sheepy.lily.vulkan.model.process.compute.ComputePackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputeProcess;
import org.sheepy.lily.vulkan.process.execution.ExecutionRecorders;
import org.sheepy.lily.vulkan.process.execution.Submission;
import org.sheepy.lily.vulkan.process.process.ProcessContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.List;

@ModelExtender(scope = ComputeConfiguration.class)
@Allocation(context = ProcessContext.class)
@AllocationChild(parent = ComputeProcess.class, features = {ComputePackage.COMPUTE_PROCESS__PIPELINE_PKG, ProcessPackage.PIPELINE_PKG__PIPELINES}, type = IRecordableAllocation.class)
@AllocationDependency(parent = ComputeProcess.class, features = {ComputePackage.COMPUTE_PROCESS__PIPELINE_PKG, ProcessPackage.PIPELINE_PKG__PIPELINES}, type = IRecordableAllocation.class)
public final class ComputeExecutionRecorders extends ExecutionRecorders implements IAllocation
{
	private static final List<ECommandStage> stages = List.of(ECommandStage.TRANSFER, ECommandStage.COMPUTE);

	private final ComputeExecutionRecorder executionRecorder;

	private ComputeExecutionRecorders(ProcessContext context,
									  @InjectDependency(index = 0) List<IRecordableAllocation> pipelines)
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

		executionRecorder = new ComputeExecutionRecorder(commandBuffer, submission, 0);
	}

	@UpdateDependency(index = 0)
	private void updatePipelines(List<IRecordableAllocation> pipelines)
	{
		super.updateRecordables(pipelines);
	}

	@Override
	public Integer acquire()
	{
		return 0;
	}

	@Override
	public List<ComputeExecutionRecorder> getRecorders()
	{
		return List.of(executionRecorder);
	}
}
