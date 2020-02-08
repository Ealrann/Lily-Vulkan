package org.sheepy.lily.vulkan.core.barrier;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkBufferMemoryBarrier;

public class VkBufferBarriers implements VkBarriers<VkBufferBarrier, VkBufferMemoryBarrier.Buffer>
{
	private final List<VkBufferBarrier> barriers;
	private final int srcQueueIndex;
	private final int dstQueueIndex;

	public VkBufferBarriers(int srcQueueIndex, int dstQueueIndex, List<VkBufferBarrier> barriers)
	{
		this.srcQueueIndex = srcQueueIndex;
		this.dstQueueIndex = dstQueueIndex;
		this.barriers = List.copyOf(barriers);
	}

	@Override
	public VkBufferMemoryBarrier.Buffer allocateInfo(MemoryStack stack)
	{
		final var res = VkBufferMemoryBarrier.calloc(barriers.size());

		for (int i = 0; i < barriers.size(); i++)
		{
			final var bufferBarrier = barriers.get(i);
			final var info = res.get();

			bufferBarrier.fill(info);
			info.srcQueueFamilyIndex(srcQueueIndex);
			info.dstQueueFamilyIndex(dstQueueIndex);
		}
		res.flip();

		return res;
	}

	@Override
	public boolean hasChanged()
	{
		for (int i = 0; i < barriers.size(); i++)
		{
			final var barrier = barriers.get(i);
			if (barrier.hasChanged())
			{
				return true;
			}
		}
		return false;
	}
}
