package org.sheepy.vulkan.execution;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkCommandBufferAllocateInfo;
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.log.Logger;

public abstract class AbstractCommandBuffer implements ICommandBuffer
{
	protected VkCommandBuffer vkCommandBuffer;

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		final var processContext = (ExecutionContext) context;
		final long commandPoolId = processContext.commandPool.getId();
		final var vkDevice = processContext.getVkDevice();

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
	public void free(IAllocationContext context)
	{
		final var executionContext = (ExecutionContext) context;
		final var device = executionContext.getVkDevice();
		final long poolId = executionContext.commandPool.getId();

		vkFreeCommandBuffers(device, poolId, vkCommandBuffer);
	}
}
