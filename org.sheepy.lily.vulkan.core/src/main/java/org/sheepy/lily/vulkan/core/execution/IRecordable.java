package org.sheepy.lily.vulkan.core.execution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EventListener;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter.IRecordContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

public interface IRecordable
{
	void record(RecordContext context);

	boolean shouldRecord(ECommandStage stage);
	boolean isActive();
	boolean isRecordNeeded(int index);

	final class RecordContext implements IRecordContext
	{
		public final VkCommandBuffer commandBuffer;
		public final ECommandStage stage;
		public final int index;
		public final MemoryStack stack;

		private final List<IExecutionIdleListener> listeners = new ArrayList<>();

		public RecordContext(	VkCommandBuffer commandBuffer,
								ECommandStage stage,
								int index,
								MemoryStack stack)
		{
			this.commandBuffer = commandBuffer;
			this.stage = stage;
			this.index = index;
			this.stack = stack;
		}

		public void addListener(IExecutionIdleListener listener)
		{
			if (listeners.contains(listener) == false)
			{
				listeners.add(listener);
			}
		}

		@FunctionalInterface
		public interface IExecutionIdleListener extends EventListener
		{
			void onExecutionIdle();
		}

		public List<IExecutionIdleListener> getExecutionIdleListeners()
		{
			return Collections.unmodifiableList(listeners);
		}

		public void clearListeners()
		{
			listeners.clear();
		}

		@Override
		public MemoryStack stack()
		{
			return stack;
		}

		@Override
		public int index()
		{
			return index;
		}
	}
}