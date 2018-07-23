package org.sheepy.vulkan.pipeline.graphic.render;

import org.lwjgl.vulkan.VkPipelineMultisampleStateCreateInfo;

public interface IMultisampleState
{
	VkPipelineMultisampleStateCreateInfo allocMultisampleStateCreateInfo();
	void freeMultisampleStateCreateInfo();
	void free();
}
