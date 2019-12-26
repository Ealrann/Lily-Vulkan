package org.sheepy.lily.vulkan.resource.image;

import org.joml.Vector2ic;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.resource.IImageAdapter;
import org.sheepy.lily.vulkan.api.util.ImageBuffer;
import org.sheepy.lily.vulkan.model.resource.FileImage;
import org.sheepy.vulkan.execution.ExecutionContext;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.enumeration.EImageUsage;
import org.sheepy.vulkan.resource.image.STBImageLoader;
import org.sheepy.vulkan.resource.image.VkImage;
import org.sheepy.vulkan.resource.image.VkImage.Builder;
import org.sheepy.vulkan.resource.image.VkTexture;

@Statefull
@Adapter(scope = FileImage.class)
public class FileImageAdapter implements IImageAdapter
{
	private final STBImageLoader imageLoader = new STBImageLoader();
	private final VkTexture vkTexture;
	private final ImageBuffer imageBuffer;

	public FileImageAdapter(FileImage image)
	{
		imageBuffer = new ImageBuffer(image.getFile());
		imageBuffer.allocate();
		final var imageBuilder = createBuilder(image, imageBuffer.getImageSize());
		vkTexture = new VkTexture(imageBuilder, image.isMipmapEnabled());
	}

	@Dispose
	public void dispose()
	{
		// if this FileImageAdapter was never allocated,
		// we still kept the buffer allocation in constructor
		imageBuffer.free();
	}

	private static Builder createBuilder(FileImage image, Vector2ic size)
	{
		final int width = size.x();
		final int height = size.y();

		final int mipLevels = image.isMipmapEnabled()
				? (int) Math.floor(log2nlz(Math.max(width, height))) + 1
				: 1;

		final var imageBuilder = new VkImage.VkImageBuilder(image, width, height);
		imageBuilder.mipLevels(mipLevels);
		imageBuilder.addUsage(EImageUsage.TRANSFER_DST_VALUE);

		return imageBuilder.copyImmutable();
	}

	@Override
	public void allocate(IExecutionContext context)
	{
		final var executionContext = (ExecutionContext) context;

		imageBuffer.allocate();
		imageLoader.allocBuffer(imageBuffer.getByteBuffer());
		vkTexture.allocate(context);
		vkTexture.loadImage(executionContext, imageLoader.getBuffer());

		imageBuffer.free();
		imageLoader.free();
	}

	@Override
	public void free(IExecutionContext context)
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

	public static int log2nlz(int bits)
	{
		if (bits == 0) return 0;
		return 31 - Integer.numberOfLeadingZeros(bits);
	}
}
