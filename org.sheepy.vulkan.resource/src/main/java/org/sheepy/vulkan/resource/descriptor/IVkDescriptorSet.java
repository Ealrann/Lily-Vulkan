package org.sheepy.vulkan.resource.descriptor;

import java.util.List;

import org.sheepy.vulkan.common.execution.AbstractCommandBuffer;

public interface IVkDescriptorSet
{
	long getId();

	long getLayoutId();

	List<IVkDescriptor> getDescriptors();

	void bindDescriptorSet(	AbstractCommandBuffer commandBuffer,
							int bindPoint,
							long pipelineLayoutId);
}
