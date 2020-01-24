package org.sheepy.lily.vulkan.common.barrier;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkImageMemoryBarrier;

public class VkImageBarriers implements VkBarriers<VkImageBarrier, VkImageMemoryBarrier.Buffer>
{
	private final List<VkBarrier<VkImageMemoryBarrier>> barriers;
	private final int srcQueueIndex;
	private final int dstQueueIndex;

	public VkImageBarriers(	int srcQueueIndex,
							int dstQueueIndex,
							List<VkBarrier<VkImageMemoryBarrier>> barriers)
	{
		this.srcQueueIndex = srcQueueIndex;
		this.dstQueueIndex = dstQueueIndex;
		this.barriers = List.copyOf(barriers);
	}

	@Override
	public VkImageMemoryBarrier.Buffer allocateInfo(MemoryStack stack)
	{
		final var res = VkImageMemoryBarrier.calloc(barriers.size());

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
