package org.sheepy.vulkan.resource.image;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkImageViewCreateInfo;
import org.sheepy.vulkan.common.util.Logger;

public class ImageView
{
	private final VkDevice device;
	private long imageId;
	private int imageFormat;

	private long imageViewId = -1;

	public static ImageView alloc(	VkDevice device,
									long imageId,
									int format,
									int aspectMask)
	{
		ImageView res = new ImageView(device);
		res.load(imageId, 1, format, aspectMask);
		return res;
	}

	public ImageView(VkDevice device)
	{
		this.device = device;
	}

	public void load(long imageId, int levelCount, int format, int aspectMask)
	{
		this.imageId = imageId;
		this.imageFormat = format;

		VkImageViewCreateInfo createInfo = VkImageViewCreateInfo.calloc();
		createInfo.sType(VK_STRUCTURE_TYPE_IMAGE_VIEW_CREATE_INFO);
		createInfo.image(imageId);
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

		long[] aBuffer = new long[1];
		Logger.check("Failed to create image views!",
				() -> vkCreateImageView(device, createInfo, null, aBuffer));
		imageViewId = aBuffer[0];

		createInfo.free();
	}

	public long getId()
	{
		return imageViewId;
	}

	public void free()
	{
		vkDestroyImageView(device, imageViewId, null);
		imageViewId = -1;
	}

	public long getImageId()
	{
		return imageId;
	}

	public int getImageFormat()
	{
		return imageFormat;
	}
}
