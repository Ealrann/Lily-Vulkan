package org.sheepy.lily.vulkan.common.execution;

import org.lwjgl.vulkan.VkCommandBuffer;

public interface ICommandBuffer
{
	void start();

	void end();

	VkCommandBuffer getVkCommandBuffer();
}
