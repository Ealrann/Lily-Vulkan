package org.sheepy.lily.vulkan.process.pipeline.task;

import org.lwjgl.vulkan.VkBufferCopy;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.game.api.resource.buffer.IBufferAllocation;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineTaskRecorder;
import org.sheepy.lily.vulkan.model.process.CopyBufferTask;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

import static org.lwjgl.vulkan.VK10.vkCmdCopyBuffer;

@ModelExtender(scope = CopyBufferTask.class)
@Allocation
@AllocationDependency(features = ProcessPackage.COPY_BUFFER_TASK__SRC_BUFFER, type = IBufferAllocation.class)
@AllocationDependency(features = ProcessPackage.COPY_BUFFER_TASK__DST_BUFFER, type = IBufferAllocation.class)
public final class CopyBufferTaskRecorder implements IPipelineTaskRecorder
{
	private final VkBufferCopy.Buffer copyInfo;
	private final CopyBufferTask task;
	private final IBufferAllocation srcBuffer;
	private final long scrPtr;
	private final long dstPtr;

	public CopyBufferTaskRecorder(CopyBufferTask task,
								  @InjectDependency(index = 0) IBufferAllocation srcBuffer,
								  @InjectDependency(index = 1) IBufferAllocation dstBuffer)
	{
		this.task = task;
		this.srcBuffer = srcBuffer;
		copyInfo = VkBufferCopy.calloc(1);

		final var scrOffset = srcBuffer.getBindOffset();
		final var dstOffset = dstBuffer.getBindOffset();
		scrPtr = srcBuffer.getPtr();
		dstPtr = dstBuffer.getPtr();
		copyInfo.srcOffset(scrOffset);
		copyInfo.dstOffset(dstOffset);

		if (task.isSetSize())
		{
			final var size = task.getSize();
			copyInfo.size(size);
		}
		else
		{
			final var srcSize = srcBuffer.getBindSize();
			final var trgSize = dstBuffer.getBindSize();

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
	public void record(RecordContext context)
	{
		final var commandBuffer = context.commandBuffer;

		srcBuffer.flush();
		vkCmdCopyBuffer(commandBuffer, scrPtr, dstPtr, copyInfo);
	}

	@Override
	public ECommandStage getStage()
	{
		return task.getStage();
	}
}
