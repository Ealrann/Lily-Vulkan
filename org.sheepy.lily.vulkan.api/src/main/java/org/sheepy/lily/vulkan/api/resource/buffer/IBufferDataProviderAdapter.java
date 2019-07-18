package org.sheepy.lily.vulkan.api.resource.buffer;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.model.resource.BufferDataProvider;

public interface IBufferDataProviderAdapter<T> extends IVulkanAdapter
{
	boolean hasChanged(T dataSource);

	void fill(T dataSource, long memoryAddress);

	@SuppressWarnings("unchecked")
	public static <T> IBufferDataProviderAdapter<T> adapt(BufferDataProvider<T> dataProvider)
	{
		return IAdapterFactoryService.INSTANCE.adapt(dataProvider, IBufferDataProviderAdapter.class);
	}
}
