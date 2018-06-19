package org.sheepy.lily.game.vulkan.command.graphic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.sheepy.lily.game.vulkan.command.AbstractCommandBuffers;
import org.sheepy.lily.game.vulkan.command.CommandPool;
import org.sheepy.lily.game.vulkan.pipeline.swap.Framebuffers;
import org.sheepy.lily.game.vulkan.pipeline.swap.RenderPass;
import org.sheepy.lily.game.vulkan.pipeline.swap.SwapConfiguration;
import org.sheepy.lily.game.vulkan.pipeline.swap.SwapPipeline;
import org.sheepy.lily.game.vulkan.swapchain.SwapChainManager;

public class GraphicCommandBuffers extends AbstractCommandBuffers<RenderCommandBuffer>
{
	private SwapConfiguration configuration;
	private SwapPipeline swapPipeline;

	public GraphicCommandBuffers(CommandPool commandPool, SwapConfiguration configuration,
			SwapPipeline swapPipeline)
	{
		super(commandPool);
		this.configuration = configuration;
		this.swapPipeline = swapPipeline;
	}

	@Override
	protected List<RenderCommandBuffer> allocCommandBuffers()
	{
		Framebuffers framebuffers = swapPipeline.getFramebuffers();
		SwapChainManager swapChain = swapPipeline.getSwapChain();
		RenderPass renderPass = swapPipeline.getRenderPass();

		long commandPoolId = commandPool.getId();

		// Command Pool Buffers
		// ------------------
		long[] commandBufferIds = allocCommandBuffers(commandPoolId, framebuffers.size());

		List<RenderCommandBuffer> commandBuffers = new ArrayList<>();
		for (int i = 0; i < framebuffers.getIDs().size(); i++)
		{
			Long framebufferId = framebuffers.getIDs().get(i);
			long commandBufferId = commandBufferIds[i];
			commandBuffers.add(new RenderCommandBuffer(logicalDevice, commandBufferId,
					configuration, framebufferId, swapChain.getExtent(), renderPass));
		}

		return Collections.unmodifiableList(commandBuffers);
	}
}
