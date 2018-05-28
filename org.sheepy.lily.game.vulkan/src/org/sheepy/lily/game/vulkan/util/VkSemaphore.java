package org.sheepy.lily.game.vulkan.util;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkSemaphoreCreateInfo;
import org.sheepy.lily.game.vulkan.device.LogicalDevice;

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

	public void free()
	{
		vkDestroySemaphore(logicalDevice.getVkDevice(), semaphoreId, null);
	}
}
