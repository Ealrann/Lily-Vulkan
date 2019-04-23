package org.sheepy.vulkan.util;

import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

public class VkModelUtil
{
	public static final int getEnumeratedFlag(List<? extends Enumerator> enumerates)
	{
		int res = 0;

		for (final Enumerator enumerate : enumerates)
		{
			res |= enumerate.getValue();
		}

		return res;
	}
}
