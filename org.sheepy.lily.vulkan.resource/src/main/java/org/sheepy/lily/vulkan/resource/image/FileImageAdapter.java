package org.sheepy.lily.vulkan.resource.image;

import static org.lwjgl.vulkan.VK10.*;

import org.joml.Vector2ic;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.resource.IImageAdapter;
import org.sheepy.lily.vulkan.api.util.ImageBuffer;
import org.sheepy.lily.vulkan.model.resource.FileImage;
import org.sheepy.vulkan.execution.ExecutionContext;
import org.sheepy.vulkan.execution.IExecutionContext;
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
	private final FileImage image;
	private final ImageBuffer imageBuffer;

	public FileImageAdapter(FileImage image)
	{
		this.image = image;
		imageBuffer = new ImageBuffer(image.getFile());
		imageBuffer.allocate();
		final var imageBuilder = createBuilder(imageBuffer.getImageSize(), image.isMipmapEnabled());

		vkTexture = new VkTexture(imageBuilder);
	}

	@Dispose
	public void dispose()
	{
		// if this FileImageAdapter was never allocated,
		// we still kept the buffer allocation in constructor
		imageBuffer.free();
	}

	private static Builder createBuilder(Vector2ic size, boolean mipmapEnabled)
	{
		final int width = size.x();
		final int height = size.y();

		final int mipLevels = mipmapEnabled
				? (int) Math.floor(log2nlz(Math.max(width, height))) + 1
				: 1;

		final int format = VK_FORMAT_R8G8B8A8_UNORM;
		final int usage = VK_IMAGE_USAGE_TRANSFER_SRC_BIT
				| VK_IMAGE_USAGE_TRANSFER_DST_BIT
				| VK_IMAGE_USAGE_SAMPLED_BIT;

		final var imageBuilder = VkImage.newBuilder(width, height, format);
		imageBuilder.usage(usage);
		imageBuilder.properties(VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT);
		imageBuilder.tiling(VK_IMAGE_TILING_OPTIMAL);
		imageBuilder.mipLevels(mipLevels);

		return imageBuilder.copyImmutable();
	}

	@Override
	public void allocate(IExecutionContext context)
	{
		final var executionContext = (ExecutionContext) context;
		final var layout = image.getInitialLayout();

		imageBuffer.allocate();
		imageLoader.allocBuffer(imageBuffer.getByteBuffer());
		vkTexture.allocate(context);
		vkTexture.loadImage(executionContext, imageLoader.getBuffer(), layout);

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
