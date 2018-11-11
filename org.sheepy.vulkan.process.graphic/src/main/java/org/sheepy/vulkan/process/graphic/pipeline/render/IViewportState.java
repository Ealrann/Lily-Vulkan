package org.sheepy.vulkan.process.graphic.pipeline.render;

import org.lwjgl.vulkan.VkPipelineViewportStateCreateInfo;
import org.sheepy.vulkan.process.graphic.swapchain.SwapChainManager;

public interface IViewportState
{
	VkPipelineViewportStateCreateInfo allocCreateInfo(SwapChainManager swapChainManager);
	void freeViewportStateCreateInfo();
	void free();
}
