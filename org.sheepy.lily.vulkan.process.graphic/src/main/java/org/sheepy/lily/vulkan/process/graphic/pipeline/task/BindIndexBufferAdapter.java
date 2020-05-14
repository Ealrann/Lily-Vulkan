package org.sheepy.lily.vulkan.process.graphic.pipeline.task;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.game.api.resource.buffer.IBufferAllocation;
import org.sheepy.lily.vulkan.api.execution.IRecordContext;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.core.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.model.process.graphic.BindIndexBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;

import static org.lwjgl.vulkan.VK10.vkCmdBindIndexBuffer;

@ModelExtender(scope = BindIndexBuffer.class)
@Adapter
public final class BindIndexBufferAdapter implements IPipelineTaskAdapter<BindIndexBuffer>
{
	private boolean changed = true;

	private BindIndexBufferAdapter(IObservatoryBuilder observatory)
	{
		observatory.explore(GraphicPackage.Literals.BIND_INDEX_BUFFER__BUFFER)
				   .allocation(IBufferAllocation.class)
				   .listenNoParam(() -> changed = true);
	}

	@Override
	public void record(BindIndexBuffer task, IRecordContext context)
	{
		final var bufferRef = task.getBuffer();
		final var adapter = bufferRef.allocationHandle(IBufferAllocation.class).get();
		final var indexPtr = adapter.getPtr();
		final var indexOffset = adapter.getBindOffset();
		final var indexType = task.getIndexType().getValue();
		final var commandBuffer = ((RecordContext) context).commandBuffer;

		vkCmdBindIndexBuffer(commandBuffer, indexPtr, indexOffset, indexType);

		changed = false;
	}

	@Override
	public boolean needRecord(BindIndexBuffer task, int index)
	{
		return changed;
	}
}
