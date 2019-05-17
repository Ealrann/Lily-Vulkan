package org.sheepy.lily.vulkan.api.resource.mesh;

import java.util.List;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.model.process.graphic.MeshProvider;
import org.sheepy.vulkan.descriptor.IVkDescriptor;

public interface IMeshProviderAdapter extends IAdapter
{
	IMeshObject getMesh();
	List<IVkDescriptor> getDescriptors();
	
	public static IMeshProviderAdapter adapt(MeshProvider resource)
	{
		return IAdapterFactoryService.INSTANCE.adapt(resource, IMeshProviderAdapter.class);
	}
}
