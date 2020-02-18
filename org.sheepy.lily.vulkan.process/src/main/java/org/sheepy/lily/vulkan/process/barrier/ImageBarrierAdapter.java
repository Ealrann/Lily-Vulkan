package org.sheepy.lily.vulkan.process.barrier;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.adapter.annotation.*;
import org.sheepy.lily.core.api.notification.INotificationListener;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.core.barrier.IImageBarrierAdapter;
import org.sheepy.lily.vulkan.core.barrier.VkImageBarrier;
import org.sheepy.lily.vulkan.core.resource.IVkImageAdapter;
import org.sheepy.lily.vulkan.core.resource.image.ImageUtil;
import org.sheepy.lily.vulkan.model.resource.ImageBarrier;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;

@Statefull
@Adapter(scope = ImageBarrier.class)
public class ImageBarrierAdapter implements IImageBarrierAdapter
{
	private final INotificationListener imageListener = this::imageChanged;
	private final ImageBarrier imageBarrier;

	private VkImageBarrier vkBarrier;
	private boolean changed = true;

	public ImageBarrierAdapter(ImageBarrier imageBarrier)
	{
		this.imageBarrier = imageBarrier;
	}

	@NotifyChanged(featureIds = VulkanResourcePackage.IMAGE_BARRIER__IMAGE)
	private void imageChanged(Notification notification)
	{
		changed = true;
	}

	@Load
	private void load()
	{
		final var adapter = imageBarrier.getImage().adapt(IVkImageAdapter.class);
		adapter.addListener(imageListener, IVkImageAdapter.Features.Image.ordinal());

		final var image = imageBarrier.getImage();
		final var imageAdapter = image.adapt(IVkImageAdapter.class);
		final var vkImage = imageAdapter.getVkImage();

		final int imageFormat = vkImage.format;
		final var srcLayout = imageBarrier.getSrcLayout();
		final var dstLayout = imageBarrier.getDstLayout();
		final var aspectMask = ImageUtil.getAspectMask(dstLayout, imageFormat);
		final int srcAccessMask = VulkanModelUtil.getEnumeratedFlag(imageBarrier.getSrcAccessMask());
		final int dstAccessMask = VulkanModelUtil.getEnumeratedFlag(imageBarrier.getDstAccessMask());

		vkBarrier = new VkImageBarrier(srcLayout.getValue(),
									   dstLayout.getValue(),
									   srcAccessMask,
									   dstAccessMask,
									   aspectMask,
									   vkImage.mipLevels);
	}

	@Dispose
	private void dispose()
	{
		final var adapter = imageBarrier.getImage().adapt(IVkImageAdapter.class);
		adapter.removeListener(imageListener, IVkImageAdapter.Features.Image.ordinal());
	}

	@Override
	public void update(int index)
	{
		if (changed == true)
		{
			final var adapter = imageBarrier.getImage().adapt(IVkImageAdapter.class);
			vkBarrier.updatePtr(adapter.getImagePtr());
			changed = false;
		}
	}

	@Override
	public VkImageBarrier getBackend()
	{
		return vkBarrier;
	}
}
