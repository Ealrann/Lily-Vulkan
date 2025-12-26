package org.sheepy.lily.vulkan.process.pipeline.task;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.api.process.IProcessContext;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableAdapter;
import org.sheepy.lily.vulkan.model.process.CompositeTask;

import java.util.List;

@ModelExtender(scope = CompositeTask.class)
@Allocation(context = IProcessContext.class, activator = CompositeTask.FeatureIDs.ENABLED)
@AllocationChild(allocateBeforeParent = true, features = CompositeTask.FeatureIDs.TASKS)
@AllocationDependency(features = CompositeTask.FeatureIDs.TASKS, type = IRecordableAdapter.class)
public final class CompositeTaskRecorder implements IRecordableAdapter
{
	private final CompositeTask task;
	private final List<IRecordableAdapter> children;

	private CompositeTaskRecorder(final CompositeTask task,
								  final @InjectDependency(index = 0) List<IRecordableAdapter> recorders)
	{
		this.task = task;
		this.children = recorders;
	}

	@Override
	public void record(final RecordContext recordContext)
	{
		for (int repeat = 0; repeat < task.repeatCount(); repeat++)
		{
			for (int i = 0; i < children.size(); i++)
			{
				final var child = children.get(i);
				child.record(recordContext);
			}
		}
	}
}

