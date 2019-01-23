package org.sheepy.lily.vulkan.resource.nativehelper;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkImageCreateInfo;
import org.sheepy.lily.vulkan.common.util.Logger;
import org.sheepy.lily.vulkan.resource.image.ImageInfo;

public class VkImageAllocator
{
	public static long allocate(MemoryStack stack, VkDevice device, ImageInfo info)
	{
		return create(stack, device, info);
	}

	private static VkImageCreateInfo allocateInfo(MemoryStack stack, ImageInfo info)
	{
		final VkImageCreateInfo imageInfo = VkImageCreateInfo.callocStack(stack);

		imageInfo.sType(VK_STRUCTURE_TYPE_IMAGE_CREATE_INFO);
		imageInfo.imageType(VK_IMAGE_TYPE_2D);
		imageInfo.extent().width(info.width);
		imageInfo.extent().height(info.height);
		imageInfo.extent().depth(1);
		imageInfo.mipLevels(info.mipLevels);
		imageInfo.arrayLayers(1);
		imageInfo.format(info.format);
		imageInfo.tiling(info.tiling);
		imageInfo.initialLayout(VK_IMAGE_LAYOUT_UNDEFINED);
		imageInfo.usage(info.usage);
		imageInfo.sharingMode(VK_SHARING_MODE_EXCLUSIVE);
		imageInfo.samples(VK_SAMPLE_COUNT_1_BIT);
		imageInfo.flags(0); // Optional

		return imageInfo;
	}

	private static long create(MemoryStack stack, VkDevice device, ImageInfo info)
			throws AssertionError
	{
		final VkImageCreateInfo imageInfo = VkImageAllocator.allocateInfo(stack, info);
		final long[] aImageId = new long[1];
		Logger.check("Failed to create image!",
				() -> vkCreateImage(device, imageInfo, null, aImageId));
		return aImageId[0];
	}
}
