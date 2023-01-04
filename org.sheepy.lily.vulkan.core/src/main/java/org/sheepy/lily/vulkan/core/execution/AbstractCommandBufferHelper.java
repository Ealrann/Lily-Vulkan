package org.sheepy.lily.vulkan.core.execution;

import org.lwjgl.PointerBuffer;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkCommandBufferAllocateInfo;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableAdapter;
import org.sheepy.lily.vulkan.core.util.Logger;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.List;

import static org.lwjgl.vulkan.VK10.*;

public abstract class AbstractCommandBufferHelper implements ICommandBufferHelper
{
	protected final VkCommandBuffer vkCommandBuffer;

	public AbstractCommandBufferHelper(ExecutionContext context)
	{
		final var stack = context.stack();
		final long commandPoolPtr = context.getCommandPool().getPtr();
		final var vkDevice = context.getVkDevice();

		final var allocInfo = VkCommandBufferAllocateInfo.calloc(stack);
		allocInfo.sType(VK_STRUCTURE_TYPE_COMMAND_BUFFER_ALLOCATE_INFO);
		allocInfo.commandPool(commandPoolPtr);
		allocInfo.level(VK_COMMAND_BUFFER_LEVEL_PRIMARY);
		allocInfo.commandBufferCount(1);

		final PointerBuffer pCommandBuffer = stack.mallocPointer(1);
		Logger.check("Failed to allocate command buffers",
					 () -> vkAllocateCommandBuffers(vkDevice, allocInfo, pCommandBuffer));

		vkCommandBuffer = new VkCommandBuffer(pCommandBuffer.get(0), vkDevice);
	}

	public void free(ExecutionContext context)
	{
		final var device = context.getVkDevice();
		final long poolId = context.getCommandPool().getPtr();

		vkFreeCommandBuffers(device, poolId, vkCommandBuffer);
	}

	@Override
	public final VkCommandBuffer getVkCommandBuffer()
	{
		return vkCommandBuffer;
	}

	protected abstract void start(ECommandStage stage);
	protected abstract void end(ECommandStage stage);
}
