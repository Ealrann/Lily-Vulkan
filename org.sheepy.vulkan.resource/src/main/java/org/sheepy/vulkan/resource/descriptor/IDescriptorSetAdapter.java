package org.sheepy.vulkan.resource.descriptor;

import java.util.List;

import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.vulkan.common.allocation.IBasicAllocable;
import org.sheepy.vulkan.common.execution.AbstractCommandBuffer;
import org.sheepy.vulkan.model.resource.DescriptorSet;

public interface IDescriptorSetAdapter extends IVulkanAdapter, IBasicAllocable
{
	void bindDescriptorSet(	AbstractCommandBuffer commandBuffer,
							int bindPoint,
							long pipelineLayoutId);

	long getId();

	long getLayoutId();

	List<IVkDescriptor> getDescriptors();

	static IDescriptorSetAdapter adapt(DescriptorSet object)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(object, IDescriptorSetAdapter.class);
	}
}
