package org.sheepy.lily.vulkan.api.resource.buffer;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.vulkan.api.resource.transfer.IMemoryTicket;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

public interface ITransferBufferAllocation extends IExtender
{
	IMemoryTicket reserveMemory(long size);
	void releaseTicket(IMemoryTicket ticket);

	void newPushCommand(IMemoryTicket ticket, long trgBuffer, long trgOffset, EPipelineStage srcStage, int srcAccess);
}
