package org.sheepy.lily.vulkan.api.allocation;

import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;

public interface IAllocableAdapter<T extends IAllocationContext>
		extends IAllocable<T>, IVulkanAdapter
{
}
