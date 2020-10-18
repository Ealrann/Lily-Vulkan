package org.sheepy.lily.vulkan.resource.buffer.transfer.util;

import org.sheepy.lily.vulkan.core.resource.util.FillCommand;
import org.sheepy.lily.vulkan.resource.buffer.transfer.backend.MemoryTicket;
import org.sheepy.lily.vulkan.resource.buffer.transfer.backend.TransferBufferBackend;
import org.sheepy.lily.vulkan.resource.buffer.transfer.backend.TransferCommand;
import org.sheepy.lily.vulkan.resource.util.command.PushBufferData;
import org.sheepy.lily.vulkan.resource.util.command.PushImageData;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public final class TransferCommandInserter
{
	private final TransferBufferBackend backendBuffer;

	public TransferCommandInserter(final TransferBufferBackend backendBuffer)
	{
		this.backendBuffer = backendBuffer;
	}

	public boolean queueCommands(final Stream<FillCommand> commands)
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
							  .map(TransferCommand::memoryTicket)
							  .forEach(this::releaseTicket);
			return false;
		}
	}

	private void releaseTicket(MemoryTicket ticket)
	{
		backendBuffer.releaseTicket(ticket);
	}

	private void fillAndAddCommand(CommandWrapper command)
	{
		command.fillMemory();
		backendBuffer.addTransferCommand(command.pushCommand);
	}

	private static record CommandWrapper(TransferCommand pushCommand, FillCommand fillCommand)
	{
		private void fillMemory()
		{
			final var ticket = pushCommand.memoryTicket();
			fillCommand.fill(ticket.toBuffer());
		}
	}

	private record FillCommandReservation(List<CommandWrapper> pushCommands, boolean succed)
	{
		public static FillCommandReservation reserve(final TransferBufferBackend backendBuffer,
													 final Stream<FillCommand> commands)
		{
			final List<CommandWrapper> resCommands = new ArrayList<>();
			boolean reservationSuccess = true;
			final var it = commands.iterator();
			while (it.hasNext())
			{
				final var command = it.next();
				final var ticket = backendBuffer.reserveMemory(command.size());
				if (ticket.getReservationStatus() == MemoryTicket.EReservationStatus.SUCCESS)
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

		private static TransferCommand buildPushCommand(final FillCommand command, final MemoryTicket ticket)
		{
			if (command instanceof FillCommand.FillBufferCommand fillBufferCommand)
			{
				final List<PushBufferData.RegionFlowInfo> regionFlowInfo = new ArrayList<>();
				long srcOffset = ticket.getOffset();
				for (final var info : fillBufferCommand.fillInfo())
				{
					regionFlowInfo.add(new PushBufferData.RegionFlowInfo(srcOffset, info.offset(), info.size()));
					srcOffset += info.size();
				}

				final var pushBufferData = new PushBufferData(ticket.getBufferPtr(),
															  fillBufferCommand.bufferPtr(),
															  regionFlowInfo);
				return new TransferCommand(pushBufferData, ticket);
			}
			else if (command instanceof FillCommand.FillImageCommand fillImageCommand)
			{
				final var image = fillImageCommand.image();
				final var vkImage = image.vkImage();
				final var pushImageData = new PushImageData(ticket,
															image,
															fillImageCommand.generateMipmap(),
															EPipelineStage.TRANSFER_BIT,
															List.of(),
															EPipelineStage.TRANSFER_BIT,
															List.of(EAccess.TRANSFER_WRITE_BIT),
															vkImage.initialLayout());

				return new TransferCommand(pushImageData, ticket);
			}
			// TODO https://bugs.openjdk.java.net/browse/JDK-8213076 switch on sealed type. No need to return null anymore.
			return null;
		}
	}
}
