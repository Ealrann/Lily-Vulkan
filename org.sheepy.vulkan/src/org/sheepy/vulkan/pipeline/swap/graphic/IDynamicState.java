package org.sheepy.vulkan.pipeline.swap.graphic;

import org.lwjgl.vulkan.VkPipelineDynamicStateCreateInfo;

public interface IDynamicState
{
	VkPipelineDynamicStateCreateInfo allocDynamicStateCreateInfo();
	void freeDynamicStateCreateInfo();
	void free();
}
