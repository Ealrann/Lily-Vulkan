package org.sheepy.lily.vulkan.resource.buffer.transfer.backend;

import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkMappedMemoryRange;
import org.sheepy.lily.vulkan.core.resource.buffer.HostVisibleBufferBackend;
import org.sheepy.lily.vulkan.resource.buffer.transfer.backend.util.MemorySpace;

import java.nio.ByteBuffer;

import static org.lwjgl.vulkan.VK10.VK_NULL_HANDLE;
import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_MAPPED_MEMORY_RANGE;

public final class MemoryTicket
{
	public enum EReservationStatus
	{
		SUCCESS,
		FLUSHED,
		FAIL__NO_SPACE_LEFT,
		ERROR__REQUEST_TOO_BIG,
		RELEASED
	}

	public final MemorySpace memorySpace;

	private final HostVisibleBufferBackend stagingBuffer;
	private final long requestedSize;

	private EReservationStatus reservationStatus;

	public static MemoryTicket requestToBig()
	{
		return emptyTicket(MemoryTicket.EReservationStatus.ERROR__REQUEST_TOO_BIG);
	}

	public static MemoryTicket noSpaceLeft()
	{
		return emptyTicket(MemoryTicket.EReservationStatus.FAIL__NO_SPACE_LEFT);
	}

	public static MemoryTicket emptyTicket(final MemoryTicket.EReservationStatus status)
	{
		return new MemoryTicket(status, null, 0, null);
	}

	public MemoryTicket(final EReservationStatus reservationStatus,
						final MemorySpace memorySpace,
						final long requestedSize,
						final HostVisibleBufferBackend stagingBuffer)
	{
		this.reservationStatus = reservationStatus;
		this.memorySpace = memorySpace;
		this.requestedSize = requestedSize;
		this.stagingBuffer = stagingBuffer;
	}

	public void fillMemoryRange(VkMappedMemoryRange memoryRange)
	{
		memoryRange.set(VK_STRUCTURE_TYPE_MAPPED_MEMORY_RANGE,
						VK_NULL_HANDLE,
						stagingBuffer.getMemoryAddress(),
						memorySpace.getOffset(),
						memorySpace.getSize());
	}

	public MemoryTicket.EReservationStatus getReservationStatus()
	{
		return reservationStatus;
	}

	public long getBufferPtr()
	{
		return stagingBuffer.getAddress();
	}

	public ByteBuffer toBuffer()
	{
		final long memAddress = stagingBuffer.getMemoryMap() + memorySpace.getOffset();
		return MemoryUtil.memByteBuffer(memAddress, (int) requestedSize);
	}

	public void markFlushed()
	{
		reservationStatus = EReservationStatus.FLUSHED;
	}

	public void markReleased()
	{
		reservationStatus = EReservationStatus.RELEASED;
	}

	public long getMemorySize()
	{
		return memorySpace.getSize();
	}

	public long getRequestedSize()
	{
		return requestedSize;
	}

	public long getOffset()
	{
		return memorySpace.getOffset();
	}
}
