package org.sheepy.vulkan.resource.buffer;

import org.sheepy.vulkan.device.PhysicalDevice;

public class BufferInfo
{
	public final long size;
	public final int usage;
	public final boolean keptMapped;
	public final int instanceCount;

	private long instanceSize;
	private long totalSize;

	public BufferInfo(long size, int usage, boolean keptMapped)
	{
		this(size, usage, keptMapped, 1);
	}

	public BufferInfo(long size, int usage, boolean keptMapped, int instanceCount)
	{
		this.size = size;
		this.usage = usage;
		this.keptMapped = keptMapped;
		this.instanceCount = instanceCount;
	}

	public void computeAlignment(PhysicalDevice device)
	{
		final double alignment = device.getBufferAlignement(usage);
		final int chunks = (int) Math.ceil(size / alignment);
		instanceSize = (long) (chunks * alignment);
		totalSize = instanceSize * instanceCount;
	}

	public long getTotalSize()
	{
		return totalSize;
	}

	public long getInstanceSize()
	{
		return instanceSize;
	}
}
