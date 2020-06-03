package org.sheepy.lily.vulkan.process.graphic.pipeline.task;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineTaskRecorder;
import org.sheepy.lily.vulkan.model.process.graphic.Draw;

import static org.lwjgl.vulkan.VK10.vkCmdDraw;

@ModelExtender(scope = Draw.class)
@Adapter
public final class DrawRecorder implements IPipelineTaskRecorder
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
