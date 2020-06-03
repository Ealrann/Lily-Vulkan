package org.sheepy.lily.vulkan.process.pipeline.task;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.api.execution.IRecordContext;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineTaskRecorder;
import org.sheepy.lily.vulkan.core.resource.buffer.InternalTransferBufferAllocation;
import org.sheepy.lily.vulkan.core.resource.buffer.InternalTransferBufferAllocation.IFlushRecorder;
import org.sheepy.lily.vulkan.model.process.FlushTransferBufferTask;
import org.sheepy.lily.vulkan.model.resource.TransferBuffer;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

@ModelExtender(scope = FlushTransferBufferTask.class)
@Adapter
public final class FlushTransferBufferTaskRecorder implements IPipelineTaskRecorder
{
	private final TransferBuffer transferBuffer;
	private final FlushTransferBufferTask task;

	private int stagingFlushHistory = 0;
	private IFlushRecorder record;

	public FlushTransferBufferTaskRecorder(FlushTransferBufferTask task)
	{
		transferBuffer = task.getTransferBuffer();
		this.task = task;
	}

	@Override
	public void update(int index)
	{
		if (task.isFlushDuringUpdate())
		{
			record();
		}
	}

	@Override
	public void record(RecordContext context)
	{
		if (task.isFlushDuringUpdate() == false)
		{
			record();
		}

		if (record != null)
		{
			setFlushHistory(context);
			record.flush(context);
		}
	}

	private void record()
	{
		final var pushBufferAdapter = transferBuffer.adapt(InternalTransferBufferAllocation.class);
		if (pushBufferAdapter.isEmpty() == false)
		{
			record = pushBufferAdapter.recordFlush();
		}
		else
		{
			record = null;
		}
	}

	@Override
	public boolean isRecordDirty(int index)
	{
		final var pushBufferAdapter = transferBuffer.adapt(InternalTransferBufferAllocation.class);
		final boolean previousRecordMadeFlush = getAndClearHistory(index);
		final boolean somethingToPush = pushBufferAdapter.isEmpty() == false;
		final boolean somethingToRecord = record != null;

		return somethingToRecord || previousRecordMadeFlush || somethingToPush;
	}

	private void setFlushHistory(IRecordContext context)
	{
		final int flushIndexFlag = 1 << context.index();
		stagingFlushHistory |= flushIndexFlag;
	}

	private boolean getAndClearHistory(final int index)
	{
		final int flushIndexFlag = 1 << index;
		final boolean previousRecordMadeFlush = (stagingFlushHistory & flushIndexFlag) != 0;
		if (previousRecordMadeFlush)
		{
			stagingFlushHistory ^= flushIndexFlag;
		}
		return previousRecordMadeFlush;
	}

	@Override
	public ECommandStage getStage()
	{
		return task.getStage();
	}
}
