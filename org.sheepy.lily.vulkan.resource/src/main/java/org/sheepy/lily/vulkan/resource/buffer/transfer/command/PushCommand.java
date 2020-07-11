package org.sheepy.lily.vulkan.resource.buffer.transfer.command;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.vulkan.core.execution.IRecordable;
import org.sheepy.lily.vulkan.core.resource.buffer.BufferUtils;
import org.sheepy.lily.vulkan.core.resource.transfer.EFlowType;
import org.sheepy.lily.vulkan.resource.buffer.transfer.backend.MemoryTicket;

public final class PushCommand implements DataFlowCommand
{
	private final MemoryTicket ticket;
	private final long trgBuffer;
	private final long trgOffset;

	public PushCommand(MemoryTicket ticket, long trgBuffer, long trgOffset)
	{
		assert trgBuffer > 0;
		assert trgOffset >= 0;
		assert ticket != null;

		this.ticket = ticket;
		this.trgBuffer = trgBuffer;
		this.trgOffset = trgOffset;
	}

	@Override
	public void execute(final IRecordable.RecordContext recordContext, final VkDevice vkDevice, final MemoryStack stack)
	{
		final var commandBuffer = recordContext.commandBuffer;
		final var srcBuffer = ticket.getBufferPtr();
		final var srcOffset = ticket.getOffset();
		final var size = ticket.getSize();

		BufferUtils.copyBuffer(stack, commandBuffer, srcBuffer, srcOffset, trgBuffer, trgOffset, size);
	}

	@Override
	public MemoryTicket getMemoryTicket()
	{
		return ticket;
	}

	@Override
	public EFlowType getFlowType()
	{
		return EFlowType.PUSH;
	}

	@Override
	public String toString()
	{
		return "PipelinePushCommand  [trg: Buffer=" + trgBuffer + ", Offset=" + trgOffset + "]";
	}
}
