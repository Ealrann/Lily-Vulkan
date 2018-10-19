package org.sheepy.vulkan.execution;

import org.lwjgl.vulkan.VkCommandBuffer;

public interface ICommandBuffer
{
	void start();

	void end();

	VkCommandBuffer getVkCommandBuffer();
}
