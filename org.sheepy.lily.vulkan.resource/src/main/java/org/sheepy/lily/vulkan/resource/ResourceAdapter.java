package org.sheepy.lily.vulkan.resource;

import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.core.api.adapter.impl.AbstractStatefullAdapter;
import org.sheepy.lily.vulkan.common.resource.IResourceAdapter;
import org.sheepy.lily.vulkan.model.IResource;

public abstract class ResourceAdapter extends AbstractStatefullAdapter
		implements IResourceAdapter
{
	public static ResourceAdapter adapt(IResource resource)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(resource, ResourceAdapter.class);
	}
}
