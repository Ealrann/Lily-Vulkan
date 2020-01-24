package org.sheepy.lily.vulkan.common.barrier;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_BUFFER_MEMORY_BARRIER;

import org.lwjgl.vulkan.VkBufferMemoryBarrier;

public class VkBufferBarrier implements VkBarrier<VkBufferMemoryBarrier>
{
	private final int srcAccessMask;
	private final int dstAccessMask;

	private long bufferPtr = 0;
	private long offset = 0;
	private long size = 0;
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

	public void updateOffset(long offset)
	{
		this.offset = offset;
		changed = true;
	}

	public void updateSize(long size)
	{
		this.size = size;
		changed = true;
	}

	@Override
	public void fill(VkBufferMemoryBarrier info)
	{
		info.sType(VK_STRUCTURE_TYPE_BUFFER_MEMORY_BARRIER);
		info.buffer(bufferPtr);
		info.srcAccessMask(srcAccessMask);
		info.dstAccessMask(dstAccessMask);
		info.offset(offset);
		info.size(size);

		changed = false;
	}

	@Override
	public boolean hasChanged()
	{
		return changed;
	}
}
