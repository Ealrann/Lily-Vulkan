package org.sheepy.lily.vulkan.resource.image;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.resource.IImageAdapter;
import org.sheepy.lily.vulkan.api.resource.ISampledImageAdapter;
import org.sheepy.lily.vulkan.model.resource.SampledImage;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.resource.image.VkImage;
import org.sheepy.vulkan.resource.image.VkSampler;

@Statefull
@Adapter(scope = SampledImage.class)
public class SampledImageAdapter implements ISampledImageAdapter
{
	private final SampledImage sampledImage;
	private final IImageAdapter imageAdapter;

	private VkSampler vkSampler;

	public SampledImageAdapter(SampledImage sampledImage)
	{
		this.sampledImage = sampledImage;
		final var image = sampledImage.getImage();
		imageAdapter = image != null ? image.adaptNotNull(IImageAdapter.class) : null;
	}

	@Override
	public void allocate(IExecutionContext context)
	{
		imageAdapter.allocate(context);
		final var samplerInfo = sampledImage.getSampler();

		if (imageAdapter != null)
		{
			final int mipLevels = imageAdapter.getVkImage().mipLevels;
			samplerInfo.setMaxLod(Math.max(mipLevels, samplerInfo.getMaxLod()));
		}

		vkSampler = new VkSampler(samplerInfo);
		vkSampler.allocate(context);
	}

	@Override
	public void free(IExecutionContext context)
	{
		vkSampler.free(context);
		imageAdapter.free(context);

		vkSampler = null;
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
	public VkSampler getVkSampler()
	{
		return vkSampler;
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
