package org.sheepy.lily.vulkan.process.pipeline;

import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.core.execution.IRecordable;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineTaskRecorder;
import org.sheepy.lily.vulkan.model.process.AbstractPipeline;
import org.sheepy.lily.vulkan.model.process.CompositeTask;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

public final class TaskPipelineManager implements IRecordable
{
	protected final AbstractPipeline pipeline;
	private List<IPipelineTaskRecorder> tasks;

	private boolean recordNeeded = true;
	private EnumSet<ECommandStage> stages;

	public TaskPipelineManager(AbstractPipeline pipeline, List<IPipelineTaskRecorder> tasks)
	{
		this.pipeline = pipeline;
		this.tasks = tasks;
		updateStages();
	}

	public void updateTasks(List<IPipelineTaskRecorder> tasks)
	{
		this.tasks = tasks;
		updateStages();
		recordNeeded = true;
	}

	private void updateStages()
	{
		final var stages = tasks.stream().map(IPipelineTaskRecorder::getStage).collect(Collectors.toSet());
		this.stages = stages.isEmpty() ? EnumSet.of(ECommandStage.INHERITED) : EnumSet.copyOf(stages);
	}

	@Override
	public void update(int index)
	{
		for (int i = 0; i < tasks.size(); i++)
		{
			final var task = tasks.get(i);
			task.update(index);
		}
	}

	@Override
	public boolean isRecordDirty(int index)
	{
		if (recordNeeded)
		{
			return true;
		}
		for (int i = 0; i < tasks.size(); i++)
		{
			final var task = tasks.get(i);
			if (task.isRecordDirty(index))
			{
				if (DebugUtil.DEBUG_VERBOSE_ENABLED && task instanceof CompositeTask == false)
				{
					System.out.println("Record required by " + task);
				}
				return true;
			}
		}
		return false;
	}

	@Override
	public void record(RecordContext context)
	{
		if (shouldRecord(context.stage))
		{
			recordInternal(context);
		}
	}

	protected void recordInternal(RecordContext context)
	{
		final var pipelineStage = pipeline.getStage();
		final var currentStage = context.stage;
		for (int i = 0; i < tasks.size(); i++)
		{
			final var task = tasks.get(i);
			final var taskStage = task.getStage();
			final boolean inherited = taskStage == null || taskStage == ECommandStage.INHERITED;

			if ((inherited && currentStage == pipelineStage) || (taskStage == currentStage))
			{
				task.record(context);
			}
		}
		recordNeeded = false;
	}

	public boolean shouldRecord(ECommandStage stage)
	{
		return (stage == pipeline.getStage() && stages.contains(ECommandStage.INHERITED)) || stages.contains(stage);
	}
}
