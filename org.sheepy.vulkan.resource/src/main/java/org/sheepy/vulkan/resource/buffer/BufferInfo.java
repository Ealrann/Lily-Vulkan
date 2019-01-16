package org.sheepy.vulkan.resource.buffer;

import java.util.List;

import org.sheepy.vulkan.model.enumeration.EBufferUsage;
import org.sheepy.vulkan.model.resource.Buffer;

public class BufferInfo
{
	public final long size;
	public final int usage;
	public final boolean keptMapped;

	public BufferInfo(long size, int usage, boolean keepMapped)
	{
		this.size = size;
		this.usage = usage;
		this.keptMapped = keepMapped;
	}

	public BufferInfo(Buffer buffer)
	{
		this.size = buffer.getSize();
		this.usage = convertUsages(buffer.getUsages());
		this.keptMapped = buffer.isOftenUpdated();
	}

	private static int convertUsages(List<EBufferUsage> usages)
	{
		int res = 0;
		for (EBufferUsage usage : usages)
		{
			res |= usage.getValue();
		}
		return res;
	}
}
