package org.sheepy.vulkan.concurrent;

import static org.lwjgl.vulkan.VK10.*;

import java.util.Collections;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkQueue;
import org.lwjgl.vulkan.VkSemaphoreCreateInfo;
import org.sheepy.vulkan.command.CommandPool;
import org.sheepy.vulkan.command.SingleTimeCommand;
import org.sheepy.vulkan.device.LogicalDevice;

public class VkSemaphore
{
	private LogicalDevice logicalDevice;

	private long semaphoreId;

	public VkSemaphore(LogicalDevice logicalDevice)
	{
		this.logicalDevice = logicalDevice;

		load();
	}

	private void load()
	{
		VkSemaphoreCreateInfo semaphoreInfo = VkSemaphoreCreateInfo.calloc();
		semaphoreInfo.sType(VK_STRUCTURE_TYPE_SEMAPHORE_CREATE_INFO);

		long[] aSemaphore = new long[1];
		if (vkCreateSemaphore(logicalDevice.getVkDevice(), semaphoreInfo, null,
				aSemaphore) != VK_SUCCESS)
		{
			throw new AssertionError("failed to create semaphores!");
		}

		semaphoreId = aSemaphore[0];

		semaphoreInfo.free();
	}

	public long getId()
	{
		return semaphoreId;
	}

	public void signalSemaphore(CommandPool commandPool, VkQueue queue)
	{
		SingleTimeCommand stc = new SingleTimeCommand(commandPool, queue, Collections.singletonList(this))
		{
			@Override
			protected void doExecute(MemoryStack stack, VkCommandBuffer commandBuffer)
			{}
		};
		
		stc.execute();
	}

	public void free()
	{
		vkDestroySemaphore(logicalDevice.getVkDevice(), semaphoreId, null);
	}
}
