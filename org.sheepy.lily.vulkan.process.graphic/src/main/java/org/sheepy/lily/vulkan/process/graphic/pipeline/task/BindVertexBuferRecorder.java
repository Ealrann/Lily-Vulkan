package org.sheepy.lily.vulkan.process.graphic.pipeline.task;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.game.api.resource.buffer.IBufferAllocation;
import org.sheepy.lily.vulkan.core.pipeline.IPipelineTaskRecorder;
import org.sheepy.lily.vulkan.model.process.graphic.BindVertexBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;

import static org.lwjgl.vulkan.VK10.vkCmdBindVertexBuffers;

@ModelExtender(scope = BindVertexBuffer.class)
@Adapter
public final class BindVertexBuferRecorder implements IPipelineTaskRecorder
{
	private final BindVertexBuffer task;
	private boolean changed = true;

	private BindVertexBuferRecorder(BindVertexBuffer task, IObservatoryBuilder observatory)
	{
		this.task = task;
		observatory.explore(GraphicPackage.BIND_VERTEX_BUFFER__VERTEX_BINDINGS)
				   .explore(GraphicPackage.VERTEX_BINDING__BUFFER)
				   .adapt(IBufferAllocation.class)
				   .listenAdaptationNoParam(() -> changed = true);
	}

	@Override
	public void record(RecordContext context)
	{
		final int firstBinding = task.getFirstBinding();
		final var bindings = task.getVertexBindings();
		final int size = bindings.size();
		final var commandBuffer = context.commandBuffer;

		final long[] vertexBuffers = new long[size];
		final long[] offsets = new long[size];

		for (int i = 0; i < bindings.size(); i++)
		{
			final var binding = bindings.get(i);
			final var buffer = binding.getBuffer();
			final var allocation = buffer.adapt(IBufferAllocation.class);

			vertexBuffers[i] = allocation.getPtr();
			offsets[i] = allocation.getBindOffset();
		}

		vkCmdBindVertexBuffers(commandBuffer, firstBinding, vertexBuffers, offsets);
		changed = false;
	}

	@Override
	public boolean isRecordDirty(int index)
	{
		return changed;
	}
}
