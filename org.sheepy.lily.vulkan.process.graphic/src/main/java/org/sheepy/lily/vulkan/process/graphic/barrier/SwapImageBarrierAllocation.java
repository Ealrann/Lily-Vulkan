package org.sheepy.lily.vulkan.process.graphic.barrier;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.allocation.annotation.UpdateDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.core.barrier.IImageBarrierAdapter;
import org.sheepy.lily.vulkan.core.barrier.VkSwapImageBarrier;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.process.graphic.SwapImageBarrier;
import org.sheepy.lily.vulkan.process.graphic.frame.ImageViewAllocation;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

@ModelExtender(scope = SwapImageBarrier.class)
@Allocation(context = ProcessContext.class)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, GraphicPackage.GRAPHIC_CONFIGURATION__IMAGE_VIEWS}, type = ImageViewAllocation.class)
public final class SwapImageBarrierAllocation implements IImageBarrierAdapter
{
	private final VkSwapImageBarrier vkBarrier;
	private ImageViewAllocation imageViews;

	private SwapImageBarrierAllocation(SwapImageBarrier imageBarrier,
									   @InjectDependency(index = 0) ImageViewAllocation imageViews)
	{
		final var srcLayout = imageBarrier.getSrcLayout().getValue();
		final var dstLayout = imageBarrier.getDstLayout().getValue();
		final int srcAccessMask = VulkanModelUtil.getEnumeratedFlag(imageBarrier.getSrcAccessMask());
		final int dstAccessMask = VulkanModelUtil.getEnumeratedFlag(imageBarrier.getDstAccessMask());

		this.imageViews = imageViews;
		this.vkBarrier = new VkSwapImageBarrier(srcLayout, dstLayout, srcAccessMask, dstAccessMask);
	}

	@UpdateDependency(index = 0)
	private void updateImageViews(ImageViewAllocation imageViews)
	{
		this.imageViews = imageViews;
	}

	@Override
	public void update(int index)
	{
		final var view = imageViews.getImageViews().get(index);
		vkBarrier.updatePtr(view.getImagePtr());
	}

	@Override
	public VkSwapImageBarrier getBackend()
	{
		return vkBarrier;
	}
}
