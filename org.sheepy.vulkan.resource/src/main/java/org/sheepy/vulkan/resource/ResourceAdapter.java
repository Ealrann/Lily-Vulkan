package org.sheepy.vulkan.resource;

import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.vulkan.common.allocation.adapter.impl.AbstractFlatAllocableAdapter;
import org.sheepy.vulkan.model.resource.Resource;

public abstract class ResourceAdapter extends AbstractFlatAllocableAdapter
{
	protected boolean dirty = false;

	@Override
	public boolean isAllocationDirty()
	{
		return dirty;
	}

	public static ResourceAdapter adapt(Resource resource)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(resource, ResourceAdapter.class);
	}
}
