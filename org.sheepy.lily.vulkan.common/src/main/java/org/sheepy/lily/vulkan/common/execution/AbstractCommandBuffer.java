package org.sheepy.lily.vulkan.common.execution;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.PointerBuffer;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkCommandBufferAllocateInfo;
import org.sheepy.lily.vulkan.common.util.Logger;

public abstract class AbstractCommandBuffer<T extends InternalExecutionContext>
		implements ICommandBuffer<T>
{
	protected VkCommandBuffer vkCommandBuffer;

	@Override
	public void allocate(T context)
	{
		final var stack = context.stack();
		final long commandPoolId = context.getCommandPool().getId();
		final var vkDevice = context.getVkDevice();

		final var allocInfo = VkCommandBufferAllocateInfo.callocStack(stack);
		allocInfo.sType(VK_STRUCTURE_TYPE_COMMAND_BUFFER_ALLOCATE_INFO);
		allocInfo.commandPool(commandPoolId);
		allocInfo.level(VK_COMMAND_BUFFER_LEVEL_PRIMARY);
		allocInfo.commandBufferCount(1);

		final PointerBuffer pCommandBuffer = stack.mallocPointer(1);
		Logger.check("Failed to allocate command buffers",
				() -> vkAllocateCommandBuffers(vkDevice, allocInfo, pCommandBuffer));

		vkCommandBuffer = new VkCommandBuffer(pCommandBuffer.get(0), vkDevice);
	}

	@Override
	public final VkCommandBuffer getVkCommandBuffer()
	{
		return vkCommandBuffer;
	}

	@Override
	public void free(T context)
	{
		final var device = context.getVkDevice();
		final long poolId = context.getCommandPool().getId();

		vkFreeCommandBuffers(device, poolId, vkCommandBuffer);
	}
}
