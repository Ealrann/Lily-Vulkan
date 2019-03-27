package org.sheepy.lily.vulkan.api.util;

import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.api.nativehelper.EVulkanStatus;

public class Logger
{
	private static final String UNKOWN_ERROR = "UNKOWN_ERROR";

	public static final void check(int status, String message)
	{
		check(status, message, false);
	}

	public static final void check(int status, String message, boolean noException)
	{
		final EVulkanStatus error = EVulkanStatus.resolveFromCode(status);
		if (error.isError)
		{
			final String stringError = error != null ? error.name() : UNKOWN_ERROR;
			final String errorMessage = error.message;

			final String messageWithError = String.format("%s\n[%s] %s", message, stringError,
					errorMessage);

			if (!noException)
			{
				log(messageWithError);
			}
			else if (DebugUtil.DEBUG_ENABLED)
			{
				log(messageWithError, true);
			}
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
		log(message, false);
	}

	public static void log(String message, boolean console)
	{
		if (console)
		{
			System.err.println(message);
		}
		else
		{
			throw new AssertionError(message);
		}
	}
}
