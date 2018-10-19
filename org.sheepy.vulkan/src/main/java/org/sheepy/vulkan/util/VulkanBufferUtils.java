package org.sheepy.vulkan.util;

import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.List;

public class VulkanBufferUtils
{
	public static final long[] toArray(LongBuffer buffer)
	{
		long[] res = new long[buffer.capacity()];

		for (int i = 0; i < buffer.capacity(); i++)
		{
			res[i] = buffer.get(i);
		}

		return res;
	}

	public static final List<Long> toList(LongBuffer buffer)
	{
		List<Long> res = new ArrayList<>(buffer.capacity());

		for (int i = 0; i < buffer.capacity(); i++)
		{
			res.add(buffer.get(i));
		}

		return res;
	}
}
