package org.sheepy.lily.vulkan.process.graphic.process;

import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.execution.IRecordable;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

@ModelExtender(scope = GraphicConfiguration.class)
@Allocation(context = ProcessContext.class)
@AllocationChild(features = GraphicPackage.GRAPHIC_CONFIGURATION__SURFACE)
@AllocationChild(features = GraphicPackage.GRAPHIC_CONFIGURATION__SWAPCHAIN_CONFIGURATION)
@AllocationChild(features = GraphicPackage.GRAPHIC_CONFIGURATION__RENDER_PASS)
@AllocationChild(features = GraphicPackage.GRAPHIC_CONFIGURATION__IMAGE_VIEWS)
@AllocationChild(features = GraphicPackage.GRAPHIC_CONFIGURATION__FRAMEBUFFER_CONFIGURATION)
public final class GraphicConfigurationAllocation implements IExtender
{
	private final IAllocationState allocationState;

	private GraphicConfigurationAllocation(IAllocationState allocationState)
	{
		this.allocationState = allocationState;
	}

	public void attach(final IRecordable.RecordContext context)
	{
		context.lockAllocationDuringExecution(allocationState);
	}
}