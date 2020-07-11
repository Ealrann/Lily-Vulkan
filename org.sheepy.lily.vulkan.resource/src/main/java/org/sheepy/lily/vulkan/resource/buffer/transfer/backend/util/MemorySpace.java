package org.sheepy.lily.vulkan.resource.buffer.transfer.backend.util;

public final class MemorySpace
{
	boolean used;
	long size;
	long offset;

	public MemorySpace(long size, long offset, boolean used)
	{
		this.used = used;
		this.offset = offset;
		this.size = size;
	}

	public long getSize()
	{
		return size;
	}

	public long getOffset()
	{
		return offset;
	}
}
