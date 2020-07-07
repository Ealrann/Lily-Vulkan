package org.sheepy.lily.vulkan.resource.memorychunk.util;

import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.vulkan.api.resource.transfer.IMemoryTicket;
import org.sheepy.lily.vulkan.resource.memorychunk.util.MemorySpaceManager.MemorySpace;

import java.nio.ByteBuffer;

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
	public IMemoryTicket.EReservationStatus getReservationStatus()
	{
		return reservationStatus;
	}

	@Override
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

	@Override
	public ByteBuffer toReadBuffer()
	{
		final var res = toBuffer();
		res.limit(res.capacity());
		return res;
	}

	@Override
	public long getSize()
	{
		return size;
	}

	@Override
	public long getBufferOffset()
	{
		return bufferOffset;
	}
}
