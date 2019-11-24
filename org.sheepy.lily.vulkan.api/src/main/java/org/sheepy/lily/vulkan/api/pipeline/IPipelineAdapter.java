package org.sheepy.lily.vulkan.api.pipeline;

import org.sheepy.lily.vulkan.api.process.IProcessContext;
import org.sheepy.lily.vulkan.api.process.IProcessPartAdapter;
import org.sheepy.vulkan.pipeline.VkPipeline;
import org.sheepy.vulkan.pipeline.VkPipelineLayout;

public interface IPipelineAdapter<T extends IProcessContext> extends IProcessPartAdapter
{
	VkPipelineLayout<? super T> getVkPipelineLayout();
	VkPipeline<? super T> getVkPipeline();
}
