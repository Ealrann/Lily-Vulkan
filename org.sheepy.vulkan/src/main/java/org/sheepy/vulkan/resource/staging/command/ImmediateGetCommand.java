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

public final class ImmediateGetCommand implements IDataFlowCommand
{
	private final MemoryTicket ticket;

	private final long srcBuffer;
	private final long srcOffset;
	private final EPipelineStage dstStage;
	private final EAccess dstAccess;
	private final Consumer<MemoryTicket> postAction;

	public ImmediateGetCommand(	MemoryTicket ticket,
								long srcBuffer,
								long srcOffset,
								EPipelineStage dstStage,
								EAccess dstAccess,
								Consumer<MemoryTicket> postAction)
	{
		this.srcBuffer = srcBuffer;
		this.srcOffset = srcOffset;
		this.ticket = ticket;
		this.dstStage = dstStage;
		this.dstAccess = dstAccess;
		this.postAction = postAction;
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

		final var srcStage1 = EPipelineStage.TOP_OF_PIPE_BIT_VALUE;
		final var dstStage1 = EPipelineStage.TRANSFER_BIT_VALUE;

		vkCmdPipelineBarrier(commandBuffer, srcStage1, dstStage1, 0, null, barrierInfo, null);

		BufferUtils.copyBuffer(	stack,
								commandBuffer,
								srcBuffer,
								srcOffset,
								trgBuffer,
								trgOffset,
								size);

		final var srcStage2 = EPipelineStage.TRANSFER_BIT_VALUE;
		final var dstStage2 = dstStage.getValue();

		barrierInfo.srcAccessMask(EAccess.TRANSFER_READ_BIT_VALUE);
		barrierInfo.dstAccessMask(dstAccess.getValue());

		vkCmdPipelineBarrier(commandBuffer, srcStage2, dstStage2, 0, null, barrierInfo, null);
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
	public Consumer<MemoryTicket> getPostAction()
	{
		return postAction;
	}

	@Override
	public EFlowType getFlowType()
	{
		return EFlowType.GET;
	}
}
