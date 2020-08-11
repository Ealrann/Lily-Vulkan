package org.sheepy.lily.vulkan.resource.buffer.transfer.util;

import org.sheepy.lily.vulkan.api.resource.transfer.IMemoryTicket;
import org.sheepy.lily.vulkan.core.util.FillCommand;
import org.sheepy.lily.vulkan.resource.buffer.transfer.backend.MemoryTicket;
import org.sheepy.lily.vulkan.resource.buffer.transfer.backend.TransferBufferBackend;
import org.sheepy.lily.vulkan.resource.buffer.transfer.command.DataFlowCommand;
import org.sheepy.lily.vulkan.resource.buffer.transfer.command.DataFlowCommandFactory;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public final class TransferCommandInserter
{
	private final TransferBufferBackend backendBuffer;

	public TransferCommandInserter(TransferBufferBackend backendBuffer)
	{
		this.backendBuffer = backendBuffer;
	}

	public boolean queueCommands(Stream<FillCommand> commands)
	{
		final var commandReservation = FillCommandReservation.reserve(backendBuffer, commands);

		if (commandReservation.succed())
		{
			commandReservation.pushCommands().forEach(this::fillAndAddCommand);
			return true;
		}
		else
		{
			commandReservation.pushCommands()
							  .stream()
							  .map(CommandWrapper::pushCommand)
							  .map(DataFlowCommand::getMemoryTicket)
							  .forEach(this::releaseTicket);
			return false;
		}
	}

	public void releaseTicket(MemoryTicket ticket)
	{
		backendBuffer.releaseTicket(ticket);
	}

	private void fillAndAddCommand(CommandWrapper command)
	{
		command.fillMemory();
		backendBuffer.addTransferCommand(command.pushCommand);
	}

	private static record CommandWrapper(DataFlowCommand pushCommand, FillCommand fillCommand)
	{
		private void fillMemory()
		{
			final var ticket = pushCommand.getMemoryTicket();
			fillCommand.dataProvider().fillBuffer(ticket.toBuffer());
		}
	}

	private record FillCommandReservation(List<CommandWrapper> pushCommands, boolean succed)
	{
		public static FillCommandReservation reserve(TransferBufferBackend backendBuffer, Stream<FillCommand> commands)
		{
			final List<CommandWrapper> resCommands = new ArrayList<>();
			boolean reservationSuccess = true;
			final var it = commands.iterator();
			while (it.hasNext())
			{
				final var command = it.next();
				final var ticket = backendBuffer.reserveMemory(command.size());
				if (ticket.getReservationStatus() == IMemoryTicket.EReservationStatus.SUCCESS)
				{
					final var pushCommand = buildPushCommand(command, ticket);
					resCommands.add(new CommandWrapper(pushCommand, command));
				}
				else
				{
					reservationSuccess = false;
					break;
				}
			}

			return new FillCommandReservation(List.copyOf(resCommands), reservationSuccess);
		}

		private static DataFlowCommand buildPushCommand(FillCommand command, MemoryTicket ticket)
		{
			if (command instanceof FillCommand.FillBufferCommand fillBufferCommand)
			{
				return DataFlowCommandFactory.newPushCommand(ticket,
															 fillBufferCommand.bufferPtr(),
															 fillBufferCommand.offset());
			}
			else if (command instanceof FillCommand.FillImageCommand fillImageCommand)
			{
				final var vkImage = fillImageCommand.vkImage();
				return DataFlowCommandFactory.newPushImageCommand(ticket,
																  vkImage,
																  EPipelineStage.TRANSFER_BIT,
																  List.of(),
																  vkImage.initialLayout.getStage(),
																  vkImage.initialLayout.getAccessMask(),
																  vkImage.initialLayout.getLayout());
			}
			// TODO https://openjdk.java.net/jeps/360 switch on sealed type. No need to return null anymore.
			return null;
		}
	}
}
