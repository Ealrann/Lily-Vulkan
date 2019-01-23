package org.sheepy.vulkan.common.execution;

import org.lwjgl.vulkan.VkCommandBuffer;

public interface ICommandBuffer
{
	void start();

	void end();

	VkCommandBuffer getVkCommandBuffer();
}
