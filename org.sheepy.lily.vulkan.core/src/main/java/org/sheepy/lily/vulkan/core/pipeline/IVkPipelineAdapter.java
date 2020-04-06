package org.sheepy.lily.vulkan.core.pipeline;

import org.sheepy.lily.vulkan.core.descriptor.IVkDescriptorSet;
import org.sheepy.lily.vulkan.core.device.VulkanContext;

import java.util.List;

public interface IVkPipelineAdapter<T extends VulkanContext> extends IPipelineAdapter
{
	VkPipelineLayout<? super T> getVkPipelineLayout();
	VkPipeline<? super T> getVkPipeline();
	void collectDescriptorSets(List<IVkDescriptorSet> collectIn);
}
