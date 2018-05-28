package org.sheepy.lily.game.vulkan.pipeline;

import org.lwjgl.vulkan.VkPipelineDynamicStateCreateInfo;

public interface IDynamicState
{
	VkPipelineDynamicStateCreateInfo allocDynamicStateCreateInfo();
	void freeDynamicStateCreateInfo();
	void free();
}
