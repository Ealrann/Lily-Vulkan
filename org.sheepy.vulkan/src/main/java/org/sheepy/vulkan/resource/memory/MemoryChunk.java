package org.sheepy.vulkan.resource.memory;

import static org.lwjgl.vulkan.VK10.*;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkMemoryAllocateInfo;
import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.device.IVulkanContext;
import org.sheepy.vulkan.log.Logger;
import org.sheepy.vulkan.resource.memory.MemoryChunkBuilder.MemoryAllocationCallback;

public final class MemoryChunk implements IAllocable<IVulkanContext>
{
	private final VkMemoryAllocateInfo allocInfo;
	private final List<MemoryConsumer> consumers;

	public long ptr;

	public MemoryChunk(VkMemoryAllocateInfo allocInfo, List<MemoryConsumer> consumers)
	{
		this.allocInfo = allocInfo;
		this.consumers = List.copyOf(consumers);
	}

	@Override
	public void allocate(MemoryStack stack, IVulkanContext context)
	{
		ptr = allocate(context);
		long offset = 0;
		for (final MemoryConsumer memoryConsumer : consumers)
		{
			final var size = memoryConsumer.size;
			memoryConsumer.callBack.finalize(ptr + offset, size);
			offset += size;
		}
	}

	private long allocate(IVulkanContext context) throws AssertionError
	{
		final var vkDevice = context.getVkDevice();
		final long[] aMemoryId = new long[1];
		Logger.check("Failed to allocate buffer",
				() -> vkAllocateMemory(vkDevice, allocInfo, null, aMemoryId));
		return aMemoryId[0];
	}

	@Override
	public void free(IVulkanContext context)
	{
		vkFreeMemory(context.getVkDevice(), ptr, null);
	}

	@Override
	public boolean isAllocationDirty(IVulkanContext context)
	{
		return false;
	}

	public final static class MemoryConsumer
	{
		public final long size;
		public final MemoryAllocationCallback callBack;

		public MemoryConsumer(long size, MemoryAllocationCallback callBack)
		{
			this.size = size;
			this.callBack = callBack;
		}
	}
}