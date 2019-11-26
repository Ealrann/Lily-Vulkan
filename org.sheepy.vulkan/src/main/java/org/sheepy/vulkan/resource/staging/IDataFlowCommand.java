package org.sheepy.vulkan.resource.staging;

import java.util.function.Consumer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.resource.staging.ITransferBuffer.MemoryTicket;
import org.sheepy.vulkan.resource.staging.command.FetchCommand;
import org.sheepy.vulkan.resource.staging.command.PushCommand;

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
