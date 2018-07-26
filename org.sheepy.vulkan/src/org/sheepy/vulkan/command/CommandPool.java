package org.sheepy.vulkan.command;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandPoolCreateInfo;
import org.sheepy.vulkan.common.IAllocable;
import org.sheepy.vulkan.device.LogicalDevice;

public class CommandPool implements IAllocable
{
	public final LogicalDevice logicalDevice;
	private int queueIndex;
	private boolean allowReset;

	private long commandPoolId = -1;
	
	public CommandPool(LogicalDevice logicalDevice, int queueIndex, boolean allowReset)
	{
		this.logicalDevice = logicalDevice;
		this.queueIndex = queueIndex;
		this.allowReset = allowReset;
	}
	
	@Override
	public void allocate(MemoryStack stack)
	{
		if(commandPoolId != -1)
			free();
		
		// Command Pool
		// ------------------
		VkCommandPoolCreateInfo poolInfo = VkCommandPoolCreateInfo.callocStack(stack);
		poolInfo.sType(VK_STRUCTURE_TYPE_COMMAND_POOL_CREATE_INFO);
		poolInfo.queueFamilyIndex(queueIndex);
		poolInfo.flags(allowReset ? VK_COMMAND_POOL_CREATE_RESET_COMMAND_BUFFER_BIT : 0);

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
