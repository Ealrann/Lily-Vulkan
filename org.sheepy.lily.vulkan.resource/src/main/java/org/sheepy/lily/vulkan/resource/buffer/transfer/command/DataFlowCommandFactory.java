package org.sheepy.lily.vulkan.resource.buffer.transfer.command;

import java.util.List;
import java.util.function.Consumer;

import org.sheepy.lily.vulkan.api.resource.buffer.ITransferBufferAdapter.IMemoryTicket;
import org.sheepy.lily.vulkan.core.resource.buffer.InternalTransferBufferAdapter.IDataFlowCommand;
import org.sheepy.lily.vulkan.core.resource.image.VkImage;
import org.sheepy.lily.vulkan.resource.buffer.memory.MemoryTicket;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

public final class DataFlowCommandFactory
{
	public static IDataFlowCommand newPushCommand(	MemoryTicket ticket,
													long trgBuffer,
													long trgOffset,
													EPipelineStage srcStage,
													int srcAccess)
	{
		return new PushCommand(ticket, trgBuffer, trgOffset, srcStage, srcAccess, null);
	}

	public static IDataFlowCommand newPushImageCommand(	MemoryTicket ticket,
														VkImage trgImage,
														EPipelineStage srcStage,
														List<EAccess> srcAccess,
														EPipelineStage trgStage,
														List<EAccess> trgAccess,
														EImageLayout trgLayout)
	{
		return new PushImageCommand(ticket,
									trgImage,
									srcStage,
									srcAccess,
									trgStage,
									trgAccess,
									trgLayout);
	}

	public static IDataFlowCommand newFetchCommand(	MemoryTicket ticket,
													long srcBuffer,
													long srcOffset,
													EPipelineStage srcStage,
													int srcAccess,
													Consumer<IMemoryTicket> transferDone)
	{
		return new FetchCommand(ticket, srcBuffer, srcOffset, srcStage, srcAccess, transferDone);
	}

}
