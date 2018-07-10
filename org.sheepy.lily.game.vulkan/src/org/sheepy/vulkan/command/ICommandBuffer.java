package org.sheepy.vulkan.command;

import org.lwjgl.vulkan.VkCommandBuffer;

public interface ICommandBuffer
{
	VkCommandBuffer start();

	void end();

	VkCommandBuffer getVkCommandBuffer();
}
