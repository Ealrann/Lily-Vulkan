package org.sheepy.lily.game.vulkan.pipeline.swap;

import org.sheepy.lily.game.vulkan.swapchain.SwapChainManager;

public interface IGraphicsPipeline
{
	long getId();
	long getLayoutId();
	void free();
	void load(SwapChainManager swapChainManager, IRenderPass renderPass);
}
