package org.sheepy.vulkan.pipeline.swap.graphic;

import org.lwjgl.vulkan.VkPipelineRasterizationStateCreateInfo;

public interface IRasterizer
{
	VkPipelineRasterizationStateCreateInfo allocRasterizationStateCreateInfo();
	void freeRasterizationStateCreateInfo();
	void free();
}
