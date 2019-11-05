package org.sheepy.lily.vulkan.api.resource.buffer;

import org.sheepy.lily.core.api.adapter.INotifierAdapter;
import org.sheepy.lily.vulkan.model.resource.IBufferReference;

public interface IBufferReferenceAdapter extends INotifierAdapter
{
	public static enum FEATURES
	{
		SIZE,
		OFFSET,
		BUFFER_PTR
	};

	long getBufferPtr(IBufferReference ref);
	long getOffset(IBufferReference ref);
	long getSize(IBufferReference ref);
	void flush(IBufferReference ref);
}
