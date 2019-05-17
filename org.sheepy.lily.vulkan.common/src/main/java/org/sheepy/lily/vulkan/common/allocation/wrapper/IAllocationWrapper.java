package org.sheepy.lily.vulkan.common.allocation.wrapper;

import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.allocation.IAllocationObject;

public interface IAllocationWrapper<T extends IAllocationContext> extends IAllocable<T>
{

	IAllocationObject<T> getAllocationObject();

	void freeDirtyElements(T context);

	void freeInternal(T context, boolean onlyDirty);
}
