package org.sheepy.lily.vulkan.core.resource.util;

public final class AlignmentUtil
{
	public static long align(final long position, final long alignment)
	{
		final double alignmentFactor = (double) position / alignment;
		final long chunks = (long) Math.ceil(alignmentFactor);
		return (chunks * alignment);
	}

	public static long leastCommonMultiple(long number1, long number2)
	{
		if (number1 == 0 || number2 == 0)
		{
			return 0;
		}
		final long absNumber1 = Math.abs(number1);
		final long absNumber2 = Math.abs(number2);
		final long absHigherNumber = Math.max(absNumber1, absNumber2);
		final long absLowerNumber = Math.min(absNumber1, absNumber2);
		long lcm = absHigherNumber;
		while (lcm % absLowerNumber != 0)
		{
			lcm += absHigherNumber;
		}
		return lcm;
	}
}
