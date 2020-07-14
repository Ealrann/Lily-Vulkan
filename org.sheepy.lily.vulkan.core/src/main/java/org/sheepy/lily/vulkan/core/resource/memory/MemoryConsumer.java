package org.sheepy.lily.vulkan.core.resource.memory;

public final class MemoryConsumer
{
	public final long size;
	public final MemoryBuilder.MemoryAllocationCallback callBack;

	public MemoryConsumer(long size, MemoryBuilder.MemoryAllocationCallback callBack)
	{
		this.size = size;
		this.callBack = callBack;
	}
}
