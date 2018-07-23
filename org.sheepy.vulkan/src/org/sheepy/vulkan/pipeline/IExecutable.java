package org.sheepy.vulkan.pipeline;

import org.lwjgl.vulkan.VkCommandBuffer;

public interface IExecutable
{
	void execute(VkCommandBuffer commandBuffer);
}
