package org.sheepy.lily.vulkan.core.execution;

import org.lwjgl.vulkan.VkCommandPoolCreateInfo;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.core.device.VulkanContext;
import org.sheepy.lily.vulkan.core.util.Logger;

import static org.lwjgl.vulkan.VK10.*;

public final class CommandPool implements IAllocable<VulkanContext>
{
	public static final String FAILED_TO_CREATE_COMMAND_POOL = "Failed to create command pool!";

	private final int queueIndex;
	private final boolean allowReset;
	private long commandPoolId = -1;

	public CommandPool(int queueIndex, boolean allowReset)
	{
		this.queueIndex = queueIndex;
		this.allowReset = allowReset;
	}

	@Override
	public void allocate(VulkanContext context)
	{
		final var stack = context.stack();
		final var device = context.getVkDevice();
		if (commandPoolId != -1) free(context);

		// Command Pool
		// ------------------
		final VkCommandPoolCreateInfo poolInfo = VkCommandPoolCreateInfo.callocStack(stack);
		poolInfo.sType(VK_STRUCTURE_TYPE_COMMAND_POOL_CREATE_INFO);
		poolInfo.queueFamilyIndex(queueIndex);
		poolInfo.flags(allowReset ? VK_COMMAND_POOL_CREATE_RESET_COMMAND_BUFFER_BIT : 0);

		final long[] aCommandPool = new long[1];
		Logger.check(vkCreateCommandPool(device, poolInfo, null, aCommandPool),
					 FAILED_TO_CREATE_COMMAND_POOL);
		commandPoolId = aCommandPool[0];
	}

	public long getId()
	{
		return commandPoolId;
	}

	@Override
	public void free(VulkanContext context)
	{
		final var device = context.getVkDevice();
		vkDestroyCommandPool(device, commandPoolId, null);
		commandPoolId = -1;
	}
}
