package org.sheepy.lily.vulkan.core.execution;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.vulkan.api.execution.IRecordContext;
import org.sheepy.lily.vulkan.core.concurrent.VkFence;
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

		private final List<VkFence.IFenceListener> listeners = new ArrayList<>();

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

		public void addListener(VkFence.IFenceListener listener)
		{
			if (listeners.contains(listener) == false)
			{
				listeners.add(listener);
			}
		}

		public List<VkFence.IFenceListener> getExecutionListeners()
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
