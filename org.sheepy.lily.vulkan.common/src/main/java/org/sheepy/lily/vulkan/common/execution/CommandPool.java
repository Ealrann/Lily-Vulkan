package org.sheepy.lily.vulkan.common.execution;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandPoolCreateInfo;
import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.vulkan.common.allocation.IAllocable;

public class CommandPool implements IAllocable
{
	private final VkDevice device;
	private final int queueIndex;
	private final boolean allowReset;

	private long commandPoolId = -1;

	public CommandPool(VkDevice device, int queueIndex, boolean allowReset)
	{
		this.device = device;
		this.queueIndex = queueIndex;
		this.allowReset = allowReset;
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		if (commandPoolId != -1) free();

		// Command Pool
		// ------------------
		final VkCommandPoolCreateInfo poolInfo = VkCommandPoolCreateInfo.callocStack(stack);
		poolInfo.sType(VK_STRUCTURE_TYPE_COMMAND_POOL_CREATE_INFO);
		poolInfo.queueFamilyIndex(queueIndex);
		poolInfo.flags(allowReset ? VK_COMMAND_POOL_CREATE_RESET_COMMAND_BUFFER_BIT : 0);

		final long[] aCommandPool = new long[1];
		if (vkCreateCommandPool(device, poolInfo, null, aCommandPool) != VK_SUCCESS)
		{
			throw new AssertionError("Failed to create command pool!");
		}
		commandPoolId = aCommandPool[0];
	}
	
	@Override
	public boolean isAllocationDirty()
	{
		return false;
	}

	public long getId()
	{
		return commandPoolId;
	}

	@Override
	public void free()
	{
		vkDestroyCommandPool(device, commandPoolId, null);
		commandPoolId = -1;
	}
}
