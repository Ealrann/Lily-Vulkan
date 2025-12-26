package org.sheepy.lily.vulkan.nuklear.font.util;

import org.sheepy.lily.core.model.types.ECharTable;

public final class FontUtil
{
	public static int getStartCodePoint(ECharTable table)
	{
		return switch (table)
				{
					case Base -> 32;
					case Extended -> 161;
					case Chinese -> 19968;
				};
	}
	
	public static int getTableLength(ECharTable table)
	{
		return switch (table)
				{
					case Base -> 95;
					case Extended -> 94;
					case Chinese -> 20991;
				};
	}
}
