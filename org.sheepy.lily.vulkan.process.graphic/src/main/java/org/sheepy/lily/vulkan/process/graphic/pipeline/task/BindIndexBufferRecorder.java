package org.sheepy.lily.vulkan.process.graphic.pipeline.task;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.game.api.resource.buffer.IBufferAllocation;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineTaskRecorder;
import org.sheepy.lily.vulkan.model.process.graphic.BindIndexBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;

import static org.lwjgl.vulkan.VK10.vkCmdBindIndexBuffer;

@ModelExtender(scope = BindIndexBuffer.class)
@Adapter
public final class BindIndexBufferRecorder implements IPipelineTaskRecorder
{
	private final BindIndexBuffer task;
	private boolean changed = true;

	private BindIndexBufferRecorder(BindIndexBuffer task, IObservatoryBuilder observatory)
	{
		this.task = task;
		observatory.explore(GraphicPackage.BIND_INDEX_BUFFER__BUFFER)
				   .adapt(IBufferAllocation.class)
				   .listenAdaptationNoParam(() -> changed = true);
	}

	@Override
	public void record(RecordContext context)
	{
		final var bufferRef = task.getBuffer();
		final var adapter = bufferRef.adapt(IBufferAllocation.class);
		final var indexPtr = adapter.getPtr();
		final var indexOffset = adapter.getBindOffset();
		final var indexType = task.getIndexType().getValue();
		final var commandBuffer = context.commandBuffer;

		vkCmdBindIndexBuffer(commandBuffer, indexPtr, indexOffset, indexType);

		changed = false;
	}

	@Override
	public boolean isRecordDirty(int index)
	{
		return changed;
	}
}
