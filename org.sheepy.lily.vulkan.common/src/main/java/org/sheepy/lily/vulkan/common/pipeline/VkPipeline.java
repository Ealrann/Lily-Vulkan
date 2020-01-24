package org.sheepy.lily.vulkan.common.pipeline;

import static org.lwjgl.vulkan.VK10.vkCmdBindPipeline;

import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.vulkan.api.execution.IExecutionContext;

public abstract class VkPipeline<T extends IExecutionContext> implements IAllocable<T>
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
