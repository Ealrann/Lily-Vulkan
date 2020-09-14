package org.sheepy.lily.vulkan.resource.buffer.transfer.backend;

import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.game.api.execution.EExecutionStatus;
import org.sheepy.lily.vulkan.api.resource.transfer.IMemoryTicket;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.resource.buffer.BufferInfo;
import org.sheepy.lily.vulkan.core.resource.buffer.HostVisibleBufferBackend;
import org.sheepy.lily.vulkan.core.resource.transfer.IDataFlowCommand;
import org.sheepy.lily.vulkan.resource.buffer.transfer.backend.util.FlushRecord;
import org.sheepy.lily.vulkan.resource.buffer.transfer.backend.util.MemorySpace;
import org.sheepy.lily.vulkan.resource.buffer.transfer.backend.util.MemorySpaceManager;
import org.sheepy.lily.vulkan.resource.buffer.transfer.command.DataFlowCommand;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;

import java.util.ArrayList;
import java.util.List;

public final class TransferBufferBackend
{
	private static final String MEMORY_RESERVATION_REJECTED = "MemoryTicket reservation was rejected";

	public final HostVisibleBufferBackend bufferBackend;

	private final List<DataFlowCommand> commands = new ArrayList<>();
	private final long capacity;
	private final MemorySpaceManager spaceManager;

	private TransferBufferBackend(HostVisibleBufferBackend bufferBackend, final long nonCoherentAtomSize)
	{
		this.bufferBackend = bufferBackend;
		this.capacity = bufferBackend.getSize();
		spaceManager = new MemorySpaceManager(capacity, nonCoherentAtomSize);
	}

	public void free(ExecutionContext context)
	{
		bufferBackend.free(context);
	}

	public MemoryTicket reserveMemory(long size)
	{
		assert size > 0;

		if (size > capacity)
		{
			return MemoryTicket.requestToBig();
		}
		else
		{
			return spaceManager.reserveMemory(size)
							   .map(space -> buildMemoryTicket(space, size))
							   .orElseGet(MemoryTicket::noSpaceLeft);
		}
	}

	private MemoryTicket buildMemoryTicket(final MemorySpace space, long size)
	{
		return newSuccessTicket(space, size);
	}

	public void addTransferCommand(DataFlowCommand command)
	{
		assert checkMemoryReservation(command);
		commands.add(command);
	}

	public boolean isEmpty()
	{
		return commands.isEmpty();
	}

	public void recordFlush(final RecordContext context, final VkDevice vkDevice)
	{
		final var res = new FlushRecord(vkDevice, commands);
		res.flush(context);

		final var flushedCommands = List.copyOf(commands);
		context.listenExecution(status -> executionDone(status, flushedCommands));

		clear();
	}

	private void executionDone(EExecutionStatus status, List<DataFlowCommand> commands)
	{
		switch (status)
		{
			case Done -> commands.stream().map(DataFlowCommand::getMemoryTicket).forEach(this::releaseTicket);
			case Canceled -> this.commands.addAll(commands);
		}
	}

	public void releaseTicket(MemoryTicket ticket)
	{
		spaceManager.releaseMemory(ticket.memorySpace);
		ticket.markReleased();
	}

	private void clear()
	{
		for (int i = 0; i < commands.size(); i++)
		{
			final var command = commands.get(i);
			final var ticket = command.getMemoryTicket();
			ticket.markFlushed();
		}
		commands.clear();
	}

	private MemoryTicket newSuccessTicket(MemorySpace space, long requestedSize)
	{
		return new MemoryTicket(IMemoryTicket.EReservationStatus.SUCCESS, space, requestedSize, bufferBackend);
	}

	@SuppressWarnings("SameReturnValue")
	private static boolean checkMemoryReservation(final IDataFlowCommand command)
	{
		if (command.getMemoryTicket().getReservationStatus() == IMemoryTicket.EReservationStatus.FLUSHED)
		{
			throw new IllegalStateException(MEMORY_RESERVATION_REJECTED);
		}
		else if (command.getMemoryTicket().getReservationStatus() != IMemoryTicket.EReservationStatus.SUCCESS)
		{
			throw new IllegalStateException(MEMORY_RESERVATION_REJECTED);
		}
		return true;
	}

	public static final class Builder
	{
		private final long capacity;
		private final boolean usedToPush;
		private final boolean usedToFetch;

		public Builder(long capacity, boolean usedToPush, boolean usedToFetch)
		{
			this.capacity = capacity;
			this.usedToPush = usedToPush;
			this.usedToFetch = usedToFetch;
		}

		public TransferBufferBackend build(ExecutionContext context)
		{
			final int pushUsage = usedToPush ? EBufferUsage.TRANSFER_SRC_BIT_VALUE : 0;
			final int fetchUsage = usedToFetch ? EBufferUsage.TRANSFER_DST_BIT_VALUE : 0;
			final int usage = pushUsage | fetchUsage;
			final var info = new BufferInfo(capacity, usage, false);
			final var bufferBuilder = new HostVisibleBufferBackend.Builder(info);
			final var bufferBackend = bufferBuilder.build(context);
			final var deviceLimits = context.getPhysicalDevice().getDeviceProperties().limits();
			final var nonCoherentAtomSize = deviceLimits.nonCoherentAtomSize();
			bufferBackend.mapMemory(context.getVkDevice());

			return new TransferBufferBackend(bufferBackend, nonCoherentAtomSize);
		}
	}
}
