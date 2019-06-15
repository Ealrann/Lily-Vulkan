package org.sheepy.vulkan.concurrent;

import static org.lwjgl.vulkan.VK10.*;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkSemaphoreCreateInfo;
import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.device.IVulkanContext;
import org.sheepy.vulkan.execution.IExecutionContext;

public class VkSemaphore implements IAllocable<IVulkanContext>
{
	private long semaphorePtr = VK_NULL_HANDLE;

	@Override
	public void allocate(MemoryStack stack, IVulkanContext context)
	{
		final var logicalDevice = context.getLogicalDevice();
		final VkSemaphoreCreateInfo semaphoreInfo = VkSemaphoreCreateInfo.calloc();
		semaphoreInfo.sType(VK_STRUCTURE_TYPE_SEMAPHORE_CREATE_INFO);
		semaphoreInfo.pNext(VK_NULL_HANDLE);
		semaphoreInfo.flags(0);

		final long[] aSemaphore = new long[1];
		if (vkCreateSemaphore(logicalDevice.getVkDevice(), semaphoreInfo, null,
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

	public void signalSemaphore(IExecutionContext executionContext)
	{
		if (semaphorePtr == VK_NULL_HANDLE)
		{
			throw new AssertionError("Unallocated Semaphore");
		}

		try (MemoryStack stack = MemoryStack.stackPush())
		{
			executionContext.execute(stack, List.of(this), (s, c) -> {});
		}
	}

	@Override
	public void free(IVulkanContext context)
	{
		final var logicalDevice = context.getLogicalDevice();
		vkDestroySemaphore(logicalDevice.getVkDevice(), semaphorePtr, null);
		semaphorePtr = VK_NULL_HANDLE;
	}

	@Override
	public boolean isAllocationDirty(IVulkanContext context)
	{
		return false;
	}
}
