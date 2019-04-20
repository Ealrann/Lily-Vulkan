package org.sheepy.lily.vulkan.extra.api.terrain;

import java.util.List;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.api.resource.IVertexBufferDescriptor;
import org.sheepy.lily.vulkan.extra.graphic.model.IMeshProvider;

public interface IMeshProviderAdapter extends IAdapter
{
	List<IMeshObject> getMeshes();
	IVertexBufferDescriptor<?> getVertexBufferDescriptor();
	
	public static IMeshProviderAdapter adapt(IMeshProvider resource)
	{
		return IAdapterFactoryService.INSTANCE.adapt(resource, IMeshProviderAdapter.class);
	}
}
