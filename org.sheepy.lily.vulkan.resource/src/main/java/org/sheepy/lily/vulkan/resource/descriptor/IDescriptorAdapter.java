package org.sheepy.lily.vulkan.resource.descriptor;

import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.model.resource.IDescriptor;

public interface IDescriptorAdapter extends IVulkanAdapter, IVkDescriptor
{
	static IDescriptorAdapter adapt(IDescriptor object)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(object, IDescriptorAdapter.class);
	}
}
