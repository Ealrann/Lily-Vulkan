package org.sheepy.lily.game.vulkan.pipeline;

import org.lwjgl.vulkan.VkPipelineVertexInputStateCreateInfo;

public interface IVertexInputState
{
	VkPipelineVertexInputStateCreateInfo allocInputStateCreateInfo();
	void freeInputStateCreateInfo();
	void free();
}
