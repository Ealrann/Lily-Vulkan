package org.sheepy.lily.vulkan.resource.descriptor;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.model.resource.IDescriptor;

public interface IDescriptorAdapter extends IVulkanAdapter, IVkDescriptor
{
	static IDescriptorAdapter adapt(IDescriptor object)
	{
		return IAdapterFactoryService.INSTANCE.adapt(object, IDescriptorAdapter.class);
	}
}
