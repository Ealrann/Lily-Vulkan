package org.sheepy.lily.vulkan.api.execution;

import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

public interface IRecordable
{
	void record(VkCommandBuffer commandBuffer, int bindPoint, int index);

	boolean shouldRecord(ECommandStage stage);
	boolean isRecordNeeded();

	void setRecordNeeded(boolean value);
}
