package org.sheepy.vulkan.pipeline.graphic.render;

import org.lwjgl.vulkan.VkPipelineDynamicStateCreateInfo;

public interface IDynamicState
{
	VkPipelineDynamicStateCreateInfo allocDynamicStateCreateInfo();
	void freeDynamicStateCreateInfo();
	void free();
}
