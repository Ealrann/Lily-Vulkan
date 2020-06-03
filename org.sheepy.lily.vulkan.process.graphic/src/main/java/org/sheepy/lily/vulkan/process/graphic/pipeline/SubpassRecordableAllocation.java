package org.sheepy.lily.vulkan.process.graphic.pipeline;

import org.sheepy.lily.core.api.allocation.annotation.*;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.model.resource.ResourcePackage;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineRecordable;
import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.List;

@ModelExtender(scope = Subpass.class)
@Allocation
@AllocationChild(features = {GraphicPackage.SUBPASS__RESOURCE_PKG, ResourcePackage.RESOURCE_PKG__RESOURCES})
@AllocationChild(features = {GraphicPackage.SUBPASS__DESCRIPTOR_PKG, VulkanPackage.DESCRIPTOR_PKG__DESCRIPTORS})
@AllocationChild(features = {GraphicPackage.SUBPASS__PIPELINE_PKG, ProcessPackage.PIPELINE_PKG__PIPELINES})
@AllocationDependency(features = {GraphicPackage.SUBPASS__PIPELINE_PKG, ProcessPackage.PIPELINE_PKG__PIPELINES}, type = IPipelineRecordable.class)
public final class SubpassRecordableAllocation implements IPipelineRecordable
{
	private final Subpass subpass;

	private List<IPipelineRecordable> recordables;
	private boolean dirty = true;

	private SubpassRecordableAllocation(Subpass subpass,
										@InjectDependency(index = 0) List<IPipelineRecordable> recordables)
	{
		this.subpass = subpass;
		this.recordables = recordables;
	}

	@UpdateDependency(index = 0)
	private void updateRecordables(List<IPipelineRecordable> recordables)
	{
		this.recordables = recordables;
		this.dirty = true;
	}

	public int getSubpassIndex()
	{
		return subpass.getSubpassIndex();
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

	@Override
	public boolean isRecordDirty(final int index)
	{
		return dirty || areRecordablesDirty(index);
	}

	private boolean areRecordablesDirty(final int index)
	{
		for (var recordable : recordables)
		{
			if (recordable.isRecordDirty(index))
			{
				return true;
			}
		}
		return false;
	}
}
