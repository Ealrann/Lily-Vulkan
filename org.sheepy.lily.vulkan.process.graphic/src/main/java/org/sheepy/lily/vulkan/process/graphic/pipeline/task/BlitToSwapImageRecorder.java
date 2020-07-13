package org.sheepy.lily.vulkan.process.graphic.pipeline.task;

import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.resource.IVkImageAllocation;
import org.sheepy.lily.vulkan.model.process.graphic.BlitToSwapImage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.process.graphic.frame.ImageViewAllocation;
import org.sheepy.lily.vulkan.process.graphic.frame.PhysicalSurfaceAllocation;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

@ModelExtender(scope = BlitToSwapImage.class)
@Allocation(context = ProcessContext.class)
@AllocationDependency(features = GraphicPackage.BLIT_TO_SWAP_IMAGE__SRC_IMAGE, type = IVkImageAllocation.class)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, GraphicPackage.GRAPHIC_CONFIGURATION__SURFACE}, type = PhysicalSurfaceAllocation.class)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, GraphicPackage.GRAPHIC_CONFIGURATION__IMAGE_VIEWS}, type = ImageViewAllocation.class)
public final class BlitToSwapImageRecorder extends AbstractBlitTaskRecorder
{
	private final ImageViewAllocation imageViews;

	public BlitToSwapImageRecorder(BlitToSwapImage blitTask,
								   ProcessContext context,
								   IAllocationState allocationState,
								   @InjectDependency(index = 0) IVkImageAllocation srcImage,
								   @InjectDependency(index = 1) PhysicalSurfaceAllocation surfaceAllocation,
								   @InjectDependency(index = 2) ImageViewAllocation imageViews)
	{
		super(blitTask, allocationState, context, srcImage, surfaceAllocation.getExtent());
		this.imageViews = imageViews;
	}

	@Override
	protected long getDstImagePtr(int index)
	{
		return imageViews.getImageViews().get(index).getImagePtr();
	}
}
