package org.sheepy.lily.game.vulkan.buffer;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.vulkan.VkBufferImageCopy;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkImageCreateInfo;
import org.lwjgl.vulkan.VkImageMemoryBarrier;
import org.lwjgl.vulkan.VkMemoryAllocateInfo;
import org.lwjgl.vulkan.VkMemoryRequirements;
import org.lwjgl.vulkan.VkQueue;
import org.sheepy.lily.game.vulkan.command.CommandPool;
import org.sheepy.lily.game.vulkan.command.SingleTimeCommands;
import org.sheepy.lily.game.vulkan.device.LogicalDevice;

public class ImageBuffer
{
	private LogicalDevice logicalDevice;

	private int width;
	private int height;

	protected long imageId;
	protected long imageMemoryId;

	public static ImageBuffer alloc(LogicalDevice logicalDevice,
			int width,
			int height,
			int format,
			int tiling,
			int usage,
			int properties)
	{
		ImageBuffer res = new ImageBuffer(logicalDevice);
		res.createImage(width, height, 1, format, tiling, usage, properties);
		return res;
	}

	public ImageBuffer(LogicalDevice logicalDevice)
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

	public void transitionImageLayout(CommandPool commandPool,
			VkQueue queue,
			int format,
			int oldLayout,
			int newLayout,
			int mipLevels)
	{
		SingleTimeCommands singleTimeCommand = commandPool.newSingleTimeCommand();
		VkCommandBuffer commandBuffer = singleTimeCommand.startRecording();

		int aspectMask = 0;
		if (newLayout == VK_IMAGE_LAYOUT_DEPTH_STENCIL_ATTACHMENT_OPTIMAL)
		{
			aspectMask = VK_IMAGE_ASPECT_DEPTH_BIT;

			if (hasStencilComponent(format))
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

		singleTimeCommand.submitCommands(queue);
	}
	
	private boolean hasStencilComponent(int format)
	{
		return format == VK_FORMAT_D32_SFLOAT_S8_UINT || format == VK_FORMAT_D24_UNORM_S8_UINT;
	}

	public void fillWithBuffer(CommandPool commandPool, VkQueue queue, Buffer buffer)
	{
		SingleTimeCommands transaction = commandPool.newSingleTimeCommand();
		VkCommandBuffer commandBuffer = transaction.startRecording();

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

		vkCmdCopyBufferToImage(commandBuffer, buffer.getBufferId(), imageId,
				VK_IMAGE_LAYOUT_TRANSFER_DST_OPTIMAL, region);

		transaction.submitCommands(queue);
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
}
