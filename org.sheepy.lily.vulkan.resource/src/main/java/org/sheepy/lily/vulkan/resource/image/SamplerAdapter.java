package org.sheepy.lily.vulkan.resource.image;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.common.resource.IImageAdapter;
import org.sheepy.lily.vulkan.common.resource.ISamplerAdapter;
import org.sheepy.lily.vulkan.model.resource.Sampler;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.resource.image.VkSampler;

@Statefull
@Adapter(scope = Sampler.class)
public class SamplerAdapter implements ISamplerAdapter
{
	private final VkSampler vkSampler;
	private final IImageAdapter imageAdapter;

	public SamplerAdapter(Sampler sampler)
	{
		final var image = sampler.getImage();
		imageAdapter = image != null ? image.adaptNotNull(IImageAdapter.class) : null;

		if (imageAdapter != null)
		{
			final int mipLevels = imageAdapter.getVkImage().mipLevels;
			sampler.setMaxLod(Math.max(mipLevels, sampler.getMaxLod()));
		}

		vkSampler = new VkSampler(sampler);
	}

	@Override
	public void allocate(IExecutionContext context)
	{

		vkSampler.allocate(context);
	}

	@Override
	public void free(IExecutionContext context)
	{
		vkSampler.free(context);
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
	public long getViewPtr()
	{
		return imageAdapter != null ? imageAdapter.getViewPtr() : 0;
	}
}
