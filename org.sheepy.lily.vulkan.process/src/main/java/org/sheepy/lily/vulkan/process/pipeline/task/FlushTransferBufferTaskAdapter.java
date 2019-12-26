package org.sheepy.lily.vulkan.process.pipeline.task;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.api.resource.buffer.ITransferBufferAdapter;
import org.sheepy.lily.vulkan.model.process.FlushTransferBufferTask;
import org.sheepy.lily.vulkan.model.resource.TransferBuffer;
import org.sheepy.vulkan.execution.IRecordable.RecordContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;
import org.sheepy.vulkan.resource.staging.ITransferBuffer;
import org.sheepy.vulkan.resource.staging.ITransferBuffer.IFlushRecorder;

@Statefull
@Adapter(scope = FlushTransferBufferTask.class)
public final class FlushTransferBufferTaskAdapter
		implements IPipelineTaskAdapter<FlushTransferBufferTask>
{
	private final ITransferBuffer bufferBackend;
	private final TransferBuffer transferBuffer;

	private int stagingFlushHistory = 0;
	private IFlushRecorder record;

	public FlushTransferBufferTaskAdapter(FlushTransferBufferTask task)
	{
		transferBuffer = task.getTransferBuffer();
		final var pushBufferAdapter = transferBuffer.adaptNotNull(ITransferBufferAdapter.class);
		bufferBackend = pushBufferAdapter.getTransferBufferBackend();
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
	public void record(FlushTransferBufferTask task, RecordContext context)
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
		if (bufferBackend.isEmpty() == false)
		{
			record = bufferBackend.recordFlush();
		}
		else
		{
			record = null;
		}
	}

	@Override
	public boolean needRecord(FlushTransferBufferTask task, int index)
	{
		final boolean previousRecordMadeFlush = getAndClearHistory(index);

		boolean res = false;
		res |= record != null;
		res |= previousRecordMadeFlush;
		res |= bufferBackend.isEmpty() == false;

		return res;
	}

	private void setFlushHistory(RecordContext context)
	{
		final int flushIndexFlag = 1 << context.index;
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
