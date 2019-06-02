package org.sheepy.vulkan.util;

import java.util.Collection;

import org.eclipse.emf.common.util.Enumerator;

public class VkModelUtil
{
	public static final int getEnumeratedFlag(Collection<? extends Enumerator> enumerates)
	{
		int res = 0;

		for (final Enumerator enumerate : enumerates)
		{
			res |= enumerate.getValue();
		}

		return res;
	}
}
