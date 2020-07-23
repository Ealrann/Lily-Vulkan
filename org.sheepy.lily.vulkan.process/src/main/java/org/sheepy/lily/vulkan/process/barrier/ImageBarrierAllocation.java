package org.sheepy.lily.vulkan.process.barrier;

import org.lwjgl.vulkan.VkImageMemoryBarrier;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.core.barrier.IImageBarrierAllocation;
import org.sheepy.lily.vulkan.core.resource.IVkImageAllocation;
import org.sheepy.lily.vulkan.core.resource.image.VkImage;
import org.sheepy.lily.vulkan.model.resource.ImageBarrier;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;
import org.sheepy.vulkan.model.enumeration.EImageLayout;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_IMAGE_MEMORY_BARRIER;

@ModelExtender(scope = ImageBarrier.class)
@Allocation
@AllocationDependency(features = VulkanResourcePackage.IMAGE_BARRIER__IMAGE, type = IVkImageAllocation.class)
public class ImageBarrierAllocation implements IImageBarrierAllocation
{
	private final EImageLayout srcLayout;
	private final EImageLayout dstLayout;
	private final VkImage vkImage;
	private final int srcAccessMask;
	private final int dstAccessMask;

	public ImageBarrierAllocation(ImageBarrier imageBarrier, @InjectDependency(index = 0) IVkImageAllocation image)
	{
		vkImage = image.getVkImage();
		srcLayout = imageBarrier.getSrcLayout();
		dstLayout = imageBarrier.getDstLayout();
		srcAccessMask = VulkanModelUtil.getEnumeratedFlag(imageBarrier.getSrcAccessMask());
		dstAccessMask = VulkanModelUtil.getEnumeratedFlag(imageBarrier.getDstAccessMask());
	}

	@Override
	public void fill(final VkImageMemoryBarrier info, final int index, final int srcQueueIndex, final int dstQueueIndex)
	{
		final var aspectMask = vkImage.aspect;

		info.sType(VK_STRUCTURE_TYPE_IMAGE_MEMORY_BARRIER);
		info.oldLayout(srcLayout.getValue());
		info.newLayout(dstLayout.getValue());
		info.image(vkImage.getPtr());
		info.subresourceRange().baseMipLevel(0);
		info.subresourceRange().levelCount(vkImage.mipLevels);
		info.subresourceRange().baseArrayLayer(0);
		info.subresourceRange().layerCount(1);
		info.subresourceRange().aspectMask(aspectMask);
		info.srcAccessMask(srcAccessMask);
		info.dstAccessMask(dstAccessMask);
		info.srcQueueFamilyIndex(srcQueueIndex);
		info.dstQueueFamilyIndex(dstQueueIndex);
	}
}
