package org.sheepy.vulkan.common.execution;

import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.vulkan.model.IResource;

public interface IResourceAllocableAdapter extends IResourceAllocable, IVulkanAdapter
{
	public static IResourceAllocableAdapter adapt(IResource resource)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(resource, IResourceAllocableAdapter.class);
	}
}
