package org.sheepy.lily.vulkan.process.graphic.pipeline.task;

import static org.lwjgl.vulkan.VK10.vkCmdBindVertexBuffers;

import org.eclipse.emf.common.notify.Notification;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.notification.INotificationListener;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.api.resource.buffer.IBufferAdapter;
import org.sheepy.lily.vulkan.model.process.graphic.BindVertexBuffer;
import org.sheepy.vulkan.execution.IRecordable.RecordContext;

@Adapter(scope = BindVertexBuffer.class)
public class BindVertexBuferAdapter implements IPipelineTaskAdapter<BindVertexBuffer>
{
	private final INotificationListener bufferListener = this::bufferChanged;

	private boolean changed = true;

	@Load
	private void load(BindVertexBuffer bindBuffer)
	{
		final var bindings = bindBuffer.getVertexBindings();
		for (int i = 0; i < bindings.size(); i++)
		{
			final var binding = bindings.get(i);
			final var bufferAdapter = binding.getBuffer().adapt(IBufferAdapter.class);
			bufferAdapter.addListener(	bufferListener,
										IBufferAdapter.Features.Ptr.ordinal(),
										IBufferAdapter.Features.Offset.ordinal());
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
			bufferAdapter.removeListener(	bufferListener,
											IBufferAdapter.Features.Ptr.ordinal(),
											IBufferAdapter.Features.Offset.ordinal());
		}
	}

	private void bufferChanged(Notification notification)
	{
		changed = true;
	}

	@Override
	public void record(BindVertexBuffer task, RecordContext context)
	{
		final int firstBinding = task.getFirstBinding();
		final var bindings = task.getVertexBindings();
		final int size = bindings.size();

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

		vkCmdBindVertexBuffers(context.commandBuffer, firstBinding, vertexBuffers, offsets);
	}

	@Override
	public boolean needRecord(BindVertexBuffer task, int index)
	{
		return changed;
	}
}
