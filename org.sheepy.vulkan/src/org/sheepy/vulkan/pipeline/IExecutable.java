package org.sheepy.vulkan.pipeline;

import org.lwjgl.vulkan.VkCommandBuffer;

public interface IExecutable extends IProcessUnit
{
	void execute(VkCommandBuffer commandBuffer);
}
