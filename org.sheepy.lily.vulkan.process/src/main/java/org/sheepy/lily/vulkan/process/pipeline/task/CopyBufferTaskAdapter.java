package org.sheepy.lily.vulkan.process.pipeline.task;

import static org.lwjgl.vulkan.VK10.vkCmdCopyBuffer;

import org.eclipse.emf.common.notify.Notification;
import org.lwjgl.vulkan.VkBufferCopy;
import org.sheepy.lily.core.api.adapter.INotificationListener;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.api.resource.buffer.IBufferReferenceAdapter;
import org.sheepy.lily.vulkan.model.process.CopyBufferTask;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.resource.IBufferReference;
import org.sheepy.vulkan.execution.IRecordable.RecordContext;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

@Statefull
@Adapter(scope = CopyBufferTask.class)
public final class CopyBufferTaskAdapter implements IPipelineTaskAdapter<CopyBufferTask>
{
	private static final int[] FEATURES = new int[] {
			IBufferReferenceAdapter.FEATURES.SIZE.ordinal(),
			IBufferReferenceAdapter.FEATURES.OFFSET.ordinal(),
			IBufferReferenceAdapter.FEATURES.BUFFER_PTR.ordinal()
	};

	private final INotificationListener bufferChanged = n -> dirty = true;

	private final VkBufferCopy.Buffer copyInfo;
	private final CopyBufferTask task;

	private boolean dirty = true;

	private IBufferReference srcBuffer;
	private IBufferReference dstBuffer;
	private IBufferReferenceAdapter srcAdapter;
	private IBufferReferenceAdapter dstAdapter;

	public CopyBufferTaskAdapter(CopyBufferTask task)
	{
		this.task = task;
		copyInfo = VkBufferCopy.calloc(1);

		srcBuffer = task.getSrcBuffer();
		dstBuffer = task.getDstBuffer();
		srcAdapter = srcBuffer.adapt(IBufferReferenceAdapter.class);
		dstAdapter = dstBuffer.adapt(IBufferReferenceAdapter.class);
		srcAdapter.addListener(bufferChanged, FEATURES);
		dstAdapter.addListener(bufferChanged, FEATURES);
	}

	@NotifyChanged(featureIds = ProcessPackage.COPY_BUFFER_TASK__SRC_BUFFER)
	public void srcChanged(Notification notification)
	{
		srcBuffer = ((IBufferReference) notification.getNewValue());
		srcAdapter = reinstallListener(srcBuffer, srcAdapter);
	}

	@NotifyChanged(featureIds = ProcessPackage.COPY_BUFFER_TASK__DST_BUFFER)
	public void dstChanged(Notification notification)
	{
		dstBuffer = ((IBufferReference) notification.getNewValue());
		dstAdapter = reinstallListener(dstBuffer, dstAdapter);
	}

	private IBufferReferenceAdapter reinstallListener(	IBufferReference bufferRef,
														IBufferReferenceAdapter oldAdapter)
	{
		dirty = true;
		oldAdapter.removeListener(bufferChanged, FEATURES);
		final var res = bufferRef.adapt(IBufferReferenceAdapter.class);
		res.addListener(bufferChanged, FEATURES);
		return res;
	}

	@Dispose
	public void dispose()
	{
		srcAdapter.removeListener(bufferChanged, FEATURES);
		dstAdapter.removeListener(bufferChanged, FEATURES);
		copyInfo.free();
	}

	private void update()
	{
		final var scrOffset = srcAdapter.getOffset(srcBuffer);
		final var dstOffset = dstAdapter.getOffset(dstBuffer);

		copyInfo.srcOffset(scrOffset);
		copyInfo.dstOffset(dstOffset);

		if (task.isSetSize())
		{
			final var size = task.getSize();
			copyInfo.size(size);
		}
		else
		{
			final var srcSize = srcAdapter.getSize(srcBuffer);
			final var trgSize = dstAdapter.getSize(dstBuffer);

			final var size = Math.min(srcSize, trgSize);
			copyInfo.size(size);
		}
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
		final var scrPtr = srcAdapter.getBufferPtr(srcBuffer);
		final var dstPtr = dstAdapter.getBufferPtr(dstBuffer);

		final var srcBufferAdapter = srcBuffer.adapt(IBufferReferenceAdapter.class);
		srcBufferAdapter.flush(srcBuffer);

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
