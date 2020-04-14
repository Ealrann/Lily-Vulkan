package org.sheepy.lily.vulkan.core.resource.buffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;

import java.nio.ByteBuffer;

public interface IBufferBackend
{
	void free(ExecutionContext context);

	long getAddress();
	long getMemoryAddress();

	long mapMemory(VkDevice vkDevice);
	void unmapMemory(VkDevice vkDevice);

	/**
	 * Flush a memory range of the buffer to make it visible to the device
	 *
	 * @apiNote Only required for host visible, non-coherent memory
	 */
	void flush(MemoryStack stack, VkDevice vkDevice);

	/**
	 * Invalidate a memory range of the buffer to make it visible to the host
	 *
	 * @apiNote Only required for host visible, non-coherent memory
	 */
	void invalidate(MemoryStack stack, VkDevice vkDevice);

	void nextInstance(VkDevice vkDevice);
	long getInstanceOffset();
	long getInstanceSize();

	void pushData(ExecutionContext executionContext, ByteBuffer data);
}
