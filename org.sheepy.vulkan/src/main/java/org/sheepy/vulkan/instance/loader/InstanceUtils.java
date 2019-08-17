package org.sheepy.vulkan.instance.loader;

import static org.lwjgl.vulkan.EXTDebugReport.*;

import java.nio.LongBuffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDebugReportCallbackCreateInfoEXT;
import org.lwjgl.vulkan.VkDebugReportCallbackEXT;
import org.lwjgl.vulkan.VkInstance;
import org.sheepy.vulkan.log.Logger;

public class InstanceUtils
{
	private static final String CREATION_ERROR = "Can't create the Debug Report Callback";

	public static long setupDebugCallback(	MemoryStack stack,
											VkInstance vkInstance,
											VkDebugReportCallbackEXT callback)
	{
		final var createInfo = VkDebugReportCallbackCreateInfoEXT.callocStack(stack);
		createInfo.sType(VK_STRUCTURE_TYPE_DEBUG_REPORT_CALLBACK_CREATE_INFO_EXT);
		createInfo.flags(VK_DEBUG_REPORT_ERROR_BIT_EXT | VK_DEBUG_REPORT_WARNING_BIT_EXT);
		createInfo.pfnCallback(callback);

		final LongBuffer pCallback = stack.callocLong(1);

		Logger.check(	CREATION_ERROR,
						() -> vkCreateDebugReportCallbackEXT(	vkInstance,
																createInfo,
																null,
																pCallback));

		return pCallback.get(0);
	}
}
