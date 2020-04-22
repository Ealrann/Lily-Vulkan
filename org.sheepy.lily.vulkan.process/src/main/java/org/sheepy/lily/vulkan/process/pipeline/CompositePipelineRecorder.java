package org.sheepy.lily.vulkan.process.pipeline;

import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineRecordable;
import org.sheepy.lily.vulkan.model.process.CompositePipeline;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.List;

@ModelExtender(scope = CompositePipeline.class)
@Allocation
@AllocationDependency(features = ProcessPackage.COMPOSITE_PIPELINE__PIPELINES, type = IPipelineRecordable.class)
public class CompositePipelineRecorder implements IPipelineRecordable
{
	private final CompositePipeline pipeline;
	private final List<IPipelineRecordable> recordables;

	public CompositePipelineRecorder(CompositePipeline pipeline,
									 IAllocationState configuration,
									 IObservatoryBuilder observatory,
									 @InjectDependency(index = 0) List<IPipelineRecordable> recordables)
	{
		this.pipeline = pipeline;
		this.recordables = recordables;
		observatory.listenNoParam(configuration::setAllocationObsolete, ProcessPackage.COMPOSITE_PIPELINE__REPEAT);
	}

	@Override
	public void record(final RecordContext context)
	{
		final int repeat = pipeline.getRepeat();
		for (int i = 0; i < repeat; i++)
		{
			for (var pipeline : recordables)
			{
				pipeline.record(context);
			}
		}
	}

	@Override
	public boolean shouldRecord(final ECommandStage stage)
	{
		boolean res = false;
		for (var pipeline : pipeline.getPipelines())
		{
			res |= pipeline.adapt(IPipelineRecordable.class).shouldRecord(stage);
		}
		return res;
	}

	@Override
	public boolean isActive()
	{
		return pipeline.isEnabled();
	}
}
