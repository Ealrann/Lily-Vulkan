package org.sheepy.lily.vulkan.resource.font;

import static org.lwjgl.stb.STBTruetype.*;
import static org.lwjgl.system.MemoryUtil.*;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.stb.STBTTAlignedQuad;
import org.lwjgl.stb.STBTTPackContext;
import org.lwjgl.stb.STBTTPackedchar;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.resource.font.IFontImageAdapter;
import org.sheepy.lily.vulkan.api.resource.font.IFontTableInfo;
import org.sheepy.lily.vulkan.model.resource.FontImage;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.resource.image.VkImage;
import org.sheepy.vulkan.resource.image.VkTexture;

@Statefull
@Adapter(scope = FontImage.class)
public final class FontImageAdapter implements IFontImageAdapter
{
	private static final int BASE_FONTIMAGE_WIDTH = 128;
	private static final int BASE_FONTIMAGE_HEIGHT = 128;
	private static final int H_OVERSAMPLING = 4;
	private static final int V_OVERSAMPLING = 4;

	private final FontImage fontImage;
	private final List<FontTableAllocator> tableAllocators = new ArrayList<>();
	private final float[] X = new float[1];
	private final float[] Y = new float[1];
	private final int bufferWidth;
	private final int bufferHeight;

	private int charCount = 0;
	private STBTTPackedchar.Buffer cdata;
	private VkTexture texture;

	private FontImageAdapter(FontImage fontImage)
	{
		this.fontImage = fontImage;
		final var font = fontImage.getFont();

		int tableCount = 0;
		for (final var table : font.getTables())
		{
			tableCount += table.getCharTables().size();
		}

		bufferWidth = BASE_FONTIMAGE_WIDTH * H_OVERSAMPLING * tableCount;
		bufferHeight = BASE_FONTIMAGE_HEIGHT * V_OVERSAMPLING * tableCount;
	}

	@Override
	public void allocate(IExecutionContext context)
	{
		final var font = fontImage.getFont();
		int size = 0;
		for (final var fontTable : font.getTables())
		{
			final var tableAllocator = new FontTableAllocator(fontTable);
			tableAllocator.allocate(context);
			size += tableAllocator.getCharCount();
			tableAllocators.add(tableAllocator);
		}

		final var builder = new VkImage.VkImageBuilder(fontImage, bufferWidth, bufferHeight);

		texture = new VkTexture(builder, false);
		texture.allocate(context);
		cdata = STBTTPackedchar.calloc(size);

		ByteBuffer bitmap = null;
		final ByteBuffer textureData = null;
		try
		{
			bitmap = memAlloc(bufferWidth * bufferHeight);

			final STBTTPackContext pc = STBTTPackContext.mallocStack(context.stack());
			stbtt_PackBegin(pc, bitmap, bufferWidth, bufferHeight, 0, 1, NULL);
			stbtt_PackSetOversampling(pc, 4, 4);

			int offset = 0;
			for (final var tableAllocator : tableAllocators)
			{
				final int count = tableAllocator.getCharCount();
				final var subData = cdata.slice(offset, count);
				tableAllocator.pack(pc, subData);
				offset += count;
			}
			charCount = offset;
			stbtt_PackEnd(pc);

			texture.loadImage(context, bitmap);

		} catch (final Exception e)
		{
			e.printStackTrace();
		} finally
		{
			if (bitmap != null) memFree(bitmap);
			if (textureData != null) memFree(textureData);
		}
	}

	@Override
	public void free(IExecutionContext context)
	{
		for (final var tableAllocator : tableAllocators)
		{
			tableAllocator.free(context);
		}
		tableAllocators.clear();

		texture.free(context);
		cdata.free();

		charCount = 0;
		texture = null;
		cdata = null;
	}

	@Override
	public IFontTableInfo getTableInfo(int codepoint)
	{
		for (int i = 0; i < tableAllocators.size(); i++)
		{
			final var allocator = tableAllocators.get(i);
			if (allocator.contains(codepoint))
			{
				return allocator;
			}
		}
		return null;
	}

	@Override
	public boolean contains(int codepoint)
	{
		for (int i = 0; i < tableAllocators.size(); i++)
		{
			final var allocator = tableAllocators.get(i);
			if (allocator.contains(codepoint))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public int indexOf(int codepoint)
	{
		for (int i = 0; i < tableAllocators.size(); i++)
		{
			final var allocator = tableAllocators.get(i);
			if (allocator.contains(codepoint))
			{
				return allocator.indexOf(codepoint);
			}
		}
		return -1;
	}

	@Override
	public int charCount()
	{
		return charCount;
	}

	@Override
	public VkTexture getTexture()
	{
		return texture;
	}

	@Override
	public void fillPackedQuad(STBTTAlignedQuad quad, int codePoint)
	{
		int index = 0;
		for (int i = 0; i < tableAllocators.size(); i++)
		{
			final var tableAllocator = tableAllocators.get(i);
			if (tableAllocator.contains(codePoint))
			{
				index += tableAllocator.indexOf(codePoint);
				X[0] = 0f;
				Y[0] = 0f;
				stbtt_GetPackedQuad(cdata, bufferWidth, bufferHeight, index, X, Y, quad, false);
				break;
			}
			else
			{
				index += tableAllocator.getCharCount();
			}
		}
	}

	@Override
	public VkImage getVkImage()
	{
		return texture.getImage();
	}

	@Override
	public long getImagePtr()
	{
		return texture.getImagePtr();
	}

	@Override
	public long getViewPtr()
	{
		return texture.getViewPtr();
	}

	@Override
	public long getMemoryPtr()
	{
		return texture.getMemoryPtr();
	}
}
