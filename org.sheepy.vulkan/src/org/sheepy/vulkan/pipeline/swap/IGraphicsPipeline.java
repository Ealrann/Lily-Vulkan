package org.sheepy.vulkan.pipeline.swap;

import org.sheepy.vulkan.swapchain.SwapChainManager;

public interface IGraphicsPipeline
{
	long getId();
	long getLayoutId();
	void free();
	void load(SwapChainManager swapChainManager, IRenderPass renderPass);
}
