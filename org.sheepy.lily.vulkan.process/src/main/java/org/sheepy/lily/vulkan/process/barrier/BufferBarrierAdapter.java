package org.sheepy.lily.vulkan.process.barrier;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkBufferMemoryBarrier;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.vulkan.api.barrier.IBufferBarrierAdapter;
import org.sheepy.lily.vulkan.model.resource.BufferBarrier;
import org.sheepy.lily.vulkan.resource.buffer.BufferAdapter;
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.model.barrier.AbstractBufferBarrier;
import org.sheepy.vulkan.util.VkModelUtil;

@Adapter(scope = BufferBarrier.class)
public class BufferBarrierAdapter implements IBufferBarrierAdapter
{
	@Override
	public void fillInfo(	IAllocationContext context,
							AbstractBufferBarrier barrier,
							VkBufferMemoryBarrier info,
							int swapIndex)
	{
		final var bufferBarrier = (BufferBarrier) barrier;
		final var buffer = bufferBarrier.getBuffer();
		final var bufferAdapter = BufferAdapter.adapt(buffer);

		final int srcAccessMask = VkModelUtil.getEnumeratedFlag(barrier.getSrcAccessMask());
		final int dstAccessMask = VkModelUtil.getEnumeratedFlag(barrier.getDstAccessMask());

		info.sType(VK_STRUCTURE_TYPE_BUFFER_MEMORY_BARRIER);
		info.buffer(bufferAdapter.getAddress());
		info.srcAccessMask(srcAccessMask);
		info.dstAccessMask(dstAccessMask);
		info.offset(0);
		info.size(VK_WHOLE_SIZE);
	}
}
