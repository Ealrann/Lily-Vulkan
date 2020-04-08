package org.sheepy.lily.vulkan.core.pipeline;

import org.sheepy.lily.vulkan.core.descriptor.IVkDescriptorSet;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;

import java.util.List;

public interface IVkPipelineAdapter<T extends IVulkanContext> extends IPipelineAdapter
{
	VkPipelineLayout<? super T> getVkPipelineLayout();
	VkPipeline<? super T> getVkPipeline();
	void collectDescriptorSets(List<IVkDescriptorSet> collectIn);
}
