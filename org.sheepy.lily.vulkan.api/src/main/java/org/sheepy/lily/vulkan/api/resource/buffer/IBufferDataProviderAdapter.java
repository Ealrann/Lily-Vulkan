package org.sheepy.lily.vulkan.api.resource.buffer;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.model.resource.BufferDataProvider;

public interface IBufferDataProviderAdapter extends IVulkanAdapter
{
	long getSize();

	void fill(long memoryAddress);

	boolean hasChanged();

	public static IBufferDataProviderAdapter adapt(BufferDataProvider<?> dataProvider)
	{
		return IAdapterFactoryService.INSTANCE.adapt(dataProvider, IBufferDataProviderAdapter.class);
	}
}
