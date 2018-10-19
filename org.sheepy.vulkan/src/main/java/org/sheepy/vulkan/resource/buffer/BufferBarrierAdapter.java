package org.sheepy.vulkan.resource.buffer;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkBufferMemoryBarrier;
import org.sheepy.vulkan.execution.AbstractCommandBuffer;
import org.sheepy.vulkan.model.process.BufferBarrier;
import org.sheepy.vulkan.pipeline.PipelineBarrierAdapter;

public class BufferBarrierAdapter extends PipelineBarrierAdapter
{
	private VkBufferMemoryBarrier.Buffer barrierInfo;

	@Override
	public void deepAllocate(MemoryStack stack)
	{
		final var barrier = (BufferBarrier) target;
		final var buffer = barrier.getBuffer();
		final var bufferAdapter = BufferAdapter.adapt(buffer);

		barrierInfo = VkBufferMemoryBarrier.calloc(1);
		barrierInfo.sType(VK_STRUCTURE_TYPE_BUFFER_MEMORY_BARRIER);
		barrierInfo.buffer(bufferAdapter.getId());
		barrierInfo.srcAccessMask(barrier.getSrcAccess());
		barrierInfo.dstAccessMask(barrier.getDstAccess());
		barrierInfo.offset(0);
		barrierInfo.size(VK_WHOLE_SIZE);
	}

	@Override
	public void free()
	{
		barrierInfo.free();
	}

	@Override
	public void record(AbstractCommandBuffer commandBuffer, int bindPoint)
	{
		final var barrier = (BufferBarrier) target;

		vkCmdPipelineBarrier(commandBuffer.getVkCommandBuffer(), barrier.getSrcStage().getValue(),
				barrier.getDstStage().getValue(), 0, null, barrierInfo, null);
	}

	@Override
	public boolean isDirty()
	{
		return false;
	}
}
