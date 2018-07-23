package org.sheepy.vulkan.pipeline.graphic.render;

import org.lwjgl.vulkan.VkPipelineDepthStencilStateCreateInfo;

public interface IDepthStencilState
{
	VkPipelineDepthStencilStateCreateInfo allocDepthStencilStateCreateInfo();
	void freeDepthStencilStateCreateInfo();
	void free();
}
