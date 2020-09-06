package org.sheepy.lily.vulkan.core.resource.buffer;

import org.sheepy.lily.vulkan.core.device.PhysicalDevice;
import org.sheepy.lily.vulkan.core.util.AlignmentUtil;

public class BufferInfo
{
	public final long size;
	public final int usage;
	public final boolean keptMapped;
	public final boolean coherent;

	private long alignedSize;

	public BufferInfo(long size, int usage, boolean keptMapped, boolean coherent)
	{
		this.size = size;
		this.usage = usage;
		this.keptMapped = keptMapped;
		this.coherent = coherent;
	}

	public void computeAlignment(PhysicalDevice device)
	{
		final long alignment = device.getBufferAlignement(usage, coherent);
		alignedSize = AlignmentUtil.align(size, alignment);
	}

	public long getAlignedSize()
	{
		return alignedSize;
	}
}
