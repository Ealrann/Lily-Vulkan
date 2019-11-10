package org.sheepy.lily.vulkan.api.resource.buffer;

import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;

public interface IBufferDataProviderAdapter extends IVulkanAdapter
{
	long getSize();

	void fill(long memoryAddress, int size);
	void fetch(long memoryAddress, int size);

	boolean hasChanged();
}
