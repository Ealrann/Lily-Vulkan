package org.sheepy.lily.vulkan.resource.font.util;

import static org.lwjgl.stb.STBTruetype.stbtt_GetPackedQuad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.lwjgl.stb.STBTTAlignedQuad;
import org.lwjgl.stb.STBTTPackContext;
import org.lwjgl.stb.STBTTPackedchar;
import org.lwjgl.stb.STBTTPackedchar.Buffer;
import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.notification.Notifier;
import org.sheepy.lily.core.api.notification.impl.ObjectNotification;
import org.sheepy.lily.core.model.ui.Font;
import org.sheepy.lily.vulkan.api.resource.font.IFontAllocator;
import org.sheepy.lily.vulkan.api.resource.font.IFontTableInfo;

public final class FontAllocator extends Notifier implements IFontAllocator
{
	private final List<FontTableAllocator> tableAllocators = new ArrayList<>();
	private final float[] X = new float[1];
	private final float[] Y = new float[1];

	public final Font font;

	private int charCount = 0;
	private Buffer cdata;
	private int imageWidth = 0;
	private int imageHeight = 0;

	public FontAllocator(Font font)
	{
		super(Features.values().length);
		this.font = font;
	}

	public void allocate(MemoryStack stack)
	{
		for (final var fontTable : font.getTables())
		{
			final var tableAllocator = new FontTableAllocator(fontTable);
			tableAllocator.allocate(stack);
			tableAllocators.add(tableAllocator);
		}
	}

	public void fill(STBTTPackContext pc, STBTTPackedchar.Buffer cdata, int[] codepoints)
	{
		this.cdata = cdata;
		imageWidth = pc.width();
		imageHeight = pc.height();
		int offset = 0;

		for (final var tableAllocator : tableAllocators)
		{
			final var dispatch = tableAllocator.prepare(codepoints);
			final var remainingCodepoints = dispatch.unsupportedCodepoints();
			final int count = codepoints.length - remainingCodepoints.length;

			final var subData = cdata.slice(offset, count);
			tableAllocator.pack(pc, subData, dispatch);
			offset += count;
			codepoints = remainingCodepoints;
		}
		charCount = offset;

		final var notification = new ObjectNotification(this,
														Features.loadedCodepoints,
														null,
														null);
		fireNotification(notification);
	}

	public void clear()
	{
		for (final var tableAllocator : tableAllocators)
		{
			tableAllocator.clear();
		}
	}

	public void free()
	{
		for (final var tableAllocator : tableAllocators)
		{
			tableAllocator.free();
		}
		tableAllocators.clear();

		charCount = 0;
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
	public List<? extends IFontTableInfo> getTableInfos()
	{
		return Collections.unmodifiableList(tableAllocators);
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
		int res = 0;
		for (int i = 0; i < tableAllocators.size(); i++)
		{
			final var allocator = tableAllocators.get(i);
			if (allocator.contains(codepoint))
			{
				res += allocator.indexOf(codepoint);
				break;
			}
			else
			{
				res += allocator.getLoadedCharCount();
			}
		}
		return res;
	}

	@Override
	public int charCount()
	{
		return charCount;
	}

	@Override
	public void fillPackedQuad(STBTTAlignedQuad quad, int index)
	{
		X[0] = 0f;
		Y[0] = 0f;
		stbtt_GetPackedQuad(cdata, imageWidth, imageHeight, index, X, Y, quad, false);
	}

	@Override
	public Font getFont()
	{
		return font;
	}
}
