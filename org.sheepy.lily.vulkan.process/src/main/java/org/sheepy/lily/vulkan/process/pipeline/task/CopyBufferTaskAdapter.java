package org.sheepy.lily.vulkan.process.pipeline.task;

import static org.lwjgl.vulkan.VK10.vkCmdCopyBuffer;

import org.eclipse.emf.common.notify.Notification;
import org.lwjgl.vulkan.VkBufferCopy;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.api.resource.buffer.IBufferAdapter;
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

		updateSize();
	}

	@NotifyChanged
	public void notifyChanged(Notification notification)
	{
		final var feature = notification.getFeature();
		if (feature == ProcessPackage.Literals.COPY_BUFFER_TASK__SRC_BUFFER
				|| feature == ProcessPackage.Literals.COPY_BUFFER_TASK__TRG_BUFFER)
		{
			updateSize();

			dirty = true;
		}
	}

	private void updateSize()
	{
		final var srcBuffer = task.getSrcBuffer();
		final var trgBuffer = task.getTrgBuffer();
		final var srcSize = srcBuffer.getSize();
		final var trgSize = trgBuffer.getSize();
		final var size = Math.min(srcSize, trgSize);

		copyInfo.size(size);
	}

	@Dispose
	public void dispose()
	{
		copyInfo.free();
	}

	@Override
	public void record(CopyBufferTask task, RecordContext context)
	{
		final var srcBuffer = task.getSrcBuffer();
		final var trgBuffer = task.getTrgBuffer();
		final var srcBufferAdapter = IBufferAdapter.adapt(srcBuffer);
		final var trgBufferAdapter = IBufferAdapter.adapt(trgBuffer);
		final var commandBuffer = context.commandBuffer;
		final var srcBufferPtr = srcBufferAdapter.getPtr();
		final var trgBufferPtr = trgBufferAdapter.getPtr();

		srcBufferAdapter.flush();

		vkCmdCopyBuffer(commandBuffer, srcBufferPtr, trgBufferPtr, copyInfo);

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
