package org.sheepy.lily.vulkan.common.concurrent;

import static org.lwjgl.vulkan.VK10.*;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkSemaphoreCreateInfo;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocable;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;
import org.sheepy.lily.vulkan.common.engine.IVulkanContext;
import org.sheepy.lily.vulkan.common.execution.ExecutionContext;
import org.sheepy.lily.vulkan.common.execution.ISingleTimeCommand;

public class VkSemaphore implements IAllocable
{
	private long semaphoreId = 0;

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		final var logicalDevice = ((IVulkanContext) context).getLogicalDevice();
		VkSemaphoreCreateInfo semaphoreInfo = VkSemaphoreCreateInfo.calloc();
		semaphoreInfo.sType(VK_STRUCTURE_TYPE_SEMAPHORE_CREATE_INFO);
		semaphoreInfo.pNext(VK_NULL_HANDLE);
		semaphoreInfo.flags(0);

		long[] aSemaphore = new long[1];
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

	public void signalSemaphore(ExecutionContext executionContext)
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
