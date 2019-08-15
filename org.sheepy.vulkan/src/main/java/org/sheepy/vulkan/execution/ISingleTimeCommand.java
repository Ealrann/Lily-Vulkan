package org.sheepy.vulkan.execution;

import org.lwjgl.vulkan.VkCommandBuffer;

@FunctionalInterface
public interface ISingleTimeCommand
{
	void execute(IExecutionContext context, VkCommandBuffer commandBuffer);

	default void postExecute()
	{}
}
