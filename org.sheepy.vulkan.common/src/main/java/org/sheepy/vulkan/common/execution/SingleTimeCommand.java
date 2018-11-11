package org.sheepy.vulkan.common.execution;

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
import org.lwjgl.vulkan.VkSubmitInfo;
import org.sheepy.vulkan.common.concurrent.VkSemaphore;

public abstract class SingleTimeCommand extends AbstractCommandBuffer
{
	protected final ExecutionManager executionManager;
	private List<VkSemaphore> semaphoreToSignal = null;

	public SingleTimeCommand(ExecutionManager executionManager, long commandBufferId)
	{
		this(executionManager, commandBufferId, null);
	}

	public SingleTimeCommand(ExecutionManager executionManager)
	{
		this(executionManager, allocCommandBufferId(executionManager), null);
	}

	public SingleTimeCommand(	ExecutionManager executionManager,
								Collection<VkSemaphore> semaphoreToSignal)
	{
		this(executionManager, allocCommandBufferId(executionManager), semaphoreToSignal);
	}

	public SingleTimeCommand(	ExecutionManager executionManager,
								long commandBufferId,
								Collection<VkSemaphore> semaphoreToSignal)
	{
		super(executionManager.logicalDevice, commandBufferId);

		this.executionManager = executionManager;
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

	private static long allocCommandBufferId(ExecutionManager executionManager)
	{
		final VkCommandBufferAllocateInfo allocInfo = VkCommandBufferAllocateInfo.calloc();
		allocInfo.sType(VK_STRUCTURE_TYPE_COMMAND_BUFFER_ALLOCATE_INFO);
		allocInfo.level(VK_COMMAND_BUFFER_LEVEL_PRIMARY);
		allocInfo.commandPool(executionManager.commandPool.getId());
		allocInfo.commandBufferCount(1);

		final PointerBuffer pCommandBuffer = MemoryUtil.memAllocPointer(1);
		vkAllocateCommandBuffers(executionManager.getVkDevice(), allocInfo, pCommandBuffer);
		final long commandBufferId = pCommandBuffer.get(0);

		pCommandBuffer.free();
		allocInfo.free();
		return commandBufferId;
	}

	@Override
	public void start()
	{
		final VkCommandBufferBeginInfo beginInfo = VkCommandBufferBeginInfo.calloc();
		beginInfo.sType(VK_STRUCTURE_TYPE_COMMAND_BUFFER_BEGIN_INFO);
		beginInfo.flags(VK_COMMAND_BUFFER_USAGE_ONE_TIME_SUBMIT_BIT);

		vkBeginCommandBuffer(vkCommandBuffer, beginInfo);

		beginInfo.free();
	}

	@Override
	public void end()
	{
		vkEndCommandBuffer(vkCommandBuffer);

		final PointerBuffer pCommandBuffer = MemoryUtil.memAllocPointer(1);
		pCommandBuffer.put(vkCommandBuffer.address());
		pCommandBuffer.flip();

		LongBuffer lBuffer = null;
		if (semaphoreToSignal != null)
		{
			lBuffer = MemoryUtil.memAllocLong(semaphoreToSignal.size());
			for (final VkSemaphore vkSemaphore : semaphoreToSignal)
			{
				lBuffer.put(vkSemaphore.getId());
			}
			lBuffer.flip();
		}

		final VkSubmitInfo submitInfo = VkSubmitInfo.calloc();
		submitInfo.sType(VK_STRUCTURE_TYPE_SUBMIT_INFO);
		submitInfo.pCommandBuffers(pCommandBuffer);
		submitInfo.pSignalSemaphores(lBuffer);

		vkQueueSubmit(executionManager.getQueue().vkQueue, submitInfo, VK_NULL_HANDLE);
		vkQueueWaitIdle(executionManager.getQueue().vkQueue);

		vkFreeCommandBuffers(executionManager.getVkDevice(), executionManager.commandPool.getId(),
				pCommandBuffer);
		pCommandBuffer.free();

		submitInfo.free();
		if (lBuffer != null) MemoryUtil.memFree(lBuffer);
	}

	protected abstract void doExecute(MemoryStack stack, VkCommandBuffer commandBuffer);

	protected void postExecute()
	{}

}
