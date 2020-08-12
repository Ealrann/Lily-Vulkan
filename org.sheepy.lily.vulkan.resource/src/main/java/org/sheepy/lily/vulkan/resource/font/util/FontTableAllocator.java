package org.sheepy.lily.vulkan.resource.font.util;

import org.lwjgl.stb.STBTTFontinfo;
import org.lwjgl.stb.STBTTPackContext;
import org.lwjgl.stb.STBTTPackedchar;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.resource.IFileResourceAdapter;
import org.sheepy.lily.core.model.ui.Font;
import org.sheepy.lily.core.model.ui.FontTable;
import org.sheepy.lily.vulkan.core.resource.font.IFontTableInfo;
import org.sheepy.lily.vulkan.core.util.Logger;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.lwjgl.stb.STBTruetype.*;

public final class FontTableAllocator implements IFontTableInfo
{
	private final FontTable fontTable;
	private final List<CodepointTable> tables;
	private final int[] hMetric = new int[1];
	private final float height;

	private float fontVMetric;
	private float scale;
	private int charCount;

	private STBTTFontinfo fontInfo;
	private ByteBuffer ttfBuffer;

	public FontTableAllocator(FontTable fontTable)
	{
		this.fontTable = fontTable;
		height = ((Font) fontTable.eContainer()).getHeight();
		this.tables = List.copyOf(buildTables(fontTable));
	}

	public void allocate(MemoryStack stack)
	{
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
	}

	public void free()
	{
		fontInfo.free();
		MemoryUtil.memFree(ttfBuffer);

		fontVMetric = 0;
		charCount = 0;
		scale = 0;
		fontInfo = null;
		ttfBuffer = null;
	}

	public CodepointDispatch prepare(int[] codepoints)
	{
		return new CodepointDispatch(tables, codepoints);
	}

	public void pack(STBTTPackContext pc, STBTTPackedchar.Buffer cdata, CodepointDispatch dispatch)
	{
		charCount = 0;
		int bufferOffset = 0;
		for (int j = 0; j < tables.size(); j++)
		{
			final var table = tables.get(j);
			final var codepoints = dispatch.getCodepoints(table);

			if (codepoints != null)
			{
				for (int i = 0; i < codepoints.length; i++)
				{
					final int codepoint = codepoints[i];
					final var subData = cdata.slice(bufferOffset++, 1);
					if (stbtt_PackFontRange(pc, ttfBuffer, 0, height, codepoint, subData) == false)
					{
						logFail();
					}
					charCount += 1;
					table.loadChar(codepoint, getCodepointHMetric(codepoint));
				}
			}
		}
	}

	public void clear()
	{
		for (int j = 0; j < tables.size(); j++)
		{
			final var table = tables.get(j);
			table.clear();
		}
	}

	private static void logFail()
	{
		Logger.log("Fail to pack the font");
	}

	@Override
	public boolean contains(int codepoint)
	{
		for (int i = 0; i < tables.size(); i++)
		{
			final CodepointTable table = tables.get(i);
			if (table.contains(codepoint))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public int getLoadedCharCount()
	{
		return charCount;
	}

	@Override
	public int indexOf(int codepoint)
	{
		int res = 0;
		for (int i = 0; i < tables.size(); i++)
		{
			final CodepointTable table = tables.get(i);
			if (table.contains(codepoint))
			{
				res += table.indexOf(codepoint);
				break;
			}
			else
			{
				res += table.loadedChars.size();
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

	@Override
	public List<TableData> getTableData()
	{
		final List<TableData> res = new ArrayList<>(getLoadedCharCount());
		for (int i = 0; i < tables.size(); i++)
		{
			final CodepointTable table = tables.get(i);
			res.addAll(table.loadedChars);
		}
		return res;
	}

	private static List<CodepointTable> buildTables(FontTable fontTable)
	{
		final List<CodepointTable> tables = new ArrayList<>();
		for (final var tableType : fontTable.getCharTables())
		{
			final int start = FontUtil.getStartCodePoint(tableType);
			final int tableLength = FontUtil.getTableLength(tableType);
			final CodepointTable table = new CodepointTable(start, tableLength);
			tables.add(table);
		}
		tables.sort(Comparator.comparingInt(t -> t.firstCodepoint));
		return tables;
	}
}
