package org.sheepy.lily.game.vulkan.pipeline.swap.graphic;

import org.lwjgl.vulkan.VkPipelineRasterizationStateCreateInfo;

public interface IRasterizer
{
	VkPipelineRasterizationStateCreateInfo allocRasterizationStateCreateInfo();
	void freeRasterizationStateCreateInfo();
	void free();
}
