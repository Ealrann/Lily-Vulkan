package org.sheepy.lily.game.vulkan.command;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkCommandBufferAllocateInfo;
import org.lwjgl.vulkan.VkCommandBufferBeginInfo;
import org.lwjgl.vulkan.VkQueue;
import org.lwjgl.vulkan.VkSubmitInfo;

public class SingleTimeCommands
{
	private CommandPool commandPool;
	
	private VkCommandBuffer commandBuffer;
	private PointerBuffer pCommandBuffer;

	public SingleTimeCommands(CommandPool commandPool)
	{
		this.commandPool = commandPool;
	}

	public VkCommandBuffer startRecording()
	{
		VkCommandBufferAllocateInfo allocInfo = VkCommandBufferAllocateInfo.calloc();
		allocInfo.sType(VK_STRUCTURE_TYPE_COMMAND_BUFFER_ALLOCATE_INFO);
		allocInfo.level(VK_COMMAND_BUFFER_LEVEL_PRIMARY);
		allocInfo.commandPool(commandPool.getId());
		allocInfo.commandBufferCount(1);

		pCommandBuffer = MemoryUtil.memAllocPointer(1);
		vkAllocateCommandBuffers(commandPool.getLogicalDevice().getVkDevice(), allocInfo, pCommandBuffer);
		commandBuffer = new VkCommandBuffer(pCommandBuffer.get(0),
				commandPool.getLogicalDevice().getVkDevice());

		VkCommandBufferBeginInfo beginInfo = VkCommandBufferBeginInfo.calloc();
		beginInfo.sType(VK_STRUCTURE_TYPE_COMMAND_BUFFER_BEGIN_INFO);
		beginInfo.flags(VK_COMMAND_BUFFER_USAGE_ONE_TIME_SUBMIT_BIT);

		vkBeginCommandBuffer(commandBuffer, beginInfo);

		return commandBuffer;
	}

	public void submitCommands(VkQueue queue) {
	    vkEndCommandBuffer(commandBuffer);

	    VkSubmitInfo submitInfo = VkSubmitInfo.calloc();
	    submitInfo.sType(VK_STRUCTURE_TYPE_SUBMIT_INFO);
	    submitInfo.pCommandBuffers(pCommandBuffer);

	    vkQueueSubmit(queue, submitInfo, VK_NULL_HANDLE);
	    vkQueueWaitIdle(queue);

	    vkFreeCommandBuffers(commandPool.getLogicalDevice().getVkDevice(), commandPool.getId(), pCommandBuffer);
	    pCommandBuffer.free();
	}
}
