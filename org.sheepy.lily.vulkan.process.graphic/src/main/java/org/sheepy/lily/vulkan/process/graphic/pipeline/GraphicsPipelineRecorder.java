package org.sheepy.lily.vulkan.process.graphic.pipeline;

import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineAllocation;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineRecordable;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineTaskRecorder;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.process.pipeline.TaskPipelineManager;
import org.sheepy.lily.vulkan.process.process.ProcessContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.List;

@ModelExtender(scope = GraphicsPipeline.class)
@Allocation(context = ProcessContext.class)
@AllocationDependency(features = {GraphicPackage.GRAPHICS_PIPELINE__TASK_PKG, ProcessPackage.TASK_PKG__TASKS}, type = IPipelineTaskRecorder.class)
public final class GraphicsPipelineRecorder implements IPipelineRecordable
{
	private final GraphicsPipeline pipeline;
	private final TaskPipelineManager taskManager;

	public GraphicsPipelineRecorder(GraphicsPipeline pipeline,
									IAllocationState config,
									IObservatoryBuilder observatory,
									@InjectDependency(index = 0) List<IPipelineTaskRecorder> recorders)
	{
		this.pipeline = pipeline;
		taskManager = new TaskPipelineManager(pipeline, recorders);
		observatory.listenNoParam(config::setAllocationObsolete, ProcessPackage.ABSTRACT_PIPELINE__ENABLED);
	}

	@Override
	public void record(RecordContext context)
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
