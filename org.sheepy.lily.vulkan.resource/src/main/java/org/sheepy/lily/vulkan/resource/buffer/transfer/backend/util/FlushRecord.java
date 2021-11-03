package org.sheepy.lily.vulkan.resource.buffer.transfer.backend.util;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkMappedMemoryRange;
import org.sheepy.lily.game.api.execution.EExecutionStatus;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.resource.buffer.transfer.backend.TransferCommand;
import org.sheepy.lily.vulkan.resource.util.command.EFlowType;

import java.util.Collection;
import java.util.List;

import static org.lwjgl.vulkan.VK10.vkFlushMappedMemoryRanges;
import static org.lwjgl.vulkan.VK10.vkInvalidateMappedMemoryRanges;

public final class FlushRecord
{
	private final VkDevice vkDevice;
	private final List<TransferCommand> commands;

	public FlushRecord(VkDevice vkDevice, Collection<TransferCommand> commands)
	{
		this.vkDevice = vkDevice;
		this.commands = List.copyOf(commands);
	}

	public void flush(RecordContext recordContext)
	{
		try (final MemoryStack stack = MemoryStack.stackPush())
		{
			flushPushMemoryRange(stack);
			recordFetchInvalidations(recordContext);

			for (int i = 0; i < commands.size(); i++)
			{
				final var command = commands.get(i);
				// System.out.println(command.toString());
				command.dataFlow().record(recordContext);
			}
		}
	}

	private void recordFetchInvalidations(final RecordContext recordContext)
	{
		final var invalidator = buildInvalidator();
		if (invalidator.isEmpty() == false)
		{
			recordContext.listenExecution(invalidator::invalidate);
		}
		else
		{
			invalidator.free();
		}
	}

	private void flushPushMemoryRange(final MemoryStack stack)
	{
		final var mappedRange = VkMappedMemoryRange.malloc(commands.size(), stack);
		commands.stream()
				.filter(c -> c.dataFlow().getFlowType() == EFlowType.PUSH)
				.map(TransferCommand::memoryTicket)
				.forEach(ticket -> ticket.fillMemoryRange(mappedRange.get()));
		mappedRange.flip();
		vkFlushMappedMemoryRanges(vkDevice, mappedRange);
	}

	private Invalidator buildInvalidator()
	{
		final var mappedRange = VkMappedMemoryRange.malloc(commands.size());
		commands.stream()
				.filter(c -> c.dataFlow().getFlowType() == EFlowType.FETCH)
				.map(TransferCommand::memoryTicket)
				.forEach(ticket -> ticket.fillMemoryRange(mappedRange.get()));
		mappedRange.flip();
		return new Invalidator(vkDevice, mappedRange);
	}

	private static record Invalidator(VkDevice vkDevice, VkMappedMemoryRange.Buffer ranges)
	{
		public void invalidate(EExecutionStatus status)
		{
			if (status == EExecutionStatus.Done)
			{
				vkInvalidateMappedMemoryRanges(vkDevice, ranges);
				free();
			}
			else if (status == EExecutionStatus.Canceled)
			{
				free();
			}
		}

		public void free()
		{
			ranges.free();
		}

		public boolean isEmpty()
		{
			return ranges.limit() == 0;
		}
	}
}
