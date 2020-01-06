package org.sheepy.lily.vulkan.nuklear.font;

import static org.lwjgl.nuklear.Nuklear.*;
import static org.lwjgl.system.MemoryUtil.memAddress;

import java.nio.IntBuffer;
import java.util.Objects;

import org.lwjgl.nuklear.NkTextWidthCallback;
import org.lwjgl.nuklear.NkUserFont;
import org.lwjgl.nuklear.NkUserFontGlyph;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.vulkan.api.resource.font.IFontAllocator;
import org.sheepy.lily.vulkan.nuklear.font.util.FontQueryData;
import org.sheepy.lily.vulkan.nuklear.resource.NuklearContextAdapter;

public final class NkFontLoader
{
	private final NkUserFont nkFont;
	private final float fontHeight;
	private final IFontAllocator fontAllocator;
	private final FontQueryData queryData;

	private IntBuffer unicode;
	private IntBuffer advanceWidth;
	private long unicodePtr;

	public NkFontLoader(IFontAllocator fontAllocator, float fontHeight)
	{
		this.fontAllocator = fontAllocator;
		this.fontHeight = fontHeight;
		nkFont = NkUserFont.create();
		queryData = new FontQueryData(fontAllocator, fontHeight);
	}

	public void allocate()
	{
		queryData.allocate();

		unicode = MemoryUtil.memAllocInt(1);
		advanceWidth = MemoryUtil.memAllocInt(1);
		unicodePtr = memAddress(unicode);

		nkFont.texture(it -> it.ptr(NuklearContextAdapter.FONT_TEXTURE_DESCRIPTOR_INDEX));
		nkFont.width(new TextWidthCallback());
		nkFont.height(fontHeight);
		nkFont.query((handle, font_height, glyph, codepoint, next_codepoint) ->
		{
			final var ufg = NkUserFontGlyph.create(glyph);
			final var tableAdapter = fontAllocator.getTableInfo(codepoint);
			final float kern = tableAdapter.getCodepointKernAdvance(codepoint, next_codepoint);

			queryData.fill(ufg, codepoint);
			ufg.xadvance(ufg.xadvance() + kern);
		});
	}

	public void free()
	{
		queryData.free();

		Objects.requireNonNull(nkFont.query()).free();
		Objects.requireNonNull(nkFont.width()).free();

		MemoryUtil.memFree(unicode);
		MemoryUtil.memFree(advanceWidth);
	}

	public NkUserFont getNkFont()
	{
		return nkFont;
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

				final var tableInfo = fontAllocator.getTableInfo(codepoint);
				textWidth += tableInfo.getCodepointHMetric(codepoint);
			}

			return textWidth;
		}
	}
}
