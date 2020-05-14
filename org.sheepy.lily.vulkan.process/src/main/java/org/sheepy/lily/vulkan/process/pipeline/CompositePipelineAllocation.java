package org.sheepy.lily.vulkan.process.pipeline;

import org.sheepy.lily.core.api.allocation.up.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.up.annotation.AllocationChild;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableAllocation;
import org.sheepy.lily.vulkan.model.process.CompositePipeline;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

@ModelExtender(scope = CompositePipeline.class)
@Allocation
@AllocationChild(features = ProcessPackage.COMPOSITE_PIPELINE__PIPELINES, type = IRecordableAllocation.class)
public class CompositePipelineAllocation implements IRecordableAllocation
{
	private final CompositePipeline pipeline;
	private boolean dirty = false;

	public CompositePipelineAllocation(CompositePipeline pipeline, IObservatoryBuilder observatory)
	{
		this.pipeline = pipeline;
		observatory.listenNoParam(() -> dirty = true, ProcessPackage.COMPOSITE_PIPELINE__REPEAT);
	}

	@Override
	public void record(final RecordContext context)
	{
		final int repeat = pipeline.getRepeat();
		for (int i = 0; i < repeat; i++)
		{
			for (var pipeline : pipeline.getPipelines())
			{
				pipeline.allocationHandle(IRecordableAllocation.class).get().record(context);
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
			res |= pipeline.allocationHandle(IRecordableAllocation.class).get().shouldRecord(stage);
		}
		return res;
	}

	@Override
	public boolean isRecordNeeded(final int index)
	{
		boolean res = dirty;
		for (var pipeline : pipeline.getPipelines())
		{
			res |= pipeline.allocationHandle(IRecordableAllocation.class).get().isRecordNeeded(index);
		}
		return res;
	}

	@Override
	public boolean isActive()
	{
		return pipeline.isEnabled();
	}
}
