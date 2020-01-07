package org.sheepy.vulkan.barrier;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkBufferMemoryBarrier;

public class VkBufferBarrier implements VkBarrier<VkBufferMemoryBarrier>
{
	private final int srcAccessMask;
	private final int dstAccessMask;

	private long bufferPtr = 0;
	private boolean changed = true;

	public VkBufferBarrier(int srcAccessMask, int dstAccessMask)
	{
		this.srcAccessMask = srcAccessMask;
		this.dstAccessMask = dstAccessMask;
	}

	public void updatePtr(long bufferPtr)
	{
		this.bufferPtr = bufferPtr;
		changed = true;
	}

	@Override
	public void fill(VkBufferMemoryBarrier info)
	{
		info.sType(VK_STRUCTURE_TYPE_BUFFER_MEMORY_BARRIER);
		info.buffer(bufferPtr);
		info.srcAccessMask(srcAccessMask);
		info.dstAccessMask(dstAccessMask);
		info.offset(0);
		info.size(VK_WHOLE_SIZE);

		changed = false;
	}

	@Override
	public boolean hasChanged()
	{
		return changed;
	}
}
