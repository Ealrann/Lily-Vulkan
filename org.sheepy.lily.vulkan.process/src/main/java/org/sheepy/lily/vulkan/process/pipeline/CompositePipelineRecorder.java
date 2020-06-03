package org.sheepy.lily.vulkan.process.pipeline;

import org.sheepy.lily.core.api.allocation.annotation.*;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineRecordable;
import org.sheepy.lily.vulkan.model.process.CompositePipeline;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.List;

@ModelExtender(scope = CompositePipeline.class)
@Allocation
@AllocationChild(features = ProcessPackage.COMPOSITE_PIPELINE__PIPELINES)
@AllocationDependency(features = ProcessPackage.COMPOSITE_PIPELINE__PIPELINES, type = IPipelineRecordable.class)
public class CompositePipelineRecorder implements IPipelineRecordable
{
	private final CompositePipeline pipeline;
	private List<IPipelineRecordable> recordables;
	private boolean dirty = false;

	public CompositePipelineRecorder(CompositePipeline pipeline,
									 IObservatoryBuilder observatory,
									 @InjectDependency(index = 0) List<IPipelineRecordable> recordables)
	{
		this.pipeline = pipeline;
		this.recordables = recordables;
		observatory.listenNoParam(() -> dirty = true, ProcessPackage.COMPOSITE_PIPELINE__REPEAT);
	}

	@UpdateDependency(index = 0)
	private void updateRecordables(List<IPipelineRecordable> recordables)
	{
		this.recordables = recordables;
		dirty = true;
	}

	@Override
	public void update(final int index)
	{
		for (var pipeline : recordables)
		{
			pipeline.update(index);
		}
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
		dirty = false;
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
	public boolean isRecordDirty(final int index)
	{
		boolean res = dirty;
		for (var pipeline : pipeline.getPipelines())
		{
			res |= pipeline.adapt(IPipelineRecordable.class).isRecordDirty(index);
		}
		return res;
	}

	@Override
	public boolean isActive()
	{
		return pipeline.isEnabled();
	}
}
