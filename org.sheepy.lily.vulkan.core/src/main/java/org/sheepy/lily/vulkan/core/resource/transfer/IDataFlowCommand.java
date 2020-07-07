package org.sheepy.lily.vulkan.core.resource.transfer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.vulkan.api.resource.transfer.IMemoryTicket;

import java.util.function.Consumer;

public interface IDataFlowCommand
{
	IMemoryTicket getMemoryTicket();
	EFlowType getFlowType();
	void execute(MemoryStack stack, VkCommandBuffer commandBuffer);
	Consumer<IMemoryTicket> getPostAction();
}
