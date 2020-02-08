package org.sheepy.lily.vulkan.core.barrier;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkImageMemoryBarrier;

public class VkSwapImageBarrier implements VkBarrier<VkImageMemoryBarrier>
{
	private final int srcLayout;
	private final int dstLayout;
	private final int srcAccessMask;
	private final int dstAccessMask;

	private long imagePtr = 0;

	public VkSwapImageBarrier(int srcLayout, int dstLayout, int srcAccessMask, int dstAccessMask)
	{
		this.srcLayout = srcLayout;
		this.dstLayout = dstLayout;
		this.srcAccessMask = srcAccessMask;
		this.dstAccessMask = dstAccessMask;
	}

	public void updatePtr(long bufferPtr)
	{
		this.imagePtr = bufferPtr;
	}

	@Override
	public void fill(VkImageMemoryBarrier info)
	{
		info.sType(VK_STRUCTURE_TYPE_IMAGE_MEMORY_BARRIER);
		info.oldLayout(srcLayout);
		info.newLayout(dstLayout);
		info.image(imagePtr);
		info.subresourceRange().baseMipLevel(0);
		info.subresourceRange().levelCount(1);
		info.subresourceRange().baseArrayLayer(0);
		info.subresourceRange().layerCount(1);
		info.subresourceRange().aspectMask(VK_IMAGE_ASPECT_COLOR_BIT);
		info.srcAccessMask(srcAccessMask);
		info.dstAccessMask(dstAccessMask);
	}

	@Override
	public boolean hasChanged()
	{
		// will be updated every frame, but not need to record again
		return false;
	}
}
