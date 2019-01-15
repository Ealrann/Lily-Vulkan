package org.sheepy.vulkan.resource.barrier;

import org.lwjgl.vulkan.VkCommandBuffer;

public interface IBarrierExecutor
{
	void allocate();
	void allocate(int srcQueueFamilly, int dstQueueFamilly);
	void free();

	void execute(VkCommandBuffer commandBuffer);
}
