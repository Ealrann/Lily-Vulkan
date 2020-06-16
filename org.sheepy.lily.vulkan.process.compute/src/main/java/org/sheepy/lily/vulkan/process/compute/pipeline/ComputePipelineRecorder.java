package org.sheepy.lily.vulkan.process.compute.pipeline;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.vulkan.core.pipeline.IVkPipelineRecordable;
import org.sheepy.lily.vulkan.core.pipeline.VkPipeline;
import org.sheepy.lily.vulkan.core.pipeline.VkPipelineLayout;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputePipeline;
import org.sheepy.lily.vulkan.process.pipeline.TaskPipelineManager;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

@ModelExtender(scope = ComputePipeline.class)
@Adapter
public final class ComputePipelineRecorder implements IVkPipelineRecordable
{
	private final ComputePipeline pipeline;
	private final TaskPipelineManager taskManager;

	private ComputePipelineAllocation pipelineAllocation;
	private boolean recordNeeded = false;

	private ComputePipelineRecorder(ComputePipeline pipeline, IObservatoryBuilder observatory)
	{
		this.pipeline = pipeline;
		taskManager = new TaskPipelineManager(pipeline, observatory);

		observatory.listenNoParam(() -> recordNeeded = true, ProcessPackage.ABSTRACT_PIPELINE__ENABLED);
		observatory.adapt(ComputePipelineAllocation.class).gatherAdaptation(this::updateAllocation, null);
	}

	private void updateAllocation(ComputePipelineAllocation newAllocation)
	{
		this.pipelineAllocation = newAllocation;
	}

	@Override
	public void update(final int index)
	{
		taskManager.update(index);
	}

	@Override
	public void record(RecordContext context)
	{
		if (isActive())
		{
			final var pipelineStage = pipeline.getStage();
			final var currentStage = context.stage;
			final var vkPipeline = pipelineAllocation.getVkPipeline();
			if (vkPipeline != null && pipelineStage == currentStage)
			{
				vkPipeline.bindPipeline(context.commandBuffer);
			}
			taskManager.record(context);
		}
		recordNeeded = false;
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

	@Override
	public boolean isRecordDirty(final int index)
	{
		return recordNeeded || taskManager.isRecordDirty(index);
	}

	@Override
	public VkPipelineLayout getVkPipelineLayout()
	{
		return pipelineAllocation.getVkPipelineLayout();
	}

	@Override
	public VkPipeline getVkPipeline()
	{
		return pipelineAllocation.getVkPipeline();
	}
}
