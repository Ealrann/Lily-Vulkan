package org.sheepy.lily.vulkan.process.graphic.pipeline.task;

import org.logoce.lmf.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.resource.image.IVkImageAllocation;
import org.sheepy.lily.vulkan.model.process.graphic.BlitToSwapImage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.process.graphic.frame.ImageViewAllocation;
import org.sheepy.lily.vulkan.process.graphic.frame.PhysicalSurfaceAllocation;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

@ModelExtender(scope = BlitToSwapImage.class)
@Allocation(context = ProcessContext.class)
@AllocationDependency(features = BlitToSwapImage.FeatureIDs.SRC_IMAGE, type = IVkImageAllocation.class)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicProcess.FeatureIDs.CONFIGURATION, GraphicConfiguration.FeatureIDs.SURFACE}, type = PhysicalSurfaceAllocation.class)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicProcess.FeatureIDs.CONFIGURATION, GraphicConfiguration.FeatureIDs.IMAGE_VIEWS}, type = ImageViewAllocation.class)
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
	protected long getDstImagePtr(RecordContext context)
	{
		return imageViews.getImageViews().get(context.executionID).getImagePtr();
	}
}
