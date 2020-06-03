package org.sheepy.lily.vulkan.resource.buffer;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorAdapter;
import org.sheepy.lily.vulkan.model.resource.BufferDescriptor;

@ModelExtender(scope = BufferDescriptor.class)
@Adapter(singleton = true)
public final class BufferDescriptorAdapter implements IDescriptorAdapter
{
	@Override
	public int sizeInPool()
	{
		return 1;
	}
}
