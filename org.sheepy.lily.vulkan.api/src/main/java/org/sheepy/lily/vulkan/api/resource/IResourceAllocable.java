package org.sheepy.lily.vulkan.api.resource;

import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.allocation.adapter.IAllocableAdapter;

public interface IResourceAllocable extends IAllocableAdapter
{
	@Override
	default boolean isAllocationDirty(IAllocationContext context)
	{
		return false;
	}
}
