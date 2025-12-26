package org.sheepy.lily.vulkan.core.pipeline;

import org.logoce.lmf.core.api.extender.IAdapter;

public interface IPipelineAllocation extends IAdapter
{
	VkPipelineLayout getVkPipelineLayout();

	VkPipeline getVkPipeline();
}
