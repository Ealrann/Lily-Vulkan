package org.sheepy.lily.game.vulkan.pipeline;

import org.lwjgl.vulkan.VkPipelineDepthStencilStateCreateInfo;

public interface IDepthStencilState
{
	VkPipelineDepthStencilStateCreateInfo allocDepthStencilStateCreateInfo();
	void freeDepthStencilStateCreateInfo();
	void free();
}
