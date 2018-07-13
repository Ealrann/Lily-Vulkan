package org.sheepy.vulkan.pipeline.swap.graphic;

import org.lwjgl.vulkan.VkPipelineColorBlendStateCreateInfo;

public interface IColorBlendState
{
	VkPipelineColorBlendStateCreateInfo allocColorBlendStateCreateInfo();
	void freeColorBlendStateCreateInfo();
	void free();
}
