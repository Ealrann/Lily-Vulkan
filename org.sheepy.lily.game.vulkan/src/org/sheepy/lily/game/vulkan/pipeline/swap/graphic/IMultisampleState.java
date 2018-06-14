package org.sheepy.lily.game.vulkan.pipeline.swap.graphic;

import org.lwjgl.vulkan.VkPipelineMultisampleStateCreateInfo;

public interface IMultisampleState
{
	VkPipelineMultisampleStateCreateInfo allocMultisampleStateCreateInfo();
	void freeMultisampleStateCreateInfo();
	void free();
}
