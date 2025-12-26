package org.sheepy.lily.vulkan.process.graphic.pipeline;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableAdapter;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.lily.vulkan.model.process.PipelinePkg;

import java.util.List;

@ModelExtender(scope = Subpass.class)
@Allocation(activator = Subpass.FeatureIDs.ENABLED)
@AllocationDependency(features = {Subpass.FeatureIDs.PIPELINE_PKG, PipelinePkg.FeatureIDs.PIPELINES}, type = IRecordableAdapter.class)
public final class SubpassRecorder implements IRecordableAdapter
{
	private final Subpass subpass;
	private final List<IRecordableAdapter> recordables;

	private SubpassRecorder(Subpass subpass, @InjectDependency(index = 0) List<IRecordableAdapter> recordables)
	{
		this.subpass = subpass;
		this.recordables = recordables;
	}

	public int getSubpassIndex()
	{
		return subpass.subpassIndex();
	}

	@Override
	public void record(final RecordContext context)
	{
		for (var pipeline : recordables)
		{
			pipeline.record(context);
		}
	}
}
