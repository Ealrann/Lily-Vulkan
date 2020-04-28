package org.sheepy.lily.vulkan.core.pipeline;

import org.sheepy.lily.vulkan.core.device.IVulkanContext;

public interface IVkPipelineAdapter<T extends IVulkanContext> extends IPipelineAdapter
{
	VkPipelineLayout<? super T> getVkPipelineLayout();
	VkPipeline<? super T> getVkPipeline();
}
