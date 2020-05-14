package org.sheepy.lily.vulkan.process.graphic.pipeline.task;

import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.sheepy.lily.core.api.allocation.up.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.up.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.up.annotation.InjectDependency;
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
public final class BlitToSwapImageAllocation extends AbstractBlitTaskAllocation
{
	private final PhysicalSurfaceAllocation surfaceAllocation;
	private final ImageViewAllocation imageViews;

	public BlitToSwapImageAllocation(BlitToSwapImage blitTask,
									 ProcessContext context,
									 @InjectDependency(index = 0) IVkImageAllocation srcImage,
									 @InjectDependency(index = 1) PhysicalSurfaceAllocation surfaceAllocation,
									 @InjectDependency(index = 2) ImageViewAllocation imageViews)
	{
		super(blitTask, context, srcImage);
		this.surfaceAllocation = surfaceAllocation;
		this.imageViews = imageViews;
	}

	@Override
	protected Vector2ic getDstImageSize()
	{
		final var extent = surfaceAllocation.getExtent();
		return new Vector2i(extent.x(), extent.y());
	}

	@Override
	protected long getDstImagePtr(int index)
	{
		return imageViews.getImageViews().get(index).getImagePtr();
	}
}
