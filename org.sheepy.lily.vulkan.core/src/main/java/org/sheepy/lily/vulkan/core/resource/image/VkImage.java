package org.sheepy.lily.vulkan.core.resource.image;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.*;
import org.sheepy.lily.game.api.execution.EExecutionStatus;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.execution.IRecordContext;
import org.sheepy.lily.vulkan.core.resource.buffer.BufferInfo;
import org.sheepy.lily.vulkan.core.resource.buffer.CPUBufferBackend;
import org.sheepy.lily.vulkan.core.resource.memory.Memory;
import org.sheepy.lily.vulkan.core.util.FillCommand;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.image.ImageInfo;

import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

import static org.lwjgl.vulkan.VK10.*;

public final class VkImage
{
	private final long imagePtr;

	public final int width;
	public final int height;
	public final int format;
	public final int usage;
	public final int properties;
	public final int tiling;
	public final int mipLevels;
	public final EImageLayout initialLayout;
	public final int aspect;

	private long memoryPtr;
	private long size = -1;
	private Memory memory;

	public static VkImageBuilder newBuilder(int width, int height, int format)
	{
		return new VkImageBuilder(width, height, format);
	}

	public static VkImageBuilder newBuilder(ImageInfo info, int width, int height)
	{
		return new VkImageBuilder(info, width, height);
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
		this.imagePtr = imagePtr;
		this.width = width;
		this.height = height;
		this.format = format;
		this.usage = usage;
		this.properties = VK10.VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT;
		this.tiling = tiling;
		this.mipLevels = mipLevels;
		this.initialLayout = initialLayout;
		this.aspect = aspect;
	}

	void linkMemory(Memory memory)
	{
		this.memory = memory;
	}

	public void bindMemory(VkDevice vkDevice, long memoryPtr, long offset, long size)
	{
		this.size = size;
		this.memoryPtr = memoryPtr;
		vkBindImageMemory(vkDevice, imagePtr, memoryPtr, offset);
	}

	void fillWithZero(final IRecordContext executionContext, final long memorySize)
	{
		final ByteBuffer data = MemoryUtil.memCalloc((int) memorySize);

		fillWith(executionContext, data);
		MemoryUtil.memFree(data);
	}

	public void fillWith(final IRecordContext context, final FillCommand.DataProvider dataProvider)
	{
		fillWithInternal(context, getSize(), buffer -> buffer.pushData(context, dataProvider));
	}

	public void fillWith(final IRecordContext context, final ByteBuffer data)
	{
		final var size = data.limit();
		fillWithInternal(context, size, buffer -> buffer.pushData(context, data));
	}

	private void fillWithInternal(final IRecordContext context,
								  final long size,
								  final Consumer<CPUBufferBackend> bufferFiller)
	{
		final int usage = VK_BUFFER_USAGE_TRANSFER_SRC_BIT;

		final var bufferInfo = new BufferInfo(size, usage, false, true);
		final var bufferBuilder = new CPUBufferBackend.Builder(bufferInfo);
		final var stagingBuffer = bufferBuilder.build(context);
		bufferFiller.accept(stagingBuffer);

		final var stack = context.stack();
		final var vkCommandBuffer = context.vkCommandBuffer();
		final List<EAccess> srcAccessMask = List.of();
		final List<EAccess> dstAccessMask = List.of(EAccess.TRANSFER_WRITE_BIT);

		transitionImageLayout(stack,
							  vkCommandBuffer,
							  EPipelineStage.TRANSFER_BIT,
							  EPipelineStage.TRANSFER_BIT,
							  EImageLayout.UNDEFINED,
							  EImageLayout.TRANSFER_DST_OPTIMAL,
							  srcAccessMask,
							  dstAccessMask);

		fillWithBuffer(vkCommandBuffer, stagingBuffer.getAddress());

		context.listenExecution(status -> {
			if (status == EExecutionStatus.Done || status == EExecutionStatus.Canceled)
			{
				stagingBuffer.free(context);
			}
		});
	}

	public void fillWithBuffer(VkCommandBuffer commandBuffer, long bufferPtr)
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
		vkCmdCopyBufferToImage(commandBuffer, bufferPtr, imagePtr, dstImageLayout, region);

		region.free();
	}

	public void transitionToInitialLayout(MemoryStack stack,
										  VkCommandBuffer commandBuffer,
										  EPipelineStage srcStage,
										  EImageLayout srcLayout,
										  Collection<EAccess> srcAccessMask)
	{
		transitionImageLayout(stack,
							  commandBuffer,
							  srcStage,
							  EPipelineStage.TOP_OF_PIPE_BIT,
							  srcLayout,
							  initialLayout,
							  srcAccessMask,
							  List.of());
	}

	public void transitionFromInitialLayout(MemoryStack stack,
											VkCommandBuffer commandBuffer,
											EPipelineStage dstStage,
											EImageLayout dstLayout,
											Collection<EAccess> dstAccessMask)
	{
		transitionImageLayout(stack,
							  commandBuffer,
							  EPipelineStage.TOP_OF_PIPE_BIT,
							  dstStage,
							  initialLayout,
							  dstLayout,
							  List.of(),
							  dstAccessMask);
	}

	public void transitionImageLayout(MemoryStack stack,
									  VkCommandBuffer commandBuffer,
									  EPipelineStage srcStage,
									  EPipelineStage dstStage,
									  EImageLayout srcLayout,
									  EImageLayout dstLayout,
									  Collection<EAccess> srcAccessMask,
									  Collection<EAccess> dstAccessMask)
	{
		final VkImageMemoryBarrier.Buffer barrierInfo = VkImageMemoryBarrier.callocStack(1, stack);

		barrierInfo.sType(VK_STRUCTURE_TYPE_IMAGE_MEMORY_BARRIER);
		barrierInfo.oldLayout(srcLayout.getValue());
		barrierInfo.newLayout(dstLayout.getValue());
		barrierInfo.image(imagePtr);
		barrierInfo.subresourceRange().baseMipLevel(0);
		barrierInfo.subresourceRange().levelCount(mipLevels);
		barrierInfo.subresourceRange().baseArrayLayer(0);
		barrierInfo.subresourceRange().layerCount(1);
		barrierInfo.subresourceRange().aspectMask(aspect);
		barrierInfo.srcAccessMask(VulkanModelUtil.getEnumeratedFlag(srcAccessMask));
		barrierInfo.dstAccessMask(VulkanModelUtil.getEnumeratedFlag(dstAccessMask));

		vkCmdPipelineBarrier(commandBuffer, srcStage.getValue(), dstStage.getValue(), 0, null, null, barrierInfo);
	}

	public void free(ExecutionContext context)
	{
		final var logicalDevice = context.getLogicalDevice();

		vkDestroyImage(logicalDevice.getVkDevice(), imagePtr, null);
		if (memory != null) memory.free(context);
		memoryPtr = 0;
	}

	public long getPtr()
	{
		return imagePtr;
	}

	public long getMemoryPtr()
	{
		return memoryPtr;
	}

	public long getSize()
	{
		return size;
	}
}
