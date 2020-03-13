package org.sheepy.lily.vulkan.process.barrier;

import org.sheepy.lily.core.api.adapter.annotation.*;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.core.barrier.IImageBarrierAdapter;
import org.sheepy.lily.vulkan.core.barrier.VkImageBarrier;
import org.sheepy.lily.vulkan.core.resource.IVkImageAdapter;
import org.sheepy.lily.vulkan.model.resource.ImageBarrier;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;

import java.util.function.LongConsumer;

@Statefull
@Adapter(scope = ImageBarrier.class)
public class ImageBarrierAdapter implements IImageBarrierAdapter
{
	private final LongConsumer imageListener = this::imageChanged;
	private final ImageBarrier imageBarrier;

	private VkImageBarrier vkBarrier;
	private boolean changed = true;

	public ImageBarrierAdapter(ImageBarrier imageBarrier)
	{
		this.imageBarrier = imageBarrier;
	}

	@NotifyChanged(featureIds = VulkanResourcePackage.IMAGE_BARRIER__IMAGE)
	private void imageChanged(Long ptr)
	{
		changed = true;
	}

	@Load
	private void load()
	{
		final var adapter = imageBarrier.getImage().adapt(IVkImageAdapter.class);
		adapter.listen(imageListener, IVkImageAdapter.Features.Image);

		final var image = imageBarrier.getImage();
		final var imageAdapter = image.adapt(IVkImageAdapter.class);
		final var vkImage = imageAdapter.getVkImage();

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
	}

	@Dispose
	private void dispose()
	{
		final var adapter = imageBarrier.getImage().adapt(IVkImageAdapter.class);
		adapter.sulk(imageListener, IVkImageAdapter.Features.Image);
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
