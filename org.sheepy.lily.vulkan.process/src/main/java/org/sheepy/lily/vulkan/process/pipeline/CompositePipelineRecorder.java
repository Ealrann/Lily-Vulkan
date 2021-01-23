package org.sheepy.lily.vulkan.process.pipeline;

import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableAdapter;
import org.sheepy.lily.vulkan.model.process.CompositePipeline;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;

import java.util.List;

@ModelExtender(scope = CompositePipeline.class)
@Allocation(activator = ProcessPackage.COMPOSITE_PIPELINE__RECORD)
@AllocationDependency(features = ProcessPackage.COMPOSITE_PIPELINE__PIPELINES, type = IRecordableAdapter.class)
public class CompositePipelineRecorder implements IRecordableAdapter
{
	private final CompositePipeline pipeline;
	private final List<IRecordableAdapter> recordables;

	public CompositePipelineRecorder(CompositePipeline pipeline,
									 IAllocationState configuration,
									 IObservatoryBuilder observatory,
									 @InjectDependency(index = 0) List<IRecordableAdapter> recordables)
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
}
