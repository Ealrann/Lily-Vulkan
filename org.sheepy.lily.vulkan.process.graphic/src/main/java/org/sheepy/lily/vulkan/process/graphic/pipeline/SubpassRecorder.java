package org.sheepy.lily.vulkan.process.graphic.pipeline;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineRecordable;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.List;

@ModelExtender(scope = Subpass.class)
@Allocation
@AllocationDependency(features = {GraphicPackage.SUBPASS__PIPELINE_PKG, ProcessPackage.PIPELINE_PKG__PIPELINES}, type = IPipelineRecordable.class)
public final class SubpassRecorder implements IPipelineRecordable
{
	private final Subpass subpass;
	private final List<IPipelineRecordable> recordables;

	private SubpassRecorder(Subpass subpass, @InjectDependency(index = 0) List<IPipelineRecordable> recordables)
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

	@Override
	public boolean shouldRecord(final ECommandStage stage)
	{
		for (var recordable : recordables)
		{
			if (recordable.shouldRecord(stage))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isActive()
	{
		return true;
	}
}
