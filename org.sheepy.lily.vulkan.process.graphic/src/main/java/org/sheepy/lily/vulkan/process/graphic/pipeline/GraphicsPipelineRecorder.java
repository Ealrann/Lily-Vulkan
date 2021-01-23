package org.sheepy.lily.vulkan.process.graphic.pipeline;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableAdapter;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.process.process.ProcessContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.List;

@ModelExtender(scope = GraphicsPipeline.class)
@Allocation(context = ProcessContext.class, activator = GraphicPackage.GRAPHICS_PIPELINE__RECORD)
@AllocationDependency(features = GraphicPackage.GRAPHICS_PIPELINE__TASK_PKGS, type = IRecordableAdapter.class)
@AllocationDependency(type = GraphicsPipelineAllocation.class)
public final class GraphicsPipelineRecorder implements IRecordableAdapter
{
	private final List<IRecordableAdapter> recorders;
	private final GraphicsPipelineAllocation pipelineAllocation;

	private GraphicsPipelineRecorder(final @InjectDependency(index = 0) List<IRecordableAdapter> recorders,
									 final @InjectDependency(index = 1) GraphicsPipelineAllocation pipelineAllocation)
	{
		this.recorders = recorders;
		this.pipelineAllocation = pipelineAllocation;
	}

	@Override
	public void record(RecordContext context)
	{
		final var currentStage = context.stage;
		final var vkPipeline = pipelineAllocation.getVkPipeline();
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
