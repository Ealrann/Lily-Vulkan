package org.sheepy.lily.vulkan.core.barrier;

import org.lwjgl.vulkan.VkImageMemoryBarrier;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_IMAGE_MEMORY_BARRIER;

public class VkImageBarrier implements VkBarrier<VkImageMemoryBarrier>
{
	private final int srcLayout;
	private final int dstLayout;
	private final int srcAccessMask;
	private final int dstAccessMask;
	private final int aspectMask;
	private final int mipLevels;

	private long imagePtr = 0;
	private boolean changed = true;

	public VkImageBarrier(int srcLayout,
						  int dstLayout,
						  int srcAccessMask,
						  int dstAccessMask,
						  int aspectMask,
						  int mipLevels)
	{
		this.srcLayout = srcLayout;
		this.dstLayout = dstLayout;
		this.srcAccessMask = srcAccessMask;
		this.dstAccessMask = dstAccessMask;
		this.aspectMask = aspectMask;
		this.mipLevels = mipLevels;
	}

	public void updatePtr(long bufferPtr)
	{
		this.imagePtr = bufferPtr;
		changed = true;
	}

	@Override
	public void fill(VkImageMemoryBarrier info)
	{
		info.sType(VK_STRUCTURE_TYPE_IMAGE_MEMORY_BARRIER);
		info.oldLayout(srcLayout);
		info.newLayout(dstLayout);
		info.image(imagePtr);
		info.subresourceRange().baseMipLevel(0);
		info.subresourceRange().levelCount(mipLevels);
		info.subresourceRange().baseArrayLayer(0);
		info.subresourceRange().layerCount(1);
		info.subresourceRange().aspectMask(aspectMask);
		info.srcAccessMask(srcAccessMask);
		info.dstAccessMask(dstAccessMask);

		changed = false;
	}

	@Override
	public boolean hasChanged()
	{
		return changed;
	}
}
