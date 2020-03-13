package org.sheepy.lily.vulkan.process.graphic.pipeline.task;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.game.api.resource.buffer.IBufferAdapter;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.core.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.model.process.graphic.BindVertexBuffer;

import java.util.EnumSet;
import java.util.function.LongConsumer;

import static org.lwjgl.vulkan.VK10.vkCmdBindVertexBuffers;

@Adapter(scope = BindVertexBuffer.class)
public class BindVertexBuferAdapter implements IPipelineTaskAdapter<BindVertexBuffer>
{
	private final LongConsumer bufferListener = this::bufferChanged;

	private boolean changed = true;

	@Load
	private void load(BindVertexBuffer bindBuffer)
	{
		final var bindings = bindBuffer.getVertexBindings();
		for (int i = 0; i < bindings.size(); i++)
		{
			final var binding = bindings.get(i);
			final var bufferAdapter = binding.getBuffer().adapt(IBufferAdapter.class);
			bufferAdapter.listen(bufferListener,
								 EnumSet.of(IBufferAdapter.Features.Ptr, IBufferAdapter.Features.Offset));
		}
	}

	@Dispose
	private void dispose(BindVertexBuffer bindBuffer)
	{
		final var bindings = bindBuffer.getVertexBindings();
		for (int i = 0; i < bindings.size(); i++)
		{
			final var binding = bindings.get(i);
			final var bufferAdapter = binding.getBuffer().adapt(IBufferAdapter.class);
			bufferAdapter.sulk(bufferListener, EnumSet.of(IBufferAdapter.Features.Ptr, IBufferAdapter.Features.Offset));
		}
	}

	private void bufferChanged(Long ptr)
	{
		changed = true;
	}

	@Override
	public void record(BindVertexBuffer task, IRecordContext context)
	{
		final int firstBinding = task.getFirstBinding();
		final var bindings = task.getVertexBindings();
		final int size = bindings.size();
		final var commandBuffer = ((RecordContext) context).commandBuffer;

		final long[] vertexBuffers = new long[size];
		final long[] offsets = new long[size];

		for (int i = 0; i < bindings.size(); i++)
		{
			final var binding = bindings.get(i);
			final var buffer = binding.getBuffer();
			final var adapter = buffer.adaptNotNull(IBufferAdapter.class);

			vertexBuffers[i] = adapter.getPtr();
			offsets[i] = adapter.getBindOffset();
		}

		vkCmdBindVertexBuffers(commandBuffer, firstBinding, vertexBuffers, offsets);
		changed = false;
	}

	@Override
	public boolean needRecord(BindVertexBuffer task, int index)
	{
		return changed;
	}
}
