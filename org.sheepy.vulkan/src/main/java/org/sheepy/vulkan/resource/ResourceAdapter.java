package org.sheepy.vulkan.resource;

import org.sheepy.vulkan.adapter.VulkanAdapterFactoryImpl;
import org.sheepy.vulkan.allocation.adapter.impl.AbstractFlatAllocableAdapter;
import org.sheepy.vulkan.model.resource.Resource;

public abstract class ResourceAdapter extends AbstractFlatAllocableAdapter
{
	@Override
	public boolean isDirty()
	{
		return false;
	}
	
	public static ResourceAdapter adapt(Resource resource)
	{
		return VulkanAdapterFactoryImpl.INSTANCE.adapt(resource, ResourceAdapter.class);
	}
}
