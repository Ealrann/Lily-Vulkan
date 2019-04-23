package org.sheepy.lily.vulkan.api.resource;

import org.sheepy.lily.vulkan.api.allocation.IAllocableAdapter;
import org.sheepy.vulkan.allocation.IAllocationContext;

public interface IResourceAllocable extends IAllocableAdapter
{
	@Override
	default boolean isAllocationDirty(IAllocationContext context)
	{
		return false;
	}
}
