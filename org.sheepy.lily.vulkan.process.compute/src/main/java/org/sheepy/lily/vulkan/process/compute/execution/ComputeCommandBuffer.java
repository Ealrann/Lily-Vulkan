package org.sheepy.lily.vulkan.process.compute.execution;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkCommandBufferBeginInfo;
import org.sheepy.lily.vulkan.common.device.LogicalDevice;
import org.sheepy.lily.vulkan.common.execution.AbstractCommandBuffer;

public class ComputeCommandBuffer extends AbstractCommandBuffer
{
	public ComputeCommandBuffer(LogicalDevice logicalDevice, long commandBufferId)
	{
		super(logicalDevice, commandBufferId);
	}

	@Override
	public void start()
	{
		// Start buffer record
		VkCommandBufferBeginInfo beginInfo = VkCommandBufferBeginInfo.calloc();
		beginInfo.sType(VK_STRUCTURE_TYPE_COMMAND_BUFFER_BEGIN_INFO);
		beginInfo.flags(VK_COMMAND_BUFFER_USAGE_SIMULTANEOUS_USE_BIT);
		beginInfo.pInheritanceInfo(null); // Optional

		if (vkBeginCommandBuffer(vkCommandBuffer, beginInfo) != VK_SUCCESS)
		{
			throw new AssertionError("failed to begin recording command buffer!");
		}

		beginInfo.free();
	}

	@Override
	public void end()
	{
		if (vkEndCommandBuffer(vkCommandBuffer) != VK_SUCCESS)
		{
			throw new AssertionError("Failed to record command buffer!");
		}
	}
}
