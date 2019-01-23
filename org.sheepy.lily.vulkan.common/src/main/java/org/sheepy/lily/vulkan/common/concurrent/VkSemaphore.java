package org.sheepy.lily.vulkan.common.concurrent;

import static org.lwjgl.vulkan.VK10.*;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkSemaphoreCreateInfo;
import org.sheepy.lily.vulkan.common.device.LogicalDevice;
import org.sheepy.lily.vulkan.common.execution.ExecutionManager;
import org.sheepy.lily.vulkan.common.execution.SingleTimeCommand;

public class VkSemaphore
{
	private long semaphoreId = 0;

	public void allocate(LogicalDevice logicalDevice)
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

	public void signalSemaphore(ExecutionManager executionManager)
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

	public void free(LogicalDevice logicalDevice)
	{
		vkDestroySemaphore(logicalDevice.getVkDevice(), semaphoreId, null);
		semaphoreId = -1;
	}
}
