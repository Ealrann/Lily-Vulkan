package org.sheepy.lily.vulkan.resource.buffer.transfer.command;

import org.sheepy.lily.vulkan.api.resource.transfer.IMemoryTicket;
import org.sheepy.lily.vulkan.core.resource.image.VkImage;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

import java.util.List;
import java.util.function.Consumer;

public final class DataFlowCommandFactory
{
	public static PushCommand newPushCommand(IMemoryTicket ticket,
											 long trgBuffer,
											 long trgOffset,
											 EPipelineStage srcStage,
											 int srcAccess)
	{
		return new PushCommand(ticket, trgBuffer, trgOffset, srcStage, srcAccess, null);
	}

	public static PushImageCommand newPushImageCommand(IMemoryTicket ticket,
													   VkImage trgImage,
													   EPipelineStage srcStage,
													   List<EAccess> srcAccess,
													   EPipelineStage trgStage,
													   List<EAccess> trgAccess,
													   EImageLayout trgLayout)
	{
		return new PushImageCommand(ticket, trgImage, srcStage, srcAccess, trgStage, trgAccess, trgLayout);
	}

	public static FetchCommand newFetchCommand(IMemoryTicket ticket,
											   long srcBuffer,
											   long srcOffset,
											   EPipelineStage srcStage,
											   int srcAccess,
											   Consumer<IMemoryTicket> transferDone)
	{
		return new FetchCommand(ticket, srcBuffer, srcOffset, srcStage, srcAccess, transferDone);
	}

}
