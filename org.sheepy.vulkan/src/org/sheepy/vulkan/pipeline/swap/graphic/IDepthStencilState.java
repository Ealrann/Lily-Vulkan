package org.sheepy.vulkan.pipeline.swap.graphic;

import org.lwjgl.vulkan.VkPipelineDepthStencilStateCreateInfo;

public interface IDepthStencilState
{
	VkPipelineDepthStencilStateCreateInfo allocDepthStencilStateCreateInfo();
	void freeDepthStencilStateCreateInfo();
	void free();
}
