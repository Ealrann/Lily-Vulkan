package org.sheepy.lily.vulkan.process.pipeline.task;

import org.sheepy.lily.core.api.allocation.annotation.*;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.api.process.IProcessContext;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineTaskRecorder;
import org.sheepy.lily.vulkan.model.process.CompositeTask;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.List;

@ModelExtender(scope = CompositeTask.class)
@Allocation(context = IProcessContext.class)
@AllocationChild(features = ProcessPackage.COMPOSITE_TASK__TASKS)
@AllocationDependency(features = ProcessPackage.COMPOSITE_TASK__TASKS, type = IPipelineTaskRecorder.class)
public class CompositeTaskRecorder implements IPipelineTaskRecorder
{
	private final CompositeTask task;
	private List<IPipelineTaskRecorder> children;
	private boolean dirty = true;

	public CompositeTaskRecorder(CompositeTask task, @InjectDependency(index = 0) List<IPipelineTaskRecorder> children)
	{
		this.task = task;
		this.children = children;
	}

	@UpdateDependency(index = 0)
	public void notifyChanged(List<IPipelineTaskRecorder> children)
	{
		this.children = children;
		dirty = true;
	}

	@Override
	public void update(int index)
	{
		for (int i = 0; i < children.size(); i++)
		{
			final var child = children.get(i);
			child.update(index);
		}
	}

	@Override
	public boolean isRecordDirty(final int index)
	{
		if (dirty)
		{
			return true;
		}

		for (int i = 0; i < children.size(); i++)
		{
			final var child = children.get(i);
			if (child.isRecordDirty(index))
			{
				if (DebugUtil.DEBUG_VERBOSE_ENABLED)
				{
					System.out.println("Record required by " + child);
				}
				return true;
			}
		}

		return false;
	}

	@Override
	public void record(RecordContext context)
	{
		final var recordContext = (RecordContext) context;

		for (int repeat = 0; repeat < task.getRepeatCount(); repeat++)
		{
			for (int i = 0; i < children.size(); i++)
			{
				final var child = children.get(i);
				child.record(recordContext);
			}
		}
		dirty = false;
	}

	@Override
	public ECommandStage getStage()
	{
		return ECommandStage.INHERITED;
	}
}
