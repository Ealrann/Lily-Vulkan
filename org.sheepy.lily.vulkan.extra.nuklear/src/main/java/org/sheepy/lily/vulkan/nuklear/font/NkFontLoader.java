package org.sheepy.lily.vulkan.nuklear.font;

import org.lwjgl.nuklear.NkTextWidthCallback;
import org.lwjgl.nuklear.NkUserFont;
import org.lwjgl.nuklear.NkUserFontGlyph;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.core.resource.font.IFontAllocator;
import org.sheepy.lily.vulkan.nuklear.font.util.FontQueryData;
import org.sheepy.lily.vulkan.nuklear.resource.NuklearContextAdapter;

import java.nio.IntBuffer;
import java.util.Objects;

import static org.lwjgl.nuklear.Nuklear.NK_UTF_INVALID;
import static org.lwjgl.nuklear.Nuklear.nnk_utf_decode;
import static org.lwjgl.system.MemoryUtil.memAddress;

public final class NkFontLoader
{
	public static final String CODEPOINT_NOT_FOUND = "Codepoint not found: ";
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
		nkFont.query((handle, font_height, glyph, codepoint, next_codepoint) -> {
			final var ufg = NkUserFontGlyph.create(glyph);
			final int solvedCodepoint = resolveCodepoint(codepoint);
			final int solvedNextCodepoint = resolveCodepoint(next_codepoint);
			final var tableInfo = fontAllocator.getTableInfo(solvedCodepoint);
			final float kern = tableInfo.getCodepointKernAdvance(solvedCodepoint, solvedNextCodepoint);
			queryData.fill(ufg, solvedCodepoint);
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

	private int resolveCodepoint(int codepoint)
	{
		if (fontAllocator.contains(codepoint))
		{
			return codepoint;
		}
		else if (DebugUtil.DEBUG_ENABLED)
		{
			System.err.println(CODEPOINT_NOT_FOUND + codepoint);
		}
		return '?';
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

				final int solvedCodepoint = resolveCodepoint(codepoint);
				final var tableInfo = fontAllocator.getTableInfo(solvedCodepoint);
				textWidth += tableInfo != null ? tableInfo.getCodepointHMetric(solvedCodepoint) : 0;
			}

			return textWidth;
		}
	}
}
