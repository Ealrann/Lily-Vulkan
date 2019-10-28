package org.sheepy.lily.vulkan.api.resource;

import java.util.List;

import org.sheepy.vulkan.descriptor.IVkDescriptor;

public interface IDescriptedResourceAdapter extends IResourceAdapter
{
	List<IVkDescriptor> getDescriptors();
}
