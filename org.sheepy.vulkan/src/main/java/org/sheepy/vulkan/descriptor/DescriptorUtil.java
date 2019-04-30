package org.sheepy.vulkan.descriptor;

import org.sheepy.vulkan.model.enumeration.EBufferUsage;
import org.sheepy.vulkan.model.enumeration.EDescriptorType;

public class DescriptorUtil
{

	public static final EDescriptorType guessType(int usage)
	{
		EDescriptorType res = null;

		if ((usage & EBufferUsage.UNIFORM_BUFFER_BIT_VALUE) != 0)
		{
			res = EDescriptorType.UNIFORM_BUFFER;
		}

		return res;
	}
}
