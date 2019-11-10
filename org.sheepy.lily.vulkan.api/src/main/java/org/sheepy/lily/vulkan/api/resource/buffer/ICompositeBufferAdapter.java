package org.sheepy.lily.vulkan.api.resource.buffer;

import org.sheepy.lily.vulkan.model.resource.EFlushMode;

public interface ICompositeBufferAdapter extends IBufferAdapter
{
	long getOffset(int componentIndex, int instance);
	void prepareFlush(EFlushMode mode, int instance);
	boolean needRecord();
}
