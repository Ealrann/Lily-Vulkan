package org.sheepy.lily.vulkan.api.barrier;

import org.lwjgl.vulkan.VkBufferMemoryBarrier;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.model.barrier.AbstractBufferBarrier;

public interface IBufferBarrierAdapter extends IVulkanAdapter
{
	void fillInfo(	IAllocationContext context,
					AbstractBufferBarrier barrier,
					VkBufferMemoryBarrier info,
					int index);

	default boolean isAllocationDirty(IAllocationContext context)
	{
		return false;
	}

	public static IBufferBarrierAdapter adapt(AbstractBufferBarrier barrier)
	{
		return IAdapterFactoryService.INSTANCE.adapt(barrier, IBufferBarrierAdapter.class);
	}
}
