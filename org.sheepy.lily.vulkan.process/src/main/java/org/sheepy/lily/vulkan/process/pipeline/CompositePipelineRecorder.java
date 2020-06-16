package org.sheepy.lily.vulkan.process.pipeline;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.util.ModelExplorer;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineRecordable;
import org.sheepy.lily.vulkan.model.process.CompositePipeline;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.List;

@ModelExtender(scope = CompositePipeline.class)
@Allocation
@AllocationChild(features = ProcessPackage.COMPOSITE_PIPELINE__PIPELINES)
public class CompositePipelineRecorder implements IPipelineRecordable
{
	private static final ModelExplorer PIPELINES_EXPLORER = new ModelExplorer(List.of(ProcessPackage.Literals.COMPOSITE_PIPELINE__PIPELINES));
	private final CompositePipeline pipeline;

	private List<IPipelineRecordable> recordables = List.of();
	private boolean dirty = false;

	public CompositePipelineRecorder(CompositePipeline pipeline, IObservatoryBuilder observatory)
	{
		this.pipeline = pipeline;
		observatory.listenNoParam(() -> dirty = true, ProcessPackage.COMPOSITE_PIPELINE__REPEAT);
		observatory.explore(ProcessPackage.COMPOSITE_PIPELINE__PIPELINES)
				   .adapt(IPipelineRecordable.class)
				   .listenAdaptationNoParam(this::updateRecordables);
	}

	private void updateRecordables()
	{
		this.recordables = PIPELINES_EXPLORER.exploreAdapt(pipeline, IPipelineRecordable.class);
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
