package org.sheepy.lily.game.vulkan.command;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandPoolCreateInfo;
import org.sheepy.lily.game.vulkan.device.LogicalDevice;

public class CommandPool
{
	private LogicalDevice logicalDevice;

	private long commandPoolId = -1;
	
	public static final CommandPool alloc(MemoryStack stack, LogicalDevice logicalDevice, int queueIndex)
	{
		CommandPool res = new CommandPool(logicalDevice);
		res.load(stack, queueIndex);
		return res;
	}
	
	private CommandPool(LogicalDevice logicalDevice)
	{
		this.logicalDevice = logicalDevice;
	}
	
	public void load(MemoryStack stack, int queueIndex)
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
