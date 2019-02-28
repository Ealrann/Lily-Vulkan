package org.sheepy.lily.vulkan.common.allocation.allocator.wrapper;

import org.sheepy.lily.vulkan.common.allocation.common.IAllocable;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;

public interface IAllocationWrapper extends IAllocable
{
	void freeDirtyElements(IAllocationContext context);
}
