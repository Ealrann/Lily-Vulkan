package org.sheepy.vulkan.resource;

import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.common.allocation.adapter.impl.AbstractFlatAllocableAdapter;
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
		return ServiceAdapterFactory.INSTANCE.adapt(resource, ResourceAdapter.class);
	}
}
