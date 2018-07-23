package org.sheepy.vulkan.pipeline.graphic.render;

import org.lwjgl.vulkan.VkPipelineRasterizationStateCreateInfo;

public interface IRasterizer
{
	VkPipelineRasterizationStateCreateInfo allocRasterizationStateCreateInfo();
	void freeRasterizationStateCreateInfo();
	void free();
}
