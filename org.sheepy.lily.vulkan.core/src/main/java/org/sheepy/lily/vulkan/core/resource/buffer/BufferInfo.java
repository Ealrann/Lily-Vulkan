package org.sheepy.lily.vulkan.core.resource.buffer;

import org.sheepy.lily.vulkan.core.device.PhysicalDevice;

public class BufferInfo
{
	public final long size;
	public final int usage;
	public final boolean keptMapped;
	public final int instanceCount;
	public final boolean coherent;

	private long instanceSize;
	private long totalSize;

	public BufferInfo(long size, int usage, boolean keptMapped, boolean coherent)
	{
		this(size, usage, keptMapped, coherent, 1);
	}

	public BufferInfo(long size, int usage, boolean keptMapped, boolean coherent, int instanceCount)
	{
		this.size = size;
		this.usage = usage;
		this.keptMapped = keptMapped;
		this.coherent = coherent;
		this.instanceCount = instanceCount;
	}

	public void computeAlignment(PhysicalDevice device)
	{
		final double alignment = device.getBufferAlignement(usage, coherent);
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
