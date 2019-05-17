package org.sheepy.vulkan.pipeline;

import static org.lwjgl.vulkan.VK10.vkCmdBindPipeline;

import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.execution.IExecutionContext;

public abstract class VkPipeline<T extends IExecutionContext> implements IAllocable<T>
{
	public void bindPipeline(VkCommandBuffer commandBuffer, int bindPoint)
	{
		vkCmdBindPipeline(commandBuffer, bindPoint, getPipelineId());
	}

	protected abstract long getPipelineId();
}
