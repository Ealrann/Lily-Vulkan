package org.sheepy.lily.game.vulkan.pipeline;

import org.lwjgl.vulkan.VkPipelineColorBlendStateCreateInfo;

public interface IColorBlendState
{
	VkPipelineColorBlendStateCreateInfo allocColorBlendStateCreateInfo();
	void freeColorBlendStateCreateInfo();
	void free();
}
