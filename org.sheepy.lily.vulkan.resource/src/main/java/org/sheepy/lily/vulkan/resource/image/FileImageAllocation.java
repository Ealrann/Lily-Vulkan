package org.sheepy.lily.vulkan.resource.image;

import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.resource.IVkImageAllocation;
import org.sheepy.lily.vulkan.core.resource.image.IVkImageBuilder;
import org.sheepy.lily.vulkan.core.resource.image.VkImage;
import org.sheepy.lily.vulkan.core.resource.image.VkImageBuilder;
import org.sheepy.lily.vulkan.model.resource.FileImage;
import org.sheepy.lily.vulkan.resource.image.backend.ImageBuffer;
import org.sheepy.lily.vulkan.resource.image.backend.STBImageLoader;
import org.sheepy.lily.vulkan.resource.image.backend.VkTexture;
import org.sheepy.vulkan.model.enumeration.EImageUsage;

@ModelExtender(scope = FileImage.class)
@Allocation(context = ExecutionContext.class)
public class FileImageAllocation implements IVkImageAllocation
{
	private final ImageBuffer imageBuffer;
	private final VkTexture vkTexture;

	public FileImageAllocation(FileImage image, ExecutionContext context)
	{
		imageBuffer = new ImageBuffer(image.getFile());
		imageBuffer.allocate();

		final var executionContext = context;

		final var imageBuilder = createBuilder(image, imageBuffer.getImageSize());
		vkTexture = new VkTexture(imageBuilder, image.isMipmapEnabled());

		imageBuffer.allocate();

		final var imageLoader = new STBImageLoader();
		imageLoader.allocBuffer(imageBuffer.getByteBuffer());
		vkTexture.allocate(context);
		vkTexture.loadImage(executionContext, imageLoader.getBuffer());

		imageBuffer.free();
		imageLoader.free();
	}

	@Dispose
	public void dispose()
	{
		// if this FileImageAdapter was never allocated,
		// we still kept the buffer allocation in constructor
		imageBuffer.free();
	}

	private static IVkImageBuilder createBuilder(FileImage image, Vector2ic size)
	{
		final int width = size.x();
		final int height = size.y();

		final int mipLevels = image.isMipmapEnabled() ? (int) Math.floor(log2nlz(Math.max(width, height))) + 1 : 1;

		final var imageBuilder = new VkImageBuilder(image, width, height);
		imageBuilder.mipLevels(mipLevels);
		imageBuilder.addUsage(EImageUsage.TRANSFER_DST_VALUE);

		return imageBuilder.copyImmutable();
	}

	@Free
	public void free(ExecutionContext context)
	{
		vkTexture.free(context);
	}

	@Override
	public VkImage getVkImage()
	{
		return vkTexture.getImage();
	}

	@Override
	public long getImagePtr()
	{
		return vkTexture.getImagePtr();
	}

	@Override
	public long getMemoryPtr()
	{
		return vkTexture.getMemoryPtr();
	}

	@Override
	public long getViewPtr()
	{
		return vkTexture.getViewPtr();
	}

	@Override
	public Vector2ic getSize()
	{
		final var vkImage = getVkImage();
		return new Vector2i(vkImage.width, vkImage.height);
	}

	public static int log2nlz(int bits)
	{
		if (bits == 0) return 0;
		return 31 - Integer.numberOfLeadingZeros(bits);
	}
}
