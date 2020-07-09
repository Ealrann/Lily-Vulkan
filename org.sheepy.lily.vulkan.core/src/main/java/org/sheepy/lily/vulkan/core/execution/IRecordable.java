package org.sheepy.lily.vulkan.core.execution;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.game.api.execution.IRecordContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface IRecordable
{
	void record(RecordContext context);

	final class RecordContext implements IRecordContext
	{
		public final VkCommandBuffer commandBuffer;
		public final ECommandStage stage;
		public final int index;
		public final int indexCount;
		public final MemoryStack stack;

		private final List<Runnable> listeners = new ArrayList<>();

		public RecordContext(VkCommandBuffer commandBuffer,
							 ECommandStage stage,
							 int index,
							 int indexCount,
							 MemoryStack stack)
		{
			this.commandBuffer = commandBuffer;
			this.stage = stage;
			this.index = index;
			this.indexCount = indexCount;
			this.stack = stack;
		}

		@Override
		public void listenExecution(Runnable listener)
		{
			if (listeners.contains(listener) == false)
			{
				listeners.add(listener);
			}
		}

		public List<Runnable> getExecutionListeners()
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
