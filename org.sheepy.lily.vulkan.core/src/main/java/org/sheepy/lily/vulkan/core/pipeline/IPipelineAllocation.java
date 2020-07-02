package org.sheepy.lily.vulkan.core.pipeline;

import org.sheepy.lily.core.api.extender.IExtender;

public interface IPipelineAllocation extends IExtender
{
	VkPipelineLayout getVkPipelineLayout();
	VkPipeline getVkPipeline();
}
