package org.sheepy.lily.vulkan.resource.buffer.transfer.command;

import static org.lwjgl.vulkan.VK10.*;

import java.util.function.Consumer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkBufferMemoryBarrier;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.vulkan.api.resource.buffer.ITransferBufferAdapter.IMemoryTicket;
import org.sheepy.lily.vulkan.core.resource.buffer.BufferUtils;
import org.sheepy.lily.vulkan.core.resource.buffer.InternalTransferBufferAdapter.EFlowType;
import org.sheepy.lily.vulkan.core.resource.buffer.InternalTransferBufferAdapter.IDataFlowCommand;
import org.sheepy.lily.vulkan.resource.buffer.memory.MemoryTicket;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

public final class PushCommand implements IDataFlowCommand
{
	private final MemoryTicket ticket;
	private final long trgBuffer;
	private final long trgOffset;
	private final Consumer<IMemoryTicket> transferDone;
	private final EPipelineStage srcStage;
	private final int srcAccess;

	public PushCommand(	MemoryTicket ticket,
						long trgBuffer,
						long trgOffset,
						EPipelineStage srcStage,
						int srcAccess,
						Consumer<IMemoryTicket> transferDone)
	{
		assert srcStage != null;
		assert trgBuffer > 0;
		assert trgOffset >= 0;
		assert ticket != null;

		this.ticket = ticket;
		this.trgBuffer = trgBuffer;
		this.trgOffset = trgOffset;
		this.srcStage = srcStage;
		this.srcAccess = srcAccess;
		this.transferDone = transferDone;
	}

	@Override
	public void execute(MemoryStack stack, VkCommandBuffer commandBuffer)
	{
		final var srcBuffer = ticket.getBufferPtr();
		final var srcOffset = ticket.getBufferOffset();
		final var size = ticket.getSize();

		// Submission guarantees the host write being complete, as per
		// https://www.khronos.org/registry/vulkan/specs/1.0/html/vkspec.html#synchronization-submission-host-writes
		// So no need for a barrier before the transfer

		final var srcStageVal = srcStage.getValue();
		final var dstStageVal = EPipelineStage.TRANSFER_BIT_VALUE;

		final var barriers = VkBufferMemoryBarrier.callocStack(2, stack);

		final var deviceBarrier = barriers.get(0);
		deviceBarrier.sType(VK_STRUCTURE_TYPE_BUFFER_MEMORY_BARRIER);
		deviceBarrier.buffer(trgBuffer);
		deviceBarrier.offset(trgOffset);
		deviceBarrier.size(size);
		deviceBarrier.srcAccessMask(srcAccess);
		deviceBarrier.dstAccessMask(EAccess.TRANSFER_WRITE_BIT_VALUE);

		final var hostBarrier = barriers.get(1);
		hostBarrier.sType(VK_STRUCTURE_TYPE_BUFFER_MEMORY_BARRIER);
		hostBarrier.buffer(srcBuffer);
		hostBarrier.offset(srcOffset);
		hostBarrier.size(size);
		hostBarrier.srcAccessMask(0);
		hostBarrier.dstAccessMask(EAccess.TRANSFER_READ_BIT_VALUE);

		vkCmdPipelineBarrier(commandBuffer, srcStageVal, dstStageVal, 0, null, barriers, null);

		BufferUtils.copyBuffer(	stack,
								commandBuffer,
								srcBuffer,
								srcOffset,
								trgBuffer,
								trgOffset,
								size);
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
	public Consumer<IMemoryTicket> getPostAction()
	{
		return transferDone;
	}

	@Override
	public String toString()
	{
		return "PipelinePushCommand  [trg: Buffer=" + trgBuffer + ", Offset=" + trgOffset + "]";
	}
}
