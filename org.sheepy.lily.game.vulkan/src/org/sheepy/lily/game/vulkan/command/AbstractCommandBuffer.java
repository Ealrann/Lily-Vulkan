package org.sheepy.lily.game.vulkan.command;

import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.game.vulkan.device.LogicalDevice;

public abstract class AbstractCommandBuffer implements ICommandBuffer
{
	protected LogicalDevice logicalDevice;

	protected VkCommandBuffer vkCommandBuffer;

	public AbstractCommandBuffer(LogicalDevice logicalDevice, long commandBufferId)
	{
		this.logicalDevice = logicalDevice;

		vkCommandBuffer = new VkCommandBuffer(commandBufferId, logicalDevice.getVkDevice());
	}
	
	@Override
	public final VkCommandBuffer getVkCommandBuffer()
	{
		return vkCommandBuffer;
	}

}
