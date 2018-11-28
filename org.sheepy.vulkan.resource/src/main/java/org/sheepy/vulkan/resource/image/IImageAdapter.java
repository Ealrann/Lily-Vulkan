package org.sheepy.vulkan.resource.image;

import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.model.resource.Image;
import org.sheepy.vulkan.resource.ISizedBufferAdapter;

public interface IImageAdapter extends ISizedBufferAdapter
{
	int getWidth();

	int getHeight();

	long getMemoryId();
	
	int getFormat();
	
	int getMipLevels();

	static IImageAdapter adapt(Image resource)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(resource, IImageAdapter.class);
	}
}
