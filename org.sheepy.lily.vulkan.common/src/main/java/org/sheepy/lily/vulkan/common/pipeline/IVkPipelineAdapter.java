package org.sheepy.lily.vulkan.common.pipeline;

import java.util.List;

import org.sheepy.lily.vulkan.common.descriptor.IVkDescriptorSet;
import org.sheepy.lily.vulkan.common.process.IProcessContext;

public interface IVkPipelineAdapter<T extends IProcessContext> extends IPipelineAdapter
{
	VkPipelineLayout<? super T> getVkPipelineLayout();
	VkPipeline<? super T> getVkPipeline();
	void collectDescriptorSets(List<IVkDescriptorSet> collectIn);
}
