package org.sheepy.vulkan.resource;

import org.sheepy.common.api.adapter.impl.ServiceAdapterFactory;
import org.sheepy.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.vulkan.model.resource.SizedBuffer;

public interface ISizedBufferAdapter extends IVulkanAdapter
{
	long getId();
	
	long getSize();

	static ISizedBufferAdapter adapt(SizedBuffer object)
	{
		return ServiceAdapterFactory.INSTANCE.adapt(object, ISizedBufferAdapter.class);
	}
}
