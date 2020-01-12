package org.sheepy.lily.vulkan.api.pipeline;

import java.util.List;

import org.sheepy.lily.vulkan.api.process.IProcessContext;
import org.sheepy.vulkan.descriptor.IVkDescriptorSet;
import org.sheepy.vulkan.pipeline.VkPipeline;
import org.sheepy.vulkan.pipeline.VkPipelineLayout;

public interface IVkPipelineAdapter<T extends IProcessContext> extends IPipelineAdapter
{
	VkPipelineLayout<? super T> getVkPipelineLayout();
	VkPipeline<? super T> getVkPipeline();
	void collectDescriptorSets(List<IVkDescriptorSet> collectIn);
}
