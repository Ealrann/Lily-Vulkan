package org.sheepy.lily.vulkan.common.execution;

import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocable;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;

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
