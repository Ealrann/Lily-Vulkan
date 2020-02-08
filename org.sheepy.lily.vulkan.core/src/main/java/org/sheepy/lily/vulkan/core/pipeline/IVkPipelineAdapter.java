package org.sheepy.lily.vulkan.core.pipeline;

import java.util.List;

import org.sheepy.lily.vulkan.core.descriptor.IVkDescriptorSet;
import org.sheepy.lily.vulkan.core.process.IProcessContext;

public interface IVkPipelineAdapter<T extends IProcessContext> extends IPipelineAdapter
{
	VkPipelineLayout<? super T> getVkPipelineLayout();
	VkPipeline<? super T> getVkPipeline();
	void collectDescriptorSets(List<IVkDescriptorSet> collectIn);
}
