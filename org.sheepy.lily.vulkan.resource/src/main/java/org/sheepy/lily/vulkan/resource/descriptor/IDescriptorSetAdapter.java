package org.sheepy.lily.vulkan.resource.descriptor;

import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.model.resource.DescriptorSet;

public interface IDescriptorSetAdapter extends IVulkanAdapter, IVkDescriptorSet
{
	static IDescriptorSetAdapter adapt(DescriptorSet object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, IDescriptorSetAdapter.class);
	}
}
