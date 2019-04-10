package org.sheepy.lily.vulkan.resource.descriptor;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.api.nativehelper.descriptor.IVkDescriptorSet;
import org.sheepy.lily.vulkan.model.resource.DescriptorSet;

public interface IDescriptorSetAdapter extends IVulkanAdapter, IVkDescriptorSet
{
	static IDescriptorSetAdapter adapt(DescriptorSet object)
	{
		return IAdapterFactoryService.INSTANCE.adapt(object, IDescriptorSetAdapter.class);
	}
}
