package org.sheepy.lily.game.vulkan.command;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkCommandBufferAllocateInfo;
import org.lwjgl.vulkan.VkCommandBufferBeginInfo;
import org.lwjgl.vulkan.VkQueue;
import org.lwjgl.vulkan.VkSubmitInfo;

public class SingleTimeCommand extends AbstractCommandBuffer
{
	private CommandPool commandPool;
	private VkQueue queue;

	public static SingleTimeCommand alloc(CommandPool commandPool, VkQueue queue)
	{
		VkCommandBufferAllocateInfo allocInfo = VkCommandBufferAllocateInfo.calloc();
		allocInfo.sType(VK_STRUCTURE_TYPE_COMMAND_BUFFER_ALLOCATE_INFO);
		allocInfo.level(VK_COMMAND_BUFFER_LEVEL_PRIMARY);
		allocInfo.commandPool(commandPool.getId());
		allocInfo.commandBufferCount(1);

		PointerBuffer pCommandBuffer = MemoryUtil.memAllocPointer(1);
		vkAllocateCommandBuffers(commandPool.getLogicalDevice().getVkDevice(), allocInfo,
				pCommandBuffer);
		long commandBufferId = pCommandBuffer.get(0);

		SingleTimeCommand res = new SingleTimeCommand(commandPool, queue, commandBufferId);
		
		pCommandBuffer.free();
		allocInfo.free();
		
		return res;
	}

	private SingleTimeCommand(CommandPool commandPool, VkQueue queue, long commandBufferId)
	{
		super(commandPool.getLogicalDevice(), commandBufferId);

		this.commandPool = commandPool;
		this.queue = queue;
	}

	@Override
	public VkCommandBuffer start()
	{
		VkCommandBufferBeginInfo beginInfo = VkCommandBufferBeginInfo.calloc();
		beginInfo.sType(VK_STRUCTURE_TYPE_COMMAND_BUFFER_BEGIN_INFO);
		beginInfo.flags(VK_COMMAND_BUFFER_USAGE_ONE_TIME_SUBMIT_BIT);

		vkBeginCommandBuffer(vkCommandBuffer, beginInfo);

		beginInfo.free();

		return vkCommandBuffer;
	}

	@Override
	public void end()
	{
		vkEndCommandBuffer(vkCommandBuffer);

		PointerBuffer pCommandBuffer = MemoryUtil.memAllocPointer(1);
		pCommandBuffer.put(vkCommandBuffer.address());
		pCommandBuffer.flip();

		VkSubmitInfo submitInfo = VkSubmitInfo.calloc();
		submitInfo.sType(VK_STRUCTURE_TYPE_SUBMIT_INFO);
		submitInfo.pCommandBuffers(pCommandBuffer);

		vkQueueSubmit(queue, submitInfo, VK_NULL_HANDLE);
		vkQueueWaitIdle(queue);

		vkFreeCommandBuffers(commandPool.getLogicalDevice().getVkDevice(), commandPool.getId(),
				pCommandBuffer);
		pCommandBuffer.free();

		submitInfo.free();
	}

}
