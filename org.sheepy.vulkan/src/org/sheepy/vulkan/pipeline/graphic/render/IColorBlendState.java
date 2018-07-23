package org.sheepy.vulkan.pipeline.graphic.render;

import org.lwjgl.vulkan.VkPipelineColorBlendStateCreateInfo;

public interface IColorBlendState
{
	VkPipelineColorBlendStateCreateInfo allocColorBlendStateCreateInfo();
	void freeColorBlendStateCreateInfo();
	void free();
}
