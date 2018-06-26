package org.sheepy.lily.game.vulkan.pipeline.swap;

import java.util.List;

import org.sheepy.lily.game.vulkan.command.AbstractCommandBuffer;
import org.sheepy.lily.game.vulkan.swapchain.SwapChainManager;

public interface IRenderPass
{

	void load(SwapChainManager swapChainManager);

	long getId();

	void free();

	void buildRenderPass(List<? extends AbstractCommandBuffer> commandBuffers);

}
