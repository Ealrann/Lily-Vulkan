package org.sheepy.lily.vulkan.process.pipeline.task;

import org.lwjgl.vulkan.VkBufferCopy;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.game.api.resource.buffer.IBufferAllocation;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.core.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.model.process.CopyBufferTask;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import static org.lwjgl.vulkan.VK10.vkCmdCopyBuffer;

@ModelExtender(scope = CopyBufferTask.class)
@Adapter
public final class CopyBufferTaskAdapter implements IPipelineTaskAdapter<CopyBufferTask>
{
	private final VkBufferCopy.Buffer copyInfo;
	private final CopyBufferTask task;

	private boolean dirty = true;

	public CopyBufferTaskAdapter(CopyBufferTask task, IObservatoryBuilder observatory)
	{
		this.task = task;
		copyInfo = VkBufferCopy.calloc(1);

		observatory.explore(ProcessPackage.Literals.COPY_BUFFER_TASK__SRC_BUFFER)
				   .allocation(IBufferAllocation.class)
				   .listenNoParam(() -> dirty = true);
		observatory.explore(ProcessPackage.Literals.COPY_BUFFER_TASK__DST_BUFFER)
				   .allocation(IBufferAllocation.class)
				   .listenNoParam(() -> dirty = true);
	}

	@Dispose
	public void dispose()
	{
		copyInfo.free();
	}

	@Override
	public void record(CopyBufferTask task, IRecordContext context)
	{
		final var srcBufferAllocation = task.getSrcBuffer()
											.allocationHandle(IBufferAllocation.class)
											.get();
		final var dstBufferAllocation = task.getDstBuffer()
											.allocationHandle(IBufferAllocation.class)
											.get();
		if (dirty)
		{
			update(srcBufferAllocation, dstBufferAllocation);
		}
		final var srcBuffer = task.getSrcBuffer();
		final var commandBuffer = ((RecordContext) context).commandBuffer;
		final var scrPtr = srcBufferAllocation.getPtr();
		final var dstPtr = dstBufferAllocation.getPtr();
		final var srcBufferAdapter = srcBuffer.allocationHandle(IBufferAllocation.class)
											  .get();

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
