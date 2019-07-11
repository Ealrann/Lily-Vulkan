package org.sheepy.vulkan.execution;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;

@FunctionalInterface
public interface ISingleTimeCommand
{
	void execute(MemoryStack stack, VkCommandBuffer commandBuffer);

	default void postExecute()
	{}
}
