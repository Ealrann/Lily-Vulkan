package org.sheepy.lily.vulkan.common.execution;

import org.sheepy.lily.vulkan.common.allocation.adapter.IAllocableAdapter;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;

public interface IResourceAllocable extends IAllocableAdapter
{
	@Override
	default boolean isAllocationDirty(IAllocationContext context)
	{
		return false;
	}
}
