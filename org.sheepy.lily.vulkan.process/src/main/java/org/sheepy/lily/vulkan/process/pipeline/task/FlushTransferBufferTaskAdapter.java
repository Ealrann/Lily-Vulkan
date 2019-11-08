package org.sheepy.lily.vulkan.process.pipeline.task;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.api.resource.buffer.ITransferBufferAdapter;
import org.sheepy.lily.vulkan.model.process.FlushTransferBufferTask;
import org.sheepy.lily.vulkan.model.resource.TransferBuffer;
import org.sheepy.vulkan.execution.IRecordable.RecordContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

@Statefull
@Adapter(scope = FlushTransferBufferTask.class)
public final class FlushTransferBufferTaskAdapter
		implements IPipelineTaskAdapter<FlushTransferBufferTask>
{
	private final ITransferBufferAdapter pushBufferAdapter;
	private final TransferBuffer transferBuffer;

	private int stagingFlushHistory = 0;

	public FlushTransferBufferTaskAdapter(FlushTransferBufferTask task)
	{
		transferBuffer = task.getTransferBuffer();
		pushBufferAdapter = transferBuffer.adaptNotNull(ITransferBufferAdapter.class);
	}

	@Override
	public void record(FlushTransferBufferTask task, RecordContext context)
	{
		final var stagingBuffer = pushBufferAdapter.getTransferBufferBackend();

		if (stagingBuffer.isEmpty() == false)
		{
			setFlushHistory(context);
			stagingBuffer.flushCommands(context);
		}
	}

	@Override
	public boolean needRecord(FlushTransferBufferTask task, int index)
	{
		boolean res = false;

		if (pushBufferAdapter != null)
		{
			final var stagingBuffer = pushBufferAdapter.getTransferBufferBackend();
			final boolean previousRecordMadeFlush = getAndClearHistory(index);

			stagingBuffer.prepare();
			res |= !stagingBuffer.isEmpty();
			res |= previousRecordMadeFlush;
		}

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
		final boolean previousRecordMadeFlush = (stagingFlushHistory | flushIndexFlag) != 0;
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
