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

public final class PipelineFetchCommand implements IDataFlowCommand
{
	private final MemoryTicket ticket;
	private final long srcBuffer;
	private final long srcOffset;
	private final Consumer<MemoryTicket> transferDone;
	private final EPipelineStage srcStage;
	private final int srcAccess;

	public PipelineFetchCommand(MemoryTicket ticket,
								long srcBuffer,
								long srcOffset,
								EPipelineStage srcStage,
								int srcAccess,
								Consumer<MemoryTicket> transferDone)
	{
		assert srcStage != null;
		assert srcBuffer > 0;
		assert srcOffset >= 0;
		assert ticket != null;

		this.ticket = ticket;
		this.srcBuffer = srcBuffer;
		this.srcOffset = srcOffset;
		this.srcStage = srcStage;
		this.srcAccess = srcAccess;
		this.transferDone = transferDone;
	}

	@Override
	public void execute(MemoryStack stack, VkCommandBuffer commandBuffer)
	{
		final var trgBuffer = ticket.getBufferPtr();
		final var trgOffset = ticket.getBufferOffset();
		final var size = ticket.getSize();

		// Submission guarantees the host write being complete, as per
		// https://www.khronos.org/registry/vulkan/specs/1.0/html/vkspec.html#synchronization-submission-host-writes
		// So no need for a barrier before the transfer

		final var srcStageVal = srcStage.getValue();
		final var dstStageVal = EPipelineStage.TRANSFER_BIT_VALUE;

		final var barrierInfo = VkBufferMemoryBarrier.callocStack(1, stack);
		barrierInfo.sType(VK_STRUCTURE_TYPE_BUFFER_MEMORY_BARRIER);
		barrierInfo.buffer(srcBuffer);
		barrierInfo.offset(srcOffset);
		barrierInfo.size(size);
		barrierInfo.srcAccessMask(srcAccess);
		barrierInfo.dstAccessMask(EAccess.TRANSFER_READ_BIT_VALUE);

		vkCmdPipelineBarrier(commandBuffer, srcStageVal, dstStageVal, 0, null, barrierInfo, null);

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
		return true;
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
}
