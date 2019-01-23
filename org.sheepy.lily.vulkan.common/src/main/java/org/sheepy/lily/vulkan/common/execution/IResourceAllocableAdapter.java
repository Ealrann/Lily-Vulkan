package org.sheepy.lily.vulkan.common.execution;

import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.model.IResource;

public interface IResourceAllocableAdapter extends IResourceAllocable, IVulkanAdapter
{
	public static IResourceAllocableAdapter adapt(IResource resource)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(resource, IResourceAllocableAdapter.class);
	}
}
