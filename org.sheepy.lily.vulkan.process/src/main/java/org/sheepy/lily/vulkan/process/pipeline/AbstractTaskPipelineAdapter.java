package org.sheepy.lily.vulkan.process.pipeline;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.core.api.notification.util.ModelStructureObserver;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineAdapter;
import org.sheepy.lily.vulkan.core.process.IProcessContext;
import org.sheepy.lily.vulkan.model.process.AbstractPipeline;
import org.sheepy.lily.vulkan.model.process.CompositeTask;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.ArrayList;
import java.util.List;

@Statefull
public abstract class AbstractTaskPipelineAdapter<T extends IProcessContext> implements IAllocableAdapter<T>,
																						IPipelineAdapter
{
	private final ModelStructureObserver taskObserver = new ModelStructureObserver(List.of(ProcessPackage.Literals.TASK_PIPELINE__TASK_PKG,
																						   ProcessPackage.Literals.TASK_PKG__TASKS),
																				   this::addTask,
																				   this::removeTask);

	protected final AbstractPipeline pipeline;

	private final List<TaskWrapper<?>> taskWrappers = new ArrayList<>();
	private boolean recordNeeded = false;
	private IAllocationConfigurator allocationConfig;

	public AbstractTaskPipelineAdapter(AbstractPipeline pipeline)
	{
		this.pipeline = pipeline;
	}

	@Override
	public void configureAllocation(IAllocationConfigurator config, T context)
	{
		this.allocationConfig = config;
		taskObserver.startObserve(pipeline);
	}

	@Dispose
	public void dispose()
	{
		taskObserver.stopObserve(pipeline);
	}

	@NotifyChanged(featureIds = ProcessPackage.ABSTRACT_PIPELINE__ENABLED)
	private void notifyChanged(Notification notification)
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

	private void addTask(ILilyEObject newValue)
	{
		final var task = (IPipelineTask) newValue;
		final int taskIndex = taskIndex(task);
		taskWrappers.add(taskIndex, new TaskWrapper<>(task, pipeline.getStage()));

		final var adapter = task.<IAllocableAdapter<? super T>>adaptGeneric(IAllocableAdapter.class);

		if (adapter != null)
		{
			allocationConfig.addChildren(List.of(adapter));
			allocationConfig.setDirty();
		}

		if (task.isEnabled())
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

	private void removeTask(ILilyEObject oldValue)
	{
		final var task = (IPipelineTask) oldValue;
		taskWrappers.removeIf(wrapper -> wrapper.task == task);

		final var adapter = task.<IAllocableAdapter<? super T>>adaptGeneric(IAllocableAdapter.class);
		if (adapter != null)
		{
			allocationConfig.removeChildren(List.of(adapter));
			allocationConfig.setDirty();
		}

		if (task.isEnabled())
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
