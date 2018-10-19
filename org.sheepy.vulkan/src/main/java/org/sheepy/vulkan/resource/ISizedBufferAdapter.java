package org.sheepy.vulkan.resource;

import org.sheepy.vulkan.adapter.IVulkanAdapter;
import org.sheepy.vulkan.adapter.VulkanAdapterFactoryImpl;
import org.sheepy.vulkan.model.resource.SizedBuffer;

public interface ISizedBufferAdapter extends IVulkanAdapter
{
	int getWidth();

	int getHeight();

	int getDepth();

	static ISizedBufferAdapter adapt(SizedBuffer object)
	{
		return VulkanAdapterFactoryImpl.INSTANCE.adapt(object, ISizedBufferAdapter.class);
	}
}
