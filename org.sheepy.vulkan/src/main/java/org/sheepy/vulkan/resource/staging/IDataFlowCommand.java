package org.sheepy.vulkan.resource.staging;

import java.util.function.Consumer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.resource.staging.ITransferBuffer.MemoryTicket;
import org.sheepy.vulkan.resource.staging.command.ImmediateFetchCommand;
import org.sheepy.vulkan.resource.staging.command.ImmediatePushCommand;
import org.sheepy.vulkan.resource.staging.command.PipelineFetchCommand;
import org.sheepy.vulkan.resource.staging.command.PipelinePushCommand;

public interface IDataFlowCommand
{
	boolean isPipelined();
	MemoryTicket getMemoryTicket();

	EFlowType getFlowType();
	void execute(MemoryStack stack, VkCommandBuffer commandBuffer);

	Consumer<MemoryTicket> getPostAction();

	static IDataFlowCommand newImmediatePushCommand(MemoryTicket ticket,
													long trgBuffer,
													long trgOffset)
	{
		return new ImmediatePushCommand(ticket, trgBuffer, trgOffset, null);
	}

	static IDataFlowCommand newPipelinePushCommand(	MemoryTicket ticket,
													long trgBuffer,
													long trgOffset,
													EPipelineStage srcStage,
													int srcAccess)
	{
		return new PipelinePushCommand(ticket, trgBuffer, trgOffset, srcStage, srcAccess, null);
	}

	static IDataFlowCommand newImmediateFetchCommand(	MemoryTicket ticket,
														long srcBuffer,
														long srcOffset)
	{
		return new ImmediateFetchCommand(ticket, srcBuffer, srcOffset, null);
	}

	static IDataFlowCommand newPipelineFetchCommand(MemoryTicket ticket,
													long srcBuffer,
													long srcOffset,
													EPipelineStage srcStage,
													int srcAccess,
													Consumer<MemoryTicket> transferDone)
	{
		return new PipelineFetchCommand(ticket,
										srcBuffer,
										srcOffset,
										srcStage,
										srcAccess,
										transferDone);
	}

	static enum EFlowType
	{
		PUSH,
		FETCH
	}
}
