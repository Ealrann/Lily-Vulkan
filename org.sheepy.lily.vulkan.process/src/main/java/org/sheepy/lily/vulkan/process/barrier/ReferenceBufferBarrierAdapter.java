package org.sheepy.lily.vulkan.process.barrier;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkBufferMemoryBarrier;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.vulkan.api.barrier.IBufferBarrierAdapter;
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.model.barrier.AbstractBufferBarrier;
import org.sheepy.vulkan.model.barrier.ReferenceBufferBarrier;
import org.sheepy.vulkan.util.VkModelUtil;

@Adapter(scope = ReferenceBufferBarrier.class)
public class ReferenceBufferBarrierAdapter implements IBufferBarrierAdapter
{
	@Override
	public void fillInfo(	IAllocationContext context,
							AbstractBufferBarrier barrier,
							VkBufferMemoryBarrier info,
							int swapIndex)
	{
		final var refBufferBarrier = (ReferenceBufferBarrier) barrier;

		final int srcAccessMask = VkModelUtil.getEnumeratedFlag(barrier.getSrcAccessMask());
		final int dstAccessMask = VkModelUtil.getEnumeratedFlag(barrier.getDstAccessMask());

		info.sType(VK_STRUCTURE_TYPE_BUFFER_MEMORY_BARRIER);
		info.buffer(refBufferBarrier.getBufferPtr());
		info.srcAccessMask(srcAccessMask);
		info.dstAccessMask(dstAccessMask);
		info.offset(0);
		info.size(VK_WHOLE_SIZE);
	}
}
