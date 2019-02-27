package org.sheepy.lily.vulkan.common.concurrent;

import static org.lwjgl.vulkan.VK10.*;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkSemaphoreCreateInfo;
import org.sheepy.lily.vulkan.common.allocation.IAllocable;
import org.sheepy.lily.vulkan.common.device.LogicalDevice;
import org.sheepy.lily.vulkan.common.execution.ExecutionContext;
import org.sheepy.lily.vulkan.common.execution.SingleTimeCommand;

public class VkSemaphore implements IAllocable
{
	private long semaphoreId = 0;
	private final LogicalDevice logicalDevice;

	public VkSemaphore(LogicalDevice logicalDevice)
	{
		this.logicalDevice = logicalDevice;
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		VkSemaphoreCreateInfo semaphoreInfo = VkSemaphoreCreateInfo.calloc();
		semaphoreInfo.sType(VK_STRUCTURE_TYPE_SEMAPHORE_CREATE_INFO);

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

	public void signalSemaphore(ExecutionContext executionManager)
	{
		if (semaphoreId == 0)
		{
			throw new AssertionError("");
		}

		SingleTimeCommand stc = new SingleTimeCommand(executionManager, List.of(this))
		{
			@Override
			protected void doExecute(MemoryStack stack, VkCommandBuffer commandBuffer)
			{}
		};

		stc.execute();
	}

	@Override
	public void free()
	{
		vkDestroySemaphore(logicalDevice.getVkDevice(), semaphoreId, null);
		semaphoreId = -1;
	}

	@Override
	public boolean isAllocationDirty()
	{
		return false;
	}
}
