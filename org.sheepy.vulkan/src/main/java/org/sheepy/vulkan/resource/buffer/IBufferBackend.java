package org.sheepy.vulkan.resource.buffer;

import java.nio.ByteBuffer;

import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.resource.memory.MemoryChunkBuilder;

public interface IBufferBackend
{
	void allocate(IExecutionContext context, MemoryChunkBuilder memoryBuilder);
	void allocate(IExecutionContext context);
	void free(IExecutionContext context);

	long getAddress();
	long getMemoryAddress();

	public long mapMemory();
	public void unmapMemory();

	void nextInstance();
	long getOffset();
	int getProperties();

	void pushData(IExecutionContext executionContext, ByteBuffer data);
}
