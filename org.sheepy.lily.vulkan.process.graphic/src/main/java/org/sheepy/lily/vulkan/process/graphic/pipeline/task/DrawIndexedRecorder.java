package org.sheepy.lily.vulkan.process.graphic.pipeline.task;

import org.sheepy.lily.core.api.allocation.IAllocationState;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.logoce.lmf.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.vulkan.core.execution.RecordContext;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableAdapter;
import org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed;

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
								  DrawIndexed.FeatureIDs.INDEX_COUNT,
								  DrawIndexed.FeatureIDs.INSTANCE_COUNT,
								  DrawIndexed.FeatureIDs.FIRST_INDEX,
								  DrawIndexed.FeatureIDs.VERTEX_OFFSET,
								  DrawIndexed.FeatureIDs.FIRST_INSTANCE);
	}

	@Override
	public void record(final RecordContext context)
	{
		final int indexCount = task.indexCount();
		final int instanceCount = task.instanceCount();
		final int firstIndex = task.firstIndex();
		final int vertexOffset = task.vertexOffset();
		final int firstInstance = task.firstInstance();
		final var commandBuffer = context.commandBuffer;

		vkCmdDrawIndexed(commandBuffer, indexCount, instanceCount, firstIndex, vertexOffset, firstInstance);
	}
}
