package org.sheepy.lily.vulkan.common.allocation.wrapper;

import org.sheepy.lily.vulkan.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;

public interface IAllocationWrapper extends IAllocable
{
	void freeDirtyElements(IAllocationContext context);
}
