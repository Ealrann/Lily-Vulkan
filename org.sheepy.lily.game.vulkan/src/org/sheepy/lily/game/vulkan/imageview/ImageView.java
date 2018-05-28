package org.sheepy.lily.game.vulkan.imageview;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkImageViewCreateInfo;
import org.sheepy.lily.game.vulkan.device.LogicalDevice;

public class ImageView
{
	private LogicalDevice logicalDevice;
	private long imageId;
	
	private long imageViewId = -1;

	ImageView(LogicalDevice logicalDevice, long imageId, int format)
	{
		this.logicalDevice = logicalDevice;
		this.imageId = imageId;

		load(format);
	}

	private void load(int format)
	{
		VkImageViewCreateInfo createInfo = VkImageViewCreateInfo.calloc();
		createInfo.sType(VK_STRUCTURE_TYPE_IMAGE_VIEW_CREATE_INFO);
		createInfo.image(imageId);
		createInfo.viewType(VK_IMAGE_VIEW_TYPE_2D);
		createInfo.format(format);
		createInfo.components().r(VK_COMPONENT_SWIZZLE_IDENTITY);
		createInfo.components().g(VK_COMPONENT_SWIZZLE_IDENTITY);
		createInfo.components().b(VK_COMPONENT_SWIZZLE_IDENTITY);
		createInfo.components().a(VK_COMPONENT_SWIZZLE_IDENTITY);
        createInfo.subresourceRange().aspectMask(VK_IMAGE_ASPECT_COLOR_BIT);
        createInfo.subresourceRange().baseMipLevel(0);
        createInfo.subresourceRange().levelCount(1);
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
	
	public long getImageViewId()
	{
		return imageViewId;
	}

	public void free()
	{
		vkDestroyImageView(logicalDevice.getVkDevice(), imageViewId, null);
		imageViewId = -1;
	}
}
