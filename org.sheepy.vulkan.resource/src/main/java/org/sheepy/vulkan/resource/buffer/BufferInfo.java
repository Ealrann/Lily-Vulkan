package org.sheepy.vulkan.resource.buffer;

import java.util.List;

import org.sheepy.vulkan.model.enumeration.EBufferUsage;
import org.sheepy.vulkan.model.enumeration.EMemoryProperty;
import org.sheepy.vulkan.model.resource.Buffer;

public class BufferInfo
{
	public final long size;
	public final int usage;
	public final int properties;

	public BufferInfo(long size, int usage, int properties)
	{
		this.size = size;
		this.usage = usage;
		this.properties = properties;
	}

	public BufferInfo(Buffer buffer)
	{
		this.size = buffer.getSize();
		this.usage = convertUsages(buffer.getUsages());
		this.properties = convertMemoryProperties(buffer.getProperties());
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

	private static int convertMemoryProperties(List<EMemoryProperty> properties)
	{
		int res = 0;
		for (EMemoryProperty property : properties)
		{
			res |= property.getValue();
		}
		return res;
	}

}
