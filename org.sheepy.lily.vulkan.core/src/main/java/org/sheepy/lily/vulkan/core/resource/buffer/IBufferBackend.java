package org.sheepy.lily.vulkan.core.resource.buffer;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.core.device.LogicalDevice;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.resource.memory.MemoryChunkBuilder;

import java.nio.ByteBuffer;

public interface IBufferBackend
{
	void allocate(ExecutionContext context, MemoryChunkBuilder memoryBuilder);
	void allocate(ExecutionContext context);
	void free(ExecutionContext context);

	long getAddress();
	long getMemoryAddress();

	long mapMemory();
	void unmapMemory();

	/**
	 * Flush a memory range of the buffer to make it visible to the device
	 *
	 * @apiNote Only required for host visible, non-coherent memory
	 */
	void flush(MemoryStack stack, LogicalDevice logicalDevice);

	/**
	 * Invalidate a memory range of the buffer to make it visible to the host
	 *
	 * @apiNote Only required for host visible, non-coherent memory
	 */
	void invalidate(MemoryStack stack, LogicalDevice logicalDevice);

	void nextInstance();
	long getInstanceOffset();
	long getInstanceSize();
	int getProperties();

	void pushData(ExecutionContext executionContext, ByteBuffer data);
}
