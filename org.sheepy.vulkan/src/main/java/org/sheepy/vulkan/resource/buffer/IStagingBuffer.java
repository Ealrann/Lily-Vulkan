package org.sheepy.vulkan.resource.buffer;

import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

public interface IStagingBuffer
{
	MemoryTicket reserveMemory(long size);
	void releaseTicket(MemoryTicket ticket);

	void pushSynchronized(	MemoryTicket ticket,
							long trgAddress,
							long trgOffset,
							EPipelineStage dstStage,
							EAccess dstAccess);

	void pushUnsynchronized(MemoryTicket ticket, long trgAddress, long trgOffset);

	boolean isEmpty();
	void flush(VkCommandBuffer commandBuffer);

	static final class MemoryTicket
	{
		public final EReservationStatus reservationStatus;
		public final long memoryAddress;

		public MemoryTicket(EReservationStatus reservationStatus, long memoryAddress)
		{
			this.reservationStatus = reservationStatus;
			this.memoryAddress = memoryAddress;
		}

		public static enum EReservationStatus
		{
			SUCCESS,
			FAIL__NO_SPACE_LEFT,
			ERROR__REQUEST_TOO_BIG;
		}
	}

}
