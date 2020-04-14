package org.sheepy.lily.vulkan.core.resource.image;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VK10;
import org.lwjgl.vulkan.VkImageCreateInfo;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.resource.memory.MemoryChunkBuilder;
import org.sheepy.lily.vulkan.core.util.Logger;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.image.ImageLayout;

import java.nio.ByteBuffer;
import java.util.Collections;

import static org.lwjgl.vulkan.VK10.*;

public interface IVkImageBuilder
{
	int width();
	int height();
	int format();
	int usage();
	int tiling();
	int mipLevels();
	int aspect();
	boolean fillWithZero();
	ByteBuffer fillWith();
	ImageLayout initialLayout();
	IVkImageBuilder copyImmutable();
	VkImageBuilder copy();

	VkImage build(ExecutionContext context);

	abstract class AbstractVkImageBuilder implements IVkImageBuilder
	{
		private static final String CREATE_ERROR = "Failed to create image!";

		@Override
		public VkImage build(ExecutionContext context)
		{
			final var memoryBuilder = new MemoryChunkBuilder(context, VK10.VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT);
			final var res = build(context, memoryBuilder);
			final var memory = memoryBuilder.build();
			memory.allocate(context);
			res.linkMemory(memory);
			return res;
		}

		public VkImage build(ExecutionContext context, MemoryChunkBuilder memoryChunkBuilder)
		{
			final long imagePtr = allocateImage(context);
			final var res = new VkImage(imagePtr,
										width(),
										height(),
										format(),
										usage(),
										tiling(),
										mipLevels(),
										initialLayout(),
										aspect());

			memoryChunkBuilder.registerImage(imagePtr, (vkDevice, memoryPtr, offset, memorySize) -> {
				res.bindMemory(vkDevice, memoryPtr, offset, memorySize);

				if (fillWith() != null) res.fillWith(context, fillWith());
				else if (fillWithZero()) res.fillWithZero(context, memorySize);

				if (initialLayout() != null)
				{
					context.execute((context2, commandBuffer) -> res.transitionToInitialLayout(context2.stack(),
																							   commandBuffer.getVkCommandBuffer(),
																							   EPipelineStage.TOP_OF_PIPE_BIT,
																							   EImageLayout.UNDEFINED,
																							   Collections.emptyList()));
				}
			});

			return res;
		}

		private long allocateImage(ExecutionContext context) throws AssertionError
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
			imageInfo.extent().width(width());
			imageInfo.extent().height(height());
			imageInfo.extent().depth(1);
			imageInfo.mipLevels(mipLevels());
			imageInfo.arrayLayers(1);
			imageInfo.format(format());
			imageInfo.tiling(tiling());
			imageInfo.initialLayout(VK_IMAGE_LAYOUT_UNDEFINED);
			imageInfo.usage(usage());
			imageInfo.sharingMode(VK_SHARING_MODE_EXCLUSIVE);
			imageInfo.samples(VK_SAMPLE_COUNT_1_BIT);
			imageInfo.flags(0); // Optional

			return imageInfo;
		}

		@Override
		public IVkImageBuilder copyImmutable()
		{
			return new VkImageBuilder.ImmutableBuilder(this);
		}

		@Override
		public VkImageBuilder copy()
		{
			return new VkImageBuilder(this);
		}
	}
}
