package org.sheepy.lily.vulkan.process.pipeline.task;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.common.resource.buffer.InternalTransferBufferAdapter;
import org.sheepy.lily.vulkan.common.resource.buffer.InternalTransferBufferAdapter.IFlushRecorder;
import org.sheepy.lily.vulkan.model.process.FlushTransferBufferTask;
import org.sheepy.lily.vulkan.model.resource.TransferBuffer;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

@Statefull
@Adapter(scope = FlushTransferBufferTask.class)
public final class FlushTransferBufferTaskAdapter
		implements IPipelineTaskAdapter<FlushTransferBufferTask>
{
	private final TransferBuffer transferBuffer;

	private int stagingFlushHistory = 0;
	private IFlushRecorder record;

	public FlushTransferBufferTaskAdapter(FlushTransferBufferTask task)
	{
		transferBuffer = task.getTransferBuffer();
	}

	@Override
	public void update(FlushTransferBufferTask task, int index)
	{
		if (task.isFlushDuringUpdate())
		{
			record();
		}
	}

	@Override
	public void record(FlushTransferBufferTask task, IRecordContext context)
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
		final var pushBufferAdapter = transferBuffer.adaptNotNull(InternalTransferBufferAdapter.class);
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
	public boolean needRecord(FlushTransferBufferTask task, int index)
	{
		final var pushBufferAdapter = transferBuffer.adaptNotNull(InternalTransferBufferAdapter.class);
		final boolean previousRecordMadeFlush = getAndClearHistory(index);

		boolean res = false;
		res |= record != null;
		res |= previousRecordMadeFlush;
		res |= pushBufferAdapter.isEmpty() == false;

		return res;
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
	public ECommandStage getStage(FlushTransferBufferTask task)
	{
		return task.getStage();
	}
}
