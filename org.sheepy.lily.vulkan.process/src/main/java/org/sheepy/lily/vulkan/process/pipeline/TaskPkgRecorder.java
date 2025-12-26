package org.sheepy.lily.vulkan.process.pipeline;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableAdapter;
import org.sheepy.lily.vulkan.model.process.TaskPkg;

import java.util.List;

@ModelExtender(scope = TaskPkg.class)
@Allocation
@AllocationDependency(features = TaskPkg.FeatureIDs.TASKS, type = IRecordableAdapter.class)
public final class TaskPkgRecorder implements IRecordableAdapter
{
	private final TaskPkg taskPkg;
	private final List<IRecordableAdapter> recorders;

	private TaskPkgRecorder(TaskPkg taskPkg, @InjectDependency(index = 0) List<IRecordableAdapter> recorders)
	{
		this.taskPkg = taskPkg;
		this.recorders = recorders;
	}

	@Override
	public void record(final RecordContext context)
	{
		if (context.stage == taskPkg.stage())
		{
			for (final var recorder : recorders)
			{
				recorder.record(context);
			}
		}
	}
}

