package org.sheepy.vulkan.resource.buffer;

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
		this.usage = buffer.getUsage();
		this.properties = buffer.getProperties();
	}
}
