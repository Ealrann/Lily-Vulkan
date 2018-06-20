package org.sheepy.lily.game.vulkan.pipeline.swap;

import org.sheepy.lily.game.vulkan.swapchain.SwapChainManager;

public interface IRenderPass
{

	void load(SwapChainManager swapChainManager);

	long getID();

	void free();

}
