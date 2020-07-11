package org.sheepy.lily.vulkan.resource.buffer.transfer.backend;

import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkMappedMemoryRange;
import org.sheepy.lily.vulkan.api.resource.transfer.IMemoryTicket;
import org.sheepy.lily.vulkan.core.resource.buffer.CPUBufferBackend;
import org.sheepy.lily.vulkan.resource.buffer.transfer.backend.util.MemorySpace;

import java.nio.ByteBuffer;

import static org.lwjgl.vulkan.VK10.VK_NULL_HANDLE;
import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_MAPPED_MEMORY_RANGE;

public final class MemoryTicket implements IMemoryTicket
{
	public final MemorySpace memorySpace;

	private final CPUBufferBackend stagingBuffer;

	private EReservationStatus reservationStatus;

	public static MemoryTicket requestToBig()
	{
		return emptyTicket(IMemoryTicket.EReservationStatus.ERROR__REQUEST_TOO_BIG);
	}

	public static MemoryTicket noSpaceLeft()
	{
		return emptyTicket(IMemoryTicket.EReservationStatus.FAIL__NO_SPACE_LEFT);
	}

	public static MemoryTicket emptyTicket(IMemoryTicket.EReservationStatus status)
	{
		return new MemoryTicket(status, null, null);
	}

	public MemoryTicket(EReservationStatus reservationStatus, MemorySpace memorySpace, CPUBufferBackend stagingBuffer)
	{
		this.reservationStatus = reservationStatus;
		this.memorySpace = memorySpace;
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

	@Override
	public IMemoryTicket.EReservationStatus getReservationStatus()
	{
		return reservationStatus;
	}

	@Override
	public long getBufferPtr()
	{
		return stagingBuffer.getAddress();
	}

	@Override
	public ByteBuffer toBuffer()
	{
		return MemoryUtil.memByteBuffer(stagingBuffer.getMemoryMap() + memorySpace.getOffset(),
										(int) memorySpace.getSize());
	}

	@Override
	public ByteBuffer toReadBuffer()
	{
		final var res = toBuffer();
		res.limit(res.capacity());
		return res;
	}

	public void markFlushed()
	{
		reservationStatus = EReservationStatus.FLUSHED;
	}

	public void markReleased()
	{
		reservationStatus = EReservationStatus.RELEASED;
	}

	@Override
	public long getSize()
	{
		return memorySpace.getSize();
	}

	@Override
	public long getOffset()
	{
		return memorySpace.getOffset();
	}
}
