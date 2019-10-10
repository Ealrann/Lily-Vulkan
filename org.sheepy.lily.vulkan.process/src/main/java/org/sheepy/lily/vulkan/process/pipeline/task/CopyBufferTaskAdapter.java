package org.sheepy.lily.vulkan.process.pipeline.task;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkBufferCopy;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.vulkan.api.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.api.resource.buffer.IBufferAdapter;
import org.sheepy.lily.vulkan.model.process.CopyBufferTask;
import org.sheepy.vulkan.model.enumeration.ECommandStage;

@Adapter(scope = CopyBufferTask.class)
public final class CopyBufferTaskAdapter implements IPipelineTaskAdapter<CopyBufferTask>
{
	private static final VkBufferCopy.Buffer copyInfo = VkBufferCopy.create(1);
	static
	{
		copyInfo.get(0).set(0, 0, VK_WHOLE_SIZE);
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
	}

	@Override
	public ECommandStage getStage(CopyBufferTask task)
	{
		return task.getStage();
	}
}
