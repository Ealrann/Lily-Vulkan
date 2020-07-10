package org.sheepy.lily.vulkan.core.resource.memory;

import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.resource.memory.MemoryBuilder.MemoryAllocationCallback;

import static org.lwjgl.vulkan.VK10.vkFreeMemory;

public final record Memory(long ptr)
{
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