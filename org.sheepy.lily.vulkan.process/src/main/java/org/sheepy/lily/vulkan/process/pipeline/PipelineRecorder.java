package org.sheepy.lily.vulkan.process.pipeline;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableAdapter;
import org.sheepy.lily.vulkan.model.process.Pipeline;

import java.util.List;

@ModelExtender(scope = Pipeline.class)
@Allocation(activator = Pipeline.FeatureIDs.RECORD)
@AllocationDependency(features = Pipeline.FeatureIDs.TASK_PKGS, type = IRecordableAdapter.class)
public final class PipelineRecorder implements IRecordableAdapter
{
	private final List<IRecordableAdapter> recorders;

	private PipelineRecorder(@InjectDependency(index = 0) List<IRecordableAdapter> recorders)
	{
		this.recorders = recorders;
	}

	@Override
	public void record(final RecordContext context)
	{
		for (final var recoder : recorders)
		{
			recoder.record(context);
		}
	}
}

