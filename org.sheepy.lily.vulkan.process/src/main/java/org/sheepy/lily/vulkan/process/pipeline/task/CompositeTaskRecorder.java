package org.sheepy.lily.vulkan.process.pipeline.task;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.api.process.IProcessContext;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineTaskRecorder;
import org.sheepy.lily.vulkan.model.process.CompositeTask;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.List;

@ModelExtender(scope = CompositeTask.class)
@Allocation(context = IProcessContext.class)
@AllocationChild(allocateBeforeParent = true, features = ProcessPackage.COMPOSITE_TASK__TASKS)
@AllocationDependency(features = ProcessPackage.COMPOSITE_TASK__TASKS, type = IPipelineTaskRecorder.class)
public class CompositeTaskRecorder implements IPipelineTaskRecorder
{
	private final CompositeTask task;
	private final List<IPipelineTaskRecorder> children;

	public CompositeTaskRecorder(CompositeTask task, @InjectDependency(index = 0) List<IPipelineTaskRecorder> recorders)
	{
		this.task = task;
		this.children = recorders;
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
	}

	@Override
	public ECommandStage getStage()
	{
		return ECommandStage.INHERITED;
	}
}
