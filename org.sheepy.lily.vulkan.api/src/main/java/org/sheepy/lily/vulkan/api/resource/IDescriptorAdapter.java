package org.sheepy.lily.vulkan.api.resource;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.vulkan.descriptor.IVkDescriptor;

public interface IDescriptorAdapter extends IAdapter
{
	IVkDescriptor getVkDescriptor();
	
	void allocate();
	void free();
}
