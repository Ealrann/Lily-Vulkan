package org.sheepy.lily.vulkan.resource.font;

import java.util.ArrayList;
import java.util.List;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.model.ui.Font;
import org.sheepy.lily.vulkan.api.resource.ITextureArrayAdapter;
import org.sheepy.lily.vulkan.api.resource.font.IFontAdapter;
import org.sheepy.lily.vulkan.model.resource.FontTextureArray;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.image.ImageInfo;
import org.sheepy.vulkan.resource.image.VkTexture;

@Statefull
@Adapter(scope = FontTextureArray.class)
public final class FontTextureArrayAdapter implements ITextureArrayAdapter
{
	private final FontTextureArray fontArray;
	private final List<FileTextureWrapper> textureWrappers;
	private final List<Font> fonts;

	public FontTextureArrayAdapter(FontTextureArray fontArray)
	{
		fonts = fontArray.getFonts();
		this.fontArray = fontArray;
		textureWrappers = List.copyOf(createTextureList());
	}

	private List<FileTextureWrapper> createTextureList()
	{
		final List<FileTextureWrapper> res = new ArrayList<>();

		for (final var font : fonts)
		{
			res.add(new FileTextureWrapper(font));
		}

		return res;
	}

	@Override
	public void allocate(IExecutionContext context)
	{
		for (final var wrapper : textureWrappers)
		{
			wrapper.allocate(context, fontArray);
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
			res.add(wrapper.getTexture());
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
			viewPtrs[i] = wrapper.getTexture().getViewPtr();
		}
		return viewPtrs;
	}

	private static final class FileTextureWrapper
	{
		private final Font font;
		private IFontAdapter adapter;

		public FileTextureWrapper(Font font)
		{
			this.font = font;
		}

		public void allocate(IExecutionContext context, ImageInfo info)
		{
			adapter = font.adapt(IFontAdapter.class);
			adapter.allocate(context, info);
		}

		public void free(IExecutionContext context)
		{
			adapter.free(context);
			adapter = null;
		}

		public VkTexture getTexture()
		{
			return adapter.getTexture();
		}
	}
}
