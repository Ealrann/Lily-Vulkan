package org.sheepy.lily.vulkan.api.nativehelper.concurrent;

import static org.lwjgl.vulkan.VK10.*;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkSemaphoreCreateInfo;
import org.sheepy.lily.vulkan.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;
import org.sheepy.lily.vulkan.api.execution.IExecutionContext;
import org.sheepy.lily.vulkan.api.execution.ISingleTimeCommand;
import org.sheepy.lily.vulkan.api.process.IVulkanContext;

public class VkSemaphore implements IAllocable
{
	private long semaphoreId = -1;

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		final var logicalDevice = ((IVulkanContext) context).getLogicalDevice();
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

		semaphoreId = aSemaphore[0];
		semaphoreInfo.free();
	}

	public long getId()
	{
		return semaphoreId;
	}

	public void signalSemaphore(IExecutionContext executionContext)
	{
		if (semaphoreId == 0)
		{
			throw new AssertionError("");
		}

		try (MemoryStack stack = MemoryStack.stackPush())
		{
			executionContext.execute(stack, List.of(this), new ISingleTimeCommand()
			{
				@Override
				public void execute(MemoryStack stack, VkCommandBuffer commandBuffer)
				{}
			});
		}
	}

	@Override
	public void free(IAllocationContext context)
	{
		final var logicalDevice = ((IVulkanContext) context).getLogicalDevice();
		vkDestroySemaphore(logicalDevice.getVkDevice(), semaphoreId, null);
		semaphoreId = -1;
	}

	@Override
	public boolean isAllocationDirty(IAllocationContext context)
	{
		return false;
	}
}
