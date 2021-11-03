package org.sheepy.lily.vulkan.resource.util.command;

import org.lwjgl.vulkan.VkBufferImageCopy;
import org.lwjgl.vulkan.VkBufferMemoryBarrier;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.resource.image.ImageBackend;
import org.sheepy.lily.vulkan.resource.buffer.transfer.backend.MemoryTicket;
import org.sheepy.lily.vulkan.resource.image.util.MipmapGenerator;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

import java.util.List;

import static org.lwjgl.vulkan.VK10.*;

public final class PushImageData implements IDataFlow
{
	private final MemoryTicket ticket;
	private final ImageBackend trgImage;
	private final EPipelineStage srcStage;
	private final List<EAccess> srcAccess;
	private final EPipelineStage trgStage;
	private final List<EAccess> trgAccess;
	private final EImageLayout trgLayout;
	private final boolean generateMipmaps;

	public PushImageData(MemoryTicket ticket,
						 ImageBackend trgImage,
						 boolean generateMipmaps,
						 EPipelineStage srcStage,
						 List<EAccess> srcAccess,
						 EPipelineStage trgStage,
						 List<EAccess> trgAccess,
						 EImageLayout trgLayout)
	{
		assert srcStage != null;
		assert ticket != null;
		assert trgImage != null;

		this.ticket = ticket;
		this.trgImage = trgImage;
		this.generateMipmaps = generateMipmaps;
		this.srcStage = srcStage;
		this.srcAccess = srcAccess;
		this.trgStage = trgStage;
		this.trgAccess = trgAccess;
		this.trgLayout = trgLayout;
	}

	@Override
	public void record(final RecordContext recordContext)
	{
		final var commandBuffer = recordContext.commandBuffer;
		final var srcBuffer = ticket.getBufferPtr();
		final var srcoffset = ticket.getOffset();
		final var size = ticket.getMemorySize();
		final var stack = recordContext.stack();
		final var vkImage = trgImage.vkImage();

		// Submission guarantees the host write being complete, as per
		// https://www.khronos.org/registry/vulkan/specs/1.0/html/vkspec.html#synchronization-submission-host-writes
		// So no need for a barrier before the transfer

		final var blitStage = EPipelineStage.TRANSFER_BIT;
		final var blitAccess = List.of(EAccess.TRANSFER_WRITE_BIT);

		trgImage.transitionImageLayout(stack,
									   commandBuffer,
									   srcStage,
									   blitStage,
									   EImageLayout.UNDEFINED,
									   EImageLayout.TRANSFER_DST_OPTIMAL,
									   srcAccess,
									   blitAccess);

		final var barriers = VkBufferMemoryBarrier.calloc(1, stack);
		final var hostBarrier = barriers.get(0);
		hostBarrier.sType(VK_STRUCTURE_TYPE_BUFFER_MEMORY_BARRIER);
		hostBarrier.buffer(srcBuffer);
		hostBarrier.offset(srcoffset);
		hostBarrier.size(size);
		hostBarrier.srcAccessMask(0);
		hostBarrier.dstAccessMask(EAccess.TRANSFER_READ_BIT_VALUE);

		vkCmdPipelineBarrier(commandBuffer, srcStage.getValue(), blitStage.getValue(), 0, null, barriers, null);

		final VkBufferImageCopy.Buffer region = VkBufferImageCopy.calloc(1, stack);
		region.bufferOffset(ticket.getOffset());
		region.bufferRowLength(0);
		region.bufferImageHeight(0);

		region.imageSubresource().aspectMask(VK_IMAGE_ASPECT_COLOR_BIT);
		region.imageSubresource().mipLevel(0);
		region.imageSubresource().baseArrayLayer(0);
		region.imageSubresource().layerCount(1);

		region.imageOffset().set(0, 0, 0);
		region.imageExtent().set(vkImage.width(), vkImage.height(), 1);

		final var dstImageLayout = VK_IMAGE_LAYOUT_TRANSFER_DST_OPTIMAL;
		vkCmdCopyBufferToImage(commandBuffer, ticket.getBufferPtr(), trgImage.getPtr(), dstImageLayout, region);

		if (generateMipmaps)
		{
			MipmapGenerator.generateMipmaps(recordContext, trgImage, trgLayout);
		}
		else
		{
			trgImage.transitionImageLayout(stack,
										   commandBuffer,
										   blitStage,
										   trgStage,
										   EImageLayout.TRANSFER_DST_OPTIMAL,
										   trgLayout,
										   blitAccess,
										   trgAccess);
		}
	}

	@Override
	public EFlowType getFlowType()
	{
		return EFlowType.PUSH;
	}

	@Override
	public String toString()
	{
		return "PipelinePushCommand  [trgImage=" + trgImage + "]";
	}
}
