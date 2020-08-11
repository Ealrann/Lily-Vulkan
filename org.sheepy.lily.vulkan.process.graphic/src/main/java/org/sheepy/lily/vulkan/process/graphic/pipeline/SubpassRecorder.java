package org.sheepy.lily.vulkan.process.graphic.pipeline;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableExtender;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;

import java.util.List;

@ModelExtender(scope = Subpass.class)
@Allocation
@AllocationDependency(features = {GraphicPackage.SUBPASS__PIPELINE_PKG, ProcessPackage.PIPELINE_PKG__PIPELINES}, type = IRecordableExtender.class)
public final class SubpassRecorder implements IRecordableExtender
{
	private final Subpass subpass;
	private final List<IRecordableExtender> recordables;

	private SubpassRecorder(Subpass subpass, @InjectDependency(index = 0) List<IRecordableExtender> recordables)
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
