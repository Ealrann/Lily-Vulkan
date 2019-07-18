package org.sheepy.lily.vulkan.api.resource.buffer;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.model.resource.IndexProvider;

public interface IIndexProviderAdapter<T> extends IBufferDataProviderAdapter<T>
{
	int getIndexCount(T dataSource);

	@SuppressWarnings("unchecked")
	public static <T> IIndexProviderAdapter<T> adapt(IndexProvider<T> dataProvider)
	{
		return IAdapterFactoryService.INSTANCE.adapt(dataProvider, IIndexProviderAdapter.class);
	}
}
