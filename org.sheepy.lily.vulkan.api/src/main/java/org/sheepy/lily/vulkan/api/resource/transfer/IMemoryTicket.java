package org.sheepy.lily.vulkan.api.resource.transfer;

import java.nio.ByteBuffer;

public interface IMemoryTicket
{
	EReservationStatus getReservationStatus();
	long getBufferPtr();
	long getSize();
	long getOffset();
	ByteBuffer toBuffer();
	ByteBuffer toReadBuffer();

	enum EReservationStatus
	{
		SUCCESS,
		FLUSHED,
		FAIL__NO_SPACE_LEFT,
		ERROR__REQUEST_TOO_BIG,
		RELEASED
	}
}
