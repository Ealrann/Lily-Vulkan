package org.sheepy.vulkan.resource.staging.command;

import static org.lwjgl.vulkan.VK10.*;

import java.util.function.Consumer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkBufferMemoryBarrier;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.resource.buffer.BufferUtils;
import org.sheepy.vulkan.resource.staging.IDataFlowCommand;
import org.sheepy.vulkan.resource.staging.ITransferBuffer.MemoryTicket;

public final class ImmediateFetchCommand implements IDataFlowCommand
{
	private final MemoryTicket ticket;
	private final long srcBuffer;
	private final long srcOffset;
	private final Consumer<MemoryTicket> transferDone;

	public ImmediateFetchCommand(	MemoryTicket ticket,
									long srcBuffer,
									long srcOffset,
									Consumer<MemoryTicket> transferDone)
	{
		this.srcBuffer = srcBuffer;
		this.srcOffset = srcOffset;
		this.ticket = ticket;
		this.transferDone = transferDone;
	}

	@Override
	public void execute(MemoryStack stack, VkCommandBuffer commandBuffer)
	{
		final var trgBuffer = ticket.getBufferPtr();
		final var trgOffset = ticket.getBufferOffset();
		final var size = ticket.getSize();

		final var barrierInfo = VkBufferMemoryBarrier.callocStack(1, stack);
		barrierInfo.sType(VK_STRUCTURE_TYPE_BUFFER_MEMORY_BARRIER);
		barrierInfo.buffer(srcBuffer);
		barrierInfo.offset(srcOffset);
		barrierInfo.srcAccessMask(0);
		barrierInfo.dstAccessMask(EAccess.TRANSFER_READ_BIT_VALUE);
		barrierInfo.size(VK_WHOLE_SIZE);

		final var srcStage1 = EPipelineStage.BOTTOM_OF_PIPE_BIT_VALUE;
		final var dstStage1 = EPipelineStage.TRANSFER_BIT_VALUE;

		vkCmdPipelineBarrier(commandBuffer, srcStage1, dstStage1, 0, null, barrierInfo, null);

		BufferUtils.copyBuffer(	stack,
								commandBuffer,
								srcBuffer,
								srcOffset,
								trgBuffer,
								trgOffset,
								size);
	}

	@Override
	public boolean isPipelined()
	{
		return false;
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
	public Consumer<MemoryTicket> getPostAction()
	{
		return transferDone;
	}

	@Override
	public String toString()
	{
		return "ImmediateFetchCommand [srcBuffer=" + srcBuffer + ", srcOffset=" + srcOffset + "]";
	}
}
