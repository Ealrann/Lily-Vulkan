package org.sheepy.lily.vulkan.api.resource.buffer;

import java.nio.ByteBuffer;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

public interface ITransferBufferAdapter extends IAdapter
{
	IMemoryTicket reserveMemory(long size);
	void releaseTicket(IMemoryTicket ticket);

	void newPushCommand(IMemoryTicket ticket,
						long trgBuffer,
						long trgOffset,
						EPipelineStage srcStage,
						int srcAccess);

	public interface IMemoryTicket
	{
		EReservationStatus getReservationStatus();
		long getMemoryPtr();
		ByteBuffer toBuffer();

		public static enum EReservationStatus
		{
			SUCCESS,
			FLUSHED,
			FAIL__NO_SPACE_LEFT,
			ERROR__REQUEST_TOO_BIG;
		}
	}
}
