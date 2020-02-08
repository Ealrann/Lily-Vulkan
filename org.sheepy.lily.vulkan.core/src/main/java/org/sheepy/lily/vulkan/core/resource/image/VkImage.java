package org.sheepy.lily.vulkan.core.resource.image;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VK10;
import org.lwjgl.vulkan.VkBufferImageCopy;
import org.lwjgl.vulkan.VkCommandBuffer;
import org.lwjgl.vulkan.VkImageCreateInfo;
import org.lwjgl.vulkan.VkImageMemoryBarrier;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.core.execution.InternalExecutionContext;
import org.sheepy.lily.vulkan.core.resource.buffer.BufferInfo;
import org.sheepy.lily.vulkan.core.resource.buffer.CPUBufferBackend;
import org.sheepy.lily.vulkan.core.resource.memory.MemoryChunk;
import org.sheepy.lily.vulkan.core.resource.memory.MemoryChunkBuilder;
import org.sheepy.lily.vulkan.core.util.Logger;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.image.ImageInfo;
import org.sheepy.vulkan.model.image.ImageLayout;

public final class VkImage
{
	private static final String CREATE_ERROR = "Failed to create image!";

	protected long imagePtr;
	protected long memoryPtr;

	public final int width;
	public final int height;
	public final int format;
	public final int usage;
	public final int properties;
	public final int tiling;
	public final int mipLevels;
	public final boolean fillWithZero;
	public final ByteBuffer fillWith;
	public final ImageLayout initialLayout;
	private MemoryChunk memory;

	VkImage(int width,
			int height,
			int format,
			int usage,
			int tiling,
			int mipLevels,
			boolean fillWithZero,
			ByteBuffer fillWith,
			ImageLayout initialLayout)
	{
		this.width = width;
		this.height = height;
		this.format = format;
		this.usage = usage;
		this.properties = VK10.VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT;
		this.tiling = tiling;
		this.mipLevels = mipLevels;
		this.fillWithZero = fillWithZero;
		this.fillWith = fillWith;
		this.initialLayout = initialLayout;
	}

	public static final VkImageBuilder newBuilder(int width, int height, int format)
	{
		return new VkImageBuilder(width, height, format);
	}

	public static final VkImageBuilder newBuilder(ImageInfo info, int width, int height)
	{
		return new VkImageBuilder(info, width, height);
	}

	public void allocate(InternalExecutionContext context)
	{
		final var memoryBuilder = new MemoryChunkBuilder(context, properties);
		allocate(context, memoryBuilder);
		memory = memoryBuilder.build();
		memory.allocate(context);
	}

	public void allocate(InternalExecutionContext context, MemoryChunkBuilder memoryChunkBuilder)
	{
		final var logicalDevice = context.getLogicalDevice();

		imagePtr = allocateImage(context);

		memoryChunkBuilder.registerImage(imagePtr, (memoryPtr, offset, memorySize) ->
		{
			this.memoryPtr = memoryPtr;
			vkBindImageMemory(logicalDevice.getVkDevice(), imagePtr, memoryPtr, offset);

			if (fillWith != null)
			{
				fillWith(context, fillWith);
			}
			else if (fillWithZero)
			{
				fillWithZero(context, memorySize);
			}

			if (initialLayout != null)
			{
				context.execute((context2, commandBuffer) ->
				{
					final var stage = initialLayout.getStage();
					final var trgAccess = new ArrayList<>(initialLayout.getAccessMask());
					if (trgAccess.isEmpty())
					{
						trgAccess.add(EAccess.SHADER_READ_BIT);
					}
					transitionImageLayout(	context2.stack(),
											commandBuffer.getVkCommandBuffer(),
											EPipelineStage.BOTTOM_OF_PIPE_BIT,
											stage,
											EImageLayout.UNDEFINED,
											initialLayout.getLayout(),
											Collections.emptyList(),
											trgAccess);
				});
			}
		});
	}

	private void fillWithZero(	final InternalExecutionContext executionContext,
								final long memorySize)
	{
		final ByteBuffer data = MemoryUtil.memCalloc((int) memorySize);

		fillWith(executionContext, data);
		MemoryUtil.memFree(data);
	}

	private void fillWith(final InternalExecutionContext context, final ByteBuffer data)
	{
		final int usage = VK_BUFFER_USAGE_TRANSFER_SRC_BIT;
		final var size = data.limit();

		final var bufferInfo = new BufferInfo(size, usage, false);
		final var stagingBuffer = new CPUBufferBackend(bufferInfo, true);
		stagingBuffer.allocate(context);
		stagingBuffer.pushData(context, data);

		context.execute((_context, commandBuffer) ->
		{
			final var stack = _context.stack();
			final var vkCommandBuffer = commandBuffer.getVkCommandBuffer();
			List<EAccess> srcAccessMask = List.of();
			List<EAccess> dstAccessMask = List.of(EAccess.TRANSFER_WRITE_BIT);

			transitionImageLayout(	stack,
									vkCommandBuffer,
									EPipelineStage.TRANSFER_BIT,
									EPipelineStage.TRANSFER_BIT,
									EImageLayout.UNDEFINED,
									EImageLayout.TRANSFER_DST_OPTIMAL,
									srcAccessMask,
									dstAccessMask);

			fillWithBuffer(vkCommandBuffer, stagingBuffer.getAddress());

			srcAccessMask = List.of(EAccess.TRANSFER_WRITE_BIT);
			dstAccessMask = List.of();

			transitionImageLayout(	stack,
									vkCommandBuffer,
									EPipelineStage.TRANSFER_BIT,
									EPipelineStage.TRANSFER_BIT,
									EImageLayout.TRANSFER_DST_OPTIMAL,
									EImageLayout.GENERAL,
									srcAccessMask,
									dstAccessMask);
		});

		stagingBuffer.free(context);
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
		vkCmdCopyBufferToImage(commandBuffer, bufferId, imagePtr, dstImageLayout, region);

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
		barrierInfo.image(imagePtr);
		barrierInfo.subresourceRange().baseMipLevel(0);
		barrierInfo.subresourceRange().levelCount(mipLevels);
		barrierInfo.subresourceRange().baseArrayLayer(0);
		barrierInfo.subresourceRange().layerCount(1);
		barrierInfo.subresourceRange().aspectMask(aspectMask);
		barrierInfo.srcAccessMask(VulkanModelUtil.getEnumeratedFlag(srcAccessMask));
		barrierInfo.dstAccessMask(VulkanModelUtil.getEnumeratedFlag(dstAccessMask));

		vkCmdPipelineBarrier(	commandBuffer,
								srcStage.getValue(),
								dstStage.getValue(),
								0,
								null,
								null,
								barrierInfo);
	}

	public void free(InternalExecutionContext context)
	{
		final var logicalDevice = context.getLogicalDevice();

		vkDestroyImage(logicalDevice.getVkDevice(), imagePtr, null);
		if (memory != null) memory.free(context);

		imagePtr = 0;
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

	private long allocateImage(InternalExecutionContext context) throws AssertionError
	{
		final var stack = context.stack();
		final var device = context.getVkDevice();

		final VkImageCreateInfo imageInfo = allocateInfo(stack);
		final long[] aImageId = new long[1];
		Logger.check(vkCreateImage(device, imageInfo, null, aImageId), CREATE_ERROR);
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
		int tiling();
		int mipLevels();
		boolean fillWithZero();
		ByteBuffer fillWith();
		ImageLayout initialLayout();

		Builder copyImmutable();

		VkImage build();
	}

	public static final class VkImageBuilder implements Builder
	{
		private final int width;
		private final int height;
		private final int format;
		private int usage = 0;
		private int tiling = 0;
		private int mipLevels = 1;
		private boolean fillWithZero = false;
		private ByteBuffer fillWith = null;
		private ImageLayout initialLayout = null;

		public VkImageBuilder(int width, int height, int format)
		{
			this.width = width;
			this.height = height;
			this.format = format;
		}

		public VkImageBuilder(ImageInfo info, int width, int height)
		{
			this.width = width;
			this.height = height;
			this.format = info.getFormat().getValue();
			this.usage = VulkanModelUtil.getEnumeratedFlag(info.getUsages());
			this.tiling = info.getTiling();
			this.mipLevels = info.getMipLevels();
			this.initialLayout = info.getInitialLayout();
		}

		public VkImageBuilder(Builder builder)
		{
			this.width = builder.width();
			this.height = builder.height();
			this.format = builder.format();
			this.usage = builder.usage();
			this.tiling = builder.tiling();
			this.mipLevels = builder.mipLevels();
			this.fillWithZero = builder.fillWithZero();
			this.initialLayout = builder.initialLayout();
		}

		@Override
		public int width()
		{
			return width;
		}

		@Override
		public int height()
		{
			return height;
		}

		@Override
		public int format()
		{
			return format;
		}

		public VkImageBuilder addUsage(int usage)
		{
			this.usage |= usage;
			return this;
		}

		public VkImageBuilder usage(int usage)
		{
			this.usage = usage;
			return this;
		}

		@Override
		public int usage()
		{
			return usage;
		}

		public VkImageBuilder tiling(int tiling)
		{
			this.tiling = tiling;
			return this;
		}

		@Override
		public int tiling()
		{
			return tiling;
		}

		public VkImageBuilder mipLevels(int mipLevels)
		{
			this.mipLevels = mipLevels;
			return this;
		}

		@Override
		public int mipLevels()
		{
			return mipLevels;
		}

		public VkImageBuilder fillWithZero(boolean fillWithZero)
		{
			this.fillWithZero = fillWithZero;
			return this;
		}

		@Override
		public boolean fillWithZero()
		{
			return fillWithZero;
		}

		public VkImageBuilder fillWith(ByteBuffer fillWith)
		{
			this.fillWith = fillWith;
			return this;
		}

		@Override
		public ByteBuffer fillWith()
		{
			return fillWith;
		}

		@Override
		public Builder copyImmutable()
		{
			return new ImmutableBuilder(this);
		}

		public Builder initialLayout(ImageLayout initialLayout)
		{
			this.initialLayout = initialLayout;
			return this;
		}

		@Override
		public ImageLayout initialLayout()
		{
			return initialLayout;
		}

		@Override
		public VkImage build()
		{
			return new VkImage(	width,
								height,
								format,
								usage,
								tiling,
								mipLevels,
								fillWithZero,
								fillWith,
								initialLayout);
		}
	}

	private static final class ImmutableBuilder implements Builder
	{
		private final int width;
		private final int height;
		private final int format;
		private final int usage;
		private final int tiling;
		private final int mipLevels;
		private final boolean fillWithZero;
		private final ByteBuffer fillWith;
		private final ImageLayout initialLayout;

		public ImmutableBuilder(Builder builder)
		{
			this.width = builder.width();
			this.height = builder.height();
			this.format = builder.format();
			this.usage = builder.usage();
			this.tiling = builder.tiling();
			this.mipLevels = builder.mipLevels();
			this.fillWithZero = builder.fillWithZero();
			this.fillWith = builder.fillWith();
			this.initialLayout = builder.initialLayout();
		}

		@Override
		public int width()
		{
			return width;
		}

		@Override
		public int height()
		{
			return height;
		}

		@Override
		public int format()
		{
			return format;
		}

		@Override
		public int usage()
		{
			return usage;
		}

		@Override
		public int tiling()
		{
			return tiling;
		}

		@Override
		public int mipLevels()
		{
			return mipLevels;
		}

		@Override
		public boolean fillWithZero()
		{
			return fillWithZero;
		}

		@Override
		public ByteBuffer fillWith()
		{
			return fillWith;
		}

		@Override
		public Builder copyImmutable()
		{
			return this;
		}

		@Override
		public ImageLayout initialLayout()
		{
			return initialLayout;
		}

		@Override
		public VkImage build()
		{
			return new VkImage(	width,
								height,
								format,
								usage,
								tiling,
								mipLevels,
								fillWithZero,
								fillWith,
								initialLayout);
		}
	}
}
