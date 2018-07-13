package org.sheepy.vulkan.pipeline.swap.graphic;

import org.lwjgl.vulkan.VkPipelineMultisampleStateCreateInfo;

public interface IMultisampleState
{
	VkPipelineMultisampleStateCreateInfo allocMultisampleStateCreateInfo();
	void freeMultisampleStateCreateInfo();
	void free();
}
