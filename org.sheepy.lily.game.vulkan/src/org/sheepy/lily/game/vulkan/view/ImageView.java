package org.sheepy.lily.game.vulkan.view;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkImageViewCreateInfo;
import org.sheepy.lily.game.vulkan.buffer.Image;
import org.sheepy.lily.game.vulkan.device.LogicalDevice;

public class ImageView
{
	private LogicalDevice logicalDevice;
	private long imageId;
	private int imageFormat;

	private long imageViewId = -1;

	public static ImageView alloc(LogicalDevice logicalDevice,
			long imageId,
			int format,
			int aspectMask)
	{
		ImageView res = new ImageView(logicalDevice);
		res.load(imageId, 1, format, aspectMask);
		return res;
	}

	public ImageView(LogicalDevice logicalDevice)
	{
		this.logicalDevice = logicalDevice;
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
		if (vkCreateImageView(logicalDevice.getVkDevice(), createInfo, null, aBuffer) != VK_SUCCESS)
		{
			throw new AssertionError("failed to create image views!");
		}
		imageViewId = aBuffer[0];

		createInfo.free();
	}

	public void transitionImageLayout(VkCommandBuffer commandBuffer, int oldLayout, int newLayout)
	{
		Image.transitionImageLayout(commandBuffer, imageId, imageFormat, oldLayout, newLayout);
	}

	public void transitionImageLayout(VkCommandBuffer commandBuffer,
			int oldLayout,
			int newLayout,
			int mipLevels)
	{
		Image.transitionImageLayout(commandBuffer, imageId, imageFormat, oldLayout, newLayout,
				mipLevels);
	}

	public void transitionImageLayout(VkCommandBuffer commandBuffer,
			int oldLayout,
			int newLayout,
			int mipLevels,
			int srcStage,
			int dstStage,
			int srcAccessMask,
			int dstAccessMask)
	{
		Image.transitionImageLayout(commandBuffer, imageId, imageFormat, oldLayout, newLayout,
				mipLevels, srcStage, dstStage, srcAccessMask, dstAccessMask);
	}

	public long getId()
	{
		return imageViewId;
	}

	public void free()
	{
		vkDestroyImageView(logicalDevice.getVkDevice(), imageViewId, null);
		imageViewId = -1;
	}

	public long getImageId()
	{
		return imageId;
	}
}
