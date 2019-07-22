package org.sheepy.vulkan.resource.image;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkImageViewCreateInfo;
import org.sheepy.vulkan.log.Logger;

public class VkImageView
{
	private final VkDevice device;

	private long imagePtr;
	private int imageFormat;

	private long imageViewPtr = -1;

	public static VkImageView alloc(VkDevice device, long imageAddress, int format, int aspectMask)
	{
		final VkImageView res = new VkImageView(device);
		res.allocate(imageAddress, 1, format, aspectMask);
		return res;
	}

	public VkImageView(VkDevice device)
	{
		this.device = device;
	}

	public void allocate(long imageAddress, int levelCount, int format, int aspectMask)
	{
		this.imagePtr = imageAddress;
		this.imageFormat = format;

		final VkImageViewCreateInfo createInfo = VkImageViewCreateInfo.calloc();
		createInfo.sType(VK_STRUCTURE_TYPE_IMAGE_VIEW_CREATE_INFO);
		createInfo.image(imageAddress);
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
		Logger.check("Failed to create image views!", () -> vkCreateImageView(device, createInfo, null, aBuffer));
		imageViewPtr = aBuffer[0];

		createInfo.free();
	}

	public void free()
	{
		vkDestroyImageView(device, imageViewPtr, null);
		imageViewPtr = -1;
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
