package org.sheepy.lily.vulkan.nuklear.font.util;

import org.lwjgl.nuklear.NkUserFontGlyph;
import org.lwjgl.stb.STBTTAlignedQuad;
import org.sheepy.lily.vulkan.nuklear.font.IFontAllocator;

public class FontQueryData
{
	private final IFontAllocator fontAllocator;
	private final float fontHeight;
	private final Runnable reloadNotification = this::reload;

	private NkUserFontGlyph.Buffer patternGlyphs;

	public FontQueryData(IFontAllocator fontAllocator, float fontHeight)
	{
		this.fontAllocator = fontAllocator;
		this.fontHeight = fontHeight;
	}

	private void reload()
	{
		dispose();
		load();
	}

	public void allocate()
	{
		load();
		fontAllocator.listen(reloadNotification, IFontAllocator.Features.codepointsLoaded);
	}

	public void free()
	{
		fontAllocator.sulk(reloadNotification, IFontAllocator.Features.codepointsLoaded);
		dispose();
	}

	private void load()
	{
		final var charCount = fontAllocator.charCount();

		patternGlyphs = NkUserFontGlyph.malloc(charCount);
		final var quad = STBTTAlignedQuad.malloc();

		int index = 0;
		for (final var table : fontAllocator.getTableInfos())
		{
			final float vMetric = table.getVMetric();
			for (final var tableData : table.getTableData())
			{
				fontAllocator.fillPackedQuad(quad, index);

				final var patternGlyph = patternGlyphs.get();
				final var hMetric = tableData.hMetric;
				final float width = quad.x1() - quad.x0();
				final float height = quad.y1() - quad.y0();
				final float offsetX = quad.x0();
				final float offsetY = quad.y0() + (fontHeight + vMetric);
				final float uvx0 = quad.s0();
				final float uvy0 = quad.t0();
				final float uvx1 = quad.s1();
				final float uvy1 = quad.t1();

				patternGlyph.width(width);
				patternGlyph.height(height);
				patternGlyph.offset().set(offsetX, offsetY);
				patternGlyph.xadvance(hMetric);
				patternGlyph.uv(0).set(uvx0, uvy0);
				patternGlyph.uv(1).set(uvx1, uvy1);
				index++;
			}
		}

		patternGlyphs.flip();

		quad.free();
	}

	private void dispose()
	{
		if (patternGlyphs != null)
		{
			patternGlyphs.free();
			patternGlyphs = null;
		}
	}

	public void fill(NkUserFontGlyph ufg, int codepoint)
	{
		final int index = fontAllocator.indexOf(codepoint);
		final var glyphInfo = patternGlyphs.get(index);
		ufg.set(glyphInfo);
	}

	public float getVMetric(int codepoint)
	{
		final var tableInfos = fontAllocator.getTableInfos();
		for (int i = 0; i < tableInfos.size(); i++)
		{
			final var table = tableInfos.get(i);
			if (table.contains(codepoint))
			{
				return table.getVMetric();
			}
		}
		return 0;
	}
}
