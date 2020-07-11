package org.sheepy.lily.vulkan.api.resource.buffer;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.vulkan.api.resource.transfer.IMemoryTicket;

public interface ITransferBufferAllocation extends IExtender
{
	IMemoryTicket reserveMemory(long size);
	void releaseTicket(IMemoryTicket ticket);
}
