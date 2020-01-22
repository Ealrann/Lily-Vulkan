package org.sheepy.lily.vulkan.process.barrier;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.notification.INotificationListener;
import org.sheepy.lily.vulkan.common.barrier.IImageBarrierAdapter;
import org.sheepy.lily.vulkan.common.resource.IImageAdapter;
import org.sheepy.lily.vulkan.model.resource.ImageBarrier;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;
import org.sheepy.vulkan.barrier.VkImageBarrier;
import org.sheepy.vulkan.resource.image.ImageUtil;
import org.sheepy.vulkan.util.VkModelUtil;

@Statefull
@Adapter(scope = ImageBarrier.class)
public class ImageBarrierAdapter implements IImageBarrierAdapter
{
	private final VkImageBarrier vkBarrier;
	private final INotificationListener imageListener = this::imageChanged;
	private final ImageBarrier imageBarrier;

	private boolean changed = true;

	public ImageBarrierAdapter(ImageBarrier imageBarrier)
	{
		this.imageBarrier = imageBarrier;
		final var image = imageBarrier.getImage();

		final int imageFormat = image.getFormat().getValue();
		final var srcLayout = imageBarrier.getSrcLayout();
		final var dstLayout = imageBarrier.getDstLayout();
		final var aspectMask = ImageUtil.getAspectMask(dstLayout, imageFormat);
		final int srcAccessMask = VkModelUtil.getEnumeratedFlag(imageBarrier.getSrcAccessMask());
		final int dstAccessMask = VkModelUtil.getEnumeratedFlag(imageBarrier.getDstAccessMask());

		vkBarrier = new VkImageBarrier(	image,
										srcLayout.getValue(),
										dstLayout.getValue(),
										srcAccessMask,
										dstAccessMask,
										aspectMask);
	}

	@NotifyChanged(featureIds = ResourcePackage.IMAGE_BARRIER__IMAGE)
	private void imageChanged(Notification notification)
	{
		changed = true;
	}

	@Load
	private void load()
	{
		final var adapter = imageBarrier.getImage().adapt(IImageAdapter.class);
		adapter.addListener(imageListener, IImageAdapter.Features.Image.ordinal());
	}

	@Dispose
	private void dispose()
	{
		final var adapter = imageBarrier.getImage().adapt(IImageAdapter.class);
		adapter.removeListener(imageListener, IImageAdapter.Features.Image.ordinal());
	}

	@Override
	public void update(int index)
	{
		if (changed == true)
		{
			final var adapter = imageBarrier.getImage().adapt(IImageAdapter.class);
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
