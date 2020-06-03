package org.sheepy.lily.vulkan.resource.image;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.descriptor.IDescriptorAdapter;
import org.sheepy.lily.vulkan.model.resource.SampledImageDescriptor;

@ModelExtender(scope = SampledImageDescriptor.class)
@Adapter(singleton = true)
public final class SampledImageDescriptorAdapter implements IDescriptorAdapter
{
	@Override
	public int sizeInPool()
	{
		return 1;
	}
}
