package org.sheepy.vulkan.resource.image;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkBufferImageCopy;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkImageCreateInfo;
import org.lwjgl.vulkan.VkImageMemoryBarrier;
import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.execution.ISingleTimeCommand;
import org.sheepy.vulkan.log.Logger;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.resource.buffer.BufferAllocator;
import org.sheepy.vulkan.resource.buffer.CPUBufferBackend;
import org.sheepy.vulkan.resource.memory.VkMemoryAllocator;
import org.sheepy.vulkan.resource.memory.VkMemoryAllocator.MemoryAllocationInfo;
import org.sheepy.vulkan.resource.memory.VkMemoryAllocator.MemoryInfo;
import org.sheepy.vulkan.util.VkModelUtil;

public final class VkImage implements IAllocable
{
	protected long imageAddress;
	protected long imageMemoryAddress;

	public final int width;
	public final int height;
	public final int format;
	public final int usage;
	public final int properties;
	public final int tiling;
	public final int mipLevels;
	public final boolean fillWithZero;

	VkImage(int width,
			int height,
			int format,
			int usage,
			int properties,
			int tiling,
			int mipLevels,
			boolean fillWithZero)
	{
		this.width = width;
		this.height = height;
		this.format = format;
		this.usage = usage;
		this.properties = properties;
		this.tiling = tiling;
		this.mipLevels = mipLevels;
		this.fillWithZero = fillWithZero;
	}

	public static final VkImageBuilder newBuilder(int width, int height, int format)
	{
		return new VkImageBuilder(width, height, format);
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		final var executionContext = (IExecutionContext) context;
		final var logicalDevice = executionContext.getLogicalDevice();

		imageAddress = allocateImage(stack, logicalDevice.getVkDevice());

		final var memoryInfo = allocateMemory(stack, logicalDevice);
		imageMemoryAddress = memoryInfo.id;

		vkBindImageMemory(logicalDevice.getVkDevice(), imageAddress, imageMemoryAddress, 0);

		if (fillWithZero)
		{
			fillWithZero(stack, executionContext, memoryInfo);
		}
	}

	private void fillWithZero(	MemoryStack stack,
								final IExecutionContext executionContext,
								final MemoryInfo memoryInfo)
	{
		final int stagingUsage = VK_BUFFER_USAGE_TRANSFER_SRC_BIT;
		final long size = memoryInfo.size;

		final ByteBuffer data = MemoryUtil.memCalloc((int) size);
		final CPUBufferBackend buffer = BufferAllocator.allocateCPUBufferAndFill(stack,
				executionContext, size, stagingUsage, false, data);
		executionContext.execute(stack, new ISingleTimeCommand()
		{
			@Override
			public void execute(MemoryStack stack, VkCommandBuffer commandBuffer)
			{
				List<EAccess> srcAccessMask = List.of();
				List<EAccess> dstAccessMask = List.of(EAccess.TRANSFER_WRITE_BIT);

				transitionImageLayout(stack, commandBuffer, EPipelineStage.TRANSFER_BIT,
						EPipelineStage.TRANSFER_BIT, EImageLayout.UNDEFINED,
						EImageLayout.TRANSFER_DST_OPTIMAL, srcAccessMask, dstAccessMask);

				fillWithBuffer(commandBuffer, buffer.getAddress());

				srcAccessMask = List.of(EAccess.TRANSFER_WRITE_BIT);
				dstAccessMask = List.of();

				transitionImageLayout(stack, commandBuffer, EPipelineStage.TRANSFER_BIT,
						EPipelineStage.TRANSFER_BIT, EImageLayout.TRANSFER_DST_OPTIMAL,
						EImageLayout.GENERAL, srcAccessMask, dstAccessMask);
			}
		});

		buffer.free(executionContext);
		MemoryUtil.memFree(data);
	}

	private MemoryInfo allocateMemory(MemoryStack stack, LogicalDevice logicalDevice)
	{
		final var allocationInfo = new MemoryAllocationInfo(logicalDevice, imageAddress,
				properties);
		return VkMemoryAllocator.allocateFromImage(stack, allocationInfo);
	}

	public void fillWithBuffer(VkCommandBuffer commandBuffer, long bufferId)
	{
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

	public void transitionImageLayout(	MemoryStack stack,
										VkCommandBuffer commandBuffer,
										EPipelineStage srcStage,
										EPipelineStage dstStage,
										EImageLayout srcLayout,
										EImageLayout dstLayout,
										List<EAccess> srcAccessMask,
										List<EAccess> dstAccessMask)
	{
		final VkImageMemoryBarrier.Buffer barrierInfo = VkImageMemoryBarrier.callocStack(1, stack);
		final var aspectMask = ImageUtil.getAspectMask(dstLayout, format);

		barrierInfo.sType(VK_STRUCTURE_TYPE_IMAGE_MEMORY_BARRIER);
		barrierInfo.oldLayout(srcLayout.getValue());
		barrierInfo.newLayout(dstLayout.getValue());
		barrierInfo.image(imageAddress);
		barrierInfo.subresourceRange().baseMipLevel(0);
		barrierInfo.subresourceRange().levelCount(mipLevels);
		barrierInfo.subresourceRange().baseArrayLayer(0);
		barrierInfo.subresourceRange().layerCount(1);
		barrierInfo.subresourceRange().aspectMask(aspectMask);
		barrierInfo.srcAccessMask(VkModelUtil.getEnumeratedFlag(srcAccessMask));
		barrierInfo.dstAccessMask(VkModelUtil.getEnumeratedFlag(dstAccessMask));

		vkCmdPipelineBarrier(commandBuffer, srcStage.getValue(), dstStage.getValue(), 0, null, null,
				barrierInfo);
	}

	@Override
	public void free(IAllocationContext context)
	{
		final var executionContext = (IExecutionContext) context;
		final var logicalDevice = executionContext.getLogicalDevice();

		vkDestroyImage(logicalDevice.getVkDevice(), imageAddress, null);
		vkFreeMemory(logicalDevice.getVkDevice(), imageMemoryAddress, null);
		imageAddress = -1;
		imageMemoryAddress = -1;
	}

	@Override
	public boolean isAllocationDirty(IAllocationContext context)
	{
		return false;
	}

	public long getAddress()
	{
		return imageAddress;
	}

	public long getMemoryAddress()
	{
		return imageMemoryAddress;
	}

	private long allocateImage(MemoryStack stack, VkDevice device) throws AssertionError
	{
		final VkImageCreateInfo imageInfo = allocateInfo(stack);
		final long[] aImageId = new long[1];
		Logger.check("Failed to create image!",
				() -> vkCreateImage(device, imageInfo, null, aImageId));
		return aImageId[0];
	}

	private VkImageCreateInfo allocateInfo(MemoryStack stack)
	{
		final VkImageCreateInfo imageInfo = VkImageCreateInfo.callocStack(stack);

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

		return imageInfo;
	}

	public static interface Builder
	{
		int width();
		int height();
		int format();
		int usage();
		int properties();
		int tiling();
		int mipLevels();
		boolean fillWithZero();

		Builder copyImmutable();

		VkImage build();
	}

}
