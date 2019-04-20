package org.sheepy.lily.vulkan.api.nativehelper.resource.buffer;

import java.util.List;

import org.sheepy.lily.vulkan.api.device.IPhysicalDevice;
import org.sheepy.lily.vulkan.model.enumeration.EBufferUsage;
import org.sheepy.lily.vulkan.model.resource.Buffer;

public class BufferInfo
{
	public final long size;
	public final int usage;
	public final boolean keptMapped;
	public final int instanceCount;

	private long instanceSize;
	private long totalSize;

	public BufferInfo(long size, int usage, boolean keepMapped)
	{
		this(size, usage, keepMapped, 1);
	}

	public BufferInfo(long size, int usage, boolean keepMapped, int instanceCount)
	{
		this.size = size;
		this.usage = usage;
		this.keptMapped = keepMapped;
		this.instanceCount = instanceCount;
	}

	public BufferInfo(Buffer buffer)
	{
		this.size = buffer.getSize();
		this.usage = convertUsages(buffer.getUsages());
		this.keptMapped = buffer.isOftenUpdated();
		this.instanceCount = buffer.getInstanceCount();
	}

	public void computeAlignment(IPhysicalDevice device)
	{
		final var limits = device.getDeviceProperties().limits();
		double alignment = 0;

		if ((usage | EBufferUsage.UNIFORM_BUFFER_BIT_VALUE) != 0)
		{
			alignment = limits.minUniformBufferOffsetAlignment();
		}
		else if ((usage | EBufferUsage.STORAGE_BUFFER_BIT_VALUE) != 0)
		{
			alignment = limits.minStorageBufferOffsetAlignment();
		}
		else
		{
			alignment = 1;
		}

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

	private static int convertUsages(List<EBufferUsage> usages)
	{
		int res = 0;
		for (final EBufferUsage usage : usages)
		{
			res |= usage.getValue();
		}
		return res;
	}
}
