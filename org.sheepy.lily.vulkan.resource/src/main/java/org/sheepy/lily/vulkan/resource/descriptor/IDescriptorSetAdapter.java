package org.sheepy.vulkan.resource.descriptor;

import org.sheepy.common.api.adapter.IServiceAdapterFactory;
import org.sheepy.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.vulkan.model.resource.DescriptorSet;

public interface IDescriptorSetAdapter extends IVulkanAdapter, IVkDescriptorSet
{
	static IDescriptorSetAdapter adapt(DescriptorSet object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, IDescriptorSetAdapter.class);
	}
}
