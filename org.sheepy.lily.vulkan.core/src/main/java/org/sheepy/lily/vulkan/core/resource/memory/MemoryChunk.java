package org.sheepy.lily.vulkan.core.resource.memory;

import org.lwjgl.vulkan.VkMemoryAllocateInfo;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.resource.memory.MemoryChunkBuilder.MemoryAllocationCallback;
import org.sheepy.lily.vulkan.core.util.Logger;

import java.util.List;

import static org.lwjgl.vulkan.VK10.vkAllocateMemory;
import static org.lwjgl.vulkan.VK10.vkFreeMemory;

public final class MemoryChunk implements IAllocable<ExecutionContext>
{
	private static final String ALLOC_ERROR = "Failed to allocate buffer";

	private final VkMemoryAllocateInfo allocInfo;
	private final List<MemoryConsumer> consumers;

	public long ptr;

	public MemoryChunk(VkMemoryAllocateInfo allocInfo, List<MemoryConsumer> consumers)
	{
		this.allocInfo = allocInfo;
		this.consumers = List.copyOf(consumers);
	}

	@Override
	public void allocate(ExecutionContext context)
	{
		final var vkDevice = context.getVkDevice();
		ptr = allocateBuffer(context);
		long offset = 0;
		for (int i = 0; i < consumers.size(); i++)
		{
			final var memoryConsumer = consumers.get(i);
			final var size = memoryConsumer.size;
			memoryConsumer.callBack.finalize(vkDevice, ptr, offset, size);
			offset += size;
		}
	}

	private long allocateBuffer(ExecutionContext context) throws AssertionError
	{
		final var vkDevice = context.getVkDevice();
		final long[] aMemoryId = new long[1];
		Logger.check(ALLOC_ERROR, () -> vkAllocateMemory(vkDevice, allocInfo, null, aMemoryId));
		return aMemoryId[0];
	}

	@Override
	public void free(ExecutionContext context)
	{
		vkFreeMemory(context.getVkDevice(), ptr, null);
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