package org.sheepy.lily.vulkan.core.pipeline;

import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;

import static org.lwjgl.vulkan.VK10.vkCmdBindPipeline;

public abstract class VkPipeline<T extends IVulkanContext> implements IAllocable<T>
{
	private final int bindPoint;

	public VkPipeline(int bindPoint)
	{
		this.bindPoint = bindPoint;
	}

	public void bindPipeline(VkCommandBuffer commandBuffer)
	{
		vkCmdBindPipeline(commandBuffer, bindPoint, getPipelinePtr());
	}

	protected abstract long getPipelinePtr();
}
