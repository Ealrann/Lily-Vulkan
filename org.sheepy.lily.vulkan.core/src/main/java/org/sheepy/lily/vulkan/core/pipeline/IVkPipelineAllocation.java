package org.sheepy.lily.vulkan.core.pipeline;

import org.sheepy.lily.vulkan.core.device.IVulkanContext;

public interface IVkPipelineAllocation<T extends IVulkanContext> extends IRecordableAllocation
{
	VkPipelineLayout getVkPipelineLayout();
	VkPipeline<? super T> getVkPipeline();
}
