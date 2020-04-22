package org.sheepy.lily.vulkan.api.resource.buffer;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

import java.nio.ByteBuffer;

public interface ITransferBufferAllocation extends IExtender
{
	IMemoryTicket reserveMemory(long size);
	void releaseTicket(IMemoryTicket ticket);

	void newPushCommand(IMemoryTicket ticket, long trgBuffer, long trgOffset, EPipelineStage srcStage, int srcAccess);

	interface IMemoryTicket
	{
		EReservationStatus getReservationStatus();
		long getMemoryPtr();
		ByteBuffer toBuffer();

		enum EReservationStatus
		{
			SUCCESS,
			FLUSHED,
			FAIL__NO_SPACE_LEFT,
			ERROR__REQUEST_TOO_BIG
		}
	}
}
