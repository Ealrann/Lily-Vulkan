package org.sheepy.lily.vulkan.common.resource;

import org.sheepy.lily.core.api.adapter.INotifierAdapter;

public interface IDataProviderAlignmentAdapter extends INotifierAdapter
{
	public static enum FEATURES
	{
		SIZE,
		OFFSET,
		BUFFER_PTR
	};

	long getBufferPtr();
	long getInstanceSize();
	long getInstanceOffset(int instance);
}
