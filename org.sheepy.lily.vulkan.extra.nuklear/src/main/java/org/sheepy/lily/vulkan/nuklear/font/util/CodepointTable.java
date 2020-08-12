package org.sheepy.lily.vulkan.nuklear.font.util;

import org.sheepy.lily.vulkan.nuklear.font.IFontTableInfo.TableData;

import java.util.ArrayList;
import java.util.List;

final class CodepointTable
{
	final int firstCodepoint;
	final int lastCodepoint;
	final int length;
	final List<TableData> loadedChars = new ArrayList<>();

	CodepointTable(int firstCodepoint, int length)
	{
		this.firstCodepoint = firstCodepoint;
		this.length = length;
		this.lastCodepoint = firstCodepoint + length - 1;
	}

	public void clear()
	{
		loadedChars.clear();
	}

	public int indexOf(int codepoint)
	{
		assert contains(codepoint);

		for (int i = 0; i < loadedChars.size(); i++)
		{
			final var currentCodepoint = loadedChars.get(i);
			if (currentCodepoint.codepoint == codepoint)
			{
				return i;
			}
		}

		return 0;
	}

	public void loadChar(int codepoint, float hMetric)
	{
		final var tableData = new TableData(codepoint, hMetric);
		loadedChars.add(tableData);
	}

	public boolean contains(int codepoint)
	{
		return codepoint >= firstCodepoint && codepoint < firstCodepoint + length;
	}
}