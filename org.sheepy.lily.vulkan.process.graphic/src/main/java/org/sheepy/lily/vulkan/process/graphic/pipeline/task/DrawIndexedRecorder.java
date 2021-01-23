package org.sheepy.lily.vulkan.process.graphic.pipeline.task;

import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableAdapter;
import org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;

import static org.lwjgl.vulkan.VK10.vkCmdDrawIndexed;

@ModelExtender(scope = DrawIndexed.class)
@Allocation
public final class DrawIndexedRecorder implements IRecordableAdapter
{
	private final DrawIndexed task;

	private DrawIndexedRecorder(final DrawIndexed task,
								final IAllocationState allocationState,
								final IObservatoryBuilder observatory)
	{
		this.task = task;

		observatory.listenNoParam(allocationState::setAllocationObsolete,
								  GraphicPackage.DRAW_INDEXED__INDEX_COUNT,
								  GraphicPackage.DRAW_INDEXED__INSTANCE_COUNT,
								  GraphicPackage.DRAW_INDEXED__FIRST_INDEX,
								  GraphicPackage.DRAW_INDEXED__VERTEX_OFFSET,
								  GraphicPackage.DRAW_INDEXED__FIRST_INSTANCE);
	}

	@Override
	public void record(final RecordContext context)
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
