package org.sheepy.lily.vulkan.resource.font.util;

import org.sheepy.lily.core.model.types.ECharTable;

public final class FontUtil
{
	public static int getStartCodePoint(ECharTable table)
	{
		switch (table)
		{
		case BASE:
			return 32;
		case EXTENDED:
			return 161;
		case CHINESE:
			return 19968;
		}
		return 0;
	}
	
	public static int getTableLength(ECharTable table)
	{
		switch (table)
		{
		case BASE:
			return 95;
		case EXTENDED:
			return 94;
		case CHINESE:
			return 20991;
		}
		return 0;
	}
}
