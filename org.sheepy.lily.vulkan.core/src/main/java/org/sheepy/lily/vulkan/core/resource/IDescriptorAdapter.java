package org.sheepy.lily.vulkan.core.resource;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.vulkan.core.descriptor.IVkDescriptor;

public interface IDescriptorAdapter extends IAdapter
{
	IVkDescriptor getVkDescriptor();
}
