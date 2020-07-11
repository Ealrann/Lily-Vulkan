package org.sheepy.lily.vulkan.resource.buffer.transfer.command;

import org.sheepy.lily.vulkan.core.resource.transfer.IDataFlowCommand;
import org.sheepy.lily.vulkan.resource.buffer.transfer.backend.MemoryTicket;

public interface DataFlowCommand extends IDataFlowCommand
{
	@Override
	MemoryTicket getMemoryTicket();
}
