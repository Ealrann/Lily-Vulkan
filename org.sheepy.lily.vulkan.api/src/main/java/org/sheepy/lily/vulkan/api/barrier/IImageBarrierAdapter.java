package org.sheepy.lily.vulkan.api.barrier;

import org.lwjgl.vulkan.VkImageMemoryBarrier;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.barrier.AbstractImageBarrier;

public interface IImageBarrierAdapter<T extends IExecutionContext> extends IVulkanAdapter
{
	void fillInfo(	T context,
					AbstractImageBarrier barrier,
					VkImageMemoryBarrier info,
					int swapIndex);

	default boolean isAllocationDirty(T context)
	{
		return false;
	}

	public static IImageBarrierAdapter<?> adapt(AbstractImageBarrier barrier)
	{
		return IAdapterFactoryService.INSTANCE.adapt(barrier, IImageBarrierAdapter.class);
	}
}
