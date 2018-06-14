package org.sheepy.lily.game.vulkan.pipeline.swap.graphic;

import org.lwjgl.vulkan.VkPipelineDynamicStateCreateInfo;

public interface IDynamicState
{
	VkPipelineDynamicStateCreateInfo allocDynamicStateCreateInfo();
	void freeDynamicStateCreateInfo();
	void free();
}
