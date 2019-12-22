package org.sheepy.lily.vulkan.resource.image;

import static org.lwjgl.vulkan.VK10.*;

import java.util.ArrayList;
import java.util.List;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.model.application.FileResource;
import org.sheepy.lily.vulkan.api.resource.ITexture2DArrayAdapter;
import org.sheepy.lily.vulkan.api.util.ImageBuffer;
import org.sheepy.lily.vulkan.model.resource.Texture2DArray;
import org.sheepy.vulkan.execution.ExecutionContext;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.resource.image.STBImageLoader;
import org.sheepy.vulkan.resource.image.VkImage;
import org.sheepy.vulkan.resource.image.VkImage.Builder;
import org.sheepy.vulkan.resource.image.VkTexture;

@Statefull
@Adapter(scope = Texture2DArray.class)
public final class Texture2DArrayAdapter implements ITexture2DArrayAdapter
{
	private final Texture2DArray textureArray;
	private final STBImageLoader imageLoader = new STBImageLoader();
	private final List<FileTextureWrapper> textureWrappers;

	public Texture2DArrayAdapter(Texture2DArray textureArray)
	{
		this.textureArray = textureArray;
		textureWrappers = List.copyOf(createTextureList());
	}

	private List<FileTextureWrapper> createTextureList()
	{
		final List<FileTextureWrapper> res = new ArrayList<>();
		final boolean mipmapEnabled = textureArray.isMipmapEnabled();

		for (final var resource : textureArray.getFiles())
		{
			res.add(new FileTextureWrapper(resource, mipmapEnabled));
		}

		return res;
	}

	@Override
	public void allocate(IExecutionContext context)
	{
		final var executionContext = (ExecutionContext) context;
		final var layout = textureArray.getInitialLayout();

		for (final var wrapper : textureWrappers)
		{
			wrapper.allocate(context);

			imageLoader.allocBuffer(wrapper.imageBuffer.getByteBuffer());
			final var buffer = imageLoader.getBuffer();

			wrapper.texture.loadImage(executionContext, buffer, layout);

			imageLoader.free();
		}
	}

	@Override
	public void free(IExecutionContext context)
	{
		for (final var wrapper : textureWrappers)
		{
			wrapper.free(context);
		}
	}

	@Override
	public List<VkTexture> getTextures()
	{
		final List<VkTexture> res = new ArrayList<>();

		for (final var wrapper : textureWrappers)
		{
			res.add(wrapper.texture);
		}

		return List.copyOf(res);
	}

	@Override
	public long[] getViewPtrs()
	{
		final int size = textureWrappers.size();
		final long[] viewPtrs = new long[size];

		for (int i = 0; i < size; i++)
		{
			final var wrapper = textureWrappers.get(i);
			viewPtrs[i] = wrapper.texture.getViewPtr();
		}
		return viewPtrs;
	}

	public static int log2nlz(int bits)
	{
		if (bits == 0) return 0;
		return 31 - Integer.numberOfLeadingZeros(bits);
	}

	private static final class FileTextureWrapper
	{
		private final VkTexture texture;
		private final ImageBuffer imageBuffer;
		private final boolean mipmapEnabled;

		public FileTextureWrapper(FileResource resource, boolean mipmapEnabled)
		{
			this.mipmapEnabled = mipmapEnabled;
			this.imageBuffer = new ImageBuffer(resource);
			imageBuffer.allocate();

			final var imageBuilder = createBuilder();
			this.texture = new VkTexture(imageBuilder);
		}

		public void allocate(IExecutionContext context)
		{
			texture.allocate(context);
		}

		public void free(IExecutionContext context)
		{
			imageBuffer.free();
			texture.free(context);
		}

		private Builder createBuilder()
		{
			final var size = imageBuffer.getImageSize();
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
			imageBuilder.tiling(VK_IMAGE_TILING_OPTIMAL);
			imageBuilder.mipLevels(mipLevels);

			return imageBuilder.copyImmutable();
		}
	}
}
