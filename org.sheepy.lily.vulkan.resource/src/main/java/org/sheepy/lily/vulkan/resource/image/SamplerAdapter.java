package org.sheepy.lily.vulkan.resource.image;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.core.resource.ISamplerAdapter;
import org.sheepy.lily.vulkan.core.resource.IVkImageAdapter;
import org.sheepy.lily.vulkan.model.resource.Sampler;
import org.sheepy.lily.vulkan.resource.image.backend.VkSampler;

@Statefull
@Adapter(scope = Sampler.class)
public class SamplerAdapter implements ISamplerAdapter
{
	private final VkSampler vkSampler;
	private final IVkImageAdapter imageAdapter;

	public SamplerAdapter(Sampler sampler)
	{
		final var image = sampler.getImage();
		imageAdapter = image != null ? image.adaptNotNull(IVkImageAdapter.class) : null;

		if (imageAdapter != null)
		{
			final int mipLevels = imageAdapter.getVkImage().mipLevels;
			sampler.setMaxLod(Math.max(mipLevels, sampler.getMaxLod()));
		}

		vkSampler = new VkSampler(sampler);
	}

	@Override
	public void allocate(IVulkanContext context)
	{

		vkSampler.allocate(context);
	}

	@Override
	public void free(IVulkanContext context)
	{
		vkSampler.free(context);
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
