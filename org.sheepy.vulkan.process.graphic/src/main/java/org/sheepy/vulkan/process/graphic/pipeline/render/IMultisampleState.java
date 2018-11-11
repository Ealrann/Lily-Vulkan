package org.sheepy.vulkan.process.graphic.pipeline.render;

import org.lwjgl.vulkan.VkPipelineMultisampleStateCreateInfo;

public interface IMultisampleState
{
	VkPipelineMultisampleStateCreateInfo allocCreateInfo();
	void freeMultisampleStateCreateInfo();
	void free();
}
