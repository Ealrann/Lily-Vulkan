package org.sheepy.vulkan.pipeline.swap.graphic;

import org.lwjgl.vulkan.VkPipelineViewportStateCreateInfo;
import org.sheepy.vulkan.swapchain.SwapChainManager;

public interface IViewportState
{
	VkPipelineViewportStateCreateInfo allocViewportStateCreateInfo(SwapChainManager swapChainManager);
	void freeViewportStateCreateInfo();
	void free();
}
