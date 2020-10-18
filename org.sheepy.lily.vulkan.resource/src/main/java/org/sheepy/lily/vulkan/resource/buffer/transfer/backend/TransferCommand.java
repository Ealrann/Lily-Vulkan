package org.sheepy.lily.vulkan.resource.buffer.transfer.backend;

import org.sheepy.lily.vulkan.resource.util.command.IDataFlow;

public record TransferCommand(IDataFlow dataFlow, MemoryTicket memoryTicket) {}
