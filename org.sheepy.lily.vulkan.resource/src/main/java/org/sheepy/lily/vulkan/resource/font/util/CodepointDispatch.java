package org.sheepy.lily.vulkan.resource.font.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class CodepointDispatch
{
	private final Map<CodepointTable, int[]> tableCodepointMap;
	private final int[] unsupportedCodepoints;
	private int unsupportedCount;

	CodepointDispatch(List<CodepointTable> tables, int[] codepoints)
	{

		final int[] unsupported = new int[codepoints.length];

		this.tableCodepointMap = Map.copyOf(buildMap(codepoints, tables, unsupported));

		unsupportedCodepoints = Arrays.copyOfRange(unsupported, 0, unsupportedCount);
	}

	private Map<CodepointTable, int[]> buildMap(int[] codepoints,
												List<CodepointTable> tables,
												int[] unsupported)
	{
		final var tableIterator = tables.iterator();
		var currentTable = tableIterator.next();
		int unsupportedIndex = 0;
		final Map<CodepointTable, int[]> tableCodepointMap = new HashMap<>();
		for (int i = 0; i < codepoints.length; i++)
		{
			final int codepoint = codepoints[i];

			while (currentTable != null && codepoint > currentTable.lastCodepoint)
			{
				if (tableIterator.hasNext() == false)
				{
					currentTable = null;
				}
				else
				{
					currentTable = tableIterator.next();
				}
			}

			if (currentTable == null || codepoint < currentTable.firstCodepoint)
			{
				unsupported[unsupportedIndex++] = codepoint;
			}
			else
			{
				final int first = i;
				while (i < codepoints.length && codepoints[i] <= currentTable.lastCodepoint)
				{
					i++;
				}
				final int[] res = Arrays.copyOfRange(codepoints, first, i);
				tableCodepointMap.put(currentTable, res);
				if (i != codepoints.length)
				{
					i--;
				}
			}
		}
		unsupportedCount = unsupportedIndex;
		return tableCodepointMap;
	}

	public int[] getCodepoints(CodepointTable table)
	{
		return tableCodepointMap.get(table);
	}

	public int[] unsupportedCodepoints()
	{
		return unsupportedCodepoints;
	}
}