package org.sheepy.lily.vulkan.core.resource.memory;

import org.sheepy.lily.vulkan.core.device.IVulkanContext;

import static org.lwjgl.vulkan.VK10.vkFreeMemory;

public final record Memory(long ptr)
{
	public void free(IVulkanContext context)
	{
		vkFreeMemory(context.getVkDevice(), ptr, null);
	}
}