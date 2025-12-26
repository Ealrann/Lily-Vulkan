package org.sheepy.lily.vulkan.core.resource.image;

import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkImageViewCreateInfo;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.api.debug.IVulkanDebugService;
import org.sheepy.lily.vulkan.core.util.Logger;

import static org.lwjgl.vulkan.VK10.*;

public final class VkImageView
{
	private static final String FAILED_TO_CREATE_IMAGE_VIEW = "Failed to create image view";
	public static final String VIEW_PREFIX = "[View]";

	private final long imagePtr;
	private final long imageViewPtr;

	public VkImageView(VkDevice device, String name, VkImage image, int aspectMask)
	{
		this(device, name, image.ptr(), image.mipLevels(), image.format(), aspectMask);
	}

	public VkImageView(VkDevice device, String name, long imagePtr, int levelCount, int format, int aspectMask)
	{
		this.imagePtr = imagePtr;

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
		Logger.check(vkCreateImageView(device, createInfo, null, aBuffer), FAILED_TO_CREATE_IMAGE_VIEW);
		imageViewPtr = aBuffer[0];

		if (DebugUtil.DEBUG_ENABLED) IVulkanDebugService.INSTANCE.register(imageViewPtr, VIEW_PREFIX + name);
		createInfo.free();
	}

	public void free(VkDevice device)
	{
		vkDestroyImageView(device, imageViewPtr, null);
		if (DebugUtil.DEBUG_ENABLED) IVulkanDebugService.INSTANCE.remove(imageViewPtr);
	}

	public long getPtr()
	{
		return imageViewPtr;
	}

	public long getImagePtr()
	{
		return imagePtr;
	}
}
