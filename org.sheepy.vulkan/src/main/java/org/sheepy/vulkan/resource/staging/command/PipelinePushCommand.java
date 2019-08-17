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
import org.sheepy.vulkan.resource.staging.IStagingBuffer.MemoryTicket;

public final class PipelinePushCommand implements IDataFlowCommand
{
	private final MemoryTicket ticket;

	private final long trgBuffer;
	private final long trgOffset;
	private EPipelineStage dstStage = null;
	private EAccess dstAccess = null;

	public PipelinePushCommand(	MemoryTicket ticket,
								long trgBuffer,
								long trgOffset,
								EPipelineStage dstStage,
								EAccess dstAccess)
	{
		assert dstStage != null;
		assert dstAccess != null;
		assert trgBuffer > 0;
		assert trgOffset >= 0;
		assert ticket != null;

		this.ticket = ticket;
		this.trgBuffer = trgBuffer;
		this.trgOffset = trgOffset;
		this.dstStage = dstStage;
		this.dstAccess = dstAccess;
	}

	@Override
	public void execute(MemoryStack stack, VkCommandBuffer commandBuffer)
	{
		final var srcBuffer = ticket.getBufferPtr();
		final var offset = ticket.getBufferOffset();
		final var size = ticket.getSize();

		// Submission guarantees the host write being complete, as per
		// https://www.khronos.org/registry/vulkan/specs/1.0/html/vkspec.html#synchronization-submission-host-writes
		// So no need for a barrier before the transfer

		BufferUtils.copyBuffer(stack, commandBuffer, srcBuffer, offset, trgBuffer, trgOffset, size);

		final var srcStageVal = EPipelineStage.TRANSFER_BIT_VALUE;
		final var dstStageVal = dstStage.getValue();

		final var barrierInfo = VkBufferMemoryBarrier.callocStack(1, stack);
		barrierInfo.sType(VK_STRUCTURE_TYPE_BUFFER_MEMORY_BARRIER);
		barrierInfo.buffer(trgBuffer);
		barrierInfo.offset(trgOffset);
		barrierInfo.size(size);
		barrierInfo.srcAccessMask(EAccess.TRANSFER_WRITE_BIT_VALUE);
		barrierInfo.dstAccessMask(dstAccess.getValue());

		vkCmdPipelineBarrier(commandBuffer, srcStageVal, dstStageVal, 0, null, barrierInfo, null);
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
	public Consumer<MemoryTicket> getPostAction()
	{
		return null;
	}

	@Override
	public EFlowType getFlowType()
	{
		return EFlowType.PUSH;
	}
}
