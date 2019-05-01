package org.sheepy.vulkan.resource.buffer;

import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

public interface IStagingBuffer
{
	long reserveMemory(long size);

	void pushSynchronized(	long localMemoryAddress,
							long trgAddress,
							long trgOffset,
							EPipelineStage dstStage,
							EAccess dstAccess);
	void pushUnsynchronized(long localMemoryAddress, long trgAddress, long trgOffset);

	boolean isEmpty();
	void flush(VkCommandBuffer commandBuffer);
}
