package org.sheepy.lily.vulkan.process.graphic.pipeline.task;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Observe;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.game.api.resource.buffer.IBufferAdapter;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.core.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.model.process.graphic.BindVertexBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;

import static org.lwjgl.vulkan.VK10.vkCmdBindVertexBuffers;

@Adapter(scope = BindVertexBuffer.class)
public class BindVertexBuferAdapter implements IPipelineTaskAdapter<BindVertexBuffer>
{
	private boolean changed = true;

	@Observe
	private void observe(IObservatoryBuilder observatory)
	{
		observatory.explore(GraphicPackage.Literals.BIND_VERTEX_BUFFER__VERTEX_BINDINGS)
				   .explore(GraphicPackage.Literals.VERTEX_BINDING__BUFFER)
				   .adaptNotifier(IBufferAdapter.class)
				   .listenNoParam(() -> changed = true, IBufferAdapter.Features.Ptr)
				   .listenNoParam(() -> changed = true, IBufferAdapter.Features.Offset);
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
