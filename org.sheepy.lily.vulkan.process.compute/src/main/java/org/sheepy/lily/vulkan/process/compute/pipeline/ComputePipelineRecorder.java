package org.sheepy.lily.vulkan.process.compute.pipeline;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.execution.IRecordable;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineAllocation;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineRecordable;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineTaskRecorder;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputePackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputePipeline;
import org.sheepy.lily.vulkan.process.pipeline.TaskPipelineManager;
import org.sheepy.lily.vulkan.process.process.ProcessContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.List;

@ModelExtender(scope = ComputePipeline.class)
@Allocation(context = ProcessContext.class)
@AllocationDependency(features = {ComputePackage.COMPUTE_PIPELINE__TASK_PKG, ProcessPackage.TASK_PKG__TASKS}, type = IPipelineTaskRecorder.class)
public final class ComputePipelineRecorder implements IPipelineRecordable
{
	private final ComputePipeline pipeline;
	private final TaskPipelineManager taskManager;

	private ComputePipelineRecorder(ComputePipeline pipeline,
									@InjectDependency(index = 0) List<IPipelineTaskRecorder> recorders)
	{
		this.pipeline = pipeline;
		taskManager = new TaskPipelineManager(pipeline, recorders);
	}

	@Override
	public void record(IRecordable.RecordContext context)
	{
		if (isActive())
		{
			final var pipelineStage = pipeline.getStage();
			final var currentStage = context.stage;
			final var vkPipeline = pipeline.adapt(IPipelineAllocation.class).getVkPipeline();
			if (vkPipeline != null && pipelineStage == currentStage)
			{
				vkPipeline.bindPipeline(context.commandBuffer);
			}
			taskManager.record(context);
		}
	}

	@Override
	public boolean shouldRecord(final ECommandStage stage)
	{
		return pipeline.getStage() == stage || taskManager.shouldRecord(stage);
	}

	@Override
	public boolean isActive()
	{
		return pipeline.isEnabled();
	}
}
