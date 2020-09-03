package org.sheepy.lily.vulkan.core.concurrent;

import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkSemaphoreCreateInfo;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.api.concurrent.ISemaphore;
import org.sheepy.lily.vulkan.core.debug.VulkanDebugService;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;

import java.util.List;

import static org.lwjgl.vulkan.VK10.*;

public class VkSemaphore implements ISemaphore
{
	private final long semaphorePtr;

	public VkSemaphore(VkDevice vkDdevice, String name)
	{
		final VkSemaphoreCreateInfo semaphoreInfo = VkSemaphoreCreateInfo.calloc();
		semaphoreInfo.sType(VK_STRUCTURE_TYPE_SEMAPHORE_CREATE_INFO);
		semaphoreInfo.pNext(VK_NULL_HANDLE);
		semaphoreInfo.flags(0);

		final long[] aSemaphore = new long[1];
		if (vkCreateSemaphore(vkDdevice, semaphoreInfo, null, aSemaphore) != VK_SUCCESS)
		{
			throw new AssertionError("Failed to create semaphores");
		}

		semaphorePtr = aSemaphore[0];
		if (DebugUtil.DEBUG_ENABLED) VulkanDebugService.INSTANCE.register(semaphorePtr, name);
		semaphoreInfo.free();
	}

	public long getPtr()
	{
		return semaphorePtr;
	}

	public void signalSemaphore(ExecutionContext executionContext)
	{
		if (semaphorePtr == VK_NULL_HANDLE)
		{
			throw new AssertionError("Unallocated Semaphore");
		}

		executionContext.executeCommand(List.of(this), (c) -> {
		});
	}

	public void free(VkDevice vkDdevice)
	{
		vkDestroySemaphore(vkDdevice, semaphorePtr, null);
		if (DebugUtil.DEBUG_ENABLED) VulkanDebugService.INSTANCE.remove(semaphorePtr);
	}
}
