package org.sheepy.lily.vulkan.process.pipeline.task;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.allocation.IAllocationAdapter;
import org.sheepy.lily.vulkan.api.allocation.IAllocationNodeAdapter;
import org.sheepy.lily.vulkan.api.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.api.process.IProcessContext;
import org.sheepy.lily.vulkan.model.process.CompositeTask;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

@Statefull
@Adapter(scope = CompositeTask.class)
public class CompositeTaskAdapter
		implements IPipelineTaskAdapter<CompositeTask>, IAllocationNodeAdapter<IProcessContext>
{
	private final List<AdaptedTaskWrapper<?>> adaptedChildren = new ArrayList<>();
	private final List<IAllocationAdapter<IProcessContext>> allocationChildren = new ArrayList<>();

	private boolean dirty = true;

	public CompositeTaskAdapter(CompositeTask task)
	{
		reloadChildren(task);
	}

	@NotifyChanged
	public void notifyChanged(Notification notification)
	{
		if (notification.getFeature() == ProcessPackage.Literals.COMPOSITE_TASK__TASKS)
		{
			dirty = true;
		}
	}

	@Override
	public List<IAllocationAdapter<IProcessContext>> getAllocationChildren()
	{
		return allocationChildren;
	}

	@Override
	public void update(CompositeTask task)
	{
		if (dirty)
		{
			reloadChildren(task);
		}

		for (int i = 0; i < adaptedChildren.size(); i++)
		{
			final var child = adaptedChildren.get(i);
			child.update();
		}
	}

	@SuppressWarnings("unchecked")
	private void reloadChildren(CompositeTask task)
	{
		adaptedChildren.clear();
		for (final var subTask : task.getTasks())
		{
			adaptedChildren.add(new AdaptedTaskWrapper<>(subTask));
			
			final var allocationAdapter = IAllocationAdapter.adapt(subTask);
			if(allocationAdapter != null)
			{
				allocationChildren.add((IAllocationAdapter<IProcessContext>) allocationAdapter);
			}
		}
		dirty = false;
	}

	@Override
	public boolean needRecord(CompositeTask task, int index)
	{
		boolean res = false;

		for (int i = 0; i < adaptedChildren.size(); i++)
		{
			final var child = adaptedChildren.get(i);
			res |= child.needRecord(index);
			if (res)
			{
				break;
			}
		}

		return res;
	}

	@Override
	public void record(CompositeTask task, RecordContext context)
	{
		for (int repeat = 0; repeat < task.getRepeatCount(); repeat++)
		{
			for (int i = 0; i < adaptedChildren.size(); i++)
			{
				final var child = adaptedChildren.get(i);
				child.record(context);
			}
		}
	}

	@Override
	public ECommandStage getStage(CompositeTask task)
	{
		// null means use the pipeline default stage
		return null;
	}

	private static final class AdaptedTaskWrapper<T extends IPipelineTask>
	{
		T task;
		IPipelineTaskAdapter<T> adapter;

		private AdaptedTaskWrapper(T task)
		{
			this.task = task;
			this.adapter = IPipelineTaskAdapter.adapt(task);
		}

		public void update()
		{
			adapter.update(task);
		}

		public boolean needRecord(int index)
		{
			return adapter.needRecord(task, index);
		}

		public void record(RecordContext context)
		{
			adapter.record(task, context);
		}
	}
}
