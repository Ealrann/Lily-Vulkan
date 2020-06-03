package org.sheepy.lily.vulkan.core.pipeline;

public interface IVkPipelineRecordable extends IPipelineRecordable
{
	VkPipelineLayout getVkPipelineLayout();
	VkPipeline getVkPipeline();
}
