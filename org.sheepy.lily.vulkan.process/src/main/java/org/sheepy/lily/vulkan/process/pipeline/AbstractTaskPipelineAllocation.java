package org.sheepy.lily.vulkan.process.pipeline;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableAllocation;
import org.sheepy.lily.vulkan.model.process.AbstractPipeline;
import org.sheepy.lily.vulkan.model.process.CompositeTask;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTaskPipelineAllocation implements IRecordableAllocation
{
	protected final AbstractPipeline pipeline;

	private final List<TaskWrapper<?>> taskWrappers = new ArrayList<>();
	private boolean recordNeeded = false;

	protected AbstractTaskPipelineAllocation(AbstractPipeline pipeline, IObservatoryBuilder observatory)
	{
		this.pipeline = pipeline;
		observatory.explore(ProcessPackage.Literals.TASK_PIPELINE__TASK_PKG)
				   .explore(ProcessPackage.Literals.TASK_PKG__TASKS, IPipelineTask.class)
				   .gather(this::addTask, this::removeTask);
		observatory.listen(this::pipelineEnabledChange, ProcessPackage.ABSTRACT_PIPELINE__ENABLED);
	}

	private void pipelineEnabledChange(Notification notification)
	{
		if (notification.getOldBooleanValue() != notification.getNewBooleanValue())
		{
			recordNeeded = true;
		}
	}

	@Override
	public final void update(int index)
	{
		for (int i = 0; i < taskWrappers.size(); i++)
		{
			final var wrapper = taskWrappers.get(i);
			if (wrapper.isEnabled())
			{
				wrapper.update(index);
			}
		}
	}

	@Override
	public boolean isRecordNeeded(int index)
	{
		boolean res = recordNeeded;

		for (int i = 0; i < taskWrappers.size(); i++)
		{
			final var wrapper = taskWrappers.get(i);
			if (wrapper.isEnabled())
			{
				res |= wrapper.needRecord(index);
			}
		}

		return res;
	}

	@Override
	public final void record(RecordContext context)
	{
		if (isActive() && shouldRecord(context.stage))
		{
			recordInternal(context);
		}
	}

	protected void recordInternal(RecordContext context)
	{
		final var pipelineStage = pipeline.getStage();
		final var currentStage = context.stage;

		for (int i = 0; i < taskWrappers.size(); i++)
		{
			final var wrapper = taskWrappers.get(i);
			if (wrapper.isEnabled())
			{
				final var taskStage = wrapper.getStage();

				if ((taskStage == null && currentStage == pipelineStage) || (taskStage == currentStage))
				{
					wrapper.record(context);
				}
			}
		}

		recordNeeded = false;
	}

	@Override
	public boolean isActive()
	{
		return pipeline.isEnabled();
	}

	@Override
	public boolean shouldRecord(ECommandStage stage)
	{
		boolean res = pipeline.getStage() == stage;
		if (!res)
		{
			for (int i = 0; i < taskWrappers.size(); i++)
			{
				final var wrapper = taskWrappers.get(i);
				if (wrapper.isEnabled())
				{
					if (wrapper.getStage() == stage)
					{
						res = true;
						break;
					}
				}
			}
		}

		return res;
	}

	private void addTask(IPipelineTask newTasks)
	{
		final int taskIndex = taskIndex(newTasks);
		taskWrappers.add(taskIndex, new TaskWrapper<>(newTasks, pipeline.getStage()));
		if (newTasks.isEnabled())
		{
			recordNeeded = true;
		}
	}

	private static int taskIndex(IPipelineTask task)
	{
		final var container = task.eContainer();
		@SuppressWarnings("unchecked") final var containningList = (List<EObject>) container.eGet(task.eContainingFeature());
		int index = containningList.indexOf(task);

		if (container instanceof IPipelineTask)
		{
			index += taskIndex((IPipelineTask) container);
		}

		return index;
	}

	private void removeTask(IPipelineTask oldTask)
	{
		taskWrappers.removeIf(wrapper -> wrapper.task == oldTask);
		if (oldTask.isEnabled())
		{
			recordNeeded = true;
		}
	}

	private static final class TaskWrapper<T extends IPipelineTask>
	{
		private final T task;
		private final IPipelineTaskAdapter<T> adapter;
		private final ECommandStage stage;

		public TaskWrapper(T task, ECommandStage pipelineStage)
		{
			this.task = task;
			this.adapter = task.adaptNotNullGeneric(IPipelineTaskAdapter.class);
			this.stage = computeStage(pipelineStage);
		}

		private ECommandStage computeStage(ECommandStage pipelineStage)
		{
			var taskStage = adapter.getStage(task);
			if (taskStage == null || taskStage == ECommandStage.INHERITED)
			{
				taskStage = pipelineStage;
			}
			return taskStage;
		}

		public void record(RecordContext context)
		{
			adapter.record(task, context);
		}

		public ECommandStage getStage()
		{
			return stage;
		}

		public boolean needRecord(int index)
		{
			final boolean needRecord = adapter.needRecord(task, index);

			if (DebugUtil.DEBUG_VERBOSE_ENABLED && needRecord && task instanceof CompositeTask == false)
			{
				System.out.println("Record required by " + task);
			}

			return needRecord;
		}

		public boolean isEnabled()
		{
			return task.isEnabled();
		}

		public void update(int index)
		{
			adapter.update(task, index);
		}

		@Override
		public boolean equals(Object o)
		{
			return task == o || super.equals(o);
		}
	}
}
