package org.sheepy.lily.vulkan.process.graphic.pipeline;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableAdapter;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;

import java.util.List;

@ModelExtender(scope = Subpass.class)
@Allocation(activator = GraphicPackage.SUBPASS__ENABLED)
@AllocationDependency(features = {GraphicPackage.SUBPASS__PIPELINE_PKG, ProcessPackage.PIPELINE_PKG__PIPELINES}, type = IRecordableAdapter.class)
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
		return subpass.getSubpassIndex();
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
