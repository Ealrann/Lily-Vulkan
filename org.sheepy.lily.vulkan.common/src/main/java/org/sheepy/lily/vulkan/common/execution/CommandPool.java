package org.sheepy.lily.vulkan.common.execution;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandPoolCreateInfo;
import org.sheepy.lily.vulkan.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.api.allocation.IAllocationContext;

public class CommandPool implements IAllocable
{
	private final int queueIndex;
	private final boolean allowReset;

	private long commandPoolId = -1;

	public CommandPool(int queueIndex, boolean allowReset)
	{
		this.queueIndex = queueIndex;
		this.allowReset = allowReset;
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		var device = ((ExecutionContext) context).getVkDevice();
		if (commandPoolId != -1) free(context);

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
	public boolean isAllocationDirty(IAllocationContext context)
	{
		return false;
	}

	public long getId()
	{
		return commandPoolId;
	}

	@Override
	public void free(IAllocationContext context)
	{
		var device = ((ExecutionContext) context).getVkDevice();
		vkDestroyCommandPool(device, commandPoolId, null);
		commandPoolId = -1;
	}
}
