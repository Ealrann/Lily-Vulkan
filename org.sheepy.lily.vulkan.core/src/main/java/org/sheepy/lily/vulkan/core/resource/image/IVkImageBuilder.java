package org.sheepy.lily.vulkan.core.resource.image;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkImageCreateInfo;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.api.debug.IVulkanDebugService;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.core.execution.IRecordContext;
import org.sheepy.lily.vulkan.core.resource.ImagePointer;
import org.sheepy.lily.vulkan.core.resource.memory.Memory;
import org.sheepy.lily.vulkan.core.resource.memory.MemoryBuilder;
import org.sheepy.lily.vulkan.core.util.Logger;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.stream.Stream;

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
	EImageLayout initialLayout();
	IVkImageBuilder copyImmutable();
	VkImageBuilder copy();
	String name();

	ImageBackend build(IRecordContext context);
	VkImage buildNoFill(IVulkanContext context);

	abstract class AbstractVkImageBuilder implements IVkImageBuilder
	{
		private static final String CREATE_ERROR = "Failed to create image!";
		private static final String IMAGE_PREFIX = "[Image]";

		@Override
		public VkImage buildNoFill(IVulkanContext context)
		{
			final long imagePtr = allocateImage(context, name());
			final var res = new VkImage(imagePtr,
										width(),
										height(),
										format(),
										usage(),
										tiling(),
										mipLevels(),
										initialLayout(),
										aspect());
			return res;
		}

		@Override
		public ImageBackend build(IRecordContext context)
		{
			final var info = new Memory.Info(false, true);
			final var memoryBuilder = new MemoryBuilder(info);
			final var imagePtr = new ImagePointer(allocateImage(context, name()));
			final var vkImage = new VkImage(imagePtr.ptr(),
											width(),
											height(),
											format(),
											usage(),
											tiling(),
											mipLevels(),
											initialLayout(),
											aspect());
			final var memory = memoryBuilder.build(context, Stream.of(imagePtr));
			final var size = memory.resources().get(0).size();
			final var res = new ImageBackend(vkImage, size, memory);

			if (fillWith() != null) res.fillWith(context, fillWith());
			else if (fillWithZero()) res.fillWithZero(context, size);

			if (initialLayout() != null)
			{
				res.transitionToInitialLayout(context.stack(),
											  context.vkCommandBuffer(),
											  EPipelineStage.TOP_OF_PIPE_BIT,
											  EImageLayout.UNDEFINED,
											  Collections.emptyList());
			}

			return res;
		}

		private long allocateImage(IVulkanContext context, String name) throws AssertionError
		{
			final var stack = context.stack();
			final var device = context.getVkDevice();

			final VkImageCreateInfo imageInfo = allocateInfo(stack);
			final long[] aImageId = new long[1];
			Logger.check(vkCreateImage(device, imageInfo, null, aImageId), CREATE_ERROR);
			final long imagePtr = aImageId[0];
			if (DebugUtil.DEBUG_ENABLED) IVulkanDebugService.INSTANCE.register(imagePtr, IMAGE_PREFIX + name);
			return imagePtr;
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
