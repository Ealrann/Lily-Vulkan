package org.sheepy.vulkan.command.graphic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.command.AbstractCommandBuffers;
import org.sheepy.vulkan.command.CommandPool;
import org.sheepy.vulkan.pipeline.swap.Framebuffers;
import org.sheepy.vulkan.pipeline.swap.IRenderPass;
import org.sheepy.vulkan.pipeline.swap.SwapConfiguration;
import org.sheepy.vulkan.swapchain.SwapChainManager;

public class GraphicCommandBuffers extends AbstractCommandBuffers<RenderCommandBuffer>
{
	private SwapConfiguration configuration;

	public GraphicCommandBuffers(CommandPool commandPool, SwapConfiguration configuration
			)
	{
		super(commandPool);
		this.configuration = configuration;
	}

	@Override
	protected List<RenderCommandBuffer> allocCommandBuffers(MemoryStack stack)
	{
		Framebuffers framebuffers = configuration.framebuffers;
		SwapChainManager swapChain = configuration.swapChainManager;
		IRenderPass renderPass = configuration.renderPass;

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
