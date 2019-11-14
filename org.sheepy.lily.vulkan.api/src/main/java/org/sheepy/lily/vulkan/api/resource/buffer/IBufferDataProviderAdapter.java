package org.sheepy.lily.vulkan.api.resource.buffer;

import java.nio.ByteBuffer;

import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;

public interface IBufferDataProviderAdapter extends IVulkanAdapter
{
	long getSize();

	void fill(ByteBuffer buffer);
	void fetch(ByteBuffer buffer);

	boolean hasChanged();
}
