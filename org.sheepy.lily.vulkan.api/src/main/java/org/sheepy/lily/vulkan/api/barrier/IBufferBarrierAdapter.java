package org.sheepy.lily.vulkan.api.barrier;

import org.lwjgl.vulkan.VkBufferMemoryBarrier;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.allocation.IAllocationContext;
import org.sheepy.vulkan.model.barrier.AbstractBufferBarrier;

public interface IBufferBarrierAdapter extends IAdapter
{
	void fillInfo(	IAllocationContext context,
					AbstractBufferBarrier barrier,
					VkBufferMemoryBarrier info,
					int index);

	default boolean isAllocationDirty(IAllocationContext context)
	{
		return false;
	}
}
