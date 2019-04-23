package org.sheepy.lily.vulkan.common.allocation.wrapper;

import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.allocation.IAllocationContext;

public interface IAllocationWrapper extends IAllocable
{
	void freeDirtyElements(IAllocationContext context);
}
