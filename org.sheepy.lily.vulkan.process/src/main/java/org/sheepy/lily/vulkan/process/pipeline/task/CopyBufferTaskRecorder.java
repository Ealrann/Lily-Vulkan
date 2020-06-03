package org.sheepy.lily.vulkan.process.pipeline.task;

import org.lwjgl.vulkan.VkBufferCopy;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.game.api.resource.buffer.IBufferAllocation;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineTaskRecorder;
import org.sheepy.lily.vulkan.model.process.CopyBufferTask;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import static org.lwjgl.vulkan.VK10.vkCmdCopyBuffer;

@ModelExtender(scope = CopyBufferTask.class)
@Adapter
public final class CopyBufferTaskRecorder implements IPipelineTaskRecorder
{
	private final VkBufferCopy.Buffer copyInfo;
	private final CopyBufferTask task;

	private boolean dirty = true;

	public CopyBufferTaskRecorder(CopyBufferTask task, IObservatoryBuilder observatory)
	{
		this.task = task;
		copyInfo = VkBufferCopy.calloc(1);

		observatory.explore(ProcessPackage.COPY_BUFFER_TASK__SRC_BUFFER)
				   .adapt(IBufferAllocation.class)
				   .listenAdaptationNoParam(() -> dirty = true);
		observatory.explore(ProcessPackage.COPY_BUFFER_TASK__DST_BUFFER)
				   .adapt(IBufferAllocation.class)
				   .listenAdaptationNoParam(() -> dirty = true);
	}

	@Dispose
	public void dispose()
	{
		copyInfo.free();
	}

	@Override
	public void record(RecordContext context)
	{
		final var srcBufferAllocation = task.getSrcBuffer().adapt(IBufferAllocation.class);
		final var dstBufferAllocation = task.getDstBuffer().adapt(IBufferAllocation.class);
		if (dirty)
		{
			update(srcBufferAllocation, dstBufferAllocation);
		}
		final var srcBuffer = task.getSrcBuffer();
		final var commandBuffer = context.commandBuffer;
		final var scrPtr = srcBufferAllocation.getPtr();
		final var dstPtr = dstBufferAllocation.getPtr();
		final var srcBufferAdapter = srcBuffer.adapt(IBufferAllocation.class);

		srcBufferAdapter.flush();
		vkCmdCopyBuffer(commandBuffer, scrPtr, dstPtr, copyInfo);
		dirty = false;
	}

	private void update(final IBufferAllocation srcBufferAllocation, final IBufferAllocation dstBufferAllocation)
	{
		final var scrOffset = srcBufferAllocation.getBindOffset();
		final var dstOffset = dstBufferAllocation.getBindOffset();

		copyInfo.srcOffset(scrOffset);
		copyInfo.dstOffset(dstOffset);

		if (task.isSetSize())
		{
			final var size = task.getSize();
			copyInfo.size(size);
		}
		else
		{
			final var srcSize = srcBufferAllocation.getBindSize();
			final var trgSize = dstBufferAllocation.getBindSize();

			final var size = Math.min(srcSize, trgSize);
			copyInfo.size(size);
		}
	}

	@Override
	public ECommandStage getStage()
	{
		return task.getStage();
	}

	@Override
	public boolean isRecordDirty(int index)
	{
		return dirty;
	}
}
