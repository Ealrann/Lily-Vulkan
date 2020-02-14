package org.sheepy.lily.vulkan.core.resource.buffer;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.vulkan.core.device.InternalVulkanContext;
import org.sheepy.lily.vulkan.core.device.LogicalDevice;
import org.sheepy.lily.vulkan.core.execution.InternalExecutionContext;
import org.sheepy.lily.vulkan.core.resource.memory.MemoryChunkBuilder;

public interface IBufferBackend
{
	void allocate(InternalVulkanContext context, MemoryChunkBuilder memoryBuilder);
	void allocate(InternalVulkanContext context);
	void free(InternalVulkanContext context);

	long getAddress();
	long getMemoryAddress();

	long mapMemory();
	void unmapMemory();

	/**
	 * Flush a memory range of the buffer to make it visible to the device
	 *
	 * @apiNote Only required for host visible, non-coherent memory
	 *
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

	void pushData(InternalExecutionContext executionContext, ByteBuffer data);
}
