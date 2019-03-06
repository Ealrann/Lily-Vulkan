package org.sheepy.lily.vulkan.process.execution;

import static org.lwjgl.vulkan.VK10.*;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkCommandBufferAllocateInfo;
import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.vulkan.api.util.Logger;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocable;
import org.sheepy.lily.vulkan.common.allocation.common.IAllocationContext;
import org.sheepy.lily.vulkan.common.execution.CommandPool;
import org.sheepy.lily.vulkan.common.execution.ICommandBuffer;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

public abstract class AbstractCommandBuffers<CB extends ICommandBuffer>
		implements Iterable<CB>, IAllocable
{
	protected List<CB> commandBuffers = Collections.emptyList();

	protected CommandPool commandPool;

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		ProcessContext processContext = (ProcessContext) context;
		this.commandPool = processContext.commandPool;

		commandBuffers = List.copyOf(allocCommandBuffers(stack, processContext));
	}

	protected static long[] allocCommandBuffers(VkDevice device, long commandPoolId, int size)
	{
		final long[] commandBufferIds = new long[size];
		final VkCommandBufferAllocateInfo allocInfo = VkCommandBufferAllocateInfo.calloc();
		allocInfo.sType(VK_STRUCTURE_TYPE_COMMAND_BUFFER_ALLOCATE_INFO);
		allocInfo.commandPool(commandPoolId);
		allocInfo.level(VK_COMMAND_BUFFER_LEVEL_PRIMARY);
		allocInfo.commandBufferCount(size);

		final PointerBuffer pCommandBuffers = MemoryUtil.memAllocPointer(size);
		Logger.check("Failed to allocate command buffers",
				() -> vkAllocateCommandBuffers(device, allocInfo, pCommandBuffers));

		for (int i = 0; i < size; i++)
		{
			final long commandBufferId = pCommandBuffers.get(i);
			commandBufferIds[i] = commandBufferId;
		}
		pCommandBuffers.free();
		allocInfo.free();

		return commandBufferIds;
	}

	public List<CB> getCommandBuffers()
	{
		return commandBuffers;
	}

	@Override
	public void free(IAllocationContext context)
	{
		var device = ((ProcessContext) context).getVkDevice();
		final long poolId = commandPool.getId();
		for (final CB commandBuffer : commandBuffers)
		{
			vkFreeCommandBuffers(device, poolId, commandBuffer.getVkCommandBuffer());
		}

		commandBuffers = null;
	}

	@Override
	public Iterator<CB> iterator()
	{
		return getCommandBuffers().iterator();
	}

	public int size()
	{
		return getCommandBuffers().size();
	}

	public CB get(int index)
	{
		return getCommandBuffers().get(index);
	}

	protected abstract List<CB> allocCommandBuffers(MemoryStack stack, ProcessContext context);
}
