package org.sheepy.lily.vulkan.core.util;

public final class Logger
{
	private static final String MESSAGE_FORMAT = "%s\n[%s] %s";
	private static final String ERROR_CODE = "Error code: ";
	private static final String UNKOWN_ERROR = "UNKOWN_ERROR";

	private Logger()
	{}

	public static void check(int status, String message)
	{
		check(status, message, false);
	}

	public static void check(int statusCode, String message, boolean noException)
	{
		final var status = EVulkanErrorStatus.resolveFromCode(statusCode);

		if ((status != null && status.isError) || statusCode < 0)
		{
			final var errorString = status != null ? status.name() : UNKOWN_ERROR;
			final var errorMessage = status != null ? status.message : ERROR_CODE + statusCode;
			final var messageWithError = String.format(	MESSAGE_FORMAT,
														message,
														errorString,
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

	public static void check(String message, VkRunnable runnable)
	{
		final int res = runnable.run();
		check(res, message);
	}

	public static void log(String message)
	{
		//noinspection ConstantConditions
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

	public interface VkRunnable
	{
		int run();
	}
}
