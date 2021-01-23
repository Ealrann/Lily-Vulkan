package org.sheepy.lily.vulkan.process.graphic.barrier;

import org.lwjgl.vulkan.VkImageMemoryBarrier;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.core.barrier.IImageBarrierAllocation;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.process.graphic.SwapImageBarrier;
import org.sheepy.lily.vulkan.process.graphic.frame.ImageViewAllocation;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

import static org.lwjgl.vulkan.VK10.VK_IMAGE_ASPECT_COLOR_BIT;
import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_IMAGE_MEMORY_BARRIER;

@ModelExtender(scope = SwapImageBarrier.class)
@Allocation(context = ProcessContext.class)
@AllocationDependency(parent = GraphicProcess.class, features = {GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, GraphicPackage.GRAPHIC_CONFIGURATION__IMAGE_VIEWS}, type = ImageViewAllocation.class)
public final class SwapImageBarrierAllocation implements IImageBarrierAllocation
{
	private final ImageViewAllocation imageViews;
	private final int srcLayout;
	private final int dstLayout;
	private final int srcAccessMask;
	private final int dstAccessMask;

	private SwapImageBarrierAllocation(SwapImageBarrier imageBarrier,
									   @InjectDependency(index = 0) ImageViewAllocation imageViews)
	{
		srcLayout = imageBarrier.getSrcLayout().getValue();
		dstLayout = imageBarrier.getDstLayout().getValue();
		srcAccessMask = VulkanModelUtil.getEnumeratedFlag(imageBarrier.getSrcAccessMask());
		dstAccessMask = VulkanModelUtil.getEnumeratedFlag(imageBarrier.getDstAccessMask());

		this.imageViews = imageViews;
	}

	@Override
	public void fill(final VkImageMemoryBarrier info, final int index, final int srcQueueIndex, final int dstQueueIndex)
	{
		final var view = imageViews.getImageViews().get(index);
		info.sType(VK_STRUCTURE_TYPE_IMAGE_MEMORY_BARRIER);
		info.oldLayout(srcLayout);
		info.newLayout(dstLayout);
		info.image(view.getImagePtr());
		info.subresourceRange().baseMipLevel(0);
		info.subresourceRange().levelCount(1);
		info.subresourceRange().baseArrayLayer(0);
		info.subresourceRange().layerCount(1);
		info.subresourceRange().aspectMask(VK_IMAGE_ASPECT_COLOR_BIT);
		info.srcAccessMask(srcAccessMask);
		info.dstAccessMask(dstAccessMask);
		info.srcQueueFamilyIndex(srcQueueIndex);
		info.dstQueueFamilyIndex(dstQueueIndex);
	}
}
