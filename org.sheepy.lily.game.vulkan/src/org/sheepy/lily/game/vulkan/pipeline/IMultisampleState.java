package org.sheepy.lily.game.vulkan.pipeline;

import org.lwjgl.vulkan.VkPipelineMultisampleStateCreateInfo;

public interface IMultisampleState
{
	VkPipelineMultisampleStateCreateInfo allocMultisampleStateCreateInfo();
	void freeMultisampleStateCreateInfo();
	void free();
}
