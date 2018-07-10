package org.sheepy.vulkan.pipeline.swap;

import java.util.List;

import org.sheepy.vulkan.command.AbstractCommandBuffer;
import org.sheepy.vulkan.swapchain.SwapChainManager;

public interface IRenderPass
{

	void load(SwapChainManager swapChainManager);

	long getId();

	void free();

	void buildRenderPass(List<? extends AbstractCommandBuffer> commandBuffers);

}
