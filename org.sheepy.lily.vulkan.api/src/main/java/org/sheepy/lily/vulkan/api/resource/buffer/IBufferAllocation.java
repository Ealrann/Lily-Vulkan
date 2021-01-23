package org.sheepy.lily.vulkan.api.resource.buffer;

import org.logoce.extender.api.IAdapter;

public interface IBufferAllocation extends IAdapter
{
	long getPtr();

	long getBindSize();
	long getBindOffset();
}
