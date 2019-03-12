package org.sheepy.lily.vulkan.common.execution;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;

public interface ISingleTimeCommand
{
	void execute(MemoryStack stack, VkCommandBuffer commandBuffer);

	default void postExecute()
	{}
}
