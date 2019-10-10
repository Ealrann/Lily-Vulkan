package org.sheepy.vulkan.resource.buffer;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.device.LogicalDevice;
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
	
	/**
	 * Flush a memory range of the buffer to make it visible to the device
	 *
	 * @note Only required for host visible, non-coherent memory
	 *
	 */
	public void flush(MemoryStack stack, LogicalDevice logicalDevice);

	/**
	 * Invalidate a memory range of the buffer to make it visible to the host
	 *
	 * @note Only required for host visible, non-coherent memory
	 */
	public void invalidate(MemoryStack stack, LogicalDevice logicalDevice);

	void nextInstance();
	long getOffset();
	int getProperties();

	void pushData(IExecutionContext executionContext, ByteBuffer data);
}
