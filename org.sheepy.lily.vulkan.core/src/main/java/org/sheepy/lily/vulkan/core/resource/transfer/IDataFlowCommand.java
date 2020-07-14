package org.sheepy.lily.vulkan.core.resource.transfer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDevice;
import org.sheepy.lily.vulkan.api.resource.transfer.IMemoryTicket;
import org.sheepy.lily.vulkan.core.execution.IRecordable;

public interface IDataFlowCommand
{
	IMemoryTicket getMemoryTicket();
	EFlowType getFlowType();
	void execute(IRecordable.RecordContext recordContext, final VkDevice vkDevice, MemoryStack stack);
}