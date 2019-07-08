package org.sheepy.vulkan.resource.buffer;

import static org.lwjgl.vulkan.VK10.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkBufferMemoryBarrier;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.resource.buffer.IStagingBuffer.MemoryTicket.EReservationStatus;

public class StagingBuffer implements IAllocable<IExecutionContext>, IStagingBuffer
{
	public final CPUBufferBackend bufferBackend;

	private final Map<Long, TransferCommand> commands = new HashMap<>();
	private final Deque<TransferCommand> synchronizedCommands = new ArrayDeque<>();
	private final Deque<TransferCommand> unsynchronizedCommands = new ArrayDeque<>();
	private final long capacity;

	private long position = 0;
	private IExecutionContext executionContext;

	private long minMemoryMapAlignment;

	public StagingBuffer(long capacity, int instanceCount)
	{
		this.capacity = capacity;
		final BufferInfo info = new BufferInfo(capacity, EBufferUsage.TRANSFER_SRC_BIT_VALUE, true,
				instanceCount);
		bufferBackend = new CPUBufferBackend(info, false);
	}

	@Override
	public void allocate(MemoryStack stack, IExecutionContext context)
	{
		this.executionContext = context;
		final var physicalDevice = context.getPhysicalDevice();
		minMemoryMapAlignment = physicalDevice.getDeviceProperties().limits()
				.minMemoryMapAlignment();

		bufferBackend.allocate(stack, context);
	}

	@Override
	public void free(IExecutionContext context)
	{
		bufferBackend.free(context);
	}

	@Override
	public MemoryTicket reserveMemory(long size)
	{
		long address = -1;
		EReservationStatus status;

		final long alignedSize = align(size, minMemoryMapAlignment);

		if (alignedSize > capacity)
		{
			status = EReservationStatus.ERROR__REQUEST_TOO_BIG;
		}
		else if (position + alignedSize > capacity)
		{
			status = EReservationStatus.FAIL__NO_SPACE_LEFT;
		}
		else
		{
			status = EReservationStatus.SUCCESS;
			address = bufferBackend.getMemoryMap() + position;
			final long bufferOffset = bufferBackend.getOffset() + position;

			final var command = new TransferCommand(bufferBackend.getAddress(), bufferOffset, size);
			commands.put(address, command);
			position += alignedSize;
		}

		return new MemoryTicket(status, address);
	}

	private static final long align(long index, long alignment)
	{
		final int chunkCount = (int) Math.ceil(((double) index) / alignment);
		return chunkCount * alignment;
	}

	@Override
	public void releaseTicket(MemoryTicket ticket)
	{
		commands.remove(ticket.memoryAddress);

		/**
		 * @TODO position should be relocated. We need a new algorithm to manage fragmented memory
		 */
	}

	@Override
	public void pushSynchronized(	MemoryTicket ticket,
									long trgAddress,
									long trgOffset,
									EPipelineStage dstStage,
									EAccess dstAccess)
	{
		if (ticket.reservationStatus != EReservationStatus.SUCCESS)
		{
			throw new IllegalStateException("MemoryTicket reservation was rejected");
		}

		final var transferCommand = commands.get(ticket.memoryAddress);
		synchronizedCommands.add(transferCommand);
		transferCommand.setTarget(trgAddress, trgOffset, dstStage, dstAccess);
	}

	@Override
	public void pushUnsynchronized(MemoryTicket ticket, long trgAddress, long trgOffset)
	{
		if (ticket.reservationStatus != EReservationStatus.SUCCESS)
		{
			throw new IllegalStateException("MemoryTicket reservation was rejected");
		}

		final var transferCommand = commands.get(ticket.memoryAddress);
		unsynchronizedCommands.add(transferCommand);
		transferCommand.setTarget(trgAddress, trgOffset);
	}

	@Override
	public boolean isEmpty()
	{
		return commands.isEmpty();
	}

	@Override
	public void flush(VkCommandBuffer commandBuffer)
	{
		bufferBackend.flush(executionContext.getLogicalDevice());
		bufferBackend.nextInstance();

		try (MemoryStack stack = MemoryStack.stackPush())
		{
			while (synchronizedCommands.isEmpty() == false)
			{
				synchronizedCommands.pop().execute(stack, commandBuffer);
			}
		}

		if (unsynchronizedCommands.isEmpty() == false)
		{
			executionContext.execute((MemoryStack stack, VkCommandBuffer subCommandBuffer) -> {
				while (unsynchronizedCommands.isEmpty() == false)
				{
					unsynchronizedCommands.pop().execute(stack, subCommandBuffer);
				}
			});
		}

		commands.clear();
		position = 0;
	}

	@Override
	public boolean isAllocationDirty(IExecutionContext context)
	{
		return false;
	}

	private class TransferCommand
	{
		private final long srcBuffer;
		private final long offset;
		private final long size;

		private long trgBuffer;
		private long trgOffset;
		private EPipelineStage dstStage = null;
		private EAccess dstAccess = null;

		public TransferCommand(long srcBuffer, long offset, long size)
		{
			this.srcBuffer = srcBuffer;
			this.offset = offset;
			this.size = size;
		}

		public void execute(MemoryStack stack, VkCommandBuffer commandBuffer)
		{
			final var barrierInfo = VkBufferMemoryBarrier.callocStack(1, stack);
			barrierInfo.sType(VK_STRUCTURE_TYPE_BUFFER_MEMORY_BARRIER);
			barrierInfo.buffer(trgBuffer);
			barrierInfo.srcAccessMask(0);
			barrierInfo.dstAccessMask(EAccess.TRANSFER_WRITE_BIT_VALUE);
			barrierInfo.offset(0);
			barrierInfo.size(VK_WHOLE_SIZE);

			final var srcStage1 = EPipelineStage.TOP_OF_PIPE_BIT_VALUE;
			final var dstStage1 = EPipelineStage.TRANSFER_BIT_VALUE;

			vkCmdPipelineBarrier(commandBuffer, srcStage1, dstStage1, 0, null, barrierInfo, null);

			BufferUtils.copyBuffer(commandBuffer, srcBuffer, offset, trgBuffer, trgOffset, size);

			if (dstStage != null)
			{
				final var srcStage2 = EPipelineStage.TRANSFER_BIT_VALUE;
				final var dstStage2 = dstStage.getValue();

				barrierInfo.srcAccessMask(EAccess.TRANSFER_WRITE_BIT_VALUE);
				barrierInfo.dstAccessMask(dstAccess.getValue());

				vkCmdPipelineBarrier(commandBuffer, srcStage2, dstStage2, 0, null, barrierInfo,
						null);
			}
		}

		public void setTarget(	long trgBuffer,
								long trgOffset,
								EPipelineStage dstStage,
								EAccess dstAccess)
		{
			this.setTarget(trgBuffer, trgOffset);

			this.dstStage = dstStage;
			this.dstAccess = dstAccess;
		}

		public void setTarget(long trgBuffer, long trgOffset)
		{
			this.trgBuffer = trgBuffer;
			this.trgOffset = trgOffset;
		}
	}
}
