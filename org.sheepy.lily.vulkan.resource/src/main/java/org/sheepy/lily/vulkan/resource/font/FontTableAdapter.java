package org.sheepy.lily.vulkan.resource.font;

import static org.lwjgl.stb.STBTruetype.*;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.stb.STBTTFontinfo;
import org.lwjgl.stb.STBTTPackContext;
import org.lwjgl.stb.STBTTPackedchar.Buffer;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.resource.IFileResourceAdapter;
import org.sheepy.lily.core.model.ui.Font;
import org.sheepy.lily.core.model.ui.FontTable;
import org.sheepy.lily.vulkan.api.resource.font.IFontTableAdapter;
import org.sheepy.lily.vulkan.resource.font.util.FontUtil;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.log.Logger;
import org.sheepy.vulkan.model.image.ImageInfo;

@Statefull
@Adapter(scope = FontTable.class)
public class FontTableAdapter implements IFontTableAdapter
{
	public static final int BUFFER_WIDTH = 1024;
	public static final int BUFFER_HEIGHT = 1024;

	private final FontTable fontTable;
	private final List<Table> tables = new ArrayList<>();
	private final int[] hMetric = new int[1];
	private final float height;

	private float fontVMetric;
	private float scale;
	private int charCount;

	private STBTTFontinfo fontInfo;
	private ByteBuffer ttfBuffer;

	private FontTableAdapter(FontTable fontTable)
	{
		this.fontTable = fontTable;
		height = ((Font) fontTable.eContainer()).getHeight();
	}

	@Override
	public void allocate(IExecutionContext context, ImageInfo info)
	{
		final var stack = context.stack();
		final var file = fontTable.getFile();
		final var fileAdapter = file.adapt(IFileResourceAdapter.class);

		ttfBuffer = fileAdapter.allocByteBuffer(file);
		fontInfo = STBTTFontinfo.calloc();
		stbtt_InitFont(fontInfo, ttfBuffer);
		scale = stbtt_ScaleForPixelHeight(fontInfo, height);

		final IntBuffer a = stack.mallocInt(1);
		final IntBuffer d = stack.mallocInt(1);
		final IntBuffer l = stack.mallocInt(1);
		stbtt_GetFontVMetrics(fontInfo, a, d, l);
		fontVMetric = d.get(0) * scale;

		charCount = 0;
		for (final var tableType : fontTable.getCharTables())
		{
			final int start = FontUtil.getStartCodePoint(tableType);
			final int tableLength = FontUtil.getTableLength(tableType);
			final Table table = new Table(start, tableLength);
			charCount += tableLength;
			tables.add(table);
		}
	}

	@Override
	public void free(IExecutionContext context)
	{
		fontInfo.free();
		MemoryUtil.memFree(ttfBuffer);
		tables.clear();

		fontVMetric = 0;
		charCount = 0;
		scale = 0;
		fontInfo = null;
		ttfBuffer = null;
	}

	@Override
	public void pack(STBTTPackContext pc, Buffer buffer)
	{
		int offset = 0;
		for (final var table : tables)
		{
			final var subData = buffer.slice(offset, table.length);
			if (stbtt_PackFontRange(pc,
									ttfBuffer,
									0,
									height,
									table.firstCodepoint,
									subData) == false)
			{
				Logger.log("Fail to pack the font");
			}
			offset += table.length;
		}
	}

	@Override
	public boolean contains(int codepoint)
	{
		for (int i = 0; i < tables.size(); i++)
		{
			final Table table = tables.get(i);
			if (table.contains(codepoint))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public int getCharCount()
	{
		return charCount;
	}

	@Override
	public int indexOf(int codepoint)
	{
		int res = 0;
		for (int i = 0; i < tables.size(); i++)
		{
			final Table table = tables.get(i);
			if (table.contains(codepoint))
			{
				res += codepoint - table.firstCodepoint;
				break;
			}
			else
			{
				res += table.length;
			}
		}
		return res;
	}

	@Override
	public float getCodepointHMetric(int codePoint)
	{
		stbtt_GetCodepointHMetrics(fontInfo, codePoint, hMetric, null);
		return hMetric[0] * scale;
	}

	@Override
	public float getCodepointKernAdvance(int codePoint, int nextCodePoint)
	{
		final int kern = stbtt_GetCodepointKernAdvance(fontInfo, codePoint, nextCodePoint);
		return kern * scale;
	}

	@Override
	public float getVMetric()
	{
		return fontVMetric;
	}

	private static final class Table
	{
		private final int firstCodepoint;
		private final int length;

		public Table(int firstCodepoint, int length)
		{
			this.firstCodepoint = firstCodepoint;
			this.length = length;
		}

		public boolean contains(int codepoint)
		{
			return codepoint >= firstCodepoint && codepoint < firstCodepoint + length;
		}
	}
}
