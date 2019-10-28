package org.sheepy.lily.vulkan.api.resource.buffer;

import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;

public interface IBufferDataProviderAdapter extends IVulkanAdapter
{
	long getSize();

	void fill(long memoryAddress);

	boolean hasChanged();
}
