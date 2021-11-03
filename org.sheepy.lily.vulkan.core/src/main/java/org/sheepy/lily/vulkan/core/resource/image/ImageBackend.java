package org.sheepy.lily.vulkan.core.resource.image;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkBufferImageCopy;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkImageMemoryBarrier;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.execution.IRecordContext;
import org.sheepy.lily.vulkan.core.resource.buffer.BufferInfo;
import org.sheepy.lily.vulkan.core.resource.buffer.HostVisibleBufferBackend;
import org.sheepy.lily.vulkan.core.resource.memory.Memory;
import org.sheepy.lily.vulkan.core.resource.util.FillCommand;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

import static org.lwjgl.vulkan.VK10.*;

public final class ImageBackend
{
	private final VkImage vkImage;
	private final long size;
	private final Memory memory;

	public ImageBackend(VkImage vkImage, long size)
	{
		this(vkImage, size, null);
	}

	public ImageBackend(VkImage vkImage, long size, Memory memory)
	{
		this.vkImage = vkImage;
		this.size = size;
		this.memory = memory;
	}

	public void free(ExecutionContext context)
	{
		vkImage.free(context.getVkDevice());
		if (memory != null) memory.free(context);
	}

	void fillWithZero(final IRecordContext executionContext, final long memorySize)
	{
		final ByteBuffer data = MemoryUtil.memCalloc((int) memorySize);

		fillWith(executionContext, data);
		MemoryUtil.memFree(data);
	}

	public void fillWith(final IRecordContext context, final FillCommand.DataProvider dataProvider)
	{
		fillWithInternal(context, size, buffer -> buffer.pushData(context, dataProvider));
	}

	public void fillWith(final IRecordContext context, final ByteBuffer data)
	{
		final var size = data.limit();
		fillWithInternal(context, size, buffer -> buffer.pushData(context, data));
	}

	private void fillWithInternal(final IRecordContext context,
								  final long size,
								  final Consumer<HostVisibleBufferBackend> bufferFiller)
	{
		final int usage = VK_BUFFER_USAGE_TRANSFER_SRC_BIT;

		final var bufferInfo = new BufferInfo(size, usage, true);
		final var bufferBuilder = new HostVisibleBufferBackend.Builder(bufferInfo);
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
			switch (status)
			{
				case Done, Canceled -> stagingBuffer.free(context);
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
		region.imageExtent().set(vkImage.width(), vkImage.height(), 1);

		final var dstImageLayout = VK_IMAGE_LAYOUT_TRANSFER_DST_OPTIMAL;
		vkCmdCopyBufferToImage(commandBuffer, bufferPtr, vkImage.ptr(), dstImageLayout, region);

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
							  vkImage.initialLayout(),
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
							  vkImage.initialLayout(),
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
		final VkImageMemoryBarrier.Buffer barrierInfo = VkImageMemoryBarrier.calloc(1, stack);

		barrierInfo.sType(VK_STRUCTURE_TYPE_IMAGE_MEMORY_BARRIER);
		barrierInfo.oldLayout(srcLayout.getValue());
		barrierInfo.newLayout(dstLayout.getValue());
		barrierInfo.image(vkImage.ptr());
		barrierInfo.subresourceRange().baseMipLevel(0);
		barrierInfo.subresourceRange().levelCount(vkImage.mipLevels());
		barrierInfo.subresourceRange().baseArrayLayer(0);
		barrierInfo.subresourceRange().layerCount(1);
		barrierInfo.subresourceRange().aspectMask(vkImage.aspect());
		barrierInfo.srcAccessMask(VulkanModelUtil.getEnumeratedFlag(srcAccessMask));
		barrierInfo.dstAccessMask(VulkanModelUtil.getEnumeratedFlag(dstAccessMask));

		vkCmdPipelineBarrier(commandBuffer, srcStage.getValue(), dstStage.getValue(), 0, null, null, barrierInfo);
	}

	public long getPtr()
	{
		return vkImage.ptr();
	}

	public long size()
	{
		return size;
	}

	public VkImage vkImage()
	{
		return vkImage;
	}
}
