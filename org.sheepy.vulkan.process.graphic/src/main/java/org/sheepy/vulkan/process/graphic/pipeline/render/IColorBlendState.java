package org.sheepy.vulkan.process.graphic.pipeline.render;

import org.lwjgl.vulkan.VkPipelineColorBlendStateCreateInfo;

public interface IColorBlendState
{
	VkPipelineColorBlendStateCreateInfo allocCreateInfo();
	void freeColorBlendStateCreateInfo();
	void free();
}
