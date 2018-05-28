package org.sheepy.lily.game.vulkan.pipeline.impl;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_PIPELINE_VIEWPORT_STATE_CREATE_INFO;

import org.lwjgl.vulkan.VkPipelineViewportStateCreateInfo;
import org.lwjgl.vulkan.VkRect2D;
import org.lwjgl.vulkan.VkViewport;
import org.sheepy.lily.game.vulkan.pipeline.IViewportState;
import org.sheepy.lily.game.vulkan.swapchain.SwapChainManager;
import org.sheepy.lily.game.vulkan.swapchain.SwapChainManager.Extent2D;

public class BasicViewportState implements IViewportState
{

	private VkPipelineViewportStateCreateInfo viewportState;
	private VkViewport.Buffer viewport;
	private VkRect2D.Buffer scissor;

	@Override
	public VkPipelineViewportStateCreateInfo allocViewportStateCreateInfo(SwapChainManager swapChainManager)
	{
		// Viewports and scissors
		Extent2D extent = swapChainManager.getExtent();
		viewport = VkViewport.calloc(1);
		viewport.x(0.0f);
		viewport.y(0.0f);
		viewport.width(extent.getWidth());
		viewport.height(extent.getHeight());
		viewport.minDepth(0.0f);
		viewport.maxDepth(1.0f);

		scissor = VkRect2D.calloc(1);
		scissor.offset().set(0, 0);
		scissor.extent().set(extent.getWidth(), extent.getHeight());

		viewportState = VkPipelineViewportStateCreateInfo.calloc();
		viewportState.sType(VK_STRUCTURE_TYPE_PIPELINE_VIEWPORT_STATE_CREATE_INFO);
		viewportState.pViewports(viewport);
		viewportState.pScissors(scissor);

		return viewportState;
	}

	@Override
	public void freeViewportStateCreateInfo()
	{
		viewportState.free();
		scissor.free();
		viewport.free();
	}

	@Override
	public void free()
	{
	}

}
