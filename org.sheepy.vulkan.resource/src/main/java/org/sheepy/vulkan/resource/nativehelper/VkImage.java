package org.sheepy.vulkan.resource.nativehelper;

import static org.lwjgl.vulkan.VK10.*;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkBufferImageCopy;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.vulkan.common.device.LogicalDevice;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.resource.image.ImageInfo;
import org.sheepy.vulkan.resource.image.barrier.ImageBarrierExecutor;
import org.sheepy.vulkan.resource.nativehelper.VkMemoryAllocator.MemoryAllocationInfo;
import org.sheepy.vulkan.resource.nativehelper.VkMemoryAllocator.MemoryInfo;

public class VkImage
{
	private final LogicalDevice logicalDevice;

	private final ImageInfo info;

	protected long imageId;
	protected long imageMemoryId;
	protected long size;

	public VkImage(LogicalDevice logicalDevice, ImageInfo info)
	{
		this.logicalDevice = logicalDevice;
		this.info = info;
	}

	public void allocate(MemoryStack stack)
	{
		imageId = VkImageAllocator.allocate(stack, logicalDevice.getVkDevice(), info);

		final var memoryInfo = allocateMemory(stack, logicalDevice);
		imageMemoryId = memoryInfo.id;
		size = memoryInfo.size;

		vkBindImageMemory(logicalDevice.getVkDevice(), imageId, imageMemoryId, 0);
	}

	private MemoryInfo allocateMemory(MemoryStack stack, LogicalDevice logicalDevice)
	{
		final var properties = info.properties;
		final var allocationInfo = new MemoryAllocationInfo(logicalDevice, imageId, properties);
		return VkMemoryAllocator.allocateFromImage(stack, allocationInfo);
	}

	public void fillWithBuffer(VkCommandBuffer commandBuffer, long bufferId)
	{
		final int width = info.width;
		final int height = info.height;

		final VkBufferImageCopy.Buffer region = VkBufferImageCopy.calloc(1);
		region.bufferOffset(0);
		region.bufferRowLength(0);
		region.bufferImageHeight(0);

		region.imageSubresource().aspectMask(VK_IMAGE_ASPECT_COLOR_BIT);
		region.imageSubresource().mipLevel(0);
		region.imageSubresource().baseArrayLayer(0);
		region.imageSubresource().layerCount(1);

		region.imageOffset().set(0, 0, 0);
		region.imageExtent().set(width, height, 1);

		final var dstImageLayout = VK_IMAGE_LAYOUT_TRANSFER_DST_OPTIMAL;
		vkCmdCopyBufferToImage(commandBuffer, bufferId, imageId, dstImageLayout, region);
	}

	public void transitionImageLayout(	VkCommandBuffer commandBuffer,
										EPipelineStage srcStage,
										EPipelineStage dstStage,
										EImageLayout srcLayout,
										EImageLayout dstLayout,
										int srcAccessMask,
										int dstAccessMask)
	{
		ImageBarrierExecutor.execute(commandBuffer, srcStage, dstStage, srcLayout, dstLayout,
				srcAccessMask, dstAccessMask, imageId, info.format, info.mipLevels);
	}

	public void free()
	{
		vkDestroyImage(logicalDevice.getVkDevice(), imageId, null);
		vkFreeMemory(logicalDevice.getVkDevice(), imageMemoryId, null);
	}

	public long getId()
	{
		return imageId;
	}

	public long getSize()
	{
		return size;
	}

	public long getMemoryId()
	{
		return imageMemoryId;
	}

}
