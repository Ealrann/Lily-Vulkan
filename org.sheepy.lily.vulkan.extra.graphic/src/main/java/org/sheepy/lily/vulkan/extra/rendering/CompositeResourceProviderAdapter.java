package org.sheepy.lily.vulkan.extra.rendering;

import java.util.ArrayList;
import java.util.List;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.vulkan.extra.api.rendering.IResourceProviderAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.CompositeResourceProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.ResourceProvider;
import org.sheepy.lily.vulkan.model.resource.DescriptedResource;

@Adapter(scope = CompositeResourceProvider.class)
public final class CompositeResourceProviderAdapter implements IResourceProviderAdapter
{
	@Override
	public List<DescriptedResource> getResources(ResourceProvider provider)
	{
		final var compositeProvider = (CompositeResourceProvider) provider;
		final List<DescriptedResource> res = new ArrayList<>();

		for (final var subProvider : compositeProvider.getProviders())
		{
			final var adapter = subProvider.adaptNotNull(IResourceProviderAdapter.class);
			res.addAll(adapter.getResources(subProvider));
		}

		return res;
	}
}
