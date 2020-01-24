package org.sheepy.lily.vulkan.common.execution;

import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

public interface ICommandBuffer<T extends InternalExecutionContext> extends IAllocable<T>
{
	void start(ECommandStage stage);

	void end(ECommandStage stage);

	VkCommandBuffer getVkCommandBuffer();
}
