package org.sheepy.lily.vulkan.api.execution;

import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.vulkan.model.enumeration.ECommandStage;

public interface IRecordable
{
	boolean shouldRecord(ECommandStage stage);

	void record(VkCommandBuffer commandBuffer, int bindPoint, int index);

	boolean isRecordNeeded();

	void setRecordNeeded(boolean value);

}
