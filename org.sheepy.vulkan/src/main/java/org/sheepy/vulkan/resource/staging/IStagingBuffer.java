package org.sheepy.vulkan.resource.staging;

import java.util.EventListener;

import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.vulkan.resource.staging.memory.MemorySpaceManager.MemorySpace;

public interface IStagingBuffer
{
	MemoryTicket reserveMemory(long size);
	void releaseTicket(MemoryTicket ticket);

	void addStagingCommand(IDataFlowCommand command);
	boolean isEmpty();

	void prepare();
	void flushCommands(VkCommandBuffer commandBuffer);

	void addListener(FlushListener listener);
	void removeListener(FlushListener listener);

	static interface FlushListener extends EventListener
	{
		@FunctionalInterface
		interface PreFlushListener extends FlushListener
		{
			void preFlush();
		}

		@FunctionalInterface
		interface PostFlushListener extends FlushListener
		{
			void postFlush();
		}
	}

	static final class MemoryTicket
	{
		final MemorySpace memorySpace;

		private final long bufferPtr;
		private final long memoryPtr;
		private final long bufferOffset;
		private final long size;

		private EReservationStatus reservationStatus;

		MemoryTicket(	EReservationStatus reservationStatus,
						MemorySpace memorySpace,
						long bufferPtr,
						long memoryPtr,
						long bufferOffset,
						long size)
		{
			this.reservationStatus = reservationStatus;
			this.memorySpace = memorySpace;
			this.bufferPtr = bufferPtr;
			this.memoryPtr = memoryPtr;
			this.bufferOffset = bufferOffset;
			this.size = size;
		}

		public void invalidate()
		{
			reservationStatus = EReservationStatus.FLUSHED;
		}

		public EReservationStatus getReservationStatus()
		{
			return reservationStatus;
		}

		public long getBufferPtr()
		{
			return bufferPtr;
		}

		public long getMemoryPtr()
		{
			return memoryPtr;
		}

		public long getSize()
		{
			return size;
		}

		public long getBufferOffset()
		{
			return bufferOffset;
		}

		public static enum EReservationStatus
		{
			SUCCESS,
			FLUSHED,
			FAIL__NO_SPACE_LEFT,
			ERROR__REQUEST_TOO_BIG;
		}
	}
}
