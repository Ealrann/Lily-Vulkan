package org.sheepy.vulkan.command;

import org.lwjgl.vulkan.VkCommandBuffer;

public interface ICommandBuffer
{
	void start();

	void end();

	VkCommandBuffer getVkCommandBuffer();
}
