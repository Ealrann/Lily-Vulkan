package org.sheepy.lily.vulkan.process.pipeline.task;

import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.common.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.common.process.IProcessContext;
import org.sheepy.lily.vulkan.model.process.CompositeTask;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.ArrayList;
import java.util.List;

@Statefull
@Adapter(scope = CompositeTask.class)
public class CompositeTaskAdapter
		implements IPipelineTaskAdapter<CompositeTask>, IAllocableAdapter<IProcessContext>
{
	private final List<AdaptedTaskWrapper<?>> adaptedChildren = new ArrayList<>();
	private final List<IAllocableAdapter<IProcessContext>> allocationChildren = new ArrayList<>();

	private boolean dirty = true;
	private IAllocationConfigurator allocationConfiguration;

	public CompositeTaskAdapter(CompositeTask task)
	{
		reloadChildren(task);
	}

	@NotifyChanged(featureIds = ProcessPackage.COMPOSITE_TASK__TASKS)
	public void notifyChanged()
	{
		dirty = true;
	}

	@Override
	public void configureAllocation(IAllocationConfigurator config, IProcessContext context)
	{
		this.allocationConfiguration = config;
		updateAllocationChildren();
	}

	@Override
	public void allocate(IProcessContext context)
	{
	}

	@Override
	public void free(IProcessContext context)
	{
	}

	@Override
	public void update(CompositeTask task, int index)
	{
		if (dirty)
		{
			reloadChildren(task);
		}

		for (int i = 0; i < adaptedChildren.size(); i++)
		{
			final var child = adaptedChildren.get(i);
			child.update(index);
		}
	}

	@SuppressWarnings("unchecked")
	private void reloadChildren(CompositeTask task)
	{
		adaptedChildren.clear();
		allocationChildren.clear();
		for (final var subTask : task.getTasks())
		{
			adaptedChildren.add(new AdaptedTaskWrapper<>(subTask));

			final var allocationAdapter = subTask.adapt(IAllocableAdapter.class);
			if (allocationAdapter != null)
			{
				allocationChildren.add(allocationAdapter);
			}
		}

		updateAllocationChildren();

		dirty = false;
	}

	private void updateAllocationChildren()
	{
		if (allocationConfiguration != null)
		{
			allocationConfiguration.clearChildren();
			allocationConfiguration.addChildren(allocationChildren);
		}
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
	public void record(CompositeTask task, IRecordContext context)
	{
		final var recordContext = (RecordContext) context;

		for (int repeat = 0; repeat < task.getRepeatCount(); repeat++)
		{
			for (int i = 0; i < adaptedChildren.size(); i++)
			{
				final var child = adaptedChildren.get(i);
				child.record(recordContext);
			}
		}
	}

	@Override
	public ECommandStage getStage(CompositeTask task)
	{
		return ECommandStage.INHERITED;
	}

	private static final class AdaptedTaskWrapper<T extends IPipelineTask>
	{
		T task;
		IPipelineTaskAdapter<T> adapter;

		private AdaptedTaskWrapper(T task)
		{
			this.task = task;
			adapter = task.adaptNotNullGeneric(IPipelineTaskAdapter.class);
		}

		public void update(int index)
		{
			adapter.update(task, index);
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

		public void record(RecordContext context)
		{
			adapter.record(task, context);
		}
	}
}
