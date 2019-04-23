package org.sheepy.vulkan.execution;

import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

public interface ICommandBuffer extends IAllocable
{
	void start(ECommandStage stage);

	void end(ECommandStage stage);

	VkCommandBuffer getVkCommandBuffer();

	@Override
	default boolean isAllocationDirty(IAllocationContext context)
	{
		return false;
	}
}
