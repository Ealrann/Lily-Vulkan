package org.sheepy.vulkan.buffer;

import static org.lwjgl.vulkan.KHRSwapchain.VK_IMAGE_LAYOUT_PRESENT_SRC_KHR;
import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkBufferImageCopy;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkImageCreateInfo;
import org.lwjgl.vulkan.VkImageMemoryBarrier;
import org.lwjgl.vulkan.VkMemoryAllocateInfo;
import org.lwjgl.vulkan.VkMemoryRequirements;
import org.sheepy.vulkan.device.LogicalDevice;

public class Image
{
	private LogicalDevice logicalDevice;

	private int width;
	private int height;
	private int format;

	private long size;
	protected long imageId;
	protected long imageMemoryId;

	public static Image alloc(LogicalDevice logicalDevice,
			int width,
			int height,
			int format,
			int tiling,
			int usage,
			int properties)
	{
		Image res = new Image(logicalDevice);
		res.createImage(width, height, 1, format, tiling, usage, properties);
		return res;
	}

	public Image(LogicalDevice logicalDevice)
	{
		this.logicalDevice = logicalDevice;
	}

	public void createImage(int width,
			int height,
			int mipLevels,
			int format,
			int tiling,
			int usage,
			int properties)
	{
		this.width = width;
		this.height = height;
		this.format = format;

		VkImageCreateInfo imageInfo = VkImageCreateInfo.calloc();
		imageInfo.sType(VK_STRUCTURE_TYPE_IMAGE_CREATE_INFO);
		imageInfo.imageType(VK_IMAGE_TYPE_2D);
		imageInfo.extent().width(width);
		imageInfo.extent().height(height);
		imageInfo.extent().depth(1);
		imageInfo.mipLevels(mipLevels);
		imageInfo.arrayLayers(1);
		imageInfo.format(format);
		imageInfo.tiling(tiling);
		imageInfo.initialLayout(VK_IMAGE_LAYOUT_UNDEFINED);
		imageInfo.usage(usage);
		imageInfo.sharingMode(VK_SHARING_MODE_EXCLUSIVE);
		imageInfo.samples(VK_SAMPLE_COUNT_1_BIT);
		imageInfo.flags(0); // Optional

		long[] aImageId = new long[1];
		if (vkCreateImage(logicalDevice.getVkDevice(), imageInfo, null, aImageId) != VK_SUCCESS)
		{
			throw new AssertionError("failed to create image!");
		}
		imageId = aImageId[0];

		VkMemoryRequirements memRequirements = VkMemoryRequirements.calloc();
		vkGetImageMemoryRequirements(logicalDevice.getVkDevice(), imageId, memRequirements);

		this.size = memRequirements.size();
		VkMemoryAllocateInfo allocInfo = VkMemoryAllocateInfo.calloc();
		allocInfo.sType(VK_STRUCTURE_TYPE_MEMORY_ALLOCATE_INFO);
		allocInfo.allocationSize(memRequirements.size());
		allocInfo.memoryTypeIndex(logicalDevice.getPhysicalDevice()
				.findMemoryType(memRequirements.memoryTypeBits(), properties));

		long[] aImageMemoryId = new long[1];
		if (vkAllocateMemory(logicalDevice.getVkDevice(), allocInfo, null,
				aImageMemoryId) != VK_SUCCESS)
		{
			throw new AssertionError("failed to allocate image memory!");
		}
		imageMemoryId = aImageMemoryId[0];

		vkBindImageMemory(logicalDevice.getVkDevice(), imageId, imageMemoryId, 0);

		imageInfo.free();
		allocInfo.free();
	}

	public void fillWithBuffer(VkCommandBuffer commandBuffer, Buffer buffer)
	{
		VkBufferImageCopy.Buffer region = VkBufferImageCopy.calloc(1);
		region.bufferOffset(0);
		region.bufferRowLength(0);
		region.bufferImageHeight(0);

		region.imageSubresource().aspectMask(VK_IMAGE_ASPECT_COLOR_BIT);
		region.imageSubresource().mipLevel(0);
		region.imageSubresource().baseArrayLayer(0);
		region.imageSubresource().layerCount(1);

		region.imageOffset().set(0, 0, 0);
		region.imageExtent().set(width, height, 1);

		vkCmdCopyBufferToImage(commandBuffer, buffer.getId(), imageId,
				VK_IMAGE_LAYOUT_TRANSFER_DST_OPTIMAL, region);
	}

	public void transitionImageLayout(VkCommandBuffer commandBuffer, int oldLayout, int newLayout)
	{
		Image.transitionImageLayout(commandBuffer, imageId, format, oldLayout, newLayout);
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
		Image.transitionImageLayout(commandBuffer, imageId, format, oldLayout, newLayout, mipLevels, srcStage, dstStage, srcAccessMask, dstAccessMask);
	}

	public static void transitionImageLayout(VkCommandBuffer commandBuffer,
			long imageId,
			int imageFormat,
			int oldLayout,
			int newLayout)
	{
		transitionImageLayout(commandBuffer, imageId, imageFormat, oldLayout, newLayout, 1);
	}

	public static void transitionImageLayout(VkCommandBuffer commandBuffer,
			long imageId,
			int imageFormat,
			int oldLayout,
			int newLayout,
			int mipLevels)
	{
		int srcStage;
		int dstStage;
		int srcAccessMask;
		int dstAccessMask;

		if (oldLayout == VK_IMAGE_LAYOUT_UNDEFINED
				&& newLayout == VK_IMAGE_LAYOUT_TRANSFER_DST_OPTIMAL)
		{
			srcAccessMask = 0;
			dstAccessMask = VK_ACCESS_TRANSFER_WRITE_BIT;

			srcStage = VK_PIPELINE_STAGE_TOP_OF_PIPE_BIT;
			dstStage = VK_PIPELINE_STAGE_TRANSFER_BIT;
		}
		else if (oldLayout == VK_IMAGE_LAYOUT_TRANSFER_DST_OPTIMAL
				&& newLayout == VK_IMAGE_LAYOUT_SHADER_READ_ONLY_OPTIMAL)
		{
			srcAccessMask = VK_ACCESS_TRANSFER_WRITE_BIT;
			dstAccessMask = VK_ACCESS_SHADER_READ_BIT;

			srcStage = VK_PIPELINE_STAGE_TRANSFER_BIT;
			dstStage = VK_PIPELINE_STAGE_FRAGMENT_SHADER_BIT;
		}
		else if (oldLayout == VK_IMAGE_LAYOUT_UNDEFINED
				&& newLayout == VK_IMAGE_LAYOUT_DEPTH_STENCIL_ATTACHMENT_OPTIMAL)
		{
			srcAccessMask = 0;
			dstAccessMask = VK_ACCESS_DEPTH_STENCIL_ATTACHMENT_READ_BIT
					| VK_ACCESS_DEPTH_STENCIL_ATTACHMENT_WRITE_BIT;

			srcStage = VK_PIPELINE_STAGE_TOP_OF_PIPE_BIT;
			dstStage = VK_PIPELINE_STAGE_EARLY_FRAGMENT_TESTS_BIT;
		}
		else if (oldLayout == VK_IMAGE_LAYOUT_TRANSFER_DST_OPTIMAL
				&& newLayout == VK_IMAGE_LAYOUT_PRESENT_SRC_KHR)
		{
			srcAccessMask = VK_ACCESS_TRANSFER_WRITE_BIT;
			dstAccessMask = VK_ACCESS_COLOR_ATTACHMENT_READ_BIT;

			srcStage = VK_PIPELINE_STAGE_TRANSFER_BIT;
			dstStage = VK_PIPELINE_STAGE_COLOR_ATTACHMENT_OUTPUT_BIT;
		}
		else if (oldLayout == VK_IMAGE_LAYOUT_GENERAL
				&& newLayout == VK_IMAGE_LAYOUT_TRANSFER_SRC_OPTIMAL)
		{
			srcAccessMask = 0;
			dstAccessMask = VK_ACCESS_TRANSFER_READ_BIT;

			srcStage = VK_PIPELINE_STAGE_TRANSFER_BIT;
			dstStage = VK_PIPELINE_STAGE_COLOR_ATTACHMENT_OUTPUT_BIT;
		}
		else if (oldLayout == VK_IMAGE_LAYOUT_UNDEFINED
				&& newLayout == VK_IMAGE_LAYOUT_TRANSFER_DST_OPTIMAL)
		{
			srcAccessMask = 0;
			dstAccessMask = VK_ACCESS_TRANSFER_WRITE_BIT;

			srcStage = VK_PIPELINE_STAGE_TRANSFER_BIT;
			dstStage = VK_PIPELINE_STAGE_COLOR_ATTACHMENT_OUTPUT_BIT;
		}
		else
		{
			throw new AssertionError("unsupported layout transition!");
		}

		transitionImageLayout(commandBuffer, imageId, imageFormat, oldLayout, newLayout, mipLevels,
				srcStage, dstStage, srcAccessMask, dstAccessMask);
	}

	public static void transitionImageLayout(VkCommandBuffer commandBuffer,
			long imageId,
			int imageFormat,
			int oldLayout,
			int newLayout,
			int mipLevels,
			int srcStage,
			int dstStage,
			int srcAccessMask,
			int dstAccessMask)
	{
		int aspectMask = 0;
		if (newLayout == VK_IMAGE_LAYOUT_DEPTH_STENCIL_ATTACHMENT_OPTIMAL)
		{
			aspectMask = VK_IMAGE_ASPECT_DEPTH_BIT;

			if (hasStencilComponent(imageFormat))
			{
				aspectMask |= VK_IMAGE_ASPECT_STENCIL_BIT;
			}
		}
		else
		{
			aspectMask = VK_IMAGE_ASPECT_COLOR_BIT;
		}

		VkImageMemoryBarrier.Buffer barrier = VkImageMemoryBarrier.calloc(1);
		barrier.sType(VK_STRUCTURE_TYPE_IMAGE_MEMORY_BARRIER);
		barrier.oldLayout(oldLayout);
		barrier.newLayout(newLayout);
		barrier.srcQueueFamilyIndex(VK_QUEUE_FAMILY_IGNORED);
		barrier.dstQueueFamilyIndex(VK_QUEUE_FAMILY_IGNORED);
		barrier.image(imageId);
		barrier.subresourceRange().baseMipLevel(0);
		barrier.subresourceRange().levelCount(mipLevels);
		barrier.subresourceRange().baseArrayLayer(0);
		barrier.subresourceRange().layerCount(1);
		barrier.subresourceRange().aspectMask(aspectMask);
		barrier.srcAccessMask(srcAccessMask);
		barrier.dstAccessMask(dstAccessMask);

		vkCmdPipelineBarrier(commandBuffer, srcStage, dstStage, 0, null, null, barrier);

		barrier.free();
	}

	private static boolean hasStencilComponent(int imageFormat)
	{
		return imageFormat == VK_FORMAT_D32_SFLOAT_S8_UINT
				|| imageFormat == VK_FORMAT_D24_UNORM_S8_UINT;
	}

	public long getId()
	{
		return imageId;
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}

	public void free()
	{
		vkDestroyImage(logicalDevice.getVkDevice(), imageId, null);
		vkFreeMemory(logicalDevice.getVkDevice(), imageMemoryId, null);
	}

	public long getSize()
	{
		return size;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (imageId ^ (imageId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Image other = (Image) obj;
		if (imageId != other.imageId) return false;
		return true;
	}

	public long getMemoryId()
	{
		return imageMemoryId;
	}

}
