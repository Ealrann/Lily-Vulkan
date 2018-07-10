package org.sheepy.vulkan.command.graphic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.command.AbstractCommandBuffers;
import org.sheepy.vulkan.command.CommandPool;
import org.sheepy.vulkan.pipeline.swap.AbstractSwapPipeline;
import org.sheepy.vulkan.pipeline.swap.Framebuffers;
import org.sheepy.vulkan.pipeline.swap.IRenderPass;
import org.sheepy.vulkan.pipeline.swap.SwapConfiguration;
import org.sheepy.vulkan.swapchain.SwapChainManager;

public class GraphicCommandBuffers extends AbstractCommandBuffers<GraphicCommandBuffer>
{
	private SwapConfiguration configuration;
	private AbstractSwapPipeline swapPipeline;

	public GraphicCommandBuffers(CommandPool commandPool, SwapConfiguration configuration,
			AbstractSwapPipeline swapPipeline)
	{
		super(commandPool);
		this.configuration = configuration;
		this.swapPipeline = swapPipeline;
	}

	@Override
	protected List<GraphicCommandBuffer> allocCommandBuffers(MemoryStack stack)
	{
		Framebuffers framebuffers = swapPipeline.getFramebuffers();
		SwapChainManager swapChain = swapPipeline.getSwapChain();
		IRenderPass renderPass = swapPipeline.getRenderPass();

		long commandPoolId = commandPool.getId();

		// Command Pool Buffers
		// ------------------
		long[] commandBufferIds = allocCommandBuffers(commandPoolId, framebuffers.size());

		List<GraphicCommandBuffer> commandBuffers = new ArrayList<>();
		for (int i = 0; i < framebuffers.getIDs().size(); i++)
		{
			Long framebufferId = framebuffers.getIDs().get(i);
			long commandBufferId = commandBufferIds[i];

			if (configuration.renderPipeline == true)
			{
				commandBuffers.add(new RenderCommandBuffer(logicalDevice, commandBufferId,
						configuration, framebufferId, swapChain.getExtent(), renderPass));
			}
			else
			{
				commandBuffers.add(new GraphicCommandBuffer(logicalDevice, commandBufferId));
			}
		}

		return Collections.unmodifiableList(commandBuffers);
	}
}
