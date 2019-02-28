package org.sheepy.lily.vulkan.resource;

import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.vulkan.model.resource.DescriptorResource;
import org.sheepy.lily.vulkan.resource.descriptor.IDescriptorAdapter;

public abstract class DescriptorResourceAdapter extends ResourceAdapter
		implements IDescriptorAdapter
{
	public static DescriptorResourceAdapter adapt(DescriptorResource resource)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(resource, DescriptorResourceAdapter.class);
	}
}
