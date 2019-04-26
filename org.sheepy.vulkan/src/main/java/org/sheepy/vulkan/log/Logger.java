package org.sheepy.vulkan.log;

import org.sheepy.vulkan.util.VulkanDebugUtil;

public class Logger
{
	private static final String UNKOWN_ERROR = "UNKOWN_ERROR";

	public static final void check(int status, String message)
	{
		check(status, message, false);
	}

	public static final void check(int status, String message, boolean noException)
	{
		final EVulkanErrorStatus error = EVulkanErrorStatus.resolveFromCode(status);

		if ((error != null && error.isError) || status < 0)
		{
			final String stringError = error != null ? error.name() : UNKOWN_ERROR;
			final String errorMessage = error != null ? error.message : "Error code: " + status;

			final String messageWithError = String.format("%s\n[%s] %s", message, stringError,
					errorMessage);

			if (!noException)
			{
				log(messageWithError);
			}
			else if (VulkanDebugUtil.DEBUG_ENABLED)
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
