package org.sheepy.lily.game.vulkan.view;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkImageMemoryBarrier;
import org.lwjgl.vulkan.VkImageViewCreateInfo;
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

	public void transitionImageLayout(VkCommandBuffer commandBuffer,
			int oldLayout,
			int newLayout)
	{
		transitionImageLayout(commandBuffer, oldLayout, newLayout, 1);
	}

	public void transitionImageLayout(VkCommandBuffer commandBuffer,
			int oldLayout,
			int newLayout,
			int mipLevels)
	{
		int aspectMask = 0;
		if (newLayout == VK_IMAGE_LAYOUT_DEPTH_STENCIL_ATTACHMENT_OPTIMAL)
		{
			aspectMask = VK_IMAGE_ASPECT_DEPTH_BIT;

			if (hasStencilComponent())
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

		int sourceStage;
		int destinationStage;

		if (oldLayout == VK_IMAGE_LAYOUT_UNDEFINED
				&& newLayout == VK_IMAGE_LAYOUT_TRANSFER_DST_OPTIMAL)
		{
			barrier.srcAccessMask(0);
			barrier.dstAccessMask(VK_ACCESS_TRANSFER_WRITE_BIT);

			sourceStage = VK_PIPELINE_STAGE_TOP_OF_PIPE_BIT;
			destinationStage = VK_PIPELINE_STAGE_TRANSFER_BIT;
		}
		else if (oldLayout == VK_IMAGE_LAYOUT_TRANSFER_DST_OPTIMAL
				&& newLayout == VK_IMAGE_LAYOUT_SHADER_READ_ONLY_OPTIMAL)
		{
			barrier.srcAccessMask(VK_ACCESS_TRANSFER_WRITE_BIT);
			barrier.dstAccessMask(VK_ACCESS_SHADER_READ_BIT);

			sourceStage = VK_PIPELINE_STAGE_TRANSFER_BIT;
			destinationStage = VK_PIPELINE_STAGE_FRAGMENT_SHADER_BIT;
		}
		else if (oldLayout == VK_IMAGE_LAYOUT_UNDEFINED
				&& newLayout == VK_IMAGE_LAYOUT_DEPTH_STENCIL_ATTACHMENT_OPTIMAL)
		{
			barrier.srcAccessMask(0);
			barrier.dstAccessMask(VK_ACCESS_DEPTH_STENCIL_ATTACHMENT_READ_BIT
					| VK_ACCESS_DEPTH_STENCIL_ATTACHMENT_WRITE_BIT);

			sourceStage = VK_PIPELINE_STAGE_TOP_OF_PIPE_BIT;
			destinationStage = VK_PIPELINE_STAGE_EARLY_FRAGMENT_TESTS_BIT;
		}
		else
		{
			throw new AssertionError("unsupported layout transition!");
		}

		vkCmdPipelineBarrier(commandBuffer, sourceStage, destinationStage, 0, null, null, barrier);
	}

	private boolean hasStencilComponent()
	{
		return imageFormat == VK_FORMAT_D32_SFLOAT_S8_UINT || imageFormat == VK_FORMAT_D24_UNORM_S8_UINT;
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
