package org.sheepy.lily.vulkan.extra.rendering;

import java.util.List;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.vulkan.extra.api.rendering.IResourceProviderAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.ResourceProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.StaticResourceProvider;
import org.sheepy.lily.vulkan.model.resource.DescriptedResource;

@Adapter(scope = StaticResourceProvider.class)
public class StaticResourceProviderAdapter implements IResourceProviderAdapter
{
	@Override
	public List<DescriptedResource> getResources(ResourceProvider provider)
	{
		return ((StaticResourceProvider) provider).getResources();
	}

}
