package org.sheepy.lily.vulkan.common.concurrent;

import static org.lwjgl.vulkan.VK10.*;

import java.util.List;

import org.lwjgl.vulkan.VkSemaphoreCreateInfo;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.api.concurrent.ISemaphore;
import org.sheepy.lily.vulkan.common.device.InternalVulkanContext;
import org.sheepy.lily.vulkan.common.execution.InternalExecutionContext;

public class VkSemaphore implements ISemaphore, IAllocable<InternalVulkanContext>
{
	private long semaphorePtr = VK_NULL_HANDLE;

	@Override
	public void allocate(InternalVulkanContext context)
	{
		final var logicalDevice = context.getLogicalDevice();
		final VkSemaphoreCreateInfo semaphoreInfo = VkSemaphoreCreateInfo.calloc();
		semaphoreInfo.sType(VK_STRUCTURE_TYPE_SEMAPHORE_CREATE_INFO);
		semaphoreInfo.pNext(VK_NULL_HANDLE);
		semaphoreInfo.flags(0);

		final long[] aSemaphore = new long[1];
		if (vkCreateSemaphore(	logicalDevice.getVkDevice(),
								semaphoreInfo,
								null,
								aSemaphore) != VK_SUCCESS)
		{
			throw new AssertionError("Failed to create semaphores");
		}

		semaphorePtr = aSemaphore[0];
		semaphoreInfo.free();
	}

	public long getPtr()
	{
		return semaphorePtr;
	}

	public void signalSemaphore(InternalExecutionContext executionContext)
	{
		if (semaphorePtr == VK_NULL_HANDLE)
		{
			throw new AssertionError("Unallocated Semaphore");
		}

		executionContext.execute(List.of(this), (s, c) ->
		{});
	}

	@Override
	public void free(InternalVulkanContext context)
	{
		final var logicalDevice = context.getLogicalDevice();
		vkDestroySemaphore(logicalDevice.getVkDevice(), semaphorePtr, null);
		semaphorePtr = VK_NULL_HANDLE;
	}
}
