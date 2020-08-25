package org.sheepy.lily.vulkan.extra.graphic.rendering;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.model.resource.ResourcePackage;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableExtender;
import org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;

@ModelExtender(scope = GenericRenderer.class, inherited = true)
@Allocation
@AllocationChild(features = {RenderingPackage.GENERIC_RENDERER__RESOURCE_PKG, ResourcePackage.RESOURCE_PKG__RESOURCES})
public class RenderPipelineAllocator implements IRecordableExtender
{
	@Override
	public void record(final RecordContext context)
	{
	}
}
