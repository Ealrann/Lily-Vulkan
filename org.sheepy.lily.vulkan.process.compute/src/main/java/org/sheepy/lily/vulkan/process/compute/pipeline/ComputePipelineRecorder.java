package org.sheepy.lily.vulkan.process.compute.pipeline;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableExtender;
import org.sheepy.lily.vulkan.model.process.compute.ComputePackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputePipeline;
import org.sheepy.lily.vulkan.process.process.ProcessContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.List;

@ModelExtender(scope = ComputePipeline.class)
@Allocation(context = ProcessContext.class, activator = ComputePackage.COMPUTE_PIPELINE__RECORD)
@AllocationDependency(type = ComputePipelineAllocation.class)
@AllocationDependency(features = ComputePackage.COMPUTE_PIPELINE__TASK_PKGS, type = IRecordableExtender.class)
public final class ComputePipelineRecorder implements IRecordableExtender
{
	private final ComputePipelineAllocation pipelineAllocation;
	private final List<IRecordableExtender> recorders;

	private ComputePipelineRecorder(@InjectDependency(index = 0) ComputePipelineAllocation pipelineAllocation,
									@InjectDependency(index = 1) List<IRecordableExtender> recorders)
	{
		this.pipelineAllocation = pipelineAllocation;
		this.recorders = recorders;
	}

	@Override
	public void record(RecordContext context)
	{
		final var vkPipeline = pipelineAllocation.getVkPipeline();
		final var currentStage = context.stage;
		if (vkPipeline != null && currentStage == ECommandStage.MAIN)
		{
			vkPipeline.bindPipeline(context.commandBuffer);
		}
		for (final var recorder : recorders)
		{
			recorder.record(context);
		}

		pipelineAllocation.attach(context);
	}
}
