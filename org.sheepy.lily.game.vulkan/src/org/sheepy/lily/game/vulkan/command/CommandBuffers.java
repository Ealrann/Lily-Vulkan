package org.sheepy.lily.game.vulkan.command;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkCommandBufferAllocateInfo;
import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.game.vulkan.descriptor.DescriptorPool;
import org.sheepy.lily.game.vulkan.descriptor.DescriptorSet;
import org.sheepy.lily.game.vulkan.framebuffer.Framebuffers;
import org.sheepy.lily.game.vulkan.pipeline.GraphicPipeline;
import org.sheepy.lily.game.vulkan.pipeline.RenderPass;
import org.sheepy.lily.game.vulkan.swapchain.SwapChainManager;
import org.sheepy.lily.game.vulkan.vertex.IndexBuffer;

public class CommandBuffers implements Iterable<CommandBuffer>
{
	private CommandPool commandPool;

	private List<CommandBuffer> commandBuffers;

	public CommandBuffers(CommandPool commandPool)
	{
		this.commandPool = commandPool;
	}

	public void load(SwapChainManager swapChain,
			Framebuffers framebuffers,
			RenderPass renderPass,
			GraphicPipeline graphicsPipeline,
			IndexBuffer indexBuffer,
			DescriptorPool descriptorPool)
	{
		VkDevice logicalDevice = commandPool.getLogicalDevice().getVkDevice();
		long commandPoolId = commandPool.getId();

		// Command Pool Buffers
		// ------------------
		commandBuffers = new ArrayList<>();

		VkCommandBufferAllocateInfo allocInfo = VkCommandBufferAllocateInfo.calloc();
		allocInfo.sType(VK_STRUCTURE_TYPE_COMMAND_BUFFER_ALLOCATE_INFO);
		allocInfo.commandPool(commandPoolId);
		allocInfo.level(VK_COMMAND_BUFFER_LEVEL_PRIMARY);
		allocInfo.commandBufferCount(framebuffers.size());

		PointerBuffer pCommandBuffers = MemoryUtil.memAllocPointer(framebuffers.size());
		if (vkAllocateCommandBuffers(logicalDevice, allocInfo, pCommandBuffers) != VK_SUCCESS)
		{
			throw new AssertionError("Failed to allocate command buffers!");
		}

		for (int i = 0; i < framebuffers.getIDs().size(); i++)
		{
			Long framebufferId = framebuffers.getIDs().get(i);
			long commandBufferId = pCommandBuffers.get(i);
			VkCommandBuffer vkCommandBuffer = new VkCommandBuffer(commandBufferId, logicalDevice);
			commandBuffers
					.add(new CommandBuffer(vkCommandBuffer, framebufferId, swapChain.getExtent()));
		}

		commandBuffers = Collections.unmodifiableList(commandBuffers);

		rebuildRenderPass(renderPass, graphicsPipeline, indexBuffer, descriptorPool);

		pCommandBuffers.free();
	}

	private void rebuildRenderPass(RenderPass renderPass,
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

		for (CommandBuffer commandBuffer : commandBuffers)
		{
			commandBuffer.startRenderpass(renderPass);

			vkCmdBindPipeline(commandBuffer.getVkCommandBuffer(), VK_PIPELINE_BIND_POINT_GRAPHICS,
					graphicsPipeline.getId());
			vkCmdBindVertexBuffers(commandBuffer.getVkCommandBuffer(), 0, vertexBuffers, offsets);
			vkCmdBindIndexBuffer(commandBuffer.getVkCommandBuffer(), indexBuffer.getIndexBufferId(),
					0, VK_INDEX_TYPE_UINT16);

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

			commandBuffer.endRenderPass();
		}
	}

	public List<CommandBuffer> getCommandBuffers()
	{
		return commandBuffers;
	}

	public void free()
	{
		for (CommandBuffer commandBuffer : commandBuffers)
		{
			vkFreeCommandBuffers(commandPool.getLogicalDevice().getVkDevice(), commandPool.getId(),
					commandBuffer.getVkCommandBuffer());
		}

		commandBuffers = null;
	}

	@Override
	public Iterator<CommandBuffer> iterator()
	{
		return commandBuffers.iterator();
	}

	public int size()
	{
		return commandBuffers.size();
	}

	public CommandBuffer get(int index)
	{
		return commandBuffers.get(index);
	}
}
