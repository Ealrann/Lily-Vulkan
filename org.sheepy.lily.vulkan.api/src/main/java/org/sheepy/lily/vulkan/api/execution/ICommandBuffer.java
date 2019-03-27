package org.sheepy.lily.vulkan.api.execution;

import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.vulkan.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.model.enumeration.ECommandStage;

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
