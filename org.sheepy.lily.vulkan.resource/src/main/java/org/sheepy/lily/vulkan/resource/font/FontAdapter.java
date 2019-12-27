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
import org.sheepy.lily.core.model.ui.Font;
import org.sheepy.lily.vulkan.api.resource.font.IFontAdapter;
import org.sheepy.lily.vulkan.api.resource.font.IFontTableAdapter;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.image.ImageInfo;
import org.sheepy.vulkan.resource.image.VkImage;
import org.sheepy.vulkan.resource.image.VkTexture;

@Statefull
@Adapter(scope = Font.class)
public final class FontAdapter implements IFontAdapter
{
	private static final int BASE_FONTIMAGE_WIDTH = 128;
	private static final int BASE_FONTIMAGE_HEIGHT = 128;
	private static final int H_OVERSAMPLING = 4;
	private static final int V_OVERSAMPLING = 4;

	private final Font font;
	private final List<IFontTableAdapter> adapters = new ArrayList<>();
	private final float[] X = new float[1];
	private final float[] Y = new float[1];
	private final int bufferWidth;
	private final int bufferHeight;

	private int charCount = 0;
	private STBTTPackedchar.Buffer cdata;
	private VkTexture texture;

	private FontAdapter(Font font)
	{
		this.font = font;

		int tableCount = 0;
		for (final var table : font.getTables())
		{
			tableCount += table.getCharTables().size();
		}

		bufferWidth = BASE_FONTIMAGE_WIDTH * H_OVERSAMPLING * tableCount;
		bufferHeight = BASE_FONTIMAGE_HEIGHT * V_OVERSAMPLING * tableCount;
	}

	@Override
	public void allocate(IExecutionContext context, ImageInfo info)
	{
		int size = 0;
		for (final var fontTable : font.getTables())
		{
			final var adapter = fontTable.adapt(IFontTableAdapter.class);
			adapter.allocate(context, info);
			size += adapter.getCharCount();
			adapters.add(adapter);
		}

		final var builder = new VkImage.VkImageBuilder(info, bufferWidth, bufferHeight);

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
			for (final var tableAdapter : adapters)
			{
				final int count = tableAdapter.getCharCount();
				final var subData = cdata.slice(offset, count);
				tableAdapter.pack(pc, subData);
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
		for (final var adapter : adapters)
		{
			adapter.free(context);
		}
		adapters.clear();

		texture.free(context);
		cdata.free();

		charCount = 0;
		texture = null;
		cdata = null;
	}

	@Override
	public IFontTableAdapter getTableAdapter(int codepoint)
	{
		for (int i = 0; i < adapters.size(); i++)
		{
			final var adapter = adapters.get(i);
			if (adapter.contains(codepoint))
			{
				return adapter;
			}
		}
		return null;
	}

	@Override
	public boolean contains(int codepoint)
	{
		for (int i = 0; i < adapters.size(); i++)
		{
			final var adapter = adapters.get(i);
			if (adapter.contains(codepoint))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public int indexOf(int codepoint)
	{
		for (int i = 0; i < adapters.size(); i++)
		{
			final var adapter = adapters.get(i);
			if (adapter.contains(codepoint))
			{
				return adapter.indexOf(codepoint);
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
		for (int i = 0; i < adapters.size(); i++)
		{
			final var tableAdapter = adapters.get(i);
			if (tableAdapter.contains(codePoint))
			{
				index += tableAdapter.indexOf(codePoint);
				X[0] = 0f;
				Y[0] = 0f;
				stbtt_GetPackedQuad(cdata, bufferWidth, bufferHeight, index, X, Y, quad, false);
				break;
			}
			else
			{
				index += tableAdapter.getCharCount();
			}
		}
	}
}
