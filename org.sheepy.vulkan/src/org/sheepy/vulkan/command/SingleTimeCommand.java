package org.sheepy.vulkan.command;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkCommandBufferAllocateInfo;
import org.lwjgl.vulkan.VkCommandBufferBeginInfo;
import org.lwjgl.vulkan.VkQueue;
import org.lwjgl.vulkan.VkSubmitInfo;
import org.sheepy.vulkan.concurrent.VkSemaphore;

public abstract class SingleTimeCommand extends AbstractCommandBuffer
{
	private final CommandPool commandPool;
	private final VkQueue queue;
	private List<VkSemaphore> semaphoreToSignal = null;

	public SingleTimeCommand(CommandPool commandPool, VkQueue queue, long commandBufferId)
	{
		this(commandPool, queue, commandBufferId, null);
	}

	public SingleTimeCommand(CommandPool commandPool, VkQueue queue)
	{
		this(commandPool, queue, allocCommandBufferId(commandPool), null);
	}

	public SingleTimeCommand(CommandPool commandPool, VkQueue queue, Collection<VkSemaphore> semaphoreToSignal)
	{
		this(commandPool, queue, allocCommandBufferId(commandPool), semaphoreToSignal);
	}

	public SingleTimeCommand(CommandPool commandPool, VkQueue queue, long commandBufferId,
			Collection<VkSemaphore> semaphoreToSignal)
	{
		super(commandPool.getLogicalDevice(), commandBufferId);

		this.commandPool = commandPool;
		this.queue = queue;
		if (semaphoreToSignal != null && semaphoreToSignal.isEmpty() == false)
		{
			this.semaphoreToSignal = new ArrayList<>(semaphoreToSignal);
		}
		else
		{
			this.semaphoreToSignal = null;
		}
	}

	public void execute()
	{
		start();

		try (MemoryStack stack = MemoryStack.stackPush())
		{
			doExecute(stack, vkCommandBuffer);
		}

		end();

		postExecute();
	}

	private static long allocCommandBufferId(CommandPool commandPool)
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

		pCommandBuffer.free();
		allocInfo.free();
		return commandBufferId;
	}

	@Override
	public void start()
	{
		VkCommandBufferBeginInfo beginInfo = VkCommandBufferBeginInfo.calloc();
		beginInfo.sType(VK_STRUCTURE_TYPE_COMMAND_BUFFER_BEGIN_INFO);
		beginInfo.flags(VK_COMMAND_BUFFER_USAGE_ONE_TIME_SUBMIT_BIT);

		vkBeginCommandBuffer(vkCommandBuffer, beginInfo);

		beginInfo.free();
	}

	@Override
	public void end()
	{
		vkEndCommandBuffer(vkCommandBuffer);

		PointerBuffer pCommandBuffer = MemoryUtil.memAllocPointer(1);
		pCommandBuffer.put(vkCommandBuffer.address());
		pCommandBuffer.flip();
		
		LongBuffer lBuffer = null;
		if(semaphoreToSignal != null)
		{
			lBuffer = MemoryUtil.memAllocLong(semaphoreToSignal.size());
			for (VkSemaphore vkSemaphore : semaphoreToSignal)
			{
				lBuffer.put(vkSemaphore.getId());
			}
			lBuffer.flip();
		}

		VkSubmitInfo submitInfo = VkSubmitInfo.calloc();
		submitInfo.sType(VK_STRUCTURE_TYPE_SUBMIT_INFO);
		submitInfo.pCommandBuffers(pCommandBuffer);
		submitInfo.pSignalSemaphores(lBuffer);
		

		vkQueueSubmit(queue, submitInfo, VK_NULL_HANDLE);
		vkQueueWaitIdle(queue);

		vkFreeCommandBuffers(commandPool.getLogicalDevice().getVkDevice(), commandPool.getId(),
				pCommandBuffer);
		pCommandBuffer.free();

		submitInfo.free();
		if(lBuffer != null) MemoryUtil.memFree(lBuffer);
	}

	protected abstract void doExecute(MemoryStack stack, VkCommandBuffer commandBuffer);

	protected void postExecute()
	{}

}
