package org.sheepy.lily.vulkan.common.execution.queue;

import org.lwjgl.vulkan.VK10;
import org.lwjgl.vulkan.VkQueue;

public class VulkanQueue
{
	public final int familyIndex;
	public final VkQueue vkQueue;

	private boolean isShared;

	public VulkanQueue(int familyIndex, VkQueue vkQueue, boolean isShared)
	{
		this.familyIndex = familyIndex;
		this.vkQueue = vkQueue;
		this.isShared = isShared;
	}

	public void waitIdle()
	{
		VK10.vkQueueWaitIdle(vkQueue);
	}

	public boolean isShared()
	{
		return isShared;
	}

	public VulkanQueue share()
	{
		isShared = true;
		return new VulkanQueue(familyIndex, vkQueue, true);
	}
}
