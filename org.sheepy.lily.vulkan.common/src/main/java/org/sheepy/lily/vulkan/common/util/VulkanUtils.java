package org.sheepy.lily.vulkan.common.util;

import static org.lwjgl.vulkan.EXTDebugReport.*;

import java.nio.LongBuffer;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDebugReportCallbackCreateInfoEXT;
import org.lwjgl.vulkan.VkDebugReportCallbackEXT;
import org.lwjgl.vulkan.VkInstance;
import org.sheepy.lily.vulkan.api.util.Logger;

public class VulkanUtils
{
	public static long setupDebugCallback(	MemoryStack stack,
											VkInstance vkInstance,
											VkDebugReportCallbackEXT callback)
	{
		final VkDebugReportCallbackCreateInfoEXT createInfo = VkDebugReportCallbackCreateInfoEXT
				.callocStack(stack);
		createInfo.sType(VK_STRUCTURE_TYPE_DEBUG_REPORT_CALLBACK_CREATE_INFO_EXT);
		createInfo.flags(VK_DEBUG_REPORT_ERROR_BIT_EXT | VK_DEBUG_REPORT_WARNING_BIT_EXT);
		createInfo.pfnCallback(callback);

		final LongBuffer pCallback = stack.callocLong(1);

		Logger.check("Can't create the Debug Report Callback",
				() -> vkCreateDebugReportCallbackEXT(vkInstance, createInfo, null, pCallback));

		return pCallback.get(0);
	}
}
