package org.sheepy.lily.vulkan.api.barrier;

import org.lwjgl.vulkan.VkImageMemoryBarrier;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.barrier.AbstractImageBarrier;

public interface IImageBarrierAdapter<T extends IExecutionContext> extends IAdapter
{
	void fillInfo(	T context,
					AbstractImageBarrier barrier,
					VkImageMemoryBarrier info,
					int swapIndex);
}
