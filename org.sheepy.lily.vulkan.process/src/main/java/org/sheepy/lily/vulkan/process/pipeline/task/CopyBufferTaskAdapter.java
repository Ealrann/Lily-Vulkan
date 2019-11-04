package org.sheepy.lily.vulkan.process.pipeline.task;

import static org.lwjgl.vulkan.VK10.vkCmdCopyBuffer;

import org.lwjgl.vulkan.VkBufferCopy;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.api.resource.buffer.IBufferReferenceAdapter;
import org.sheepy.lily.vulkan.model.process.CopyBufferTask;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

@Statefull
@Adapter(scope = CopyBufferTask.class)
public final class CopyBufferTaskAdapter implements IPipelineTaskAdapter<CopyBufferTask>
{
	private final VkBufferCopy.Buffer copyInfo;
	private final CopyBufferTask task;

	private boolean dirty = true;

	public CopyBufferTaskAdapter(CopyBufferTask task)
	{
		this.task = task;
		copyInfo = VkBufferCopy.calloc(1);
	}

	@NotifyChanged(featureIds = {
			ProcessPackage.COPY_BUFFER_TASK__SRC_BUFFER, ProcessPackage.COPY_BUFFER_TASK__DST_BUFFER
	})
	public void notifyChanged()
	{
		dirty = true;
	}

	private void update()
	{
		final var srcBuffer = task.getSrcBuffer();
		final var dstBuffer = task.getDstBuffer();
		final var scrOffset = IBufferReferenceAdapter.Helper.getOffset(srcBuffer);
		final var dstOffset = IBufferReferenceAdapter.Helper.getOffset(dstBuffer);

		copyInfo.srcOffset(scrOffset);
		copyInfo.dstOffset(dstOffset);

		if (task.isSetSize())
		{
			final var size = task.getSize();
			copyInfo.size(size);
		}
		else
		{
			final var srcSize = IBufferReferenceAdapter.Helper.getSize(srcBuffer);
			final var trgSize = IBufferReferenceAdapter.Helper.getSize(dstBuffer);

			final var size = Math.min(srcSize, trgSize);
			copyInfo.size(size);
		}
	}

	@Dispose
	public void dispose()
	{
		copyInfo.free();
	}

	@Override
	public void record(CopyBufferTask task, RecordContext context)
	{
		if (dirty)
		{
			update();
		}

		final var srcBuffer = task.getSrcBuffer();
		final var dstBuffer = task.getDstBuffer();
		final var commandBuffer = context.commandBuffer;
		final var scrPtr = IBufferReferenceAdapter.Helper.getBufferPtr(srcBuffer);
		final var dstPtr = IBufferReferenceAdapter.Helper.getBufferPtr(dstBuffer);

		IBufferReferenceAdapter.Helper.flush(srcBuffer);

		vkCmdCopyBuffer(commandBuffer, scrPtr, dstPtr, copyInfo);

		dirty = false;
	}

	@Override
	public ECommandStage getStage(CopyBufferTask task)
	{
		return task.getStage();
	}

	@Override
	public boolean needRecord(CopyBufferTask task, int index)
	{
		return dirty;
	}
}
