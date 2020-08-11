package org.sheepy.lily.vulkan.process.graphic.pipeline.task;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableExtender;
import org.sheepy.lily.vulkan.core.resource.IVulkanBufferAllocation;
import org.sheepy.lily.vulkan.model.process.graphic.BindIndexBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;

import static org.lwjgl.vulkan.VK10.vkCmdBindIndexBuffer;

@ModelExtender(scope = BindIndexBuffer.class)
@Allocation
@AllocationDependency(features = GraphicPackage.BIND_INDEX_BUFFER__BUFFER, type = IVulkanBufferAllocation.class)
public final class BindIndexBufferRecorder implements IRecordableExtender
{
	private final BindIndexBuffer task;
	private final IVulkanBufferAllocation buffer;

	private BindIndexBufferRecorder(BindIndexBuffer task, @InjectDependency(index = 0) IVulkanBufferAllocation buffer)
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

		buffer.attach(context);

		vkCmdBindIndexBuffer(commandBuffer, indexPtr, indexOffset, indexType);
	}
}
