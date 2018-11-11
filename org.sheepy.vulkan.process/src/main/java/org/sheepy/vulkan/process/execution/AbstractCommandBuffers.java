package org.sheepy.vulkan.process.execution;

import static org.lwjgl.vulkan.VK10.*;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkCommandBufferAllocateInfo;
import org.lwjgl.vulkan.VkDevice;
import org.sheepy.vulkan.common.allocation.IBasicAllocable;
import org.sheepy.vulkan.common.execution.CommandPool;
import org.sheepy.vulkan.common.execution.ICommandBuffer;
import org.sheepy.vulkan.common.util.Logger;

public abstract class AbstractCommandBuffers<CB extends ICommandBuffer>
		implements Iterable<CB>, IBasicAllocable
{
	protected List<CB> commandBuffers = Collections.emptyList();

	protected VkDevice device;
	protected CommandPool commandPool;

	public AbstractCommandBuffers(VkDevice device, CommandPool commandPool)
	{
		this.device = device;
		this.commandPool = commandPool;
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		commandBuffers = List.copyOf(allocCommandBuffers(stack));
	}

	protected long[] allocCommandBuffers(long commandPoolId, int size)
	{
		final long[] commandBufferIds = new long[size];
		final VkCommandBufferAllocateInfo allocInfo = VkCommandBufferAllocateInfo.calloc();
		allocInfo.sType(VK_STRUCTURE_TYPE_COMMAND_BUFFER_ALLOCATE_INFO);
		allocInfo.commandPool(commandPoolId);
		allocInfo.level(VK_COMMAND_BUFFER_LEVEL_PRIMARY);
		allocInfo.commandBufferCount(size);

		final PointerBuffer pCommandBuffers = MemoryUtil.memAllocPointer(size);
		Logger.check("Failed to allocate command buffers!",
				() -> vkAllocateCommandBuffers(device, allocInfo, pCommandBuffers));

		for (int i = 0; i < size; i++)
		{
			final long commandBufferId = pCommandBuffers.get(i);
			commandBufferIds[i] = commandBufferId;
		}
		pCommandBuffers.free();

		return commandBufferIds;
	}

	public List<CB> getCommandBuffers()
	{
		return commandBuffers;
	}

	@Override
	public void free()
	{
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

	protected abstract List<CB> allocCommandBuffers(MemoryStack stack);
}
