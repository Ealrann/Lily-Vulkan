package org.sheepy.vulkan.command;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandPoolCreateInfo;
import org.sheepy.vulkan.common.IAllocable;
import org.sheepy.vulkan.device.LogicalDevice;

public class CommandPool implements IAllocable
{
	private LogicalDevice logicalDevice;
	private int queueIndex;

	private long commandPoolId = -1;
	
	public CommandPool(LogicalDevice logicalDevice, int queueIndex)
	{
		this.logicalDevice = logicalDevice;
		this.queueIndex = queueIndex;
	}
	
	@Override
	public void allocate(MemoryStack stack)
	{
		// Command Pool
		// ------------------
		VkCommandPoolCreateInfo poolInfo = VkCommandPoolCreateInfo.callocStack(stack);
		poolInfo.sType(VK_STRUCTURE_TYPE_COMMAND_POOL_CREATE_INFO);
		poolInfo.queueFamilyIndex(queueIndex);
		poolInfo.flags(0); // Optional

		long[] aCommandPool = new long[1];
		if (vkCreateCommandPool(logicalDevice.getVkDevice(), poolInfo, null, aCommandPool) != VK_SUCCESS)
		{
			throw new AssertionError("Failed to create command pool!");
		}
		commandPoolId = aCommandPool[0];
	}

	public long getId()
	{
		return commandPoolId;
	}

	@Override
	public void free()
	{
		vkDestroyCommandPool(logicalDevice.getVkDevice(), commandPoolId, null);
		commandPoolId = -1;
	}

	public LogicalDevice getLogicalDevice()
	{
		return logicalDevice;
	}
}
