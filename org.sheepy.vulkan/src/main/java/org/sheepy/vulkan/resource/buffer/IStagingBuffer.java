package org.sheepy.vulkan.resource.buffer;

import org.lwjgl.vulkan.VkCommandBuffer;

public interface IStagingBuffer
{
	long reserveMemory(long size);
	void pushMemoryTo(long localMemoryAddress, long trgAddress, long trgOffset);

	boolean isEmpty();
	void flush(VkCommandBuffer commandBuffer);
}
