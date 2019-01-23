package org.sheepy.lily.vulkan.common.execution;

import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.vulkan.common.device.LogicalDevice;

public abstract class AbstractCommandBuffer implements ICommandBuffer
{
	protected final VkCommandBuffer vkCommandBuffer;

	public AbstractCommandBuffer(LogicalDevice logicalDevice, long commandBufferId)
	{
		vkCommandBuffer = new VkCommandBuffer(commandBufferId, logicalDevice.getVkDevice());
	}
	
	@Override
	public final VkCommandBuffer getVkCommandBuffer()
	{
		return vkCommandBuffer;
	}

}
