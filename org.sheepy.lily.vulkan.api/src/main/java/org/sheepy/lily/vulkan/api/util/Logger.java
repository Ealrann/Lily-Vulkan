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
		EVulkanStatus error = EVulkanStatus.resolveFromCode(status);
		if (error.isError)
		{
			String stringError = error != null ? error.name() : UNKOWN_ERROR;
			String errorMessage = error.message;

			String messageWithError = String.format("%s\n[%s] %s", message, stringError,
					errorMessage);

			if (!noException)
			{
				log(messageWithError);
			}
			else if (DebugUtil.DEBUG_ENABLED)
			{
				System.err.println(messageWithError);
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
		throw new AssertionError(message);
	}
}
