package org.sheepy.lily.vulkan.api.resource;

import java.util.List;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.model.resource.DescriptedResource;
import org.sheepy.vulkan.descriptor.IVkDescriptor;

public interface IDescriptedResourceAdapter extends IVulkanAdapter
{
	List<IVkDescriptor> getDescriptors();

	static IDescriptedResourceAdapter adapt(DescriptedResource object)
	{
		return IAdapterFactoryService.INSTANCE.adapt(object, IDescriptedResourceAdapter.class);
	}
}
