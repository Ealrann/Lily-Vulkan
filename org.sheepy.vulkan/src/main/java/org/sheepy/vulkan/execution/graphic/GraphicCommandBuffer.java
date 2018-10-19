package org.sheepy.vulkan.execution.graphic;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkCommandBufferBeginInfo;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.execution.AbstractCommandBuffer;

/**
 * 
 * @author ealrann
 */
public abstract class GraphicCommandBuffer extends AbstractCommandBuffer
{
	public final int index;
	
	public GraphicCommandBuffer(LogicalDevice logicalDevice, int index, long commandBufferId)
	{
		super(logicalDevice, commandBufferId);
		this.index = index;
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
			throw new AssertionError("failed to record command buffer!");
		}
	}
}
