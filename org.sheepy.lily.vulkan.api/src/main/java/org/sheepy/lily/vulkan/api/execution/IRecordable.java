package org.sheepy.lily.vulkan.api.execution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EventListener;
import java.util.List;

import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

public interface IRecordable
{
	void record(RecordContext context, ECommandStage stage);

	boolean shouldRecord(ECommandStage stage);
	boolean isActive();
	boolean isRecordNeeded(int index);

	public static final class RecordContext
	{
		public final VkCommandBuffer commandBuffer;
		public final ECommandStage stage;
		public final int index;
		private final List<IExecutionIdleListener> listeners = new ArrayList<>();

		public RecordContext(VkCommandBuffer commandBuffer, ECommandStage stage, int index)
		{
			this.commandBuffer = commandBuffer;
			this.stage = stage;
			this.index = index;
		}

		public void addListener(IExecutionIdleListener listener)
		{
			if (listeners.contains(listener) == false)
			{
				listeners.add(listener);
			}
		}

		@FunctionalInterface
		public static interface IExecutionIdleListener extends EventListener
		{
			void onExecutionIdle();
		}

		public List<IExecutionIdleListener> getExecutionIdleListeners()
		{
			return Collections.unmodifiableList(listeners);
		}
	}
}
