package org.sheepy.vulkan.process.graphic.pipeline.render;

import org.lwjgl.vulkan.VkPipelineDynamicStateCreateInfo;

public interface IDynamicState
{
	VkPipelineDynamicStateCreateInfo allocDynamicStateCreateInfo();
	void freeDynamicStateCreateInfo();
	void free();
}
