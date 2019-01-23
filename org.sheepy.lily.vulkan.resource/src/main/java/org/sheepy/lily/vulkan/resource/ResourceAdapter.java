package org.sheepy.vulkan.resource;

import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.common.api.adapter.impl.AbstractStatefullAdapter;
import org.sheepy.vulkan.common.execution.IResourceAllocableAdapter;
import org.sheepy.vulkan.model.IResource;

public abstract class ResourceAdapter extends AbstractStatefullAdapter
		implements IResourceAllocableAdapter
{
	public static ResourceAdapter adapt(IResource resource)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(resource, ResourceAdapter.class);
	}
}
