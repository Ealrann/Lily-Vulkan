package org.sheepy.lily.vulkan.api.allocation;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.IAllocationContext;

public interface IAllocableAdapter<T extends IAllocationContext>
		extends IAllocable<T>, IAdapter
{
}
