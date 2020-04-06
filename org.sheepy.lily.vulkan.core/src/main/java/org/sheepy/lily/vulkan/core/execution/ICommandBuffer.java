package org.sheepy.lily.vulkan.core.execution;

import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

public interface ICommandBuffer<T extends ExecutionContext> extends IAllocable<T>
{
	void start(ECommandStage stage);

	void end(ECommandStage stage);

	VkCommandBuffer getVkCommandBuffer();
}
