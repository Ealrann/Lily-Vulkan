package org.sheepy.lily.vulkan.process.graphic.pipeline.task;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.game.api.resource.buffer.IBufferAllocation;
import org.sheepy.lily.vulkan.core.pipeline.IRecordableExtender;
import org.sheepy.lily.vulkan.model.process.graphic.BindVertexBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;

import java.util.List;

import static org.lwjgl.vulkan.VK10.vkCmdBindVertexBuffers;

@ModelExtender(scope = BindVertexBuffer.class)
@Allocation
@AllocationDependency(features = {GraphicPackage.BIND_VERTEX_BUFFER__VERTEX_BINDINGS, GraphicPackage.VERTEX_BINDING__BUFFER}, type = IBufferAllocation.class)
public final class BindVertexBuferRecorder implements IRecordableExtender
{
	private final BindVertexBuffer task;
	private final long[] vertexBuffers;
	private final long[] offsets;

	private BindVertexBuferRecorder(BindVertexBuffer task, @InjectDependency(index = 0) List<IBufferAllocation> buffers)
	{
		this.task = task;

		final int size = buffers.size();
		vertexBuffers = new long[size];
		offsets = new long[size];

		for (int i = 0; i < buffers.size(); i++)
		{
			final var buffer = buffers.get(i);

			vertexBuffers[i] = buffer.getPtr();
			offsets[i] = buffer.getBindOffset();
		}
	}

	@Override
	public void record(RecordContext context)
	{
		final var commandBuffer = context.commandBuffer;
		final int firstBinding = task.getFirstBinding();

		vkCmdBindVertexBuffers(commandBuffer, firstBinding, vertexBuffers, offsets);
	}
}
