package org.sheepy.vulkan.resource.descriptor;

import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.vulkan.model.resource.IDescriptor;

public interface IDescriptorAdapter extends IVulkanAdapter, IVkDescriptor
{
	static IDescriptorAdapter adapt(IDescriptor object)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(object, IDescriptorAdapter.class);
	}
}
