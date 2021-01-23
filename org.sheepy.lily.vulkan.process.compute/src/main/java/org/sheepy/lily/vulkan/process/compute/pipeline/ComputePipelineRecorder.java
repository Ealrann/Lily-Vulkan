package org.sheepy.lily.vulkan.process.compute.pipeline;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableAdapter;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.compute.ComputePackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputePipeline;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.process.process.ProcessContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.List;

@ModelExtender(scope = ComputePipeline.class)
@Allocation(context = ProcessContext.class, activator = ComputePackage.COMPUTE_PIPELINE__RECORD)
@AllocationDependency(type = ComputePipelineAllocation.class)
@AllocationDependency(features = ComputePackage.COMPUTE_PIPELINE__TASK_PKGS, type = IRecordableAdapter.class)
public final class ComputePipelineRecorder implements IRecordableAdapter
{
	private final ComputePipelineAllocation pipelineAllocation;
	private final List<IRecordableAdapter> recorders;
	private final ECommandStage bindStage;

	private ComputePipelineRecorder(final ComputePipeline pipeline,
									final @InjectDependency(index = 0) ComputePipelineAllocation pipelineAllocation,
									final @InjectDependency(index = 1) List<IRecordableAdapter> recorders)
	{
		this.pipelineAllocation = pipelineAllocation;
		this.recorders = recorders;

		final var process = ModelUtil.findParent(pipeline, AbstractProcess.class);
		bindStage = process instanceof GraphicProcess ? ECommandStage.PRE_RENDER : ECommandStage.MAIN;
	}

	@Override
	public void record(final RecordContext context)
	{
		final var vkPipeline = pipelineAllocation.getVkPipeline();
		final var currentStage = context.stage;
		if (vkPipeline != null && currentStage == bindStage)
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
