package org.sheepy.lily.vulkan.core.util;

import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.List;

public class VulkanBufferUtils
{
	public static final List<Long> toList(LongBuffer buffer)
	{
		final List<Long> res = new ArrayList<>(buffer.capacity());

		for (int i = 0; i < buffer.capacity(); i++)
		{
			res.add(buffer.get(i));
		}

		return res;
	}
}
