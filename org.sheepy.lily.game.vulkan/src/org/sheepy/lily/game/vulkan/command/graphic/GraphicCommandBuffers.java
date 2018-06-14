package org.sheepy.lily.game.vulkan.command.graphic;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.game.vulkan.buffer.IndexBuffer;
import org.sheepy.lily.game.vulkan.command.AbstractCommandBuffers;
import org.sheepy.lily.game.vulkan.command.CommandPool;
import org.sheepy.lily.game.vulkan.descriptor.DescriptorPool;
import org.sheepy.lily.game.vulkan.descriptor.DescriptorSet;
import org.sheepy.lily.game.vulkan.framebuffer.Framebuffers;
import org.sheepy.lily.game.vulkan.pipeline.GraphicPipeline;
import org.sheepy.lily.game.vulkan.pipeline.RenderPass;
import org.sheepy.lily.game.vulkan.swapchain.SwapChainManager;
import org.sheepy.lily.game.vulkan.swappipeline.SwapConfiguration;
import org.sheepy.lily.game.vulkan.swappipeline.SwapPipeline;

public class GraphicCommandBuffers extends AbstractCommandBuffers<RenderCommandBuffer>
{
	private SwapConfiguration configuration;
	private SwapPipeline swapPipeline;
	private IndexBuffer indexBuffer;

	public GraphicCommandBuffers(CommandPool commandPool, SwapConfiguration configuration,
			SwapPipeline swapPipeline, IndexBuffer indexBuffer)
	{
		super(commandPool);
		this.configuration = configuration;
		this.swapPipeline = swapPipeline;
		this.indexBuffer = indexBuffer;
	}

	@Override
	protected List<RenderCommandBuffer> allocCommandBuffers()
	{
		Framebuffers framebuffers = swapPipeline.getFramebuffers();
		SwapChainManager swapChain = swapPipeline.getSwapChain();
		RenderPass renderPass = swapPipeline.getRenderPass();
		DescriptorPool descriptorPool = swapPipeline.getDescriptorPool();
		GraphicPipeline graphicsPipeline = swapPipeline.getGraphicPipeline();

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

		commandBuffers = Collections.unmodifiableList(commandBuffers);
		
		rebuildRenderPass(commandBuffers, renderPass, graphicsPipeline, indexBuffer,
				descriptorPool);

		return commandBuffers;
	}

	private void rebuildRenderPass(List<RenderCommandBuffer> commandBuffers,
			RenderPass renderPass,
			GraphicPipeline graphicsPipeline,
			IndexBuffer indexBuffer,
			DescriptorPool descriptorPool)
	{
		long[] vertexBuffers = {
				indexBuffer.getBufferId()
		};
		long[] offsets = {
				0
		};

		for (RenderCommandBuffer commandBuffer : commandBuffers)
		{
			commandBuffer.start();

			vkCmdBindPipeline(commandBuffer.getVkCommandBuffer(), VK_PIPELINE_BIND_POINT_GRAPHICS,
					graphicsPipeline.getId());
			vkCmdBindVertexBuffers(commandBuffer.getVkCommandBuffer(), 0, vertexBuffers, offsets);
			vkCmdBindIndexBuffer(commandBuffer.getVkCommandBuffer(), indexBuffer.getIndexBufferId(),
					0, VK_INDEX_TYPE_UINT32);

			if (descriptorPool != null)
			{
				LongBuffer bDescriptorSet = MemoryUtil.memAllocLong(descriptorPool.getSize());
				for (DescriptorSet descriptorSet : descriptorPool)
				{
					bDescriptorSet.put(descriptorSet.getId());
				}
				bDescriptorSet.flip();
				vkCmdBindDescriptorSets(commandBuffer.getVkCommandBuffer(),
						VK_PIPELINE_BIND_POINT_GRAPHICS, graphicsPipeline.getLayoutId(), 0,
						bDescriptorSet, null);
			}

			vkCmdDrawIndexed(commandBuffer.getVkCommandBuffer(), indexBuffer.indexCount(), 1, 0, 0,
					0);

			commandBuffer.end();
		}
	}
}
