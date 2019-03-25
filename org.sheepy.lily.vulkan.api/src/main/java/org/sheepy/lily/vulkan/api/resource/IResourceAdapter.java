package org.sheepy.lily.vulkan.api.resource;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.model.IResource;

public interface IResourceAdapter extends IResourceAllocable, IVulkanAdapter
{
	public static IResourceAdapter adapt(IResource resource)
	{
		return IAdapterFactoryService.INSTANCE.adapt(resource, IResourceAdapter.class);
	}
}
