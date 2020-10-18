package org.sheepy.lily.vulkan.core.resource.image;

import org.lwjgl.vulkan.VK10;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.api.debug.IVulkanDebugService;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.image.ImageInfo;

import static org.lwjgl.vulkan.VK10.vkDestroyImage;

public record VkImage
		(long imagePtr,
		 int width,
		 int height,
		 int format,
		 int usage,
		 int properties,
		 int tiling,
		 int mipLevels,
		 EImageLayout initialLayout,
		 int aspect)
{
	public static VkImageBuilder newBuilder(String name, int width, int height, int format)
	{
		return new VkImageBuilder(name, width, height, format);
	}

	public static VkImageBuilder newBuilder(String name, ImageInfo info, int width, int height)
	{
		return new VkImageBuilder(name, info, width, height);
	}

	VkImage(long imagePtr,
			int width,
			int height,
			int format,
			int usage,
			int tiling,
			int mipLevels,
			EImageLayout initialLayout,
			int aspect)
	{
		this(imagePtr,
			 width,
			 height,
			 format,
			 usage,
			 VK10.VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT,
			 tiling,
			 mipLevels,
			 initialLayout,
			 aspect);
	}

	public void free(ExecutionContext context)
	{
		final var logicalDevice = context.getLogicalDevice();
		vkDestroyImage(logicalDevice.getVkDevice(), imagePtr, null);
		if (DebugUtil.DEBUG_ENABLED) IVulkanDebugService.INSTANCE.remove(imagePtr);
	}

	public long getPtr()
	{
		return imagePtr;
	}
}
