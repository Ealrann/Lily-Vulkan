package org.sheepy.lily.vulkan.nuklear.util;

import static org.lwjgl.nuklear.Nuklear.*;
import static org.lwjgl.system.MemoryUtil.memAddress;

import java.nio.IntBuffer;
import java.util.Objects;

import org.lwjgl.nuklear.NkTextWidthCallback;
import org.lwjgl.nuklear.NkUserFont;
import org.lwjgl.nuklear.NkUserFontGlyph;
import org.lwjgl.stb.STBTTAlignedQuad;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.api.resource.font.IFontImageAdapter;
import org.sheepy.lily.vulkan.model.resource.FontImage;

public final class NkFontLoader
{
	public final FontImage fontImage;

	private final NkUserFont nkFont;
	private final float fontHeight;

	private IntBuffer unicode;
	private IntBuffer advanceWidth;
	private long unicodePtr;
	private IFontImageAdapter fontAdapter;
	private STBTTAlignedQuad quad;
	private QueryData[] queryDatas;

	public NkFontLoader(FontImage fontImage, float fontHeight)
	{
		this.fontImage = fontImage;
		this.fontHeight = fontHeight;
		nkFont = NkUserFont.create();
	}

	public void allocate()
	{
		fontAdapter = fontImage.adapt(IFontImageAdapter.class);
		queryDatas = new QueryData[fontAdapter.charCount()];

		unicode = MemoryUtil.memAllocInt(1);
		advanceWidth = MemoryUtil.memAllocInt(1);
		unicodePtr = memAddress(unicode);

		quad = STBTTAlignedQuad.calloc();

		nkFont.width(new TextWidthCallback());
		nkFont.height(fontHeight);
		nkFont.query((handle, font_height, glyph, codepoint, next_codepoint) ->
		{
			final QueryData queryData = getOrCreateQueryData(codepoint);
			final NkUserFontGlyph ufg = NkUserFontGlyph.create(glyph);

			final var tableAdapter = fontAdapter.getTableInfo(codepoint);
			final float kern = tableAdapter.getCodepointKernAdvance(codepoint, next_codepoint);

			queryData.fill(ufg);
			ufg.xadvance(ufg.xadvance() + kern);
		});
		nkFont.texture(it -> it.ptr(fontAdapter.getTexture().getViewPtr()));
	}

	public void free()
	{
		for (int i = 0; i < queryDatas.length; i++)
		{
			final var queryData = queryDatas[i];
			if (queryData != null)
			{
				queryData.free();
			}
		}

		Objects.requireNonNull(nkFont.query()).free();
		Objects.requireNonNull(nkFont.width()).free();

		MemoryUtil.memFree(unicode);
		MemoryUtil.memFree(advanceWidth);
		quad.free();
		fontAdapter = null;
	}

	public NkUserFont getNkFont()
	{
		return nkFont;
	}

	private QueryData getOrCreateQueryData(int codepoint)
	{
		if (fontAdapter.contains(codepoint) == false)
		{
			return getOrCreateQueryData(getUnknownCharacter(codepoint));
		}

		final int index = fontAdapter.indexOf(codepoint);
		if (queryDatas[index] == null)
		{
			queryDatas[index] = createQueryData(codepoint);
		}

		return queryDatas[index];
	}

	private QueryData createQueryData(int codepoint)
	{
		final int codeToQuery = codepoint;

		final var tableAdapter = fontAdapter.getTableInfo(codeToQuery);
		fontAdapter.fillPackedQuad(quad, codeToQuery);
		final var hMetric = tableAdapter.getCodepointHMetric(codeToQuery);
		final var vMetric = tableAdapter.getVMetric();

		return new QueryData(quad, hMetric, vMetric);
	}

	private static int getUnknownCharacter(int codepoint)
	{
		int codeToQuery;
		if (DebugUtil.DEBUG_ENABLED)
		{
			System.err.println("Character not found: " + codepoint);
		}
		codeToQuery = 63;
		return codeToQuery;
	}

	private final class QueryData
	{
		private final NkUserFontGlyph patternGlyph = NkUserFontGlyph.calloc();
		private final float hMetric;

		QueryData(STBTTAlignedQuad quad, float hMetric, float vMetric)
		{
			this.hMetric = hMetric;

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
		}

		public void free()
		{
			patternGlyph.free();
		}

		public void fill(NkUserFontGlyph ufg)
		{
			ufg.set(patternGlyph);
		}
	}

	private final class TextWidthCallback extends NkTextWidthCallback
	{
		@Override
		public float invoke(long handle, float height, long text, int length)
		{
			float textWidth = 0;
			int position = 0;

			while (position < length)
			{
				final int currentGlyphLength = nnk_utf_decode(text + position, unicodePtr, 1);
				final int codepoint = unicode.get(0);
				position += currentGlyphLength;

				if (currentGlyphLength == 0)
				{
					position++;
					continue;
				}
				else if (codepoint == NK_UTF_INVALID)
				{
					continue;
				}

				final var data = getOrCreateQueryData(codepoint);
				textWidth += data.hMetric;
			}

			return textWidth;
		}
	}
}
