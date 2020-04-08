package org.sheepy.lily.vulkan.process.pipeline.task;

import org.eclipse.emf.common.notify.Notification;
import org.lwjgl.vulkan.VkBufferCopy;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.game.api.resource.buffer.IBufferAdapter;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.core.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.model.process.CopyBufferTask;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.resource.IBuffer;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import java.util.List;
import java.util.function.LongConsumer;

import static org.lwjgl.vulkan.VK10.vkCmdCopyBuffer;

@Statefull
@Adapter(scope = CopyBufferTask.class)
public final class CopyBufferTaskAdapter implements IPipelineTaskAdapter<CopyBufferTask>
{
	private final LongConsumer bufferChanged = n -> dirty = true;

	private final VkBufferCopy.Buffer copyInfo;
	private final CopyBufferTask task;

	private boolean dirty = true;

	private IBuffer srcBuffer;
	private IBuffer dstBuffer;
	private IBufferAdapter srcAdapter;
	private IBufferAdapter dstAdapter;

	public CopyBufferTaskAdapter(CopyBufferTask task)
	{
		this.task = task;
		copyInfo = VkBufferCopy.calloc(1);

		srcBuffer = task.getSrcBuffer();
		dstBuffer = task.getDstBuffer();
		srcAdapter = srcBuffer.adapt(IBufferAdapter.class);
		dstAdapter = dstBuffer.adapt(IBufferAdapter.class);
		listenAdapter(srcAdapter);
		listenAdapter(dstAdapter);
	}

	@NotifyChanged(featureIds = ProcessPackage.COPY_BUFFER_TASK__SRC_BUFFER)
	public void srcChanged(Notification notification)
	{
		srcBuffer = ((IBuffer) notification.getNewValue());
		srcAdapter = reinstallListener(srcBuffer, srcAdapter);
	}

	@NotifyChanged(featureIds = ProcessPackage.COPY_BUFFER_TASK__DST_BUFFER)
	public void dstChanged(Notification notification)
	{
		dstBuffer = ((IBuffer) notification.getNewValue());
		dstAdapter = reinstallListener(dstBuffer, dstAdapter);
	}

	private IBufferAdapter reinstallListener(IBuffer bufferRef, IBufferAdapter oldAdapter)
	{
		dirty = true;
		sulkAdapter(oldAdapter);
		final var res = bufferRef.adapt(IBufferAdapter.class);
		listenAdapter(res);
		return res;
	}

	@Dispose
	public void dispose()
	{
		sulkAdapter(srcAdapter);
		sulkAdapter(dstAdapter);
		copyInfo.free();
	}

	private void update()
	{
		final var scrOffset = srcAdapter.getBindOffset();
		final var dstOffset = dstAdapter.getBindOffset();

		copyInfo.srcOffset(scrOffset);
		copyInfo.dstOffset(dstOffset);

		if (task.isSetSize())
		{
			final var size = task.getSize();
			copyInfo.size(size);
		}
		else
		{
			final var srcSize = srcAdapter.getBindSize();
			final var trgSize = dstAdapter.getBindSize();

			final var size = Math.min(srcSize, trgSize);
			copyInfo.size(size);
		}
	}

	@Override
	public void record(CopyBufferTask task, IRecordContext context)
	{
		if (dirty)
		{
			update();
		}

		final var srcBuffer = task.getSrcBuffer();
		final var commandBuffer = ((RecordContext) context).commandBuffer;
		final var scrPtr = srcAdapter.getPtr();
		final var dstPtr = dstAdapter.getPtr();
		final var srcBufferAdapter = srcBuffer.adapt(IBufferAdapter.class);

		srcBufferAdapter.flush();
		vkCmdCopyBuffer(commandBuffer, scrPtr, dstPtr, copyInfo);
		dirty = false;
	}

	private void listenAdapter(final IBufferAdapter adapter)
	{
		adapter.listen(bufferChanged,
					   List.of(IBufferAdapter.Features.Size,
							   IBufferAdapter.Features.Ptr,
							   IBufferAdapter.Features.Offset));
	}

	private void sulkAdapter(final IBufferAdapter adapter)
	{
		adapter.sulk(bufferChanged,
					 List.of(IBufferAdapter.Features.Size,
							 IBufferAdapter.Features.Ptr,
							 IBufferAdapter.Features.Offset));
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
