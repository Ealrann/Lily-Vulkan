package org.sheepy.vulkan.command;

import static org.lwjgl.vulkan.VK10.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkCommandBufferAllocateInfo;
import org.sheepy.vulkan.common.IAllocable;
import org.sheepy.vulkan.device.LogicalDevice;

public abstract class AbstractCommandBuffers<T extends ICommandBuffer>
		implements Iterable<T>, IAllocable
{
	protected LogicalDevice logicalDevice;
	protected CommandPool commandPool;

	private List<T> commandBuffers = new ArrayList<>();

	public AbstractCommandBuffers(CommandPool commandPool)
	{
		this.logicalDevice = commandPool.getLogicalDevice();
		this.commandPool = commandPool;
	}

	@Override
	public void allocate(MemoryStack stack)
	{
		commandBuffers = Collections.unmodifiableList(allocCommandBuffers(stack));
	}

	protected long[] allocCommandBuffers(long commandPoolId, int size)
	{
		long[] commandBufferIds = new long[size];
		VkCommandBufferAllocateInfo allocInfo = VkCommandBufferAllocateInfo.calloc();
		allocInfo.sType(VK_STRUCTURE_TYPE_COMMAND_BUFFER_ALLOCATE_INFO);
		allocInfo.commandPool(commandPoolId);
		allocInfo.level(VK_COMMAND_BUFFER_LEVEL_PRIMARY);
		allocInfo.commandBufferCount(size);

		PointerBuffer pCommandBuffers = MemoryUtil.memAllocPointer(size);
		if (vkAllocateCommandBuffers(logicalDevice.getVkDevice(), allocInfo,
				pCommandBuffers) != VK_SUCCESS)
		{
			throw new AssertionError("Failed to allocate command buffers!");
		}
		for (int i = 0; i < size; i++)
		{
			long commandBufferId = pCommandBuffers.get(i);
			commandBufferIds[i] = commandBufferId;
		}
		pCommandBuffers.free();

		return commandBufferIds;
	}

	public List<T> getCommandBuffers()
	{
		return commandBuffers;
	}

	@Override
	public void free()
	{
		for (T commandBuffer : commandBuffers)
		{
			vkFreeCommandBuffers(commandPool.getLogicalDevice().getVkDevice(), commandPool.getId(),
					commandBuffer.getVkCommandBuffer());
		}

		commandBuffers = null;
	}

	@Override
	public Iterator<T> iterator()
	{
		return getCommandBuffers().iterator();
	}

	public int size()
	{
		return getCommandBuffers().size();
	}

	public T get(int index)
	{
		return getCommandBuffers().get(index);
	}

	protected abstract List<T> allocCommandBuffers(MemoryStack stack);
}
