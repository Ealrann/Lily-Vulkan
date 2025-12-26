package org.sheepy.lily.vulkan.nuklear.font.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import org.sheepy.lily.core.model.ui.Font;

public final class CodepointMap
{
	public final Map<Font, int[]> codepointsMap;
	public final int codepointCount;

	private CodepointMap(Map<Font, int[]> codepointsMap, int codepointCount)
	{
		this.codepointCount = codepointCount;
		this.codepointsMap = Map.copyOf(codepointsMap);
	}

	public static CodepointMap fromCharacterMap(Map<Font, List<String>> characterMap)
	{
		final Map<Font, int[]> codepointsMap = new HashMap<>();
		int codepointCount = 0;
		for (final var entry : characterMap.entrySet())
		{
			final var list = entry.getValue();
			final var font = entry.getKey();
			final var codepoints = toCodepointStream(list).toArray();
			codepointCount += codepoints.length;
			codepointsMap.put(font, codepoints);
		}

		return new CodepointMap(codepointsMap, codepointCount);
	}

	public boolean isCompatible(CodepointMap other)
	{
		for (final var entry : other.codepointsMap.entrySet())
		{
			final var font = entry.getKey();
			final var otherCodepoints = entry.getValue();
			final var ourCodepoints = this.codepointsMap.get(font);
			final int ourCodepointsLength = ourCodepoints != null ? ourCodepoints.length : 0;

			int index = 0;
			// both arrays are sorted, we exploit that.
			for (final var otherCodepoint : otherCodepoints)
			{
				boolean found = false;

				while (index < ourCodepointsLength)
				{
					if (ourCodepoints[index++] == otherCodepoint)
					{
						found = true;
						break;
					}
				}

				if (found == false)
				{
					return false;
				}
			}
		}

		return true;
	}

	private static IntStream toCodepointStream(final List<String> list)
	{
		IntStream stream = IntStream.empty();
		for (int i = 0; i < list.size(); i++)
		{
			final String string = list.get(i);
			stream = IntStream.concat(stream, string.codePoints());
		}
		return stream.distinct().sorted();
	}

	public int[] get(Font font)
	{
		return codepointsMap.get(font);
	}
}
