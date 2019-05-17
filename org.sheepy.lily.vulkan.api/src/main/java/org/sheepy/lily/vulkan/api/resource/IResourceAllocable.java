package org.sheepy.lily.vulkan.api.resource;

import org.sheepy.lily.vulkan.api.allocation.IAllocableAdapter;
import org.sheepy.vulkan.execution.IExecutionContext;

public interface IResourceAllocable extends IAllocableAdapter<IExecutionContext>
{
	@Override
	default boolean isAllocationDirty(IExecutionContext context)
	{
		return false;
	}
}
