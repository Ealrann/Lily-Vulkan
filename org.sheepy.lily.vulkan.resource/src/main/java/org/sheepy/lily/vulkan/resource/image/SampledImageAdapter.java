package org.sheepy.lily.vulkan.resource.image;

import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.sheepy.lily.core.api.adapter.IAllocableAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.notification.Notifier;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.core.resource.ISampledImageAdapter;
import org.sheepy.lily.vulkan.core.resource.IVkImageAdapter;
import org.sheepy.lily.vulkan.core.resource.image.VkImage;
import org.sheepy.lily.vulkan.model.resource.SampledImage;
import org.sheepy.lily.vulkan.resource.image.backend.VkSampler;

import java.util.List;

@SuppressWarnings("unchecked")
@Statefull
@Adapter(scope = SampledImage.class)
public class SampledImageAdapter extends Notifier<IVkImageAdapter.Features> implements ISampledImageAdapter
{
	private final SampledImage sampledImage;
	private final IVkImageAdapter imageAdapter;

	private VkSampler vkSampler;

	public SampledImageAdapter(SampledImage sampledImage)
	{
		super(List.of(Features.Image, Features.View));

		this.sampledImage = sampledImage;
		final var image = sampledImage.getImage();
		imageAdapter = image != null ? image.adaptNotNull(IVkImageAdapter.class) : null;
	}

	@Override
	public void allocate(IVulkanContext context)
	{
		final var samplerInfo = sampledImage.getSampler();

		if (imageAdapter != null)
		{
			((IAllocableAdapter<? super IVulkanContext>) imageAdapter).allocate(context);
			final int mipLevels = imageAdapter.getVkImage().mipLevels;
			samplerInfo.setMaxLod(Math.max(mipLevels, samplerInfo.getMaxLod()));
		}

		vkSampler = new VkSampler(samplerInfo);
		vkSampler.allocate(context);
	}

	@Override
	public void free(IVulkanContext context)
	{
		vkSampler.free(context);
		((IAllocableAdapter<? super IVulkanContext>) imageAdapter).free(context);

		vkSampler = null;
	}

	@Override
	public Vector2ic getSize()
	{
		final var vkImage = getVkImage();
		return new Vector2i(vkImage.width, vkImage.height);
	}

	@Override
	public long getImagePtr()
	{
		return imageAdapter.getImagePtr();
	}

	@Override
	public long getViewPtr()
	{
		return imageAdapter.getViewPtr();
	}

	@Override
	public long getSamplerPtr()
	{
		return vkSampler.getPtr();
	}

	@Override
	public VkImage getVkImage()
	{
		return imageAdapter.getVkImage();
	}

	@Override
	public long getMemoryPtr()
	{
		return imageAdapter.getMemoryPtr();
	}
}
