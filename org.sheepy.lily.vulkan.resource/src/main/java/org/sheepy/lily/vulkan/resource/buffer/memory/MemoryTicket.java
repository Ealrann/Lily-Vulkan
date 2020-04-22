package org.sheepy.lily.vulkan.resource.buffer.memory;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.vulkan.api.resource.buffer.ITransferBufferAllocation.IMemoryTicket;
import org.sheepy.lily.vulkan.resource.buffer.memory.MemorySpaceManager.MemorySpace;

public final class MemoryTicket implements IMemoryTicket
{
	public final MemorySpace memorySpace;

	private final long bufferPtr;
	private final long memoryPtr;
	private final long bufferOffset;
	private final long size;

	private EReservationStatus reservationStatus;

	public MemoryTicket(EReservationStatus reservationStatus,
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

	@Override
	public EReservationStatus getReservationStatus()
	{
		return reservationStatus;
	}

	public long getBufferPtr()
	{
		return bufferPtr;
	}

	@Override
	public long getMemoryPtr()
	{
		return memoryPtr;
	}

	@Override
	public ByteBuffer toBuffer()
	{
		return MemoryUtil.memByteBuffer(memoryPtr, (int) size);
	}

	public ByteBuffer toReadBuffer()
	{
		final var res = toBuffer();
		res.limit(res.capacity());
		return res;
	}

	public long getSize()
	{
		return size;
	}

	public long getBufferOffset()
	{
		return bufferOffset;
	}
}