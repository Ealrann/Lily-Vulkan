package org.sheepy.lily.vulkan.api.resource.buffer;

import java.nio.ByteBuffer;

import org.sheepy.lily.core.api.adapter.IAdapter;

public interface IBufferDataProviderAdapter extends IAdapter
{
	long requestedSize();

	void fill(ByteBuffer buffer);
	void fetch(ByteBuffer buffer);

	boolean hasChanged();
}
