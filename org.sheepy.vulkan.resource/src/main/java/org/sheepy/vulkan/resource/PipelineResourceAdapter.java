package org.sheepy.vulkan.resource;

import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.common.allocation.adapter.impl.AbstractFlatAllocableAdapter;
import org.sheepy.vulkan.model.resource.Resource;
import org.sheepy.vulkan.resource.descriptor.IDescriptorAdapter;

public abstract class PipelineResourceAdapter extends AbstractFlatAllocableAdapter
		implements IDescriptorAdapter
{
	@Override
	public boolean isDirty()
	{
		return false;
	}
	
	public static PipelineResourceAdapter adapt(Resource resource)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(resource, PipelineResourceAdapter.class);
	}
}
