package org.sheepy.lily.vulkan.process.execution;

import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.game.api.execution.EExecutionStatus;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableAdapter;
import org.sheepy.lily.vulkan.model.process.ICommandBuffer;
import org.sheepy.lily.vulkan.process.execution.util.CountLocker;
import org.sheepy.lily.vulkan.process.execution.util.FenceManager;
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

	public AbstractCommandBufferAllocation(ICommandBuffer commandBuffer,
										   AbstractProcessCommandBufferHelper commandBufferHelper,
										   final ProcessContext context,
										   IAllocationState allocationState)
	{
		this.commandBufferHelper = commandBufferHelper;
		this.context = context;
		this.index = commandBuffer.getIndex();
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
	public void prepare(final FenceManager fenceManager)
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
		fenceManager.addListeners(listeners);
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
}
