package org.sheepy.lily.vulkan.process.graphic.pipeline;

import org.sheepy.lily.core.api.allocation.up.annotation.*;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableAllocation;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.List;

@ModelExtender(scope = Subpass.class)
@Allocation
@AllocationChild(features = ProcessPackage.COMPOSITE_PIPELINE__PIPELINES, type = IRecordableAllocation.class)
@AllocationDependency(features = ProcessPackage.COMPOSITE_PIPELINE__PIPELINES, type = IRecordableAllocation.class)
public final class SubpassRecordableAllocation implements IRecordableAllocation
{
	private final Subpass subpass;

	private List<IRecordableAllocation> recordables;
	private boolean dirty = true;

	private SubpassRecordableAllocation(Subpass subpass,
										@InjectDependency(index = 0) List<IRecordableAllocation> recordables)
	{
		this.subpass = subpass;
		this.recordables = recordables;
	}

	@UpdateDependency(index = 0)
	private void updateRecordables(List<IRecordableAllocation> recordables)
	{
		this.recordables = recordables;
		this.dirty = true;
	}

	@Override
	public void record(final RecordContext context)
	{
		final var pipelines = subpass.getPipelinePkg().getPipelines();
		for (var pipeline : pipelines)
		{
			pipeline.allocationHandle(IRecordableAllocation.class).get().record(context);
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

	@Override
	public boolean isRecordNeeded(final int index)
	{
		return dirty || areRecordablesDirty(index);
	}

	private boolean areRecordablesDirty(final int index)
	{
		for (var recordable : recordables)
		{
			if (recordable.isRecordNeeded(index))
			{
				return true;
			}
		}
		return false;
	}
}
