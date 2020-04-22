package org.sheepy.lily.vulkan.process.pipeline;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.execution.IRecordable;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineRecordable;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineTaskRecorder;
import org.sheepy.lily.vulkan.model.process.Pipeline;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.List;

@ModelExtender(scope = Pipeline.class)
@Allocation
@AllocationDependency(features = {ProcessPackage.PIPELINE__TASK_PKG, ProcessPackage.TASK_PKG__TASKS}, type = IPipelineTaskRecorder.class)
public final class PipelineRecorder implements IPipelineRecordable
{
	private final TaskPipelineManager taskManager;
	private final Pipeline pipeline;

	private PipelineRecorder(Pipeline pipeline, @InjectDependency(index = 0) List<IPipelineTaskRecorder> recorders)
	{
		this.pipeline = pipeline;
		taskManager = new TaskPipelineManager(pipeline, recorders);
	}

	@Override
	public void record(final IRecordable.RecordContext context)
	{
		if (isActive())
		{
			taskManager.record(context);
		}
	}

	@Override
	public boolean shouldRecord(final ECommandStage stage)
	{
		return pipeline.getStage() == stage || taskManager.shouldRecord(stage);
	}

	@Override
	public boolean isActive()
	{
		return pipeline.isEnabled();
	}
}
