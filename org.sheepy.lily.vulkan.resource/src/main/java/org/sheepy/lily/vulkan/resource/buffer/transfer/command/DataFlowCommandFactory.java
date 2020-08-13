package org.sheepy.lily.vulkan.resource.buffer.transfer.command;

import org.sheepy.lily.vulkan.api.resource.transfer.IMemoryTicket;
import org.sheepy.lily.vulkan.core.resource.image.VkImage;
import org.sheepy.lily.vulkan.resource.buffer.transfer.backend.MemoryTicket;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

import java.util.List;
import java.util.function.Consumer;

public final class DataFlowCommandFactory
{
	public static PushCommand newPushCommand(MemoryTicket ticket, long trgBuffer, long trgOffset)
	{
		return new PushCommand(ticket, trgBuffer, trgOffset);
	}

	public static PushImageCommand newPushImageCommand(MemoryTicket ticket,
													   VkImage trgImage,
													   int mipLevel,
													   EPipelineStage srcStage,
													   List<EAccess> srcAccess,
													   EPipelineStage trgStage,
													   List<EAccess> trgAccess,
													   EImageLayout trgLayout)
	{
		return new PushImageCommand(ticket, trgImage, mipLevel, srcStage, srcAccess, trgStage, trgAccess, trgLayout);
	}

	public static FetchCommand newFetchCommand(MemoryTicket ticket,
											   long srcBuffer,
											   long srcOffset,
											   Consumer<IMemoryTicket> transferDone)
	{
		return new FetchCommand(ticket, srcBuffer, srcOffset, transferDone);
	}
}
