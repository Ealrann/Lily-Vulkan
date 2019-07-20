package org.sheepy.lily.vulkan.api.resource;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.model.resource.Sampler;
import org.sheepy.vulkan.resource.image.VkSampler;

public interface ISamplerAdapter extends IDescriptedResourceAdapter
{
	VkSampler getVkSampler();

	public static ISamplerAdapter adapt(Sampler sampler)
	{
		return IAdapterFactoryService.INSTANCE.adapt(sampler, ISamplerAdapter.class);
	}
}
