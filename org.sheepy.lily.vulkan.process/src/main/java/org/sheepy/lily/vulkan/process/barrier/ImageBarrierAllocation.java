package org.sheepy.lily.vulkan.process.barrier;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.allocation.annotation.UpdateDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.core.barrier.IImageBarrierAdapter;
import org.sheepy.lily.vulkan.core.barrier.VkImageBarrier;
import org.sheepy.lily.vulkan.core.resource.IVkImageAllocation;
import org.sheepy.lily.vulkan.model.resource.ImageBarrier;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;

@ModelExtender(scope = ImageBarrier.class)
@Allocation
@AllocationDependency(features = VulkanResourcePackage.IMAGE_BARRIER__IMAGE, type = IVkImageAllocation.class)
public class ImageBarrierAllocation implements IImageBarrierAdapter
{
	private final VkImageBarrier vkBarrier;

	public ImageBarrierAllocation(ImageBarrier imageBarrier, @InjectDependency(index = 0) IVkImageAllocation image)
	{
		final var vkImage = image.getVkImage();
		final var srcLayout = imageBarrier.getSrcLayout();
		final var dstLayout = imageBarrier.getDstLayout();
		final var aspectMask = vkImage.aspect;
		final int srcAccessMask = VulkanModelUtil.getEnumeratedFlag(imageBarrier.getSrcAccessMask());
		final int dstAccessMask = VulkanModelUtil.getEnumeratedFlag(imageBarrier.getDstAccessMask());

		vkBarrier = new VkImageBarrier(srcLayout.getValue(),
									   dstLayout.getValue(),
									   srcAccessMask,
									   dstAccessMask,
									   aspectMask,
									   vkImage.mipLevels);
		updateBarrier(image);
	}

	@Override
	public void update(int index)
	{
	}

	@UpdateDependency(index = 0)
	private void updateBarrier(IVkImageAllocation image)
	{
		vkBarrier.updatePtr(image.getImagePtr());
	}

	@Override
	public VkImageBarrier getBackend()
	{
		return vkBarrier;
	}
}
