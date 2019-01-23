package org.sheepy.vulkan.api.queue;

import org.lwjgl.vulkan.VK10;
import org.lwjgl.vulkan.VkQueue;

public class VulkanQueue
{
	public final EQueueType type;
	public final int index;
	public final VkQueue vkQueue;

	public VulkanQueue(EQueueType type, int index, VkQueue vkQueue)
	{
		this.type = type;
		this.index = index;
		this.vkQueue = vkQueue;
	}
	
	public void waitIdle()
	{
		VK10.vkQueueWaitIdle(vkQueue);
	}
}
