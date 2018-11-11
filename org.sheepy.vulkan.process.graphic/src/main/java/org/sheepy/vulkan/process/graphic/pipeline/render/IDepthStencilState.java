package org.sheepy.vulkan.process.graphic.pipeline.render;

import org.lwjgl.vulkan.VkPipelineDepthStencilStateCreateInfo;

public interface IDepthStencilState
{
	VkPipelineDepthStencilStateCreateInfo allocCreateInfo();
	void freeDepthStencilStateCreateInfo();
	void free();
}
