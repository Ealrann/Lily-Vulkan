package org.sheepy.vulkan.resource.image;

import org.sheepy.vulkan.adapter.VulkanAdapterFactoryImpl;
import org.sheepy.vulkan.model.resource.Image;
import org.sheepy.vulkan.resource.ISizedBufferAdapter;

public interface IImageAdapter extends ISizedBufferAdapter
{
	long getId();

	long getSize();

	long getMemoryId();
	
	int getFormat();
	
	int getMipLevels();

	static IImageAdapter adapt(Image resource)
	{
		return VulkanAdapterFactoryImpl.INSTANCE.adapt(resource, IImageAdapter.class);
	}
}
