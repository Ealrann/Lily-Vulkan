package org.sheepy.vulkan.nativehelper;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkImageCreateInfo;
import org.sheepy.vulkan.resource.image.ImageInfo;
import org.sheepy.vulkan.util.Logger;

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
		imageInfo.extent().width(info.getWidth());
		imageInfo.extent().height(info.getHeight());
		imageInfo.extent().depth(1);
		imageInfo.mipLevels(info.getMipLevels());
		imageInfo.arrayLayers(1);
		imageInfo.format(info.getFormat());
		imageInfo.tiling(info.getTiling());
		imageInfo.initialLayout(VK_IMAGE_LAYOUT_UNDEFINED);
		imageInfo.usage(info.getUsage());
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