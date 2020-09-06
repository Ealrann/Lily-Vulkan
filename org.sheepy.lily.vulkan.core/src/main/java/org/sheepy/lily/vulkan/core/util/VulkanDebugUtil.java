package org.sheepy.lily.vulkan.core.util;

public final class VulkanDebugUtil
{
	private VulkanDebugUtil()
	{
	}

	public static boolean DEBUG_ENABLED;
	static
	{
		final String debugProperty = System.getProperty("debug");
		DEBUG_ENABLED = debugProperty != null && debugProperty.equals("false") == false;
	}
}
