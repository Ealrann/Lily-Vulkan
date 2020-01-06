package org.sheepy.vulkan.resource.staging;

import java.util.List;
import java.util.function.Consumer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.resource.image.VkImage;
import org.sheepy.vulkan.resource.staging.ITransferBuffer.MemoryTicket;
import org.sheepy.vulkan.resource.staging.command.FetchCommand;
import org.sheepy.vulkan.resource.staging.command.PushCommand;
import org.sheepy.vulkan.resource.staging.command.PushImageCommand;

public interface IDataFlowCommand
{
	MemoryTicket getMemoryTicket();

	EFlowType getFlowType();
	void execute(MemoryStack stack, VkCommandBuffer commandBuffer);

	Consumer<MemoryTicket> getPostAction();

	static IDataFlowCommand newPushCommand(	MemoryTicket ticket,
											long trgBuffer,
											long trgOffset,
											EPipelineStage srcStage,
											int srcAccess)
	{
		return new PushCommand(ticket, trgBuffer, trgOffset, srcStage, srcAccess, null);
	}

	static IDataFlowCommand newPushImageCommand(MemoryTicket ticket,
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

	static IDataFlowCommand newFetchCommand(MemoryTicket ticket,
											long srcBuffer,
											long srcOffset,
											EPipelineStage srcStage,
											int srcAccess,
											Consumer<MemoryTicket> transferDone)
	{
		return new FetchCommand(ticket, srcBuffer, srcOffset, srcStage, srcAccess, transferDone);
	}

	static enum EFlowType
	{
		PUSH,
		FETCH
	}
}
