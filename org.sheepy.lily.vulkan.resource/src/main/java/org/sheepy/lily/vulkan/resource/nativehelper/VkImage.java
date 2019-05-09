package org.sheepy.lily.vulkan.resource.nativehelper;

import static org.lwjgl.vulkan.VK10.*;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkBufferImageCopy;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.sheepy.lily.vulkan.resource.barrier.ImageBarrierExecutor;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.resource.image.ImageInfo;
import org.sheepy.vulkan.resource.image.VkImageAllocator;
import org.sheepy.vulkan.resource.memory.VkMemoryAllocator;
import org.sheepy.vulkan.resource.memory.VkMemoryAllocator.MemoryAllocationInfo;
import org.sheepy.vulkan.resource.memory.VkMemoryAllocator.MemoryInfo;

public class VkImage
{
	private final LogicalDevice logicalDevice;

	private final ImageInfo info;

	protected long imageAddress;
	protected long imageMemoryAddress;

	public VkImage(LogicalDevice logicalDevice, ImageInfo info)
	{
		this.logicalDevice = logicalDevice;
		this.info = info;
	}

	public void allocate(MemoryStack stack)
	{
		imageAddress = VkImageAllocator.allocate(stack, logicalDevice.getVkDevice(), info);

		final var memoryInfo = allocateMemory(stack, logicalDevice);
		imageMemoryAddress = memoryInfo.id;

		vkBindImageMemory(logicalDevice.getVkDevice(), imageAddress, imageMemoryAddress, 0);
	}

	private MemoryInfo allocateMemory(MemoryStack stack, LogicalDevice logicalDevice)
	{
		final var properties = info.properties;
		final var allocationInfo = new MemoryAllocationInfo(logicalDevice, imageAddress,
				properties);
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
		vkCmdCopyBufferToImage(commandBuffer, bufferId, imageAddress, dstImageLayout, region);

		region.free();
	}

	public void transitionImageLayout(	VkCommandBuffer commandBuffer,
										EPipelineStage srcStage,
										EPipelineStage dstStage,
										EImageLayout srcLayout,
										EImageLayout dstLayout,
										List<EAccess> srcAccessMask,
										List<EAccess> dstAccessMask)
	{
		ImageBarrierExecutor.execute(commandBuffer, srcStage, dstStage, srcLayout, dstLayout,
				srcAccessMask, dstAccessMask, imageAddress, info.format, info.mipLevels);
	}

	public void free()
	{
		vkDestroyImage(logicalDevice.getVkDevice(), imageAddress, null);
		vkFreeMemory(logicalDevice.getVkDevice(), imageMemoryAddress, null);
		imageAddress = -1;
		imageMemoryAddress = -1;
	}

	public long getAddress()
	{
		return imageAddress;
	}

	public long getMemoryAddress()
	{
		return imageMemoryAddress;
	}

}
