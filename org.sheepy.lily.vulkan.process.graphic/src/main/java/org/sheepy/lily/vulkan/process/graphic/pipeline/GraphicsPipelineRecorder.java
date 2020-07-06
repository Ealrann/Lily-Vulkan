package org.sheepy.lily.vulkan.process.graphic.pipeline;

import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineAllocation;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableExtender;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.process.process.ProcessContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.List;

@ModelExtender(scope = GraphicsPipeline.class)
@Allocation(context = ProcessContext.class)
@AllocationDependency(features = GraphicPackage.GRAPHICS_PIPELINE__TASK_PKGS, type = IRecordableExtender.class)
public final class GraphicsPipelineRecorder implements IRecordableExtender
{
	private final GraphicsPipeline pipeline;
	private final List<IRecordableExtender> recorders;

	public GraphicsPipelineRecorder(GraphicsPipeline pipeline,
									IAllocationState config,
									IObservatoryBuilder observatory,
									@InjectDependency(index = 0) List<IRecordableExtender> recorders)
	{
		this.pipeline = pipeline;
		this.recorders = recorders;
		observatory.listenNoParam(config::setAllocationObsolete, ProcessPackage.ABSTRACT_PIPELINE__ENABLED);
	}

	@Override
	public void record(RecordContext context)
	{
		if (isActive())
		{
			final var currentStage = context.stage;
			final var vkPipeline = pipeline.adapt(IPipelineAllocation.class).getVkPipeline();
			if (vkPipeline != null && currentStage == ECommandStage.MAIN)
			{
				vkPipeline.bindPipeline(context.commandBuffer);
			}
			for (final var recorder : recorders)
			{
				recorder.record(context);
			}
		}
	}

	private boolean isActive()
	{
		return pipeline.isEnabled();
	}
}
