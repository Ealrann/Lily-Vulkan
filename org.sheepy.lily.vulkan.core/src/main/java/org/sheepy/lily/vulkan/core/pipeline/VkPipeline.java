package org.sheepy.lily.vulkan.core.pipeline;

import org.lwjgl.vulkan.VkCommandBuffer;

import static org.lwjgl.vulkan.VK10.vkCmdBindPipeline;

public abstract class VkPipeline
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
