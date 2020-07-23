package org.sheepy.lily.vulkan.core.execution;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.game.api.execution.EExecutionStatus;
import org.sheepy.lily.game.api.execution.IRecordContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.*;
import java.util.function.Consumer;

public interface IRecordable
{
	void record(RecordContext context);

	final class RecordContext implements IRecordContext
	{
		public final VkCommandBuffer commandBuffer;
		public final ECommandStage stage;
		public final int index;
		public final MemoryStack stack;

		private final List<Consumer<EExecutionStatus>> listeners = new ArrayList<>();

		public RecordContext(VkCommandBuffer commandBuffer, ECommandStage stage, int index, MemoryStack stack)
		{
			this.commandBuffer = commandBuffer;
			this.stage = stage;
			this.index = index;
			this.stack = stack;
		}

		@Override
		public void lockAllocationDuringExecution(final IAllocationState allocationState)
		{
			final var recordLocker = new RecordLocker(allocationState);
			listenExecution(recordLocker::onStatusChange);
		}

		@Override
		public void listenExecution(Consumer<EExecutionStatus> listener)
		{
			listeners.add(listener);
		}

		public List<Consumer<EExecutionStatus>> getExecutionListeners()
		{
			return Collections.unmodifiableList(listeners);
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

		private static final class RecordLocker
		{
			private final IAllocationState allocationState;
			private final Deque<IAllocationState.Lock> locks = new ArrayDeque<>();

			public RecordLocker(IAllocationState allocationState)
			{
				this.allocationState = allocationState;
			}

			public void onStatusChange(EExecutionStatus status)
			{
				switch (status)
				{
					case Started -> lock();
					case Done, Canceled -> unlock();
				}
			}

			private void lock()
			{
				locks.add(allocationState.lockUntil());
			}

			private void unlock()
			{
				locks.pop().unlock();
			}
		}
	}
}
