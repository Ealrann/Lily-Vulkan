package org.sheepy.lily.vulkan.common.util;

public class VulkanDebugUtil
{
	public static boolean DEBUG_ENABLED;
	static
	{
		final String debugProperty = System.getProperty("debug");
		DEBUG_ENABLED = debugProperty != null && debugProperty.equals("false") == false;
	}
}
