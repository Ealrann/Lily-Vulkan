package org.sheepy.lily.vulkan.core.resource.image;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkImageViewCreateInfo;
import org.sheepy.lily.vulkan.core.util.Logger;

public final class VkImageView
{
	private static final String FAILED_TO_CREATE_IMAGE_VIEW = "Failed to create image view";

	private final int aspectMask;

	private int imageFormat;
	private long imagePtr = 0;
	private long imageViewPtr = 0;

	public static VkImageView alloc(VkDevice device, long imageAddress, int format, int aspectMask)
	{
		final VkImageView res = new VkImageView(aspectMask);
		res.allocate(device, imageAddress, 1, format);
		return res;
	}

	public VkImageView(int aspectMask)
	{
		this.aspectMask = aspectMask;
	}

	public void allocate(VkDevice device, VkImage image)
	{
		allocate(device, image.imagePtr, image.mipLevels, image.format);
	}

	public void allocate(VkDevice device, long imagePtr, int levelCount, int format)
	{
		this.imagePtr = imagePtr;
		this.imageFormat = format;

		final VkImageViewCreateInfo createInfo = VkImageViewCreateInfo.calloc();
		createInfo.sType(VK_STRUCTURE_TYPE_IMAGE_VIEW_CREATE_INFO);
		createInfo.image(imagePtr);
		createInfo.viewType(VK_IMAGE_VIEW_TYPE_2D);
		createInfo.format(format);
		createInfo.components().r(VK_COMPONENT_SWIZZLE_IDENTITY);
		createInfo.components().g(VK_COMPONENT_SWIZZLE_IDENTITY);
		createInfo.components().b(VK_COMPONENT_SWIZZLE_IDENTITY);
		createInfo.components().a(VK_COMPONENT_SWIZZLE_IDENTITY);
		createInfo.subresourceRange().aspectMask(aspectMask);
		createInfo.subresourceRange().baseMipLevel(0);
		createInfo.subresourceRange().levelCount(levelCount);
		createInfo.subresourceRange().baseArrayLayer(0);
		createInfo.subresourceRange().layerCount(1);

		final long[] aBuffer = new long[1];
		Logger.check(	vkCreateImageView(device, createInfo, null, aBuffer),
						FAILED_TO_CREATE_IMAGE_VIEW);
		imageViewPtr = aBuffer[0];

		createInfo.free();
	}

	public void free(VkDevice device)
	{
		vkDestroyImageView(device, imageViewPtr, null);
		imageViewPtr = 0;
	}

	public long getPtr()
	{
		return imageViewPtr;
	}

	public long getImagePtr()
	{
		return imagePtr;
	}

	public int getImageFormat()
	{
		return imageFormat;
	}
}
