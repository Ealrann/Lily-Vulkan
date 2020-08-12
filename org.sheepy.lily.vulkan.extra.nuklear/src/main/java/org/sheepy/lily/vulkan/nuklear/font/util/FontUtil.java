package org.sheepy.lily.vulkan.nuklear.font.util;

import org.sheepy.lily.core.model.types.ECharTable;

public final class FontUtil
{
	public static int getStartCodePoint(ECharTable table)
	{
		return switch (table)
				{
					case BASE -> 32;
					case EXTENDED -> 161;
					case CHINESE -> 19968;
				};
	}
	
	public static int getTableLength(ECharTable table)
	{
		return switch (table)
				{
					case BASE -> 95;
					case EXTENDED -> 94;
					case CHINESE -> 20991;
				};
	}
}
