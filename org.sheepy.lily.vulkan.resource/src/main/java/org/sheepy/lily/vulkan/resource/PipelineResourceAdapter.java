package org.sheepy.lily.vulkan.resource;

import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.vulkan.model.resource.PipelineResource;
import org.sheepy.lily.vulkan.resource.descriptor.IDescriptorAdapter;

public abstract class PipelineResourceAdapter extends ResourceAdapter implements IDescriptorAdapter
{
	public static PipelineResourceAdapter adapt(PipelineResource resource)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(resource, PipelineResourceAdapter.class);
	}
}
