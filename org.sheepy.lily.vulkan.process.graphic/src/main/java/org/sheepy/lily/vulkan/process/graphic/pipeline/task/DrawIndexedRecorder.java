package org.sheepy.lily.vulkan.process.graphic.pipeline.task;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableExtender;
import org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed;

import static org.lwjgl.vulkan.VK10.vkCmdDrawIndexed;

@ModelExtender(scope = DrawIndexed.class)
@Adapter
public final class DrawIndexedRecorder implements IRecordableExtender
{
	private final DrawIndexed task;

	private DrawIndexedRecorder(DrawIndexed task)
	{
		this.task = task;
	}

	@Override
	public void record(RecordContext context)
	{
		final int indexCount = task.getIndexCount();
		final int instanceCount = task.getInstanceCount();
		final int firstIndex = task.getFirstIndex();
		final int vertexOffset = task.getVertexOffset();
		final int firstInstance = task.getFirstInstance();
		final var commandBuffer = context.commandBuffer;

		vkCmdDrawIndexed(commandBuffer, indexCount, instanceCount, firstIndex, vertexOffset, firstInstance);
	}
}
