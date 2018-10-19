package org.sheepy.vulkan.util;

import static org.lwjgl.vulkan.VK10.VK_SUCCESS;

public class Logger
{

	public static final void check(int status, String message)
	{
		if (status != VK_SUCCESS)
		{
			log(message);
		}
	}

	public static final void check(String message, VkRunnable runnable)
	{
		final int res = runnable.run();
		check(res, message);
	}

	public interface VkRunnable
	{
		int run();
	}

	public static void log(String message)
	{
		throw new AssertionError(message);
	}

}
