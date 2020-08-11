package org.sheepy.lily.vulkan.process.pipeline;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableExtender;
import org.sheepy.lily.vulkan.model.process.Pipeline;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;

import java.util.List;

@ModelExtender(scope = Pipeline.class)
@Allocation
@AllocationDependency(features = ProcessPackage.PIPELINE__TASK_PKGS, type = IRecordableExtender.class)
public final class PipelineRecorder implements IRecordableExtender
{
	private final Pipeline pipeline;
	private final List<IRecordableExtender> recorders;

	private PipelineRecorder(Pipeline pipeline, @InjectDependency(index = 0) List<IRecordableExtender> recorders)
	{
		this.pipeline = pipeline;
		this.recorders = recorders;
	}

	@Override
	public void record(final RecordContext context)
	{
		if (isActive())
		{
			for (final var recoder : recorders)
			{
				recoder.record(context);
			}
		}
	}

	private boolean isActive()
	{
		return pipeline.isEnabled();
	}
}
