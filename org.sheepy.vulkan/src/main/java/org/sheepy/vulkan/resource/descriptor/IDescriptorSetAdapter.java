package org.sheepy.vulkan.resource.descriptor;

import org.sheepy.vulkan.adapter.VulkanAdapterFactoryImpl;
import org.sheepy.vulkan.allocation.adapter.IFlatAllocableAdapter;
import org.sheepy.vulkan.execution.AbstractCommandBuffer;
import org.sheepy.vulkan.model.resource.DescriptorSet;

public interface IDescriptorSetAdapter extends IFlatAllocableAdapter
{
	void bindDescriptorSet(	AbstractCommandBuffer commandBuffer,
							int bindPoint,
							long pipelineLayoutId);

	long getId();

	long getLayoutId();

	public static IDescriptorSetAdapter adapt(DescriptorSet object)
	{
		return VulkanAdapterFactoryImpl.INSTANCE.adapt(object, IDescriptorSetAdapter.class);
	}
}
