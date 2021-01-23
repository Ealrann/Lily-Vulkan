package org.sheepy.lily.vulkan.core.pipeline;

import org.logoce.extender.api.IAdapter;

public interface IPipelineAllocation extends IAdapter
{
	VkPipelineLayout getVkPipelineLayout();
	VkPipeline getVkPipeline();
}
