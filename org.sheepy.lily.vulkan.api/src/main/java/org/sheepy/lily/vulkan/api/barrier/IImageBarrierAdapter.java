package org.sheepy.lily.vulkan.api.barrier;

import org.lwjgl.vulkan.VkImageMemoryBarrier;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.barrier.AbstractImageBarrier;

public interface IImageBarrierAdapter<T extends IExecutionContext> extends IVulkanAdapter
{
	void fillInfo(	T context,
					AbstractImageBarrier barrier,
					VkImageMemoryBarrier info,
					int swapIndex);
}
