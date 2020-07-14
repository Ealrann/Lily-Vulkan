package org.sheepy.lily.vulkan.resource.buffer.transfer;

import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.Notifier;
import org.sheepy.lily.vulkan.api.resource.transfer.IMemoryTicket;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.execution.IRecordable;
import org.sheepy.lily.vulkan.core.resource.buffer.InternalTransferBufferAllocation;
import org.sheepy.lily.vulkan.core.util.FillCommand;
import org.sheepy.lily.vulkan.model.resource.TransferBuffer;
import org.sheepy.lily.vulkan.resource.buffer.transfer.backend.MemoryTicket;
import org.sheepy.lily.vulkan.resource.buffer.transfer.backend.TransferBufferBackend;
import org.sheepy.lily.vulkan.resource.buffer.transfer.command.DataFlowCommand;
import org.sheepy.lily.vulkan.resource.buffer.transfer.command.DataFlowCommandFactory;
import org.sheepy.lily.vulkan.resource.buffer.transfer.command.PushCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@ModelExtender(scope = TransferBuffer.class)
@Allocation(context = ExecutionContext.class)
public class TransferBufferAllocation extends Notifier<InternalTransferBufferAllocation.Features> implements
																								  InternalTransferBufferAllocation
{
	private final TransferBufferBackend backendBuffer;
	private final VkDevice vkDevice;

	public TransferBufferAllocation(TransferBuffer transferBuffer, ExecutionContext context)
	{
		super(List.of(Features.TransferQueueChange));

		this.vkDevice = context.getVkDevice();
		final long size = transferBuffer.getSize();
		final boolean usedToPush = transferBuffer.isUsedToPush();
		final boolean usedToFetch = transferBuffer.isUsedToFetch();

		final var bufferBuilder = new TransferBufferBackend.Builder(size, usedToPush, usedToFetch);
		backendBuffer = bufferBuilder.build(context);
	}

	@Free
	public void free(ExecutionContext context)
	{
		backendBuffer.free(context);
	}

	@Override
	public MemoryTicket reserveMemory(long size)
	{
		return backendBuffer.reserveMemory(size);
	}

	@Override
	public void releaseTicket(IMemoryTicket ticket)
	{
		backendBuffer.releaseTicket((MemoryTicket) ticket);
	}

	public boolean pushFillCommands(Stream<FillCommand> commands)
	{
		final List<CommandWrapper> pushCommands = new ArrayList<>();
		boolean reservationSuccess = true;
		final var it = commands.iterator();
		while (it.hasNext())
		{
			final var command = it.next();
			final var ticket = reserveMemory(command.size());
			if (ticket.getReservationStatus() == IMemoryTicket.EReservationStatus.SUCCESS)
			{
				final var pushCommand = DataFlowCommandFactory.newPushCommand(ticket,
																			  command.bufferPtr(),
																			  command.offset());
				pushCommands.add(new CommandWrapper(pushCommand, command));
			}
			else
			{
				reservationSuccess = false;
				break;
			}
		}

		if (reservationSuccess)
		{
			pushCommands.forEach(this::fillAndAddCommand);
			notify(Features.TransferQueueChange);
			return true;
		}
		else
		{
			pushCommands.stream()
						.map(CommandWrapper::pushCommand)
						.map(PushCommand::getMemoryTicket)
						.forEach(this::releaseTicket);
			return false;
		}
	}

	private void fillAndAddCommand(CommandWrapper command)
	{
		command.fillMemory();
		backendBuffer.addTransferCommand(command.pushCommand);
	}

	@Override
	public boolean isEmpty()
	{
		return backendBuffer.isEmpty();
	}

	@Override
	public void flush(IRecordable.RecordContext context)
	{
		backendBuffer.recordFlush(context, vkDevice);
		notify(Features.TransferQueueChange);
	}

	public void addTransferCommand(final DataFlowCommand command)
	{
		backendBuffer.addTransferCommand(command);
		notify(Features.TransferQueueChange);
	}

	private static record CommandWrapper(PushCommand pushCommand, FillCommand fillCommand)
	{
		private void fillMemory()
		{
			final var ticket = pushCommand.getMemoryTicket();
			fillCommand.dataProvider().fillBuffer(ticket.toBuffer());
		}
	}
}