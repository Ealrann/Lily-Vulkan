package org.sheepy.lily.vulkan.process.pipeline.task;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.api.resource.buffer.IPushBufferAdapter;
import org.sheepy.lily.vulkan.api.resource.buffer.IPushBufferUpdater;
import org.sheepy.lily.vulkan.model.process.PushBufferTask;
import org.sheepy.lily.vulkan.model.resource.PushBuffer;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

@Statefull
@Adapter(scope = PushBufferTask.class)
public class PushBufferTaskAdapter implements IPipelineTaskAdapter<PushBufferTask>
{
	private final boolean[] stagingFlushHistory;
	private final IPushBufferAdapter pushBufferAdapter;
	private final IPushBufferUpdater updater;
	private final PushBuffer pushBuffer;

	public PushBufferTaskAdapter(PushBufferTask task)
	{
		pushBuffer = task.getPushBuffer();
		updater = IPushBufferUpdater.adapt(pushBuffer);
		stagingFlushHistory = new boolean[pushBuffer.getInstanceCount()];
		pushBufferAdapter = IPushBufferAdapter.adapt(pushBuffer);
	}

	@Override
	public void record(PushBufferTask task, RecordContext context)
	{
		if (context.stage == ECommandStage.TRANSFER)
		{
			final var stagingBuffer = pushBufferAdapter.getStagingBuffer();

			if (stagingBuffer.isEmpty() == false)
			{
				stagingFlushHistory[context.index] = true;
				stagingBuffer.flushCommands(context.commandBuffer);
			}
		}
	}

	@Override
	public boolean needRecord(PushBufferTask task, int index)
	{
		boolean res = false;

		if (pushBufferAdapter != null)
		{
			if (updater != null)
			{
				updater.beforePush(pushBuffer);
			}

			final var stagingBuffer = pushBufferAdapter.getStagingBuffer();
			final boolean previousRecordMadeFlush = stagingFlushHistory[index];
			if (previousRecordMadeFlush)
			{
				stagingFlushHistory[index] = false;
			}

			stagingBuffer.prepare();
			res |= !stagingBuffer.isEmpty();
			res |= previousRecordMadeFlush;
		}

		return res;
	}

	@Override
	public ECommandStage getStage(PushBufferTask task)
	{
		return ECommandStage.TRANSFER;
	}
}
