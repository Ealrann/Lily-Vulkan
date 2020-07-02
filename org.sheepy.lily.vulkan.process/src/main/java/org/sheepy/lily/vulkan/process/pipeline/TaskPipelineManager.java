package org.sheepy.lily.vulkan.process.pipeline;

import org.sheepy.lily.vulkan.core.execution.IRecordable;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineTaskRecorder;
import org.sheepy.lily.vulkan.model.process.AbstractPipeline;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

public final class TaskPipelineManager implements IRecordable
{
	private final AbstractPipeline pipeline;
	private final List<IPipelineTaskRecorder> recorders;
	private final EnumSet<ECommandStage> stages;

	public TaskPipelineManager(AbstractPipeline pipeline, List<IPipelineTaskRecorder> recorders)
	{
		this.pipeline = pipeline;
		this.recorders = recorders;
		this.stages = computeStages(recorders);
	}

	@Override
	public void record(RecordContext context)
	{
		if (shouldRecord(context.stage))
		{
			recordInternal(context);
		}
	}

	private void recordInternal(RecordContext context)
	{
		final var pipelineStage = pipeline.getStage();
		final var currentStage = context.stage;
		for (int i = 0; i < recorders.size(); i++)
		{
			final var task = recorders.get(i);
			final var taskStage = task.getStage();
			final boolean inherited = taskStage == null || taskStage == ECommandStage.INHERITED;

			if ((inherited && currentStage == pipelineStage) || (taskStage == currentStage))
			{
				task.record(context);
			}
		}
	}

	public boolean shouldRecord(ECommandStage stage)
	{
		return (stage == pipeline.getStage() && stages.contains(ECommandStage.INHERITED)) || stages.contains(stage);
	}

	private static EnumSet<ECommandStage> computeStages(List<IPipelineTaskRecorder> recorders)
	{
		final var stages = recorders.stream().map(IPipelineTaskRecorder::getStage).collect(Collectors.toSet());
		return stages.isEmpty() ? EnumSet.of(ECommandStage.INHERITED) : EnumSet.copyOf(stages);
	}
}
