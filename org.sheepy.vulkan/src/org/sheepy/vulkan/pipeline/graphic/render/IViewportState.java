package org.sheepy.vulkan.pipeline.graphic.render;

import org.lwjgl.vulkan.VkPipelineViewportStateCreateInfo;
import org.sheepy.vulkan.swapchain.SwapChainManager;

public interface IViewportState
{
	VkPipelineViewportStateCreateInfo allocViewportStateCreateInfo(SwapChainManager swapChainManager);
	void freeViewportStateCreateInfo();
	void free();
}
