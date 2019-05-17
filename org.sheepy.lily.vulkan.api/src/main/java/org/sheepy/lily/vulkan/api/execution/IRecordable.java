package org.sheepy.lily.vulkan.api.execution;

import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

public interface IRecordable
{
	void record(RecordContext context);

	boolean shouldRecord(ECommandStage stage);
	boolean isActive();
	boolean isRecordNeeded(int index);

	public static final class RecordContext
	{
		public final VkCommandBuffer commandBuffer;
		public final ECommandStage stage;
		public final int bindPoint;
		public final int index;

		public RecordContext(	VkCommandBuffer commandBuffer,
								ECommandStage stage,
								int bindPoint,
								int index)
		{
			this.commandBuffer = commandBuffer;
			this.stage = stage;
			this.bindPoint = bindPoint;
			this.index = index;
		}
	}
}
