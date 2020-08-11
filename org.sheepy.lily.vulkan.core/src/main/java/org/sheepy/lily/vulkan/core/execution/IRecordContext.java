package org.sheepy.lily.vulkan.core.execution;

import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.game.api.execution.EExecutionStatus;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.function.Consumer;

public interface IRecordContext extends IVulkanContext
{
	VkCommandBuffer vkCommandBuffer();
	ECommandStage stage();
	int index();
	void listenExecution(Consumer<EExecutionStatus> listener);
	void lockAllocationDuringExecution(IAllocationState allocationState);
}
