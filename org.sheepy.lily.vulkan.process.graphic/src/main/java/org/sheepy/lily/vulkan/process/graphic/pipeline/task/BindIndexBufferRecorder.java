package org.sheepy.lily.vulkan.process.graphic.pipeline.task;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.game.api.resource.buffer.IBufferAllocation;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineTaskRecorder;
import org.sheepy.lily.vulkan.model.process.graphic.BindIndexBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;

import static org.lwjgl.vulkan.VK10.vkCmdBindIndexBuffer;

@ModelExtender(scope = BindIndexBuffer.class)
@Allocation
@AllocationDependency(features = GraphicPackage.BIND_INDEX_BUFFER__BUFFER, type = IBufferAllocation.class)
public final class BindIndexBufferRecorder implements IPipelineTaskRecorder
{
	private final BindIndexBuffer task;
	private final IBufferAllocation buffer;

	private BindIndexBufferRecorder(BindIndexBuffer task, @InjectDependency(index = 0) IBufferAllocation buffer)
	{
		this.task = task;
		this.buffer = buffer;
	}

	@Override
	public void record(RecordContext context)
	{
		final var indexPtr = buffer.getPtr();
		final var indexOffset = buffer.getBindOffset();
		final var indexType = task.getIndexType().getValue();
		final var commandBuffer = context.commandBuffer;

		vkCmdBindIndexBuffer(commandBuffer, indexPtr, indexOffset, indexType);
	}
}
