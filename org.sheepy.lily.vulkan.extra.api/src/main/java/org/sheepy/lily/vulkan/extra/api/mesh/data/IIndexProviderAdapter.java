package org.sheepy.lily.vulkan.extra.api.mesh.data;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.api.resource.buffer.IBufferDataProviderAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.GenericIndexProvider;

public interface IIndexProviderAdapter extends IBufferDataProviderAdapter
{
	int getIndexCount();

	public static IIndexProviderAdapter adapt(GenericIndexProvider<?> dataProvider)
	{
		return IAdapterFactoryService.INSTANCE.adapt(dataProvider, IIndexProviderAdapter.class);
	}
}
