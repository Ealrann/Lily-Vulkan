package org.sheepy.lily.vulkan.core.execution;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandPoolCreateInfo;
import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.core.util.Logger;

import static org.lwjgl.vulkan.VK10.*;

public final class CommandPool
{
	private final long ptr;

	private CommandPool(long ptr)
	{
		this.ptr = ptr;
	}

	public long getPtr()
	{
		return ptr;
	}

	public void free(IVulkanContext context)
	{
		final var device = context.getVkDevice();
		vkDestroyCommandPool(device, ptr, null);
	}

	public static final class Builder
	{
		private static final String FAILED_TO_CREATE_COMMAND_POOL = "Failed to create command pool!";
		private final int queueIndex;
		private final boolean allowReset;

		public Builder(int queueIndex, boolean allowReset)
		{
			this.queueIndex = queueIndex;
			this.allowReset = allowReset;
		}

		public CommandPool build(VkDevice device, MemoryStack stack)
		{
			// Command Pool
			// ------------------
			final VkCommandPoolCreateInfo poolInfo = VkCommandPoolCreateInfo.calloc(stack);
			poolInfo.sType(VK_STRUCTURE_TYPE_COMMAND_POOL_CREATE_INFO);
			poolInfo.queueFamilyIndex(queueIndex);
			poolInfo.flags(allowReset ? VK_COMMAND_POOL_CREATE_RESET_COMMAND_BUFFER_BIT : 0);

			final long[] aCommandPool = new long[1];
			Logger.check(vkCreateCommandPool(device, poolInfo, null, aCommandPool), FAILED_TO_CREATE_COMMAND_POOL);
			final long commandPoolPtr = aCommandPool[0];

			return new CommandPool(commandPoolPtr);
		}
	}
}
