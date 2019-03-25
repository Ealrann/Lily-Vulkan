package org.sheepy.lily.vulkan.api.execution;

import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.vulkan.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;

public interface ICommandBuffer extends IAllocable
{
	void start();

	void end();

	VkCommandBuffer getVkCommandBuffer();

	@Override
	default boolean isAllocationDirty(IAllocationContext context)
	{
		return false;
	}
}
