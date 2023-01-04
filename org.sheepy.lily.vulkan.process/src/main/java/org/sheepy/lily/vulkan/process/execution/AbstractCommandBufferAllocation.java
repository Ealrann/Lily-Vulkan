package org.sheepy.lily.vulkan.process.execution;

import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.game.api.execution.EExecutionStatus;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableAdapter;
import org.sheepy.lily.vulkan.process.execution.util.SynchronizationManager;
import org.sheepy.lily.vulkan.process.process.ProcessContext;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public abstract class AbstractCommandBufferAllocation implements ICommandBufferAdapter
{
	private final AbstractProcessCommandBufferHelper commandBufferHelper;
	private final ProcessContext context;
	private final int index;
	private final CountLocker locker;
	private final IAllocationState allocationState;
	private boolean needRecord = true;
	private List<IRecordableAdapter> recordables;
	private List<Consumer<EExecutionStatus>> listeners;

	public AbstractCommandBufferAllocation(AbstractProcessCommandBufferHelper commandBufferHelper,
										   final ProcessContext context,
										   int index,
										   IAllocationState allocationState)
	{
		this.commandBufferHelper = commandBufferHelper;
		this.context = context;
		this.index = index;
		this.allocationState = allocationState;
		this.locker = new CountLocker(allocationState::lockAllocation, allocationState::unlockAllocation);
	}

	protected void changeRecordables(List<IRecordableAdapter> recordables)
	{
		this.recordables = recordables;
		allocationState.setAllocationObsolete();
		needRecord = true;
	}

	@Override
	public void prepare(final SynchronizationManager.SyncUnit currentSyncUnit)
	{
		if (needRecord)
		{
			final var recordContexts = commandBufferHelper.record(recordables, context, index);
			listeners = Stream.concat(Stream.of(this::updateLock),
									  recordContexts.stream()
													.map(RecordContext::getExecutionListeners)
													.flatMap(Collection::stream)).toList();
			needRecord = false;
		}
		currentSyncUnit.setListeners(listeners);
	}

	@Free
	public void free(ExecutionContext context)
	{
		commandBufferHelper.free(context);
	}

	@Override
	public VkCommandBuffer getVkCommandBuffer()
	{
		return commandBufferHelper.getVkCommandBuffer();
	}

	private void updateLock(EExecutionStatus e)
	{
		switch (e)
		{
			case Started -> locker.increase();
			case Done, Canceled -> locker.decrease();
		}
	}

	/**
	 * Lock when count > 0
	 */
	private static final class CountLocker
	{
		private final Runnable onLock;
		private final Runnable onUnlock;
		private int count = 0;

		public CountLocker(Runnable onLock, Runnable onUnlock)
		{
			this.onLock = onLock;
			this.onUnlock = onUnlock;
		}

		public void increase()
		{
			count++;
			if (count == 1)
			{
				onLock.run();
			}
		}

		public void decrease()
		{
			assert count > 0;
			count--;
			if (count == 0)
			{
				onUnlock.run();
			}
		}
	}
}
