package org.sheepy.lily.vulkan.extra.api.rendering;

import java.util.List;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.ResourceProvider;
import org.sheepy.lily.vulkan.model.resource.DescriptedResource;

public interface IResourceProviderAdapter extends IVulkanAdapter
{
	List<DescriptedResource> getResources(ResourceProvider provider);

	public static IResourceProviderAdapter adapt(ResourceProvider provider)
	{
		return IAdapterFactoryService.INSTANCE.adapt(provider, IResourceProviderAdapter.class);
	}
}
