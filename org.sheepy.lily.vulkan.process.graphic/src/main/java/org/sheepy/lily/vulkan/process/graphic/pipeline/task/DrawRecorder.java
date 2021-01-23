package org.sheepy.lily.vulkan.process.graphic.pipeline.task;

import org.logoce.adapter.api.Adapter;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableAdapter;
import org.sheepy.lily.vulkan.model.process.graphic.Draw;

import static org.lwjgl.vulkan.VK10.vkCmdDraw;

@ModelExtender(scope = Draw.class)
@Adapter
public final class DrawRecorder implements IRecordableAdapter
{
	private final Draw task;

	private DrawRecorder(Draw task)
	{
		this.task = task;
	}

	@Override
	public void record(RecordContext context)
	{
		final int vertexCount = task.getVertexCount();
		final int instanceCount = task.getInstanceCount();
		final int firstVertex = task.getFirstVertex();
		final int firstInstance = task.getFirstInstance();
		final var commandBuffer = context.commandBuffer;

		vkCmdDraw(commandBuffer, vertexCount, instanceCount, firstVertex, firstInstance);
	}
}
