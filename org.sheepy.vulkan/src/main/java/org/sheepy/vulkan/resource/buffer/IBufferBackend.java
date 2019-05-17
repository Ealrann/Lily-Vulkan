package org.sheepy.vulkan.resource.buffer;

import java.nio.ByteBuffer;

import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.execution.IExecutionContext;

public interface IBufferBackend extends IAllocable<IExecutionContext>
{
	@Override
	default boolean isAllocationDirty(IExecutionContext context)
	{
		return false;
	}

	long getAddress();

	long getMemoryAddress();

	public long mapMemory();

	public void unmapMemory();

	void nextInstance();
	long getOffset();

	void pushData(IExecutionContext executionContext, ByteBuffer data);
}
