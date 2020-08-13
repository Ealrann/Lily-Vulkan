package org.sheepy.lily.vulkan.resource.buffer.transfer.command;

import org.sheepy.lily.game.api.execution.EExecutionStatus;
import org.sheepy.lily.vulkan.api.resource.transfer.IMemoryTicket;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.resource.buffer.BufferUtils;
import org.sheepy.lily.vulkan.core.resource.transfer.EFlowType;
import org.sheepy.lily.vulkan.resource.buffer.transfer.backend.MemoryTicket;

import java.util.function.Consumer;

public final class FetchCommand implements DataFlowCommand
{
	private final MemoryTicket ticket;
	private final long srcBuffer;
	private final long srcOffset;
	private final Consumer<IMemoryTicket> transferDone;

	public FetchCommand(MemoryTicket ticket, long srcBuffer, long srcOffset, Consumer<IMemoryTicket> transferDone)
	{
		assert srcBuffer != 0;
		assert srcOffset >= 0;
		assert ticket != null;

		this.ticket = ticket;
		this.srcBuffer = srcBuffer;
		this.srcOffset = srcOffset;
		this.transferDone = transferDone;
	}

	@Override
	public void execute(RecordContext recordContext)
	{
		final var trgBuffer = ticket.getBufferPtr();
		final var trgOffset = ticket.getOffset();
		final var size = ticket.getSize();
		final var commandBuffer = recordContext.commandBuffer;
		final var stack = recordContext.stack();

		// Submission guarantees the host write being complete, as per
		// https://www.khronos.org/registry/vulkan/specs/1.0/html/vkspec.html#synchronization-submission-host-writes
		// So no need for a barrier before the transfer

		BufferUtils.copyBuffer(stack, commandBuffer, srcBuffer, srcOffset, trgBuffer, trgOffset, size);

		if (transferDone != null)
		{
			recordContext.listenExecution(new TransferDone(ticket, transferDone));
		}
	}

	@Override
	public MemoryTicket getMemoryTicket()
	{
		return ticket;
	}

	@Override
	public EFlowType getFlowType()
	{
		return EFlowType.FETCH;
	}

	@Override
	public String toString()
	{
		return "PipelineFetchCommand [srcBuffer=" + srcBuffer + ", srcOffset=" + srcOffset + "]";
	}

	private static final class TransferDone implements Consumer<EExecutionStatus>
	{
		private final MemoryTicket ticket;
		private final Consumer<IMemoryTicket> transferDone;

		private TransferDone(final MemoryTicket ticket, final Consumer<IMemoryTicket> transferDone)
		{
			this.ticket = ticket;
			this.transferDone = transferDone;
		}

		@Override
		public void accept(final EExecutionStatus status)
		{
			if (status == EExecutionStatus.Done)
			{
				transferDone.accept(ticket);
			}
		}
	}
}
