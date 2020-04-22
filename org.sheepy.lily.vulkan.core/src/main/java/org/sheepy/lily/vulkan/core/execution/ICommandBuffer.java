package org.sheepy.lily.vulkan.core.execution;

import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

public interface ICommandBuffer
{
	void start(ECommandStage stage);
	void end(ECommandStage stage);

	VkCommandBuffer getVkCommandBuffer();
}
