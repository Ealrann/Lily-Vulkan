package org.sheepy.lily.vulkan.extra.graphic.rendering;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.model.vulkan.VulkanResourcePkg;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer;

@ModelExtender(scope = GenericRenderer.class, inherited = true)
@Allocation
@AllocationChild(features = {GenericRenderer.FeatureIDs.RESOURCE_PKG, VulkanResourcePkg.FeatureIDs.RESOURCES})
public class RenderPipelineAllocator implements IRecordableAdapter
{
	@Override
	public void record(final RecordContext context)
	{
	}
}
