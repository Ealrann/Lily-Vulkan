package org.sheepy.lily.vulkan.resource.buffer.transfer.command;

import org.sheepy.lily.vulkan.core.resource.transfer.IDataFlowCommand;
import org.sheepy.lily.vulkan.resource.buffer.transfer.backend.MemoryTicket;

public sealed interface DataFlowCommand extends IDataFlowCommand permits FetchCommand, PushCommand, PushImageCommand
{
	@Override
	MemoryTicket getMemoryTicket();
}
