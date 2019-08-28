package org.sheepy.vulkan.util;

import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

public class VkModelUtil
{
	public static final int getEnumeratedFlag(List<? extends Enumerator> enumerates)
	{
		int res = 0;

		for (int i = 0; i < enumerates.size(); i++)
		{
			final Enumerator enumerate = enumerates.get(i);
			res |= enumerate.getValue();
		}

		return res;
	}
}
