package org.sheepy.lily.vulkan.api.resource;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.api.allocation.IAllocableAdapter;
import org.sheepy.lily.vulkan.model.IResource;
import org.sheepy.vulkan.execution.IExecutionContext;

public interface IResourceAdapter extends IAllocableAdapter<IExecutionContext>
{
	public static IResourceAdapter adapt(IResource resource)
	{
		return IAdapterFactoryService.INSTANCE.adapt(resource, IResourceAdapter.class);
	}
}
