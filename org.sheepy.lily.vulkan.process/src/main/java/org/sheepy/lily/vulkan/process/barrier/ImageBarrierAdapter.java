package org.sheepy.lily.vulkan.process.barrier;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.model.resource.IImage;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.core.barrier.IImageBarrierAdapter;
import org.sheepy.lily.vulkan.core.barrier.VkImageBarrier;
import org.sheepy.lily.vulkan.core.resource.IVkImageAllocation;
import org.sheepy.lily.vulkan.model.resource.ImageBarrier;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;

@ModelExtender(scope = ImageBarrier.class)
@Adapter
public class ImageBarrierAdapter implements IImageBarrierAdapter
{
	private final ImageBarrier imageBarrier;
	private final VkImageBarrier vkBarrier;

	private boolean changed = true;

	public ImageBarrierAdapter(ImageBarrier imageBarrier, IObservatoryBuilder observatory)
	{
		this.imageBarrier = imageBarrier;

		final IImage image = imageBarrier.getImage();
		final var allocation = image.allocationHandle(IVkImageAllocation.class).get();

		final var vkImage = allocation.getVkImage();
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

		observatory.explore(VulkanResourcePackage.Literals.IMAGE_BARRIER__IMAGE)
				   .allocation(IVkImageAllocation.class)
				   .listenNoParam(this::imageChanged);
	}

	@NotifyChanged(featureIds = VulkanResourcePackage.IMAGE_BARRIER__IMAGE)
	private void imageChanged()
	{
		changed = true;
	}

	@Override
	public void update(int index)
	{
		if (changed == true)
		{
			final IImage image = imageBarrier.getImage();
			final var allocation = image.allocationHandle(IVkImageAllocation.class).get();
			vkBarrier.updatePtr(allocation.getImagePtr());
			changed = false;
		}
	}

	@Override
	public VkImageBarrier getBackend()
	{
		return vkBarrier;
	}
}
