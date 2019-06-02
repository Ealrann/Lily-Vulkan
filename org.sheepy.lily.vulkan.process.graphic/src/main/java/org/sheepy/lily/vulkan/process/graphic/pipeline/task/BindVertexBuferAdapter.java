package org.sheepy.lily.vulkan.process.graphic.pipeline.task;

import static org.lwjgl.vulkan.VK10.vkCmdBindVertexBuffers;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.vulkan.api.execution.IRecordable.RecordContext;
import org.sheepy.lily.vulkan.api.pipeline.IPipelineTaskAdapter;
import org.sheepy.lily.vulkan.api.resource.IBufferAdapter;
import org.sheepy.lily.vulkan.model.process.graphic.BindVertexBuffer;

@Adapter(scope = BindVertexBuffer.class)
public class BindVertexBuferAdapter implements IPipelineTaskAdapter<BindVertexBuffer>
{
	@Override
	public void record(	BindVertexBuffer task,
	                   	RecordContext context)
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
			final var bufferAdapter = IBufferAdapter.adapt(buffer);

			vertexBuffers[i] = bufferAdapter.getPtr();
			offsets[i] = binding.getOffset();
		}

		vkCmdBindVertexBuffers(context.commandBuffer, firstBinding, vertexBuffers, offsets);
	}
}
