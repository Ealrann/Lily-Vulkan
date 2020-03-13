package org.sheepy.lily.vulkan.process.graphic.pipeline.task;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.game.api.resource.buffer.IBufferAdapter;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.core.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.model.process.graphic.BindIndexBuffer;

import java.util.EnumSet;
import java.util.function.LongConsumer;

import static org.lwjgl.vulkan.VK10.vkCmdBindIndexBuffer;

@Statefull
@Adapter(scope = BindIndexBuffer.class)
public final class BindIndexBufferAdapter implements IPipelineTaskAdapter<BindIndexBuffer>
{
	private final LongConsumer bufferListener = this::bufferChanged;

	private boolean changed = true;

	@Load
	private void load(BindIndexBuffer bindBuffer)
	{
		final var bufferAdapter = bindBuffer.getBuffer().adapt(IBufferAdapter.class);
		bufferAdapter.listen(bufferListener, EnumSet.of(IBufferAdapter.Features.Ptr, IBufferAdapter.Features.Offset));
	}

	@Dispose
	private void dispose(BindIndexBuffer bindBuffer)
	{
		final var bufferAdapter = bindBuffer.getBuffer().adapt(IBufferAdapter.class);
		bufferAdapter.sulk(bufferListener, EnumSet.of(IBufferAdapter.Features.Ptr, IBufferAdapter.Features.Offset));
	}

	private void bufferChanged(Long ptr)
	{
		changed = true;
	}

	@Override
	public void record(BindIndexBuffer task, IRecordContext context)
	{
		final var bufferRef = task.getBuffer();
		final var adapter = bufferRef.adaptNotNull(IBufferAdapter.class);
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
