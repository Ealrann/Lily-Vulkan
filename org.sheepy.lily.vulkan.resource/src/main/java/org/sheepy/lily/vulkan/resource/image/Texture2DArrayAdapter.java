package org.sheepy.lily.vulkan.resource.image;

import java.util.ArrayList;
import java.util.List;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.model.application.FileResource;
import org.sheepy.lily.vulkan.api.resource.ITextureArrayAdapter;
import org.sheepy.lily.vulkan.api.util.ImageBuffer;
import org.sheepy.lily.vulkan.model.resource.Texture2DArray;
import org.sheepy.vulkan.execution.ExecutionContext;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.image.ImageInfo;
import org.sheepy.vulkan.resource.image.STBImageLoader;
import org.sheepy.vulkan.resource.image.VkImage;
import org.sheepy.vulkan.resource.image.VkImage.Builder;
import org.sheepy.vulkan.resource.image.VkTexture;

@Statefull
@Adapter(scope = Texture2DArray.class)
public final class Texture2DArrayAdapter implements ITextureArrayAdapter
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

		for (final var resource : textureArray.getFiles())
		{
			res.add(new FileTextureWrapper(textureArray, resource));
		}

		return res;
	}

	@Override
	public void allocate(IExecutionContext context)
	{
		final var executionContext = (ExecutionContext) context;

		for (final var wrapper : textureWrappers)
		{
			wrapper.allocate(context);

			imageLoader.allocBuffer(wrapper.imageBuffer.getByteBuffer());
			final var buffer = imageLoader.getBuffer();

			wrapper.texture.loadImage(executionContext, buffer);

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

	private static final class FileTextureWrapper
	{
		private final VkTexture texture;
		private final ImageBuffer imageBuffer;

		public FileTextureWrapper(Texture2DArray textureArray, FileResource resource)
		{
			this.imageBuffer = new ImageBuffer(resource);
			imageBuffer.allocate();

			final var imageBuilder = createBuilder(textureArray);
			this.texture = new VkTexture(imageBuilder, textureArray.isMipmapEnabled());
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

		private Builder createBuilder(ImageInfo info)
		{
			final var size = imageBuffer.getImageSize();
			final int width = size.x();
			final int height = size.y();

			return new VkImage.VkImageBuilder(info, width, height);
		}
	}
}
