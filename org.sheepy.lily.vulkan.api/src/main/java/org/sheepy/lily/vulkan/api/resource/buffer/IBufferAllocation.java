package org.sheepy.lily.vulkan.api.resource.buffer;

import org.sheepy.lily.core.api.extender.IExtender;

public interface IBufferAllocation extends IExtender
{
	long getPtr();

	long getBindSize();
	long getBindOffset();
}
